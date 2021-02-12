package geometrie.demo;

import geometrie.Gerade;
import geometrie.Punkt;

public class GeradeDemo {

	public static void main(String[] args) {
		Gerade gerade1 = new Gerade();

		Punkt punkt1 = new Punkt(0, 0);
		Punkt punkt2 = new Punkt(3, 4);
		Gerade gerade2 = new Gerade(punkt1, punkt2);

		Gerade gerade3 = new Gerade();
		System.out.println("Eingabe fuer Gerade 3: ");
		gerade3.eingabe();

		Gerade gerade4 = new Gerade(gerade3);

		System.out.println("Gerade 1: ");
		gerade1.ausgabe();

		System.out.println("Gerade 2: ");
		gerade2.ausgabe();

		System.out.println("Gerade 3: ");
		gerade3.ausgabe();

		System.out.println("Gerade 4: ");
		gerade4.ausgabe();

		Punkt punkt3 = new Punkt(2, 3);
		Punkt punkt4 = new Punkt(5, 6);

		double abstand = Gerade.abstand(punkt3, punkt4);
		System.out.println("Abstand zwishen " + punkt3 + " und " + punkt4 + " ist " + abstand);

		double koeffizient = Gerade.koeffizient(punkt3, punkt4);
		System.out.println("Koeffizient der Gerade zwishen " + punkt3 + " und " + punkt4 + " ist " + koeffizient);
	}

}
