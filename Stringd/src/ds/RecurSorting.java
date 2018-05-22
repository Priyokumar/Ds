package ds;

public class RecurSorting {

	public static void main(String[] args) {
		int[] elements = {5,5,3,7,10,14};
		
		elements = rearrange(elements);
		
		for(int i : elements)
			System.out.println("vvvvvvvv --" +i);
		
	}
	
	static int[] rearrange(int[] elements) {

		for (int i = 0; i < elements.length - 1; i++) {
			if (elements[i] > elements[i + 1]) {
				int t = elements[i];
				elements[i] = elements[i + 1];
				elements[i + 1] = t;
				rearrange(elements);
			}
		}

		
		
		return elements;
	}
}
