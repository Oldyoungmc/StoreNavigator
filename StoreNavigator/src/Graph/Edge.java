package Graph;


public class Edge {
	private int weight;
	private Node startNode;
	private Node endNode;
	
	public Edge(Node startNode, Node endNode, int weight){
		super();
		this.weight 	= weight;
		this.startNode 	= startNode;
		this.endNode 	= endNode;
	}
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Node getStartNode() {
		return startNode;
	}
	public void setStartNode(Node startNode) {
		this.startNode = startNode;
	}
	public Node getEndNode() {
		return endNode;
	}
	public void setEndNode(Node endNode) {
		this.endNode = endNode;
	}
}
