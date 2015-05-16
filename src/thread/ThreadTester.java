/**
 * 
 */
package thread;

/**
 * @author Daniyuu
 *
 */
public class ThreadTester {

	/**
	 * 
	 */
	public ThreadTester() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runnable threadJob = new MyRunnable();
		Thread myThread = new Thread(threadJob);
		
		myThread.start();
		
		System.out.println("back in main");

	}

}
