package Graph;
import java.util.LinkedList;


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
	
	public void main(String args[]){
		
	}
}
