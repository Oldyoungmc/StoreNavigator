package Graph;
import java.util.HashSet;

public class Dijkstra {
	
	// Init is already done in the creation of the graph
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
	
	public void shortestPath(Node start, Graph graph) {
		HashSet<Node> nodes = this.graph.getNodes();
		if (graph.containsNode(start)) {
			while (!nodes.isEmpty()) {
				
			}
		}
	}

}
