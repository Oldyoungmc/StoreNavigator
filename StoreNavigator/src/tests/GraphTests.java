package tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.HashSet;
import java.util.LinkedList;

import Graph.Items;
import Graph.Node;
import Graph.StoreNavigator;
import Graph.Graph;
import Graph.Dijkstra;
import HelperAlgorithms.HelperAlgorithms;
import org.junit.Test;


public class GraphTests {
	Graph testgraph = new Graph("/Users/janriehm/git/StoreNavigator/StoreNavigator/src/EdekaLonsdorfer.txt");
	Graph miniGraph = new Graph("/Users/janriehm/git/StoreNavigator/StoreNavigator/src/tests/miniGraph.txt");
	
	@Test
	public void testNodeCreation() {
		Items it = new Items();
		assertEquals(it.getKeys().size(),testgraph.getNodes().size());
	}

	@Test
	public void testEdgeCreation() {
		System.out.println(testgraph.getEdges().size());
		assertEquals(100,testgraph.getEdges().size());
	}
	
	@Test
	public void testRandomEdges() {
		Node fridge = testgraph.getNode("fridge");
		Node chips = testgraph.getNode("chips");
		Node wurst = testgraph.getNode("wurst");
		Node cashier = testgraph.getNode("cashier");
		assertTrue(testgraph.containsEdge(fridge, wurst));
		assertFalse(testgraph.containsEdge(fridge, chips));
		assertEquals(3,testgraph.getNeighbors().get(cashier).size());
	}
	
	@Test
	public void testNeighbors() {
		Node cashier = testgraph.getNode("cashier");
		assertEquals(3,testgraph.getNeighbors().get(cashier).size());
	}
	
	@Test
	public void testCharDeletion() {
		HelperAlgorithms ha = new HelperAlgorithms();
		String s = "Kartoffel";
		List<String> l = ha.getMissingLetterWords(s);
		System.out.println(l.toString());
	}
	
	@Test
	public void testGetter(){
		Node bread = miniGraph.getNode("bread");
		miniGraph.getNode("bread").setName("X");
		Node coffee = miniGraph.getNode("coffee");
		Node bread2 = miniGraph.getNode("bread");
	}
	
	@Test
	public void testDijkstra(){
		Dijkstra dijkstra = new Dijkstra(miniGraph);
		Node start = miniGraph.getNode("vegetables");
		Node bread = miniGraph.getNode("bread");
		Node coffee = miniGraph.getNode("coffee");
		assertNull(coffee.getPredecessor());
		dijkstra.shortestPath(start, miniGraph, miniGraph.getNodes());
		assertEquals(bread, coffee.getPredecessor());
		//assertEquals(bread, miniGraph.getNode("vegetables").getPredecessor());
	}
}
