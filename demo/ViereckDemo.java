package geometrie.demo;

import geometrie.Punkt;
import geometrie.Viereck;

public class ViereckDemo {

	public static void main(String[] args) {
		Viereck viereck1 = new Viereck();

		Punkt[] punkte = new Punkt[4];
		punkte[0] = new Punkt();
		punkte[1] = new Punkt();
		punkte[2] = new Punkt();
		punkte[3] = new Punkt();
		Viereck viereck2 = new Viereck(punkte);

		Viereck viereck3 = new Viereck();
		viereck3.eingabe();

		Viereck viereck4 = new Viereck(viereck3);

		System.out.println("Ausgabe fuer Viereck 1: ");
		viereck1.ausgabe();

		System.out.println("Ausgabe fuer Viereck 2: ");
		viereck2.ausgabe();

		System.out.println("Ausgabe fuer Viereck 3: ");
		viereck3.ausgabe();

		System.out.println("Ausgabe fuer Viereck 4: ");
		viereck4.ausgabe();

		if (viereck1.equal(viereck4)) {
			System.out.println("Viereck 1 und Viereck 4 sind gleich.");
		} else {
			System.out.println("Viereck 1 und Viereck 4 sind ungleich.");
		}
	}

}
