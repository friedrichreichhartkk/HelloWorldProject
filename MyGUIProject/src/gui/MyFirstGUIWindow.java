package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseEvent;

public class MyFirstGUIWindow {

	protected Shell shlFrWindow;
	private Text vornameTF;
	private Text text;

	/**
	 * Launch the application.
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
				System.out.println(vornameTF.getText());
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
		
		text = new Text(shlFrWindow, SWT.BORDER);
		text.setBounds(105, 133, 128, 21);
		
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
		shlFrWindow.setTabList(new Control[]{text, vornameTF, btnMybutton});

	}
}
