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
	// o(n^2)
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
	
	// o(n^2)
	public static void selectSort(int[] source){
		for(int i = 0; i < source.length; ++i){
			for(int j = i + 1;j < source.length; ++j){
				if(source[i] > source[j]){
					swap(source,i,j);
				}
			}
		}
	}

	//
	public static void insertSort(int[] source){
		for(int i = 1; i < source.length;++i){
			for(int j = i; (j > 0) && (source[j] < source[j - 1]); j--){
				swap(source,j,j-1);
			}
		}
	}
}
