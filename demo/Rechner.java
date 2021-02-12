package geometrie.demo;
import java.util.Scanner; /* Klasse importieren */

public class Rechner {
	public static void main(String[] args) {
		// Variablen für Eingabe und Ergebnis
		Scanner sc = new Scanner(System.in);
		int a, b, summe;
		// Werte einlesen
		a = sc.nextInt();
		b = sc.nextInt();
		// Summe berechnen
		summe = a + b;
		// Summe ausgeben
		System.out.println("Ergebnis = " + summe);
	}
}
