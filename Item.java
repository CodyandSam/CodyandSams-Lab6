package Game;

public class Item {

	private String itemType;
	private int itemValue;
	
	public Item(String itemType, int itemValue) {
		this.itemType = itemType;
		this.itemValue = itemValue; 
		
	}
	
	public String toString() {
		return "I am an item";
		
	}
}
