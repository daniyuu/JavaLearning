import java.util.NoSuchElementException;

/**
 * 
 */

/**
 * @author Daniyuu
 *
 */
public class ArrayQueue<E> implements Cloneable {
	private E[] data;
	private int manyItems;
	private int front;
	private int rear;
	/**
	 * 
	 */
	public ArrayQueue() {
		final int INITIAL_CAPACITY = 10;
		manyItems = 0;
		data = (E[]) new Object[INITIAL_CAPACITY];
	}
	
	public ArrayQueue(int initialCapacity){
		if(initialCapacity < 0){
			throw new IllegalArgumentException("initialCapacity is negative: " + initialCapacity);
		}
		manyItems = 0;
		data = (E[]) new Object[initialCapacity];
	}
	
	public void add(E item){
		if(manyItems == data.length){
			ensureCapacity(manyItems * 2 + 1);
		}
		
		if(manyItems == 0){
			front = 0;
			rear = 0;
		}else{
			rear = nextIndex(rear);
		}
		
		data[rear] = item;
		manyItems++;
	}
	
	public ArrayQueue<E> clone(){
		ArrayQueue<E> answer;
		
		try{
			answer = (ArrayQueue<E>) super.clone();
		}catch(CloneNotSupportedException e){
			throw new RuntimeException("This class does not implement Cloneable.");
		}
		
		answer.data = data.clone();
		return answer;
	}
	
	public int getCapacity(){
		return data.length;
	}
	
	public boolean isEmpty(){
		return (manyItems == 0);
	}
	
	public int nextIndex(int i){
		if(++i == data.length){
			return 0;
		}else{
			return i;
		}
	}
	
	public void ensureCapacity(int minimumCapacity){
		E[] biggerArray;
		int n1, n2;
		
		if(data.length >= minimumCapacity)
			return;
		else if(manyItems == 0)
			data = (E[]) new Object[minimumCapacity];
		else if(front <= rear){
			biggerArray = (E[]) new Object[minimumCapacity];
			System.arraycopy(data, front, biggerArray, front, manyItems);
			data = biggerArray;
		}else{
			biggerArray = (E[]) new Object[minimumCapacity];
			n1 = data.length - front;
			n2 = rear + 1;
			System.arraycopy(data, front, biggerArray, 0, n1);
			System.arraycopy(data, 0, biggerArray, n1, n2);
			front = 0;
			rear = manyItems - 1;
			data = biggerArray;
		}
		
	}
	
	public E remove(){
		E answer;
		
		if(manyItems == 0){
			throw new NoSuchElementException("Queue underflow.");
		}
		answer = data[front];
		front = nextIndex(front);
		manyItems--;
		return answer;
	}

	public int size(){
		return manyItems;
	}
	
	public void trimToSize(){
		
	}
}
