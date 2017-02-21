package Graph;
import java.util.HashSet;
import java.util.LinkedList;

public class Dijkstra {
	
	Graph graph;

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
	
	public LinkedList<Node> getShortestPath(Node start, Graph graph) {
		LinkedList<Node> path = new LinkedList<Node>();
		HashSet<Node> nodes = this.graph.getNodes();
		if (graph.containsNode(start)) {
			while (!nodes.isEmpty()) {
				
			}
		}
		return path;
	}

}
