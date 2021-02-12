package geometrie;

public class Punkt {

	protected int x;

	protected int y;

	public Punkt() {
		x = 0;
		y = 0;
	}

	public Punkt(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Punkt(Punkt punkt) {
		x = punkt.x;
		y = punkt.y;
	}

	public void eingabe() {
		System.out.println("Eingabe fuer einen Punkt");

		System.out.println("Geben Sie x ein: ");
		x = Hilfe.SCANNER.nextInt();

		System.out.println("Geben Sie y ein: ");
		y = Hilfe.SCANNER.nextInt();
	}

	public void move(int xDelta, int yDelta) {
		x = x + xDelta;
		y = y + yDelta;
	}

	public Punkt moveNew(int xDelta, int yDelta) {
		int newX = x + xDelta;
		int newY = y + yDelta;

		return new Punkt(newX, newY);
	}

	public boolean equal(Punkt punkt) {
		boolean xEqual = Hilfe.equal(x, punkt.x);
		boolean yEqual = Hilfe.equal(y, punkt.y);

		return xEqual && yEqual;
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	public void ausgabe() {
		System.out.println(this);
	}

}
