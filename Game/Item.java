package Game;

public class Item {

	private String itemType;
	private int itemValue;
	private int x;
	private int y;
	private String imagePath;
	
	public Item(String itemType, int itemValue, int x, int y, String imagePath) {
		this.itemType = itemType;
		this.itemValue = itemValue; 
		this.itemValue = x;
		this.itemValue = y;
		this.imagePath = imagePath; 
		
	}
	
	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public int getItemValue() {
		return itemValue;
	}

	public void setItemValue(int itemValue) {
		this.itemValue = itemValue;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String toString() {
		return "I am an item " + x + y + imagePath + itemType + itemValue;
		
	}
}