package beginners;

public class Numbers {

	Numbers(int i) {

		System.out.println(i);
		i++;
		if (i <= 100)
			new Numbers(i);
	}

	public static void main(String[] ard) {
		int i = 1;
		new Numbers(i);
	}
}