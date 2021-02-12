package geometrie.demo;

import geometrie.Punkt;

public class PunktDemo {

	public static void main(String[] args) {
		Punkt punkt1 = new Punkt();
		Punkt punkt2 = new Punkt(3, 3);

		Punkt punkt3 = new Punkt();
		System.out.println("Eingabe fuer Punkt 3: ");
		punkt3.eingabe();

		Punkt punkt4 = new Punkt(punkt3);
		Punkt punkt5 = punkt2.moveNew(1, 1);
		Punkt punkt6 = punkt2;

		punkt2.move(3, 4);

		System.out.println("Punkt 1: ");
		punkt1.ausgabe();

		System.out.println("Punkt 2: ");
		punkt2.ausgabe();

		System.out.println("Punkt 3: ");
		punkt3.ausgabe();

		System.out.println("Punkt 4: ");
		punkt4.ausgabe();

		System.out.println("Punkt 5: ");
		punkt5.ausgabe();

		System.out.println("Punkt 6: ");
		punkt6.ausgabe();
	}

}
