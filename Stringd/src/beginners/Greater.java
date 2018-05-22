package beginners;

public class Greater {

	public static void main(String[] args) {

		int[] vals = { 1, 2, 21, 4, 31 };

		int big = vals[0];
		for (int i = 0; i <= vals.length-1; i++) {
			if (vals[i] > big)
				big = vals[i];
		}
		System.out.println(big);
	}

}
