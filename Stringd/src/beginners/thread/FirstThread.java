package beginners.thread;

public class FirstThread extends Thread{

	public void run() {
		System.out.println("Thread is runninhg");
	}
	
	public static void main(String[] args) {

		FirstThread t = new FirstThread();
		
		t.start();

	}

}
