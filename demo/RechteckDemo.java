package geometrie.demo;

import geometrie.Punkt;
import geometrie.Rechteck;

public class RechteckDemo {

	public static void main(String[] args) {
		Rechteck rechteck1 = new Rechteck();

		Punkt punkt = new Punkt(1, 1);
		Rechteck rechteck2 = new Rechteck(punkt, 2, 3);

		Rechteck rechteck3 = new Rechteck();
		rechteck1.eingabe();

		Rechteck rechteck4 = new Rechteck(rechteck3);

		System.out.println("Ausgabe fuer Rechteck 1: ");
		rechteck1.ausgabe();

		System.out.println("Ausgabe fuer Rechteck 2: ");
		rechteck2.ausgabe();

		System.out.println("Ausgabe fuer Rechteck 3: ");
		rechteck3.ausgabe();

		System.out.println("Ausgabe fuer Rechteck 4: ");
		rechteck4.ausgabe();
	}

}
