/**
 * 
 */

/**
 * @author Daniyuu
 *
 */
public class Test {

	/**
	 * 
	 */
	public Test() {
		// TODO Auto-generated constructor stub
		int[] scores = new int[4];
		scores[2] = 1;
		System.out.println(scores[2]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t[] = {1,2,3};
		change(t,2,7);
		for(int i = 0; i < t.length; ++i){
			System.out.println(t[i]);
		}

	}
	
	private static void change(int[] t,int pos, int num){
		t[pos] = num;
	}

}
