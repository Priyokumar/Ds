package beginners;

public class Prime {

	public static void main(String[] arg) {
		
		String prime = "";
		for (int i = 2; i < 20; i++) {

			boolean isprime = true;
			for (int j = 2; j < i; j++) {

				if (i % j == 0) {
					isprime = false;
					break;
				}
			} 
			if (isprime) {
				if (i != 0)
					prime += " " + i;
			}
		}
		System.out.println(prime);
	}
}
