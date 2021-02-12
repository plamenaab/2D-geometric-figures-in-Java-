package geometrie.demo;

import geometrie.Ellipse;
import geometrie.Punkt;

public class EllipseDemo {

	public static void main(String[] args) {
		Ellipse ellipse1 = new Ellipse();

		Punkt punkt = new Punkt(1, 1);
		Ellipse ellipse2 = new Ellipse(punkt, 3, 4);

		Ellipse ellipse3 = new Ellipse();
		ellipse1.eingabe();

		Ellipse ellipse4 = new Ellipse(ellipse3);

		System.out.println("Ausgabe fuer Ellipse 1: ");
		ellipse1.ausgabe();

		System.out.println("Ausgabe fuer Ellipse 2: ");
		ellipse2.ausgabe();

		System.out.println("Ausgabe fuer Ellipse 3: ");
		ellipse3.ausgabe();

		System.out.println("Ausgabe fuer Ellipse 4: ");
		ellipse4.ausgabe();
	}

}
