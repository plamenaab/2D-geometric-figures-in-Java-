package geometrie;

import java.awt.Graphics;

public class FigurC extends GObjekt {
	
	//Aufgabe 2.1
	private int a;//halbaxe
	private int b;
	
	private Rechteck rechteck;
	private Ellipse elipse;
	
	
	//Aufgabe 2.2
	public FigurC() {
		this(new Punkt(0,0),1, 1);
	}

	//Aufgabe 2.3
	public FigurC(Punkt punkt, int aN, int bN) {
		super("Rechteck/Elipse", 1);
		objekteErzeugung(punkt, aN, bN);
	}
	
	
	//Aufgabe 2.4
	public FigurC(FigurC fig) {
		super("Rechteck/Elipse", 1);
		objekteErzeugung(fig.eckpunkte[0], fig.a, fig.b);
	}
	
	
	//Aufgabe 2.5
	private void objekteErzeugung(Punkt punkt, int aN, int bN) {
		eckpunkte[0] = punkt;
		a = aN;
		b = bN;
		rechteck = new Rechteck(eckpunkte[0] , 2*a, 2*b);
		elipse = new Ellipse(eckpunkte[0], 2*a, 2*b);
	}
	
	
	//Aufgabe 2.6
	@Override
	public int kontrolle() {
		if (a<=0) {
			return 1;
		}
		if (b<=0) {
			return 2;
		}
		return 0;
	}
	
	//Aufgabe 2.7
	@Override
	void eingabe() {
		System.out.println("Eingabe fuer FigurC: ");
		eckpunkte[0].eingabe();

		do {
			System.out.println("a: ");
			a = Hilfe.SCANNER.nextInt();
		} while (kontrolle() > 0);
		
		
		do {
			System.out.println("b: ");
			b = Hilfe.SCANNER.nextInt();
		} while (kontrolle() > 0);
	}

	
	//Aufgabe 2.8
	@Override
	double umfang() {
		return rechteck.umfang();
	}

	
	//Aufgabe 2.9
	@Override
	public double flaeche() {
		return rechteck.flaeche() - elipse.flaeche();
	}
    
	//Aufgabe 2.10
	@Override
	String art() {
		if (a == b) {
			return "Quadrat/Kreis";			
		} else {
			return "Rechteck/Elipse";
		}
	}

	@Override
	public void ausgabe() {
		System.out.println(this);
		System.out.println("Umfang: " + umfang());
		System.out.println("Flaeche: " + flaeche());
		System.out.println("Art: " + art());
	}

	@Override
	boolean equal(GObjekt objekt) {
		// TODO Auto-generated method stub
		return false;
	}
	//Aufgabe 2.12
	@Override
	public void zeichnen(Graphics g, double koef) {
		rechteck.zeichnen(g, koef);
		elipse.zeichnen(g, koef);
	}
	
	
	//Aufgabe 2.13
	public boolean contains(int x, int y) {
		return rechteck.contains(x,y) && !elipse.contains(x,y);
	}
	
	@Override
	public String toString() {
		return "FigurC: " + eckpunkte[0] + " - " + (a*2) + " - " + (b*2);
	}

}
