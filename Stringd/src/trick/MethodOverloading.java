package trick;

public class MethodOverloading {
	
	public static Object get(Object str) {
		return "Object";
	}
	
	public static String get(String str) {
		return "String";
	}

	public static void main(String[] args) {

		System.out.println(MethodOverloading.get(null));

	}

}
