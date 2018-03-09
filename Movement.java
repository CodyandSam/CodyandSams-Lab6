package Lab6;
//Cody Wood 3/9/18 Movement Class for Lab6
public class Movement {
	private String image;
	private int Xposition;
	private int Yposition;
	
	public Movement(String image, int Xposition, int Yposition) {
		this.image = image;
		this.Xposition = Xposition;
		this.Yposition = Yposition;
	}
	
	public int PlayerMove() {
		return Xposition;
	}
	
	public int EnemyMove() {
		return Yposition;
	}
}
