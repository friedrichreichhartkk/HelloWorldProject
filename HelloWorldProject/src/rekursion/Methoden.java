package rekursion;

public class Methoden {
	
	// main Methode - ist die Methode
	// die beim Start des Programmes / der Klasse
	// aufgerufen wird
	public static void main(String[] args) {
		spezielleMethode();
		spezielleMethode();
		spezielleMethode();
		//
		for (int i=0; i < 10; i++)
			spezielleMethode();
		//
		addiere(10, 5);
		//
		System.out.println(mult(8, 7));
	}
	
	// eine "normale" methode
	// die erst - wenn sie aufgerufen wird - "druchlaufen" wird
	public static void spezielleMethode() {
		System.out.println("Ich bin speziell.");
	}
	
	public static void addiere(int zahlA, int zahlB) {
		System.out.println(zahlA + zahlB);
	}
	
	public static int mult(int zahlA, int zahlB) {
		int ergebis = zahlA * zahlB;
		return ergebis;
	}
	
	//
	

}
