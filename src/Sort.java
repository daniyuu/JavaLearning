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

	// o(n^2)
	public static void insertSort(int[] source){
		for(int i = 1; i < source.length;++i){
			for(int j = i; (j > 0) && (source[j] < source[j - 1]); j--){
				swap(source,j,j-1);
			}
		}
	}
	
	public static void ShellSort(int[] source, int Index){
		int i,j,k;
		int Temp;
		boolean Change;
		int DataLength;
		int Pointer;
		
		DataLength = (int) Index /2;
		
		while(DataLength != 0){
			for(j = DataLength; j <Index; j++){
				Change = false;
				Temp = source[j];
				Pointer = j - DataLength;
				
				while(Temp < source[Pointer] && Pointer >= 0 && Pointer <= Index){
					source[Pointer + DataLength] = source[Pointer];
					Pointer = Pointer - DataLength;
					Change = true;
					if(Pointer < 0 || Pointer > Index){
						break;
					}
				}
				
				source[Pointer + DataLength] = Temp;
				
				if(Change){
					System.out.println("sorting...");
					for(k = 0; k < Index; ++k){
						System.out.printf("%3s ", source[k]);
					System.out.println("");
					}
				}
				DataLength = DataLength / 2;
			}
		}
	}
	
	
}
