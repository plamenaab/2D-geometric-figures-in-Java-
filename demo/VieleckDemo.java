package geometrie.demo;

import geometrie.Punkt;
import geometrie.Vieleck;

public class VieleckDemo {
	public static void main(String[] args) {
	Vieleck v1,v2,v3,v4,v5;
		v1=new Vieleck(5);
		v2=new Vieleck(5,3);
		v3=new Vieleck(5);
		System.out.println("Eingabe fuer Vieleck:");
		v3.eingabe();
		Punkt zentrum= new Punkt(3,3);
		v4=new Vieleck(6,zentrum,2);
		v5=new Vieleck(v4);
		System.out.println("Ausgabe fuer Vieleck 1: ");
		v1.ausgabe();

		System.out.println("Ausgabe fuer Vieleck 2: ");
		v2.ausgabe();

		System.out.println("Ausgabe fuer Vieleck 3: ");
		v3.ausgabe();

		System.out.println("Ausgabe fuer Vieleck 4: ");
		v4.ausgabe();
		
		System.out.println("Ausgabe fuer Vieleck 5: ");
		v5.ausgabe();

			
	}

	

}
