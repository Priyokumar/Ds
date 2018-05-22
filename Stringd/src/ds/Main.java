package ds;

public class Main {

	public static void main(String[] args) {

		/*ArrayList arrList = new ArrayList();
		arrList.add("1").add("2").add("3").add("4").add("5").add("6");
		for (int i = 0; i < arrList.size(); i++)
			System.out.println(arrList.get(i));*/
		
		
		
		Stack st = new Stack(5);
		st.push("1").push("2").push("3").push("4").push("5");

		for(String d  :st.values())
			System.out.println(d);
		
		System.out.println("----------PEEK-------------");
		System.out.println(st.peek());
		
		System.out.println("-------3-----After POP----------------");
		
		st.pop().pop().pop();
		
		for(String d  :st.values())
			System.out.println(d);
		
		System.out.println("----------PEEK-------------");
		System.out.println(st.peek());
		
	}
}
