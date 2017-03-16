package Graph;
import java.util.HashSet;

public class Dijkstra {
	
	// Init is already done in the creation of the graph
	private Graph graph;
	private static int distBetweenTwoNeighboringNodes = 1;

	public Dijkstra(Graph graph) {
		// TODO Auto-generated constructor stub
		super();
		this.graph = graph;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}
	
	public void shortestPath(Node start, Graph graph, HashSet<Node> nodes) {
		if (graph.containsNode(start)) {
			while (!nodes.isEmpty()) {
				Node u = getNodeWithSmallestDistance(start, nodes);
				nodes.remove(u);
				for (Node node : u.getNeighbors()){
					if (nodes.contains(node)){
						updateDistance(start, u, node, graph);
					}
				}
			}
		}
	}
	
	public void updateDistance(Node startNode, Node u, Node v, Graph graph){
		int newDist = graph.getDistances().get(startNode).get(u) + distBetweenTwoNeighboringNodes;
		if (newDist < graph.getDistances().get(startNode).get(v)){
			graph.getDistances().get(startNode).put(v, newDist);
			v.setPredecessor(u);
		}
	}
	
	public Node getNodeWithSmallestDistance(Node node, HashSet<Node> nodes){
		int minimDist = 100;
		Node returnNode = null;
		for (Node actualNode : nodes){
			if (graph.getDistanceBetweenTwoNodes(node, actualNode) < minimDist){
				returnNode = actualNode;
				minimDist = graph.getDistanceBetweenTwoNodes(node, actualNode);
			}
		}
		return returnNode;
	}
}
