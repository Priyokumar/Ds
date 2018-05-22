package ds;

public class Bby2 {

	public static void main(String[] args) {

		long tm1 = System.currentTimeMillis();

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("1st Called --------------------");
				print(nBy2());
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("2nd Called --------------------");
				print(NintoLess());
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("3rd Called --------------------");
				Ninto2();
			}
		}).start();

		System.out.println("Time taken by thread : " + (System.currentTimeMillis() - tm1));

	}

	private static void print(int[] newArr) {
		for (int o : newArr)
			System.out.println(o);
	}

	private static int[] nBy2() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] newArr = new int[arr.length];

		int halfLen = (arr.length) / 2;
		int mid = halfLen;
		int odd = arr.length % 2;

		int length = arr.length - 1;

		int j = 0;
		int k = mid;

		if (odd > 0) {
			k = mid + 1;
			newArr[mid] = arr[mid];
		}

		for (int i = halfLen; i > 0; i--) {

			newArr[j] = arr[length];
			length--;
			j++;

			newArr[k] = arr[mid - 1];
			mid--;
			k++;

		}
		return newArr;
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

	private static int[] NintoLess() {
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

		return arr;
	}
}
