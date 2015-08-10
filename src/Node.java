/**
 * 
 */

/**
 * @author Daniyuu
 *
 */
public class Node<E> {
	private E data;
	private Node<E> link;

	/**
	 * 
	 */
	public Node() {
		// TODO Auto-generated constructor stub
	}
	
	public Node(E initialData, Node<E> initialLink){
		data = initialData;
		link = initialLink;
	}
	public void addNodeAfter(E element){
		link = new Node<E>(element,link);
	}
	
	public E getData(){
		return data;
	}
	
	public Node<E> getLink(){
		return link;
	}
	
	public static <E> Node<E> listCopy(Node<E> source){
		Node<E> copyHead;
		Node<E> copyTail;
		
		if(source == null){
			return null;
		}
		
		copyHead = new Node<E>(source.data,null);
		copyTail = copyHead;
		
		while(source.link != null){
			source = source.link;
			copyTail.addNodeAfter(source.data);
			copyTail = copyTail.link;
		}
		
		return copyHead;
	} 
	
	
	public static <E> Node<E>[] listCopyWithTail(Node<E> source){
		Node<E> copyHead;
		Node<E> copyTail;
		Node<E>[] answer = (Node<E>[]) new Object[2];
		
		if(source == null){
			return answer;
		}
		
		copyHead = new Node<E>(source.data, null);
		copyTail = copyHead;
		
		while(source.link != null){
			source = source.link;
			copyTail.addNodeAfter(source.data);
			copyTail = copyTail.link;
		}
		
		answer[0] = copyHead;
		answer[1] = copyTail;
		return answer;
	}
	
	public static <E> int listLength(Node<E> head){
		Node<E> cursor;
		int answer;
		
		answer = 0;
		for(cursor = head;cursor != null; cursor = cursor.link){
			answer++;
		}
		return answer;
	}
	
	public static <E> Node<E>[] listPart(Node<E> start, Node<E> end){
		Node<E> copyHead;
		Node<E> copyTail;
		Node<E> cursor;
		Node<E> [] answer = (Node<E> []) new Object[2];
		
		if(start == null){
			throw new IllegalArgumentException("start is null.");
		}
		if(end == null){
			throw new IllegalArgumentException("end is null.");
		}
		
		copyHead = new Node<E>(start.data,null);
		copyTail = copyHead;
		cursor = start;
		
		while(cursor != null){
			cursor = cursor.link;
			if(cursor == null){
				throw new IllegalArgumentException("end node was not found on the list.");
			}
			
			copyTail.addNodeAfter(cursor.data);
			copyTail = copyTail.link;
		}
		
		answer[0] = copyHead;
		answer[1] = copyTail;
		return answer;
	}

	public static <E> Node<E> listPosition(Node<E> head, int position){
		Node<E> cursor;
		int i;
		
		if(position == 0){
			throw new IllegalArgumentException("position is zero");
		}
		
		cursor = head;
		for(i = 1; (i < position) && (cursor != null); ++i){
			cursor = cursor.link;
		}
		
		
		return cursor;
	}
	
	public static <E> Node<E> listSearch(Node<E> head, E target){
		Node<E> cursor;
		
		if(target == null){
			for(cursor = head; cursor != null; cursor = cursor.link){
				if(cursor.data == null){
					return cursor;
				}
			}
		}
		else{
			for(cursor = head;cursor != null; cursor = cursor.link){
				if(target.equals(cursor.data)){
					return cursor;
				}
			}
		}
		return null;
	}
	
	public void removeNodeAfter(){
		link = link.link;
	}
	
	public void setData(E newData){
		data = newData;
	}
	
	public void setLink(Node<E> newLink){
		link = newLink;
	}
}
