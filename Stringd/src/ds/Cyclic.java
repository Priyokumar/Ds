package ds;

public class Cyclic {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };

		int length = arr.length;
		int len = 1;
		int init = arr[length - 1];

		for (int i = 0; i < length - 1; i++) {

			arr[length - len] = arr[length - len - 1];
			len++;
		}
		arr[0] = init;
		
		for(int k : arr)
			System.out.println(k);
	}

}
