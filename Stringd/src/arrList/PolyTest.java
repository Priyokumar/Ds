package arrList;


public class PolyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassA a = new ClassC();
		ClassC c = (ClassC) new ClassA();
		
		
		
		String ff= "dere";
		String df= "dere";
		String h= "dere";
		
		
		df ="tt";
		String ffrr = "tt";
		String y= "dere";
		
		
		
		String dd = new String("sdsd");
		
		c.methodA();
		c.methodC();

	}

}


class ClassA {
	
	protected void methodA() {
		System.out.println("A");
	}
	
}

class ClassB extends ClassA {
	
	protected void methodA() {
		System.out.println("B");
	}
	
}

class ClassC extends ClassB{
	
	protected void methodC() {
		System.out.println("C");
	}
	
	/*protected void methodA() {
		System.out.println("A");
	}
	*/
}