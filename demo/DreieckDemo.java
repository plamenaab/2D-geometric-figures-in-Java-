package geometrie.demo;

import geometrie.Dreieck;
import geometrie.Punkt;

public class DreieckDemo {

	public static void main(String[] args) {
		Dreieck dreieck1 = new Dreieck();
		
		Punkt[] punkte = new Punkt[3];
		punkte[0] = new Punkt(2, 0);
		punkte[1] = new Punkt(3, 0);
		punkte[2] = new Punkt(4, 1);
		Dreieck dreieck2 = new Dreieck(punkte);
		
		Dreieck dreieck3 = new Dreieck();
		dreieck3.eingabe();
		
		Dreieck dreieck4 = new Dreieck(dreieck3);
		
		System.out.println("Ausgabe fuer Dreieck 1: ");
		dreieck1.ausgabe();
		
		System.out.println("Ausgabe fuer Dreieck 2: ");
		dreieck2.ausgabe();
		
		System.out.println("Ausgabe fuer Dreieck 3: ");
		dreieck3.ausgabe();
		
		System.out.println("Ausgabe fuer Dreieck 4: ");
		dreieck4.ausgabe();
		
		if (dreieck1.equal(dreieck3)) {
			System.out.println("Dreieck 1 und Dreieck 3 sind gleich!");
		} else {
			System.out.println("Dreieck 1 und Dreieck 3 sind ungleich!");
		}
	}
	
}
