package ds;

public class Nby2 {

	public static void main(String[] args) {

		NintoLess();

		// Ninto2();

	}

	private static void Ninto2() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int k = 0;
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr.length; j++) {

				if (arr[j] == 0) {
					System.out.print(" ");
				} else
					System.out.print(arr[j]);

			}
			arr[k] = 0;
			k++;
			System.out.println();
		}
	}

	private static void NintoLess() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int n = arr.length;
		int d = 2;

		for (int i = 0; i < d; i++) {

			int t = arr[0];
			for (int j = 0; j < n; j++) {

				if (j == n - 1)
					arr[j] = t;
				else
					arr[j] = arr[j + 1];
			}
		}

		for (int l : arr)
			System.out.println(l);
	}

}
