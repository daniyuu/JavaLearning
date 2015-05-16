/**
 * 
 */
package thread;

/**
 * @author Daniyuu
 *
 */
public class MyRunnable implements Runnable {

	/**
	 * 
	 */
	public MyRunnable() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		go();

	}
	
	public void go(){
		doMore();
	}
	
	public void doMore(){
		System.out.println("top o' the stack");
	}

}
