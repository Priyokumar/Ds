package beginners;

public class SelectionSort {
	public static void main(String[] args) {

		int[] arr = { 8, 6, 3, 9, 5, 3 };

		int len = arr.length;

		for (int i = 0; i < len - 2; i++) {

			int minIndx = i;

			for (int j = i; j < len; j++) {
				if (arr[j] < arr[minIndx]) {
					minIndx = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndx];
			arr[minIndx] = temp;
		}

		for (int i : arr)
			System.out.print(" " + i);

	}
}
