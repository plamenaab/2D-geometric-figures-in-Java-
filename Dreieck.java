package geometrie;

public class Dreieck extends GObjekt {

	public Dreieck() {
		super("Dreieck", 3);

		eckpunkte = new Punkt[anzahl];
		eckpunkte[0] = new Punkt(0, 0);
		eckpunkte[1] = new Punkt(1, 0);
		eckpunkte[2] = new Punkt(0, 1);

		seiten = new double[anzahl];
		seitenBerechnung();
	}
	
	public Dreieck(Punkt[] punkte) {
		super("Dreieck", 3);

		eckpunkte = new Punkt[anzahl];
		for (int i = 0; i < punkte.length; i++) {
			eckpunkte[i] = new Punkt(punkte[i]);
		}

		seiten = new double[anzahl];
		seitenBerechnung();
	}

	public Dreieck(Dreieck dreieck) {
		super("Dreieck", 3);

		eckpunkte = new Punkt[anzahl];
		for (int i = 0; i < dreieck.eckpunkte.length; i++) {
			eckpunkte[i] = new Punkt(dreieck.eckpunkte[i]);
		}

		seiten = new double[anzahl];
		seitenBerechnung();
	}

	@Override
	public int kontrolle() {
		if (eckpunkte[0].equal(eckpunkte[1])) {
			return 1;
		} else if (Math.abs(flaeche(eckpunkte[0], eckpunkte[1], eckpunkte[2])) < Hilfe.EPSILON) {
			return 2;
		} else {
			return 0;
		}
	}

	@Override
	public void eingabe() {
		do {
			System.out.println("Eingabe fuer Dreieck: ");

			for (int i = 0; i < eckpunkte.length; i++) {
				System.out.println("Koordinaten fuer Punkt " + i);

				eckpunkte[i].eingabe();
			}
		} while (kontrolle() > 0);

		seitenBerechnung();
	}

	@Override
	public double umfang() {
		return seiten[0] + seiten[1] + seiten[2];
	}

	@Override
	public double flaeche() {
		double p = (seiten[0] + seiten[1] + seiten[2]) / 2;

		return Math.sqrt(p * (p - seiten[0]) * (p - seiten[1]) * (p - seiten[2]));
	}

	@Override
	public String art() {
		String art;

		if (Hilfe.equal(seiten[0], seiten[1]) && Hilfe.equal(seiten[1], seiten[2])) {
			art = "gleichseitig";
		} else if (Hilfe.equal(seiten[0], seiten[1]) 
				|| Hilfe.equal(seiten[1], seiten[2]) 
				|| Hilfe.equal(seiten[2], seiten[0])) {
			art = "gleichschenklig";
		} else {
			art = "ungleihseitig";
		}

		double maxWinkel = maxWinkel();

		if (Hilfe.equal(maxWinkel, Math.PI / 2)) {
			art = art + " rechtwinklig";
		} else if (maxWinkel > Math.PI / 2) {
			art = art + " stumpfwinklig";
		} else {
			art = art + " spitzwinklig";
		}

		return art;
	}

	public double maxWinkel() {
		double alpha = winkel(seiten[0], seiten[1], seiten[2]);
		double beta = winkel(seiten[1], seiten[2], seiten[0]);
		double gama = winkel(seiten[2], seiten[0], seiten[1]);

		double maxWinkel = alpha;

		if (beta > maxWinkel) {
			maxWinkel = beta;
		}

		if (gama > maxWinkel) {
			maxWinkel = gama;
		}

		return maxWinkel;
	}

	@Override
	public boolean equal(GObjekt objekt) {
		Dreieck dreieck = (Dreieck) objekt;

		return Hilfe.equal(seiten[0], dreieck.seiten[0]) 
				&& Hilfe.equal(seiten[1], dreieck.seiten[1]) 
				&& Hilfe.equal(seiten[2], dreieck.seiten[2]);
	}

	@Override
	public String toString() {
		return "Dreieck mit: " + eckpunkte[0] + " - " + eckpunkte[1] + " - " + eckpunkte[2];
	}

	@Override
	public void ausgabe() {
		System.out.println(this);
		System.out.println("Umfang: " + umfang());
		System.out.println("Flaeche: " + flaeche());
		System.out.println("Art: " + art());
	}

	public static double flaeche(Punkt punkt1, Punkt punkt2, Punkt punkt3) {
		double sum = punkt1.x * (punkt2.y - punkt3.y) 
				+ punkt2.x * (punkt3.y - punkt1.y) 
				+ punkt3.x * (punkt1.y - punkt2.y);

		return 0.5 * sum;
	}

	public static double winkel(double a, double b, double c) {
		double sum = (b * b + c * c - a * a) / 2 * b * c;

		return Math.acos(sum);
	}	
}
