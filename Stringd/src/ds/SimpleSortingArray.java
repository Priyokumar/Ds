package ds;

public class SimpleSortingArray {

	public static void main(String[] args) {

		int a[] = { 4, 7, 1, 3, 10, 9 };
		int b[] = new int[a.length];

		for (int i = 0; i < a.length; i++) {

			int min = a[0];
			int location = 0;
			for (int j = 0; j < a.length; j++) {
				if (a[j] != 0) {
					if (min < a[j]) {
						min = a[j];
						location = j;
					}
				}
			}
			a[location] = 0;
			b[i] = min;
		}
		
		for(int o : b)
			System.out.println(o);

	}

}
