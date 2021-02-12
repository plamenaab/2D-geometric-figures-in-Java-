package geometrie;

import java.awt.Graphics;

public abstract class GObjekt implements GOZeichnen {

	protected String name;

	protected int anzahl;

	protected Punkt[] eckpunkte;
	protected Punkt[] eckpunkteZ;

	protected double[] seiten;

	public GObjekt(String name, int anzahl) {
		eckpunkte = new Punkt[anzahl];
		this.name = name;
		this.anzahl = anzahl;
	}

	abstract void eingabe();

	abstract int kontrolle();

	abstract double umfang();

	public abstract double flaeche();

	abstract String art();

	abstract void ausgabe();

	abstract boolean equal(GObjekt objekt);

	public void seitenBerechnung() {
		for (int i = 0; i < eckpunkte.length; i++) {
			int j;

			if (i < eckpunkte.length - 1) {
				j = i + 1;
			} else {
				j = 0;
			}

			seiten[i] = Gerade.abstand(eckpunkte[i], eckpunkte[j]);
		}
	}
	
	@Override
	public void zeichnen(Graphics g, double koef) {
		g.drawPolyline(getXs(), getYs(), eckpunkte.length + 1);
		
	}

	private int[] getYs() {
		int[] result = new int[eckpunkte.length+1];
		for (int i = 0; i < eckpunkte.length; i++) {
			result[i] = eckpunkte[i].y;
		}
		result[eckpunkte.length] = eckpunkte[0].y;
		return result;
	}

	private int[] getXs() {
		int[] result = new int[eckpunkte.length+1];
		for (int i = 0; i < eckpunkte.length; i++) {
			result[i] = eckpunkte[i].x;
		}
		result[eckpunkte.length] = eckpunkte[0].x;
		return result;
	}
	
	
	protected int masstabierung(int toMasstabieren, double koef) {
		return new Double(toMasstabieren* koef).intValue();
	}
}
