package ds;

public class BinarySearch {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

		int search = 6;

		long currentTimeMillis = System.nanoTime();
		int len = arr.length / 2;
		int tempIndex = len + 1;
		
		System.out.println("No of iteration" +len);

		if (arr.length % 2 > 0) {
			tempIndex = len + 2;
			if (search == arr[len]) {
				System.out.println("found data at index : " + len + 1 + " || search value : " + search);
				System.out.println("Time Taken " + (currentTimeMillis - System.nanoTime()));
				return;
			}
		}

		for (int i = 0; i < len; i++) {

			if (arr[i] == search) {
				System.out.println("found data at index : " + i + " || search value : " + search);
				break;
			}

			if (arr[tempIndex] == search) {
				System.out.println("found data at index : " + tempIndex + " || search value : " + search);
				break;
			}
			tempIndex++;
		}

		System.out.println("Time Taken " + (currentTimeMillis - System.nanoTime()));

	}

}
