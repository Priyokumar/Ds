
public class StringD {

	public static void main(String[] args) {

		System.out.println(isP("cac"));

	}

	public static boolean isP(String word) {

		char[] charArr = word.toCharArray();

		String rev = "";
		for (int i = charArr.length-1; i >= 0; i--) {
			rev += charArr[i];
		}

		if (word.equals(rev))
			return true;
		else
			return false;
	}

}
