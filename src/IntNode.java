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
}
