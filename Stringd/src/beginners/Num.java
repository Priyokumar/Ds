package beginners;

public class Num {

	static int i;

	public Num() {
		if (i < 100) {
			System.out.print(" "+ ++i);
			new Num();
		}
	}

	public static void main(String[] args) {
		new Num();
	}
}
