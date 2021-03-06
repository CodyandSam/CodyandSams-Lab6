package Game;

public class Monster {

	private String name;
	private int x;
	private int y;
	private String imagePath;
	
	public Monster(String name, int x, int y, String imagePath) {
		this.name = name;
		this.x = x;
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

	public String toString() {
		return "I am a monster";
	}
}
