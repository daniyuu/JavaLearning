/**
 * 
 */

/**
 * @author daniyuu
 *
 */
public class IntLinkedBag implements Cloneable {
	private IntNode head;
	private int manyNodes;
	
	/**
	 * 
	 */
	public IntLinkedBag() {
		// TODO Auto-generated constructor stub
		head = null;
		manyNodes = 0;
	}
	
	public void add(int element){
		head = new IntNode(element,head);
		manyNodes++;
	}
	
	public void addAll(IntLinkedBag addend){
		IntNode[] copyInfo;
		
		if(addend == null){
			throw new IllegalArgumentException("addend is null.");
		}
		if(addend.manyNodes > 0){
			copyInfo = IntNode.listCopyWithTail(addend.head);
			copyInfo[1].setLink(head);
			head = copyInfo[0];
			manyNodes += addend.manyNodes;
		}
	}

	
	public void addMany(int... elements){
		for(int i: elements)
			add(i);
	}
	
	public int size(){
		return manyNodes;
	}
	
	public static IntLinkedBag union(IntLinkedBag b1, IntLinkedBag b2){
		if(b1 == null)
			throw new IllegalArgumentException("b1 is null.");
		if(b2 == null)
			throw new IllegalArgumentException("b2 is null.");
		
		IntLinkedBag answer = new IntLinkedBag();
		
		answer.addAll(b1);
		answer.addAll(b2);
		return answer;
	}
	
	public IntLinkedBag clone(){
		IntLinkedBag answer;
		try{
			answer = (IntLinkedBag) super.clone();
		}catch(CloneNotSupportedException e){
			throw new RuntimeException("This class does not implement Cloneale.");
		}
		
		// 为answer实例创建生成一个新的链表，新链表独立于原始链表
		answer.head = IntNode.listCopy(head);
		return answer;
	}
	
	public boolean remove(int target){
		IntNode targetNode;
		
		targetNode = IntNode.listSearch(head, target);
		if(targetNode == null){
			return false;
		}
		else{
			targetNode.setData(head.getData());
			head = head.getLink();
			manyNodes--;
			return true;
		}
		
	}
	
	public int countOccurrences(int target){
		int answer;
		IntNode cursor;
		
		answer = 0;
		cursor = IntNode.listSearch(head, target);
		
		while(cursor != null){
			answer++;
			cursor = cursor.getLink();
			cursor = IntNode.listSearch(cursor, target);
		}
		
		return answer;
	}
	
	public int grab(){
		int i;
		IntNode cursor;
		
		if(manyNodes == 0){
			throw new IllegalStateException("Bag size is zero.");
		}
		
		i = (int)(Math.random() * manyNodes) + 1;
		cursor = IntNode.listPosition(head, i);
		return cursor.getData();
	}
}
