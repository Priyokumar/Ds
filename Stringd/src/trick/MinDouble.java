package trick;

public class MinDouble {

	public static void main(String[] args) {
		
		System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
		System.out.println(0.1*3);
		
		try {
			
			Double dd = 1.0 / 0.0;
			System.out.println(dd);
		}catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		System.out.println("-----------------------------------------------------------------");
		
		for (int i = 0; i < 12; i++) {
		      System.out.println(0.1 * i);
		      }
		
		
	}

}
