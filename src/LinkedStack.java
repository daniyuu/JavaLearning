import java.util.EmptyStackException;

/**
 * 
 */

/**
 * @author Daniyuu
 *
 */
public class LinkedStack<E> implements Cloneable {
	private Node<E> top;
	/**
	 * 
	 */
	public LinkedStack() {
		top = null;
	}
	
	public LinkedStack<E> clone(){
		LinkedStack answer;
		try{
			answer = (LinkedStack<E>) super.clone();
		}catch(CloneNotSupportedException e){
			throw new RuntimeException("This class does not implement Cloneable.");
		}
		
		answer.top = Node.listCopy(top);
		return answer;
	}
	
	public boolean isEmpty(){
		return (top == null);
	}
	
	public E peek(){
		if(top == null){
			throw new EmptyStackException();
		}
		return top.getData();
	}
	
	public E pop(){
		E answer;
		
		if(top == null){
			throw new EmptyStackException();
		}
		
		answer = top.getData();
		top = top.getLink();
		return answer;
	}
	
	public void push(E item){
		top = new Node<E>(item,top);
	}
	
	public int sizr(){
		return Node.listLength(top);
	}

}
