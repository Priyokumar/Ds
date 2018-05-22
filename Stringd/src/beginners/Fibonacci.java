package beginners;

public class Fibonacci {

	public static void main(String[] args) {
		
		int min = 0;
		int max = 1;
		int count = 2;
		int curr = 1;
		System.out.print(min +", " + max + ", ");
		while(count < 20) {
			
			if (curr - max == min) {
				min = max;
				max = curr;
				count++;
				System.out.print(curr + ", ");
			}
			curr++;
		}

	}

}
