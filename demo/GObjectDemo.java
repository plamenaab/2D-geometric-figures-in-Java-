package geometrie.demo;

import geometrie.Dreieck;
import geometrie.Ellipse;
import geometrie.GObjekt;
import geometrie.Punkt;
import geometrie.Rechteck;
import geometrie.Viereck;

public class GObjectDemo {

	static GObjekt[] objekte = new GObjekt[10];

	static void init() {
		objekte[0] = new Rechteck(new Punkt(1, 0), 2, 3);

		Punkt[] punkte1 = { new Punkt(1, 2), new Punkt(1, 3), new Punkt(0, 3) };
		objekte[1] = new Dreieck(punkte1);

		Punkt[] punkte2 = { new Punkt(3, 2), new Punkt(3, 3), new Punkt(2, 3) };
		objekte[2] = new Dreieck(punkte2);

		Punkt[] punkte3 = { new Punkt(4, 2), new Punkt(7, 2), new Punkt(6, 3), new Punkt(5, 3) };
		objekte[3] = new Viereck(punkte3);

		Punkt[] punkte4 = { new Punkt(7, 2), new Punkt(8, 3), new Punkt(7, 4) };
		objekte[4] = new Dreieck(punkte4);

		objekte[5] = new Ellipse(new Punkt(2, 4), 1, 1);

		objekte[6] = new Rechteck(new Punkt(3, 3), 1, 2);

		objekte[7] = new Ellipse(new Punkt(5, 4), 1, 1);

		objekte[8] = new Rechteck(new Punkt(0, 5), 3, 7);

		objekte[9] = new Ellipse(new Punkt(5, 6), 1, 2);
	}

	public static void main(String[] args) {
		init();

		double sum = 0;

		for (int i = 0; i < objekte.length; i++) {
			sum += objekte[i].flaeche();
		}

		System.out.println(sum);
	}

}
