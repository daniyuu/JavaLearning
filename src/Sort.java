/**
 * 
 */

/**
 * @author daniyuu
 *
 */
public class Sort {

	/**
	 * 
	 */
	public Sort() {
		// TODO Auto-generated constructor stub
	}
	
	public static void bubbleSort(int[] source){
		for(int i = source.length - 1; i > 0; i--){
			for(int j = 0; j < i; ++j){
				if(source[j] > source[j + 1]){
					swap(source,j,j+1);
				}
			}
		}
	}
	
	private static void swap(int[] source, int x, int y){
		int temp = source[x];
		source[x] = source[y];
		source[y] = temp;
	}

}
