package Game;

public class player {

	private String name;
	private int x;
	private int y;
	private int hieght;
	private int width;
	private String imagePath;
	
	public player(String name, int x, int y, String imagePath) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.imagePath = imagePath;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public void moveUp() {
		if(getY() <= 0) {
			setY(0);
		}
		else {
			setY(getY() - 20);
		}
	}
	
	public void moveDown() {
		if(getY() >= 755) {
			setY(755);
		}
		else {
			setY(getY() + 20);
		}
	}
	
	public void moveRight() {
		if(getX() >= 755) {
			setX(755);
		}
		else {
			setX(getX() + 20);
		}
	}
	
	public void moveLeft() {
		if(getX() <= 0) {
			setX(0);
		}
		else {
			setX(getX() - 20);
		}
	}
	
	public String toString() {
		return "I am " + getName() + getX() + getY() + getImagePath();
	}
}