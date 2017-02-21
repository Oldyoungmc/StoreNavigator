package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;

import Graph.Items;
import Graph.Node;
import Graph.StoreNavigator;
import Graph.Graph;
import org.junit.Test;


public class GraphTests {
	Graph testgraph = new Graph("/Users/janriehm/git/SuperMarketCrawler/SuperMarketCrawler/src/EdekaLonsdorfer.txt");
	
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
}
