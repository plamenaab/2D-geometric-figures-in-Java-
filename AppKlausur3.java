package geometrie;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
//Aufgabe 3
public class AppKlausur3 extends Applet {

	
	//Aufgabe 3.2
	@Override
	public void paint(Graphics g) {
		setSize(new Dimension(900, 300));
		setForeground(Color.RED);
		double koef = 30;
		for (int i = 0; i < 6; i++) {
			
			if ((i % 2) == 0) {
				FigurC fig = new FigurC(new Punkt(i * 60, 0), 1, 1);
			    fig.zeichnen(g, koef);
			} else {
				FigurC fig1 = new FigurC(new Punkt(i * 60, 60), 1, 1);
				fig1.zeichnen(g, koef);
			}
		}
	}

}
