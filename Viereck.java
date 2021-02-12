package geometrie;

public class Viereck extends GObjekt {

	public Viereck() {
		super("Viereck", 4);

		eckpunkte = new Punkt[anzahl];
		eckpunkte[0] = new Punkt(20, 20);
		eckpunkte[1] = new Punkt(100, 40);
		eckpunkte[2] = new Punkt(120, 100);
		eckpunkte[3] = new Punkt(30, 100);

		seiten = new double[anzahl];
		seitenBerechnung();
	}

	public Viereck(Punkt[] punkte) {
		super("Viereck", 4);

		eckpunkte = new Punkt[anzahl];
		for (int i = 0; i < punkte.length; i++) {
			eckpunkte[i] = new Punkt(punkte[i]);
		}

		seiten = new double[anzahl];
		seitenBerechnung();
	}

	public Viereck(Viereck viereck) {
		super("Viereck", 4);

		eckpunkte = new Punkt[anzahl];
		for (int i = 0; i < viereck.eckpunkte.length; i++) {
			eckpunkte[i] = new Punkt(viereck.eckpunkte[i]);
		}

		seiten = new double[anzahl];
		seitenBerechnung();
	}

	@Override
	public int kontrolle() {
		if (eckpunkte[0].equal(eckpunkte[1])) {
			return 1;
		} else if (Math.abs(Dreieck.flaeche(eckpunkte[0], eckpunkte[1], eckpunkte[2])) < Hilfe.EPSILON) {
			return 2;
		} else {
			int signum1 = Hilfe.signum(Dreieck.flaeche(eckpunkte[0], eckpunkte[1], eckpunkte[3]));
			int signum2 = Hilfe.signum(Dreieck.flaeche(eckpunkte[0], eckpunkte[2], eckpunkte[3]));
			int signum3 = Hilfe.signum(Dreieck.flaeche(eckpunkte[1], eckpunkte[2], eckpunkte[3]));

			if (signum1 != signum2 || signum1 != signum3 || signum2 != signum3) {
				return 3;
			} else {
				return 0;
			}
		}
	}

	@Override
	public void eingabe() {
		do {
			System.out.println("Eingabe fuer Viereck: ");

			for (int i = 0; i < eckpunkte.length; i++) {
				System.out.println("Koordinaten fuer Punkt " + i);

				eckpunkte[i].eingabe();
			}
		} while (kontrolle() > 0);

		seitenBerechnung();
	}

	@Override
	public double umfang() {
		return seiten[0] + seiten[1] + seiten[2] + seiten[3];
	}

	@Override
	public double flaeche() {
		double flaeche1 = Dreieck.flaeche(eckpunkte[0], eckpunkte[1], eckpunkte[2]);
		double flaeche2 = Dreieck.flaeche(eckpunkte[0], eckpunkte[2], eckpunkte[3]);

		return flaeche1 + flaeche2;
	}

	@Override
	public String art() {
		String art;

		double koeffizient1 = Gerade.koeffizient(eckpunkte[0], eckpunkte[1]);
		double koeffizient2 = Gerade.koeffizient(eckpunkte[1], eckpunkte[2]);
		double koeffizient3 = Gerade.koeffizient(eckpunkte[2], eckpunkte[3]);
		double koeffizient4 = Gerade.koeffizient(eckpunkte[3], eckpunkte[0]);

		if (Hilfe.equal(koeffizient1, koeffizient3) && Hilfe.equal(koeffizient2, koeffizient4)) {
			art = "Parallelogram";
		} else if (Hilfe.equal(koeffizient1, koeffizient3) || Hilfe.equal(koeffizient2, koeffizient4)) {
			art = "Trapez";
		} else {
			art = "gewoehnliches Viereck";
		}

		return art;
	}

	@Override
	public boolean equal(GObjekt objekt) {
		/*
		Viereck viereck = (Viereck) objekt;

		Punkt[] punkte1 = { eckpunkte[0], eckpunkte[1], eckpunkte[2] };
		Dreieck dreieck1 = new Dreieck(punkte1);

		Punkt[] punkte2 = { eckpunkte[0], eckpunkte[2], eckpunkte[3] };
		Dreieck dreieck2 = new Dreieck(punkte2);

		Punkt[] punkte3 = { viereck.eckpunkte[0], viereck.eckpunkte[1], viereck.eckpunkte[2] };
		Dreieck dreieck3 = new Dreieck(punkte3);

		Punkt[] punkte4 = { viereck.eckpunkte[0], viereck.eckpunkte[2], viereck.eckpunkte[3] };
		Dreieck dreieck4 = new Dreieck(punkte4);

		return dreieck1.equal(dreieck3) && dreieck2.equal(dreieck4);
		*/
		return false;
	}

	@Override
	public String toString() {
		return "Viereck" + eckpunkte[0] + " - " + eckpunkte[1] + " - " + eckpunkte[2] + " - " + eckpunkte[3];
	}

	@Override
	public void ausgabe() {
		System.out.println(this);
		System.out.println("Umfang: " + umfang());
		System.out.println("Flaeche: " + flaeche());
		System.out.println("Art: " + art());
	}
}
