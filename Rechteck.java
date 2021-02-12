package geometrie;

import java.awt.Graphics;

public class Rechteck extends GObjekt {
	protected int breite;
	protected int hoehe;

	public Rechteck() {
		super("Recheck", 1);
		eckpunkte = new Punkt[anzahl];
		eckpunkte[0] = new Punkt(0, 0);
		breite = 1;
		hoehe = 1;
	}

	public Rechteck(Punkt punkt, int breite, int hoehe) {
		super("Recheck", 1);

		eckpunkte = new Punkt[anzahl];
		this.eckpunkte[0] = new Punkt(punkt);
		this.breite = breite;
		this.hoehe = hoehe;
	}

	public Rechteck(Rechteck rechteck) {
		super("Recheck", 1);

		eckpunkte = new Punkt[anzahl];
		eckpunkte[0] = new Punkt(rechteck.eckpunkte[0]);
		breite = rechteck.breite;
		hoehe = rechteck.hoehe;
	}

	@Override
	public int kontrolle() {
		if (breite <= 0) {
			return 1;
		} else if (hoehe <= 0) {
			return 2;
		} else {
			return 0;
		}
	}

	@Override
	public void eingabe() {
		System.out.println("Eingabe fuer Rechteck: ");

		eckpunkte[0].eingabe();

		do {
			System.out.println("Breite: ");
			breite = Hilfe.SCANNER.nextInt();

			System.out.println("Hoehe: ");
			hoehe = Hilfe.SCANNER.nextInt();
		} while (kontrolle() > 0);
	}

	@Override
	public double umfang() {
		return breite * 2 + hoehe * 2;
	}

	@Override
	public double flaeche() {
		return breite * hoehe;
	}

	@Override
	public String art() {
		String art;

		if (breite == hoehe) {
			art = "Quadrat";
		} else {
			art = "Rechteck";
		}

		return art;
	}

	@Override
	public String toString() {
		return "Rechteck: " + eckpunkte[0] + " - " + breite + " - " + hoehe;
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
		Rechteck rechteck = (Rechteck) objekt;

		boolean gleich1 = Hilfe.equal(breite, rechteck.breite) && Hilfe.equal(hoehe, rechteck.hoehe);
		boolean gleich2 = Hilfe.equal(breite, rechteck.hoehe) && Hilfe.equal(hoehe, rechteck.breite);

		return gleich1 || gleich2;
	}

	@Override
	public void zeichnen(Graphics g, double koef) {
		g.drawRect(eckpunkte[0].x, eckpunkte[0].y, masstabierung(breite, koef), masstabierung(hoehe, koef));
		
	}


	public boolean contains(int x, int y) {
		boolean result = (x>=eckpunkte[0].x) && (x <= eckpunkte[0].x + breite);
		result = result && (y>=eckpunkte[0].y) && (y <= eckpunkte[0].y + hoehe);
		return result;
	}

}
