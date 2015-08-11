import java.util.EmptyStackException;

/**
 * 
 */

/**
 * @author Daniyuu
 *
 */
public class ArrayStack<E> implements Cloneable {
	private E[] data;
	private int manyItems;
	/**
	 * 
	 */
	public ArrayStack() {
		final int INITIAL_CAPACITY = 10;
		manyItems = 0;
		data = (E[]) new Object[INITIAL_CAPACITY];
	}
	
	public ArrayStack(int initialCapacity){
		if(initialCapacity < 0){
			throw new IllegalArgumentException("initialCapacity too small " + initialCapacity);
		}
		manyItems = 0;
		data = (E[]) new Object[initialCapacity];
	}
	
	public ArrayStack<E> clone(){
		ArrayStack<E> answer;
		try{
			answer = (ArrayStack<E>) super.clone();
		}catch(CloneNotSupportedException e){
			throw new RuntimeException("This class does not implement Cloneable.");
		}
		answer.data = data.clone();
		
		return answer;
	}
	
	public void ensureCapacity(int minimumCapacity){
		E biggerArray[];
		if(data.length < minimumCapacity){
			biggerArray = (E[])new Object[minimumCapacity];
			System.arraycopy(data, 0, biggerArray, 0, manyItems);
			data = biggerArray;
		}
	}
	
	public int getCapacity(){
		return data.length;
	}
	
	public boolean isEmpty(){
		return (manyItems == 0);
	}
	
	public E peek(){
		if(manyItems == 0){
			throw new EmptyStackException();
		}
	    return data[manyItems - 1];
		
	}
	
	public E pop(){
		E answer;
		if(manyItems == 0){
			throw new EmptyStackException();
		}
		answer = data[--manyItems];
		data[manyItems] = null;
		return answer;
	}
	
	public void push(E item){
		if(manyItems == data.length){
			ensureCapacity(manyItems * 2 + 1);
		}
		data[manyItems] = item;
		manyItems++;
	}
	
	public int size(){
		return manyItems;
	}
	
	public void trimToSize(){
		E trimmedArray[];
		if(data.length != manyItems){
			trimmedArray = (E[]) new Object[manyItems];
			System.arraycopy(data, 0, trimmedArray, 0, manyItems);
			data = trimmedArray;
		}
	}
	

}
