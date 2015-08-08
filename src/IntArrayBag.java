/**
 * 
 */

/**
 * @author daniyuu
 *
 */
public class IntArrayBag implements Cloneable {
	private int manyItems;
	private int [] data ;
	
	/**
	 * 
	 */
	public IntArrayBag() {
		final int INITIAL_CAPACITY = 10;
		manyItems = 0;
		data = new int[INITIAL_CAPACITY];
	}
	
	public IntArrayBag(int initialCapacity){
		if(initialCapacity < 0)
			throw new IllegalArgumentException("initialCapacity is negative: " + initialCapacity);
		
		manyItems = 0;
		data = new int[initialCapacity];
	}
	
	public void add(int element){
		if(manyItems == data.length){
			ensureCapacity(manyItems*2 + 1);
		}
		data[manyItems] = element;
		manyItems++;
	}
	
	public void addAll(IntArrayBag addend){
		ensureCapacity(manyItems + addend.manyItems);
		
		System.arraycopy(addend.data, 0, data, manyItems, addend.manyItems);
		manyItems += addend.manyItems;
	}

	
	public void addMany(int... elements){
		if(manyItems + elements.length > data.length){
			ensureCapacity((manyItems + elements.length) * 2);
		}
		System.arraycopy(elements, 0, data, manyItems, elements.length);
		manyItems += elements.length;
	}
	
	public boolean remove(int target){
		int index;
		
		index = 0;
		while((index < manyItems) && (target != data[index]))
			index++;
		
		if(index == manyItems){
			return false;
		}else{
			manyItems--;
			data[index] = data[manyItems];
			return true;
		}
		
	}
	
	public int countOccurrences(int target){
		int answer;
		int index;
		
		answer = 0;
		
		for(index = 0;index < manyItems; index++){
			if(target == data[index]){
				answer++;
			}
		}
		
		return answer;
	}
	
	public static IntArrayBag union(IntArrayBag b1, IntArrayBag b2){
		IntArrayBag answer = new IntArrayBag(b1.getCapacity() + b2.getCapacity());
		System.arraycopy(b1.data, 0, answer.data, 0, b1.manyItems);
		System.arraycopy(b2.data, 0, answer.data, b1.manyItems, b2.manyItems);
		
		answer.manyItems = b1.manyItems + b2.manyItems;
		
		return answer;
	}
	
	public IntArrayBag clone(){
		IntArrayBag answer;
		try{
			answer = (IntArrayBag) super.clone();
		}catch(
				CloneNotSupportedException e){
			throw new RuntimeException("This class does not implement Clonable.");
		}
		
		answer.data = data.clone();
		
		return answer;
	}
	
	public void ensureCapacity(int minimumCapacity){
		int[] biggerArray;
		
		if(data.length < minimumCapacity){
			biggerArray = new int[minimumCapacity];
			System.arraycopy(data, 0, biggerArray, 0, manyItems);
			data = biggerArray;
		}
	}
	
	public int getCapacity(){
		return data.length;
	}
	
	public int size(){
		return manyItems;
	}
	
	public void trimToSize(){
		int[] trimmedArray;
		
		if(data.length != manyItems){
			trimmedArray = new int[manyItems];
			System.arraycopy(data, 0, trimmedArray, 0, manyItems);
			data = trimmedArray;
		}
	}
}
