/**
 * 
 */

/**
 * @author daniyuu
 * ������ͷ������½�� head = new IntNode(5, head)
 * ������ͷ��ɾ����� head = head.getLink()
 * ������ķ�ͷ��λ������½�� addNodeAfter(int element)
 * ɾ�������з�ͷ��λ�õĽ�� removeNodeAfter()
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
