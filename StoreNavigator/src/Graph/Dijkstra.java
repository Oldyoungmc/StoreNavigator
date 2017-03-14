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
	
	public void shortestPath(Node start, Graph graph) {
		HashSet<Node> nodes = this.graph.getNodes();
		int actualDistance = 0;
		if (graph.containsNode(start)) {
			while (!nodes.isEmpty()) {
				Node u = this.getNodeWithSmallestDistance(start, graph);
				nodes.remove(u);
				for (Node node : u.getNeighbors()){
					if (nodes.contains(node)){
						updateDistance(u,node, actualDistance, graph);
					}
				}
			}
		}
	}
	
	public void updateDistance(Node u, Node v, int dist, Graph graph){
		int newDist = dist + distBetweenTwoNeighboringNodes;
		/*
		 * TODO
		 * distinguish between the overall distance between two nodes (those that are initialized with infinity)
		 * AND
		 * those where the distance is 1 --> neighboring nodes
		 */
	}
	
	public Node getNodeWithSmallestDistance(Node node, Graph graph){
		int minimDist = 100;
		Node returnNode = null;
		for (Node actualNode : graph.getNodes()){
			if (graph.getDistanceBetweenTwoNodes(node, actualNode) < minimDist){
				returnNode = actualNode;
				minimDist = graph.getDistanceBetweenTwoNodes(node, actualNode);
			}
		}
		return returnNode;
	}
}
