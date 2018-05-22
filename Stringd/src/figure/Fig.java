package figure;

public class Fig {
	
	private static final int x = 6;

	public static void main(String[] args) {

		/*System.out.println("                         Figure 1-----------\n");
		drawFig1();
		System.out.println("                         Figure 2-----------\n");
		drawFig2(); 
		System.out.println("                         Figure 4-----------\n");
		drawFig4();
		System.out.println("                         Figure 5-----------\n");
		drawFig5();
		System.out.println("                         Figure 6-----------\n");
		drawFig6();
		System.out.println("                         Figure 7-----------\n");
		drawFig7();
		System.out.println("                         Figure 8-----------\n");*/

	}

	public static void drawFig7() {

		int star = x;
		for (int i = 0; i < x; i++) {

			for (int j = 0, k = 0; j < x+1; j++, k++) {

				if (star != k && k < star)
					System.out.print("*");
				else
					System.out.print(" ");
			}

			star--;
			System.out.println();
		}
	}
	
	public static void drawFig6() {

		int star = x;
		for (int i = 0; i < x; i++) {

			for (int j = 0, k = 0; j < x+1; j++, k++) {

				if (star != k && k < star)
					System.out.print(" ");
				else
					System.out.print("*");
			}

			star--;
			System.out.println();
		}
	}
	
	public static void drawFig5() {

		int star = x ;
		for (int i = 0; i < x; i++) {

			for (int j = 0, k = 0; j < x+1; j++, k++) {

				if (star != k)
					System.out.print(" ");
				if (star > k)
					System.out.print("*");
			}

			star--;
			System.out.println();
		}
	}
	
	public static void drawFig4() {

		int star = x - 1;
		for (int i = 0; i < x; i++) {

			for (int j = 0, k = 0; j < x+1; j++, k++) {

				if (star != k)
					System.out.print(" ");
				if (star < k)
					System.out.print("*");
			}
			star--;
			System.out.println();
		}
	}

	public static void drawFig1() {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void drawFig2() {
		for (int i = 0; i < x; i++) {
			for (int j = x; j > i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
