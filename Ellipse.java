package geometrie;

import java.awt.Graphics;

public class Ellipse extends GObjekt {

	protected int a;

	protected int b;

	public Ellipse() {
		super("Ellipse", 1);

		eckpunkte = new Punkt[anzahl];
		eckpunkte[0] = new Punkt(0, 0);
		a = 1;
		b = 1;
	}

	public Ellipse(Punkt punkt, int a, int b) {
		super("Ellipse", 1);

		this.eckpunkte = new Punkt[anzahl];
		this.eckpunkte[0] = new Punkt(punkt);
		this.a = a;
		this.b = b;
	}

	public Ellipse(Ellipse ellipse) {
		super("Ellipse", 1);

		eckpunkte = new Punkt[anzahl];
		eckpunkte[0] = new Punkt(ellipse.eckpunkte[0]);
		a = ellipse.a;
		b = ellipse.b;
	}

	@Override
	public int kontrolle() {
		if (a <= 0) {
			return 1;
		} else if (b <= 0) {
			return 2;
		} else {
			return 0;
		}
	}

	@Override
	public void eingabe() {
		System.out.println("Eingabe fuer Ellipse: ");

		eckpunkte[0].eingabe();

		do {
			System.out.println("a: ");
			a = Hilfe.SCANNER.nextInt();

			System.out.println("b: ");
			b = Hilfe.SCANNER.nextInt();
		} while (kontrolle() > 0);
	}

	@Override
	public double umfang() {
		return Math.PI * (3 * (a + b) - Math.sqrt((3 * a + b) * (a + 3 * b)));
	}

	@Override
	public double flaeche() {
		return Math.PI * a * b;
	}

	@Override
	public String art() {
		String art;

		if (a == b) {
			art = "Kreis";
		} else {
			art = "Ellipse";
		}

		return art;
	}

	@Override
	public String toString() {
		return "Ellipse: " + eckpunkte[0] + " - " + a + " - " + b;
	}

	@Override
	public void ausgabe() {
		System.out.println(this);
		System.out.println("Umfang: " + umfang());
		System.out.println("Flaeche: " + flaeche());
		System.out.println("Art: " + art());
	}

	@Override
	public boolean equal(GObjekt objekt) {
		Ellipse ellipse = (Ellipse) objekt;

		boolean gleich1 = Hilfe.equal(a, ellipse.a) && Hilfe.equal(b, ellipse.b);
		boolean gleich2 = Hilfe.equal(a, ellipse.b) && Hilfe.equal(b, ellipse.a);

		return gleich1 || gleich2;
	}

	@Override
	public void zeichnen(Graphics g, double koef) {
		g.drawOval(eckpunkte[0].x, eckpunkte[0].y, masstabierung(a, koef), masstabierung(b, koef));
	}

	public boolean contains(int x, int y) {
		//TO be implemented here.
		return false;
	}	
}
