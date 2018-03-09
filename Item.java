//Sam Clement 3/9/2018
//Item class for game

package lab6;

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
