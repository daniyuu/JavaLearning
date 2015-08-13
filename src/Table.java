/**
 * 
 */

/**
 * @author Daniyuu
 *
 */
public class Table {
	private int manyItems;
	private Object[] keys;
	private Object[] data;
	private boolean[] hasBeenUsed;

	/**
	 * 
	 */
	public Table() {
		// TODO Auto-generated constructor stub
	}
	
	private Table(int capacity){
		if(capacity == 0)
			throw new IllegalArgumentException("Capacity is negatie.");
		keys = new Object[capacity];
		data = new Object[capacity];
		hasBeenUsed = new boolean[capacity];
	}
	
	public boolean containsKey(Object key){
		return false;
	}
	
	private int findIndex(Object key){
		int count = 0;
		int i = hash(key);
		
		while((count < data.length) && (hasBeenUsed[i])){
			if(key.equals(keys[i]))
				return i;
			count++;
			i = nextIndex(i);
		}
		
		return -1;
	}
	
	public Object get(Object key){
		int index = findIndex(key);
		if(index == -1){
			return null;
		}else{
			return data[index];
		}
	}
	
	public int hash(Object key){
		return Math.abs(key.hashCode()) % data.length;
	}
	
	private int nextIndex(int i){
		if(i + 1 == data.length){
			return 0;
		}else{
			return i + 1;
		}
	}
	
	private Object put(Object key, Object element){
		int index = findIndex(key);
		Object answer;
		
		if(index != -1){
			answer = data[index];
			data[index] = element;
			return answer;
		}else if(manyItems < data.length){
			index = hash(key);
			while(keys[index] != null){
				index = nextIndex(index);
			}
			keys[index] = key;
			data[index] = element;
			hasBeenUsed[index] = true;
			manyItems++;
			return null;
		}else{
			throw new IllegalStateException("Table is full.");
		}
	}
	
	private Object remove(Object key){
		int index = findIndex(key);
		Object answer = null;
		
		if(index != -1){
			answer = data[index];
			keys[index] = null;
			data[index] = null;
			manyItems--;
		}
		return answer;
	}

}
