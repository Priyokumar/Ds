package beginners;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StringTest {

	static String[] countOne(int n) {

		String binaryString = Integer.toBinaryString(n);
		String[] result = new String[2];
		char[] arr = binaryString.toCharArray();

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '1')
				count++;
		}

		result[0] = binaryString;
		result[1] = count + "";

		return result;
	}

	/**
	 * Complete the function below. DONOT MODIFY anything outside this function!
	 */
	static int[] rearrange(int[] elements) {

		elements = sortByBinary(elements);

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < elements.length; i++) {

			if (list.isEmpty())
				list.add(elements[i]);
			else {
				if (list.get(list.size() - 1).intValue() != elements[i]) {
					list.add(elements[i]);
				}
			}

		}

		int[] opp = new int[list.size()];
		
		for(int i = 0 ; i < opp.length ; i++) {
			opp[i] = list.get(i);
		}
		
		return opp;
	}

	public static int[] sortByBinary(int[] elements) {

		for (int i = 0; i < elements.length - 1; i++) {

			Integer curr = Integer.valueOf(countOne(elements[i])[1]);
			Integer nxt = Integer.valueOf(countOne(elements[i + 1])[1]);

			if (curr > nxt) {
				int t = elements[i];
				elements[i] = elements[i + 1];
				elements[i + 1] = t;
				sortByBinary(elements);
			}
			
			if(curr.equals(nxt)) {
				if (elements[i] > elements[i + 1]) {
					int t = elements[i];
					elements[i] = elements[i + 1];
					elements[i + 1] = t;
					sortByBinary(elements);
				}
			}
		}
		return elements;
	}

	/**
	 * DO NOT MODIFY THIS METHOD!
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		int n = 0;
		n = Integer.parseInt(in.nextLine().trim());
		int[] elements = new int[n];
		int element;
		for (int i = 0; i < n; i++) {
			element = Integer.parseInt(in.nextLine().trim());
			elements[i] = element;
		}

		// call rearrange function
		int[] results = rearrange(elements);

		for (int i = 0; i < results.length; i++) {
			System.out.println(String.valueOf(results[i]));
		}
	}
}
