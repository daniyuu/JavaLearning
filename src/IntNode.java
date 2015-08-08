/**
 * 
 */

/**
 * @author daniyuu
 * 在链表头部添加新结点 head = new IntNode(5, head)
 * 从链表头部删除结点 head = head.getLink()
 * 在链表的非头部位置添加新结点 addNodeAfter(int element)
 * 删除链表中非头部位置的结点 removeNodeAfter()
 */
public class IntNode {
	private int data;
	private IntNode link;
	/**
	 * 
	 */
	public IntNode() {
		// TODO Auto-generated constructor stub
	}

	public IntNode(int initialData, IntNode initialLink){
		data = initialData;
		link = initialLink;
	}
	
	public int getData(){
		return data;
	}
	
	public IntNode getLink(){
		return link;
	}
	
	public void setData(int newdata){
		data = newdata;
	}
	
	public void setLink(IntNode newLink){
		link = newLink;
	}
	
	public void addNodeAfter(int element){
		link = new IntNode(element,link);
	}
	
	public void removeNodeAfter(){
		link = link.link;
	}
	
	public static int listLength(IntNode head){
		IntNode cursor;
		int answer;
		
		answer = 0;
		for(cursor = head; cursor != null; cursor = cursor.link)
			answer++;
		
		return answer;
	}
	
	public static IntNode listSearch(IntNode head, int target){
		IntNode cursor;
		for(cursor = head; cursor != null; cursor = cursor.link)
			if(target == cursor.data){
				return cursor;
			}
		return null;
	}
	
	public static IntNode listPosition(IntNode head, int position){
		IntNode cursor;
		int i;
		if(position <= 0){
			throw new IllegalArgumentException("Position is not positive.");
		}
		
		cursor = head;
		for(i =  1; (i < position) && (cursor != null); i++){
			cursor = cursor.link;
		}
		
		return cursor;
	}
	
	// 为什么一定是static？因为普通方法不能复制空链表
	public static IntNode listCopy(IntNode source){
		IntNode copyHead;
		IntNode copyTail;
		
		if(source == null){
			return null;
		}
		
		copyHead = new IntNode(source.data,null);
		copyTail = copyHead;
		
		while(source.link != null){
			source = source.link;
			copyTail.addNodeAfter(source.data);
			copyTail = copyTail.link;
		}
		
		return copyHead;
	}
	
	public static IntNode[] listCopyWithTail(IntNode source){
		IntNode copyHead;
		IntNode copyTail;
		IntNode[] answer = new IntNode[2];
		
		if(source == null){
			return answer;
		}
		
		copyHead = new IntNode(source.data,null);
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
	
	public static IntNode[] listPart(IntNode start, IntNode end){
		IntNode copyHead;
		IntNode copyTail;
		IntNode[] answer = new IntNode[2];
		
		if(start == null)
			throw new IllegalArgumentException("start is null.");
		if(end == null)
			throw new IllegalArgumentException("end is null.");
		
		copyHead = new IntNode(start.data,null);
		copyTail = copyHead;
		
		while(start != end){
			start = start.link;
			if(start == null){
				throw new IllegalArgumentException("end node was not found on the list");
			
			}
			copyTail.addNodeAfter(start.data);
			copyTail = copyTail.link;
			
		}
		
		answer[0] = copyHead;
		answer[1] = copyTail;
		
		return answer;
	}
}
