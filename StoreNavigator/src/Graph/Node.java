package Graph;
import java.util.HashSet;

public class Node {

	private String category;
	private Node predecessor;
	private HashSet<Node> neighbors;

	
	public Node(String name){
		super();
		category = name;
		predecessor = null;
		neighbors = new HashSet<Node>();
	}

	public String getName() {
		return category;
	}

	public void setName(String category) {
		this.category = category;
	}	
	
	public Node getPredecessor() {
		return predecessor;
	}
	
	public void setPredecessor(Node node){
		predecessor = node;
	}
	
	public HashSet<Node> getNeighbors(){
		return neighbors;
	}
	
	public void setNeighbors(HashSet<Node> nodes){
		neighbors = nodes;
	}
	
	public void addNeighbor(Node node){
		neighbors.add(node);
	}
	
	@Override
	public boolean equals(Object obj) {
		return (((Node) obj).toString().equals(this.toString()));
	}

	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}

	@Override
	public String toString() {
		return getName();
	}
}
