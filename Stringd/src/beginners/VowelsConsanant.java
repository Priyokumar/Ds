package beginners;

public class VowelsConsanant {

	static char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

	public static void main(String[] args) {

		System.out.println(isVowel('u'));

	}

	private static boolean isVowel(char c) {

		for (int i = 0; i <= vowels.length - 1; i++) {
			if (c == vowels[i]) {
				return true;
			}
		}

		return false;
	}

}
