package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import data.Person;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseEvent;

public class MyFirstGUIWindow {

	protected Shell shlFrWindow;
	private Text vornameTF;
	private Text nachnameTF;
	private Label vornameOut;
	private Label nachnameOut;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MyFirstGUIWindow window = new MyFirstGUIWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlFrWindow.open();
		shlFrWindow.layout();
		while (!shlFrWindow.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlFrWindow = new Shell();
		shlFrWindow.setBackground(SWTResourceManager.getColor(255, 228, 196));
		shlFrWindow.setFullScreen(true);
		shlFrWindow.setSize(450, 300);
		shlFrWindow.setText("FR Window");

		Button btnMybutton = new Button(shlFrWindow, SWT.NONE);
		btnMybutton.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		btnMybutton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Knoppe gedrückt.");
//				System.out.println(vornameTF.getText());
				//
				System.out.println(getVornameTF().getText());
				System.out.println(getNachnameTF().getText());
				//
				getVornameOut().setText(getVornameTF().getText());
				getNachnameOut().setText(getNachnameTF().getText());
				//
				Person p1; // Variablen Definition
				p1 = new Person(); // Instanzierung
				//
				p1.setVorname(getVornameTF().getText());
				p1.setNachname(getNachnameTF().getText());
				//
				System.out.println(p1);
				//
				Person.getListe().add(p1);
				//
				System.out.println(Person.getListe());
				// alle felder loeschen
				getVornameTF().setText("");
				getNachnameTF().setText("");

			}
		});
		btnMybutton.setBounds(44, 41, 75, 25);
		btnMybutton.setText("MyButton");

		Label vornameL = new Label(shlFrWindow, SWT.NONE);
		vornameL.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		vornameL.setBounds(44, 107, 55, 15);
		vornameL.setText("Vorname");

		vornameTF = new Text(shlFrWindow, SWT.BORDER);
		vornameTF.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		vornameTF.setBounds(105, 101, 128, 21);

		Label lblNachname = new Label(shlFrWindow, SWT.NONE);
		lblNachname.setBounds(44, 139, 55, 15);
		lblNachname.setText("Nachname");

		nachnameTF = new Text(shlFrWindow, SWT.BORDER);
		nachnameTF.setBounds(105, 133, 128, 21);

		Button btnAbbrechen = new Button(shlFrWindow, SWT.NONE);
		btnAbbrechen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		btnAbbrechen.setBounds(137, 41, 75, 25);
		btnAbbrechen.setText("abbrechen");

		Composite composite = new Composite(shlFrWindow, SWT.NONE);
		composite.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent me) {
				System.out.println(me.x + " / " + me.y);
			}
		});
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		composite.setBounds(44, 171, 194, 80);
		
		vornameOut = new Label(shlFrWindow, SWT.NONE);
		vornameOut.setBounds(252, 101, 116, 21);
		
		nachnameOut = new Label(shlFrWindow, SWT.NONE);
		nachnameOut.setBounds(252, 133, 116, 21);
		
		Button btnJson = new Button(shlFrWindow, SWT.NONE);
		btnJson.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				//
				//System.out.println(gson.toJson(Person.getListe()));
				//
				try {
					File jsonFile = File.createTempFile("wpfinf-json-", ".humptydumpty");
					FileWriter fw = new FileWriter(jsonFile);
					//
					gson.toJson(Person.getListe(), fw);
					//
					fw.flush();
					fw.close();
					//
					// explorer öffnen - %TEMP%
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnJson.setBounds(241, 41, 75, 25);
		btnJson.setText("JSON");
		
		Button btnLoad = new Button(shlFrWindow, SWT.NONE);
		btnLoad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(shlFrWindow, SWT.OPEN);
				//
				fd.setFilterExtensions(new String[] {"humptydumpty"});
				fd.setFilterPath("%TEMP%");
				//
				fd.open();
			}
		});
		btnLoad.setBounds(332, 41, 75, 25);
		btnLoad.setText("Load");
		shlFrWindow.setTabList(new Control[] { nachnameTF, vornameTF, btnMybutton });

	}

	public Text getVornameTF() {
		return vornameTF;
	}

	public Text getNachnameTF() {
		return nachnameTF;
	}
	public Label getVornameOut() {
		return vornameOut;
	}
	public Label getNachnameOut() {
		return nachnameOut;
	}
}
