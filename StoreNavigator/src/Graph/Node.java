package Graph;
import java.util.HashSet;

public class Node {

	private String category;
	private Node predecessor;
	private HashSet<Node> neighbors;

	
	public Node(String name){
		super();
		this.category = name;
		this.predecessor = null;
		this.neighbors = new HashSet<Node>();
	}

	public String getName() {
		return category;
	}

	public void setName(String category) {
		this.category = category;
	}	
	
	public Node getPredecessor() {
		return this.predecessor;
	}
	
	public void setPredecessor(Node node){
		this.predecessor = node;
	}
	
	public HashSet<Node> getNeighbors(){
		return this.neighbors;
	}
	
	public void setNeighbors(HashSet<Node> nodes){
		this.neighbors = nodes;
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
		return this.getName();
	}
}
