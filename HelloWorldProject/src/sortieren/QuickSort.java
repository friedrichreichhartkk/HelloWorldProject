package sortieren;

public class QuickSort {

	//
	static int[] zahlen = {4,2,5,9,6,10,9,7};
	//
	
	public static void main(String[] args) {
		// unsortierte Zahlen ausgeben
		// sortieren
		// quicksort(0,6) // zahlen.length -1
		// sortierte zahlen ausgegebn
		
	}
	
	static void quicksort(int links, int rechts) {
		//falls links < rechts dann
		if () {
        int teiler = teile(links, rechts);
        quicksort(links, teiler-1);
        quicksort(teiler+1, rechts);
		}

	}

	private static int teile(int links, int rechts) {
		// variablen
		int i;
		int j;
		//
		do {
			// Suche von links ein Element, welches größer als das Pivotelement ist

			
			// Suche von rechts ein Element, welches gleich oder kleiner als das Pivotelement ist

			
			if (i < j)   {
				// tauschen
			}
			
		} while (i < j);
		
		 falls daten[i] > pivot dann
         	tausche daten[i] mit pivot
         ende
         
         return i;

	}


}
