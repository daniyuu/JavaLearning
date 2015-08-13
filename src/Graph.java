/**
 * 
 */

/**
 * @author Daniyuu
 *
 */
public class Graph<E> {
	private boolean[][] edges;
	private E[] labels;
	/**
	 * 
	 */
	public Graph(int n) {
		edges = new boolean[n][n];
		labels = (E[]) new Object[n];
	}
	
	private void addEdges(int source, int target){
		edges[source][target] = true;
	}
	
	public Graph<E> clone(){
		Graph<E> answer;
		
		try{
			answer = (Graph<E>) super.clone();
		}catch(CloneNotSupportedException e){
			throw new RuntimeException("This class does not implement Clonable");
		}
		
		answer.edges = edges.clone();
		answer.labels = labels.clone();
		
		return answer;
	}
	
	public E getLabel(int vertex){
		return labels[vertex];
	}
	
	public boolean isEdge(int source, int target){
		return edges[source][target];
	}
	
	public int[] neighbors(int vertex){
		int i;
		int count;
		int[] answer;
		
		count = 0;
		for(i = 0; i < labels.length; ++i){
			if(edges[vertex][i])
				count++;
		}
		
		answer = new int[count];
		
		count = 0;
		for(i = 0; i < labels.length; ++i){
			if(edges[vertex][i])
				answer[count++] = i;
		}
		
		return answer;
	}
	
	public void removeEdge(int source, int target){
		edges[source][target] = false;
	}
	
	public void setLabels(int vertex, E newLabel){
		labels[vertex] = newLabel;
	}
	
	public int size(){
		return labels.length;
	}

	public static <E> void depthFirstRecurse(Graph<E> g, int v, boolean[] marked){
		int[] connections = g.neighbors(v);
		int i;
		
		marked[v] = true;
		System.out.println(g.getLabel(v));
		
		for(int nextNeighbor:connections){
			if(!marked[nextNeighbor]){
				depthFirstRecurse(g, nextNeighbor, marked);
			}
		}
	}
	
	public static <E> void depthFirstPrint(Graph<E> g, int start){
		boolean[] marked = new boolean[g.size()];
		depthFirstRecurse(g,start,marked);
	}
}
