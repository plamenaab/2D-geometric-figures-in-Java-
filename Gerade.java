package geometrie;

import java.awt.Graphics;

public class Gerade  implements GOZeichnen {

	protected Punkt punkt1;

	protected Punkt punkt2;

	public Gerade() {
		punkt1 = new Punkt(0, 0);
		punkt2 = new Punkt(1, 1);
	}

	public Gerade(Punkt punkt1, Punkt punkt2) {
		this.punkt1 = new Punkt(punkt1);
		this.punkt2 = new Punkt(punkt2);
	}

	public Gerade(Gerade gerade) {
		punkt1 = new Punkt(gerade.punkt1);
		punkt2 = new Punkt(gerade.punkt2);
	}

	public int kontrolle() {
		if (punkt1.equal(punkt2)) {
			return 1;
		} else {
			return 0;
		}
	}

	public void eingabe() {
		do {
			punkt1.eingabe();
			punkt2.eingabe();

			if (kontrolle() > 0) {
				System.out.println("Die Punkte sind gleich! Wiederholen der Eingabe...");
			}
		} while (kontrolle() > 0);
	}

	public String toString() {
		return punkt1 + "-" + punkt2;
	}

	public void ausgabe() {
		System.out.println(this);
		System.out.println("Abstand zwischen den Punkten: " + abstand());
		System.out.println("Koeffizient der Gerade: " + koeffizient());
	}

	public double abstand() {
		return abstand(punkt1, punkt2);
	}

	public double koeffizient() {
		return koeffizient(punkt1, punkt2);
	}

	public static double abstand(Punkt punkt1, Punkt punkt2) {
		return Math.sqrt(Hilfe.quad(punkt2.x - punkt1.x) + Hilfe.quad(punkt2.y - punkt1.y));
	}

	public static double koeffizient(Punkt punkt1, Punkt punkt2) {
		double koeffizient;

		double xDelta = punkt2.x - punkt1.x;
		if (Math.abs(xDelta) > Hilfe.EPSILON) {
			koeffizient = (punkt2.y - punkt1.y) / xDelta;
		} else {
			koeffizient = 1e8;
		}

		return koeffizient;
	}
	
	@Override
	public void zeichnen(Graphics g, double koef) {
		g.drawLine(punkt1.x, punkt1.y, punkt2.x, punkt2.y);
	}

}
