package Graph;
import java.util.HashSet;
import java.util.LinkedList;

import HelperAlgorithms.HelperAlgorithms;


public class StoreNavigator {
	private LinkedList<String> groceryList;
	private Items items;
	
	public StoreNavigator(LinkedList<String> groceryList, Items items) {
		super();
		this.groceryList = groceryList;
		this.items = items;
	}

	public LinkedList<String> getGroceryList() {
		return groceryList;
	}

	public void setGroceryList(LinkedList<String> groceryList) {
		this.groceryList = groceryList;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
	
	// Get all shortest paths from every node to every other
	public Graph computeAllShortestPaths(Graph g){
		HashSet<Node> nodes = g.getNodes();
		Dijkstra d = new Dijkstra(g);
		for(Node node : g.getNodes()){
			d.shortestPath(node, g, nodes);
		}
		return g;
	}
	
	// compute overall shortest path through whole graph
	public LinkedList<String> getOverallShortestPath(LinkedList<String> categories, Graph g){
		LinkedList<String> path = new LinkedList<>();
		//vegetables category always has to be first, cashier last
		if(categories.contains("vegetables")){
			path.add("vegetables");
			categories.remove("vegetables");
		}
		//Should be a list of lists, with all permutations of list items in it.
		// TODO!!!!!
		HelperAlgorithms ha = new HelperAlgorithms();
		ha.permutateList(categories);
		
		//LinkedList<String> permutatedCategories = permutateList(categories);
		return path;
	}

	
	public static void main(String args[]){
		Items items = new Items();
		LinkedList<String> groceryList = new LinkedList<>();
		groceryList.add("Kartoffeln");
		groceryList.add("Chips");
		groceryList.add("Wurst");
		
		//1. Get all categories = nodes in graph that need to be traversed
		LinkedList<String> categories = new LinkedList<>();
		for (int i = 0; i < groceryList.size(); i++){
			categories.add(items.getCategoryFromValue(groceryList.get(i)));
			System.out.println(items.getCategoryFromValue(groceryList.get(i)));
		}
		
	}
}
