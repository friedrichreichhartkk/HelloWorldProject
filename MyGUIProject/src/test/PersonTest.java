package test;

import data.Person;

public class PersonTest {

	public static void main(String[] args) {
		//
		String personText;
		//
		Person p1; // Variablen Definition
		p1 = new Person(); // Instanzierung
		//
		p1.setVorname("Hans");
		p1.setNachname("Huber");
		//
		System.out.println(p1);
		

	}

}
