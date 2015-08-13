/**
 * 
 */

/**
 * @author Daniyuu
 *
 */
public class ChainedTable {
	private ChainedHashNode[] table;
	/**
	 * 
	 */
	public ChainedTable(int tableSize) {
		if(tableSize <= 0){
			throw new IllegalArgumentException("Table size must be positive.");
		}
		table = new ChainedHashNode[tableSize];
	}
	
	public int hash(Object key){
		return Math.abs(key.hashCode());
	}
	
	public Object put(Object key, Object element){
		ChainedHashNode cursor = null;
		Object answer = null;
		
		if(cursor == null){
			int i = hash(key);
			cursor = new ChainedHashNode();
			cursor.element = element;
			cursor.key = key;
			cursor.link = table[i];
			table[i] = cursor;
		}else{
			answer = cursor.element;
			cursor.element = element;
		}
		return answer;
	}

}

class ChainedHashNode {

	public Object element;
	public Object key;
	public ChainedHashNode link;

}
