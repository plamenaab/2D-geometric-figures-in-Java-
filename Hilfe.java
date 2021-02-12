package geometrie;

import java.util.Scanner;

public class Hilfe {

	public static final Scanner SCANNER = new Scanner(System.in);

	public static final double EPSILON = 1e-4;

	public static boolean equal(double x, double y) {
		return Math.abs(x - y) < EPSILON;
	}

	public static double quad(double x) {
		return x * x;
	}

	public static int signum(double x) {
		if (x > EPSILON) {
			return 1;
		} else if (x < EPSILON) {
			return -1;
		} else {
			return 0;
		}
	}

}
