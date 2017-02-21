package Graph;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Graph {
	private HashSet<Node> nodes;
	private HashSet<Edge> edges;
	private HashMap<Node, HashMap<Node, Integer>> distances;
	private HashMap<Node, HashSet<Node>> neighbors;
	
	public Graph(String textFile) {
		super();
		HashSet<Node> nodes = new HashSet<Node>();
		HashSet<Edge> edges = new HashSet<Edge>();
		Node start = null;
		Node end   = null;
		Edge edge1 = null;
		Edge edge2 = null;
		int weight = 0;
		
		File file = new File(textFile);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(fis);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(dis));
		String line;
		try {
			while((line = br.readLine()) != null){
				String[] tokens = line.split(" ");
				System.out.println(Arrays.toString(tokens));
				start = new Node(tokens[0]);
				end = new Node(tokens[1]);
				weight = Integer.parseInt(tokens[2]);
				edge1 = new Edge(start, end, weight);
				edge2 = new Edge(end, start, weight);
				nodes.add(start);
				nodes.add(end);
				edges.add(edge1);
				edges.add(edge2);
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.nodes = nodes;
		this.edges = edges;
		this.distances 	= new HashMap<>();
		this.neighbors 	= new HashMap<>();
		/* load distances map as well as predecessors of each node
		*  for each node put predecessor to null
		*  for each node put distance to any other node to -100
		*/
		for (Node node : nodes){
			node.setPredecessor(null);
			this.neighbors.put(node, node.getNeighbors());
			HashMap<Node, Integer> initDistances = new HashMap<>();
			for (Node subNode : nodes){
				initDistances.put(subNode, -100);
				if (subNode.equals(node)){
					initDistances.put(subNode, 0);
				}
			}
			this.distances.put(node, initDistances);
		}
		
		/*
		 * Iterate over all edges to get neighbors set for each node
		 */
		for (Edge edge : this.edges){
			this.neighbors.get(edge.getStartNode()).add(edge.getEndNode());
		}
	}
	
	
	public HashMap<Node, HashMap<Node, Integer>> getDistances() {
		return distances;
	}


	public void setDistances(HashMap<Node, HashMap<Node, Integer>> distances) {
		this.distances = distances;
	}


	public HashMap<Node, HashSet<Node>> getNeighbors() {
		return neighbors;
	}


	public void setNeighbors(HashMap<Node, HashSet<Node>> neighbors) {
		this.neighbors = neighbors;
	}


	public Graph(HashSet<Node> nodes, HashSet<Edge> edges) {
		super();
		this.nodes 		= nodes;
		this.edges		= edges;
		this.distances 	= new HashMap<>();
		this.neighbors 	= new HashMap<>();
		/* load distances map as well as predecessors of each node
		*  for each node put predecessor to null
		*  for each node put distance to any other node to -100
		*/
		for (Node node : nodes){
			node.setPredecessor(null);
			this.neighbors.put(node, node.getNeighbors());
			HashMap<Node, Integer> initDistances = new HashMap<>();
			for (Node subNode : nodes){
				initDistances.put(subNode, -100);
			}
			this.distances.put(node, initDistances);
		}
		
		/*
		 * Iterate over all edges to get neighbors set for each node
		 */
		for (Edge edge : this.edges){
			this.neighbors.get(edge.getStartNode()).add(edge.getEndNode());
		}
	}


	public Node getNode(String name){
		for (Node node : this.nodes){
			if (node.getName().equals(name)){
				return node;
			}
		}
		return null;
	}
	
	public HashSet<Node> getNodes() {
		return this.nodes;
	}

	public void setNodes(HashSet<Node> nodes) {
		this.nodes = nodes;
	}

	public HashSet<Edge> getEdges() {
		return this.edges;
	}

	public void setEdges(HashSet<Edge> edges) {
		this.edges = edges;
	}
	
	public boolean containsEdge(Edge edge){
		return this.edges.contains((Edge) edge);
	}
	
	public boolean containsEdge(Node node1, Node node2){
		for (Edge edge : this.getEdges()){
			if ((edge.getStartNode().equals(node1) && edge.getEndNode().equals(node2))||(edge.getStartNode().equals(node2) && edge.getEndNode().equals(node1))){
				return true;
			}
		}
		return false;
	}
	
	public boolean containsNode(Node node){
		return this.nodes.contains((Node) node);
	}
	
	public int getDistanceBetweenTwoNodes(Node node1, Node node2){
		return this.distances.get(node1).get(node2);
	}
	
	public void setDistanceBetweenTwoNodes(Node node1, Node node2, int distance){
		this.distances.get(node1).put(node2, distance);
	}
	
}
