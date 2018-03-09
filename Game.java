package Lab6;
// Cody Wood 3/9/18 Game Class for Lab6
public class Game {
	
		
		private int score;
		private int highScores; // this is going to be an array
		private static player myPlayer; // This will be the player object
		private static Monster enemy; // This will be the enemy object
		private static Item item; // This will be the item object
		
		public Game(int score, int highScores, player myPlayer, Monster enemy, Item item) {
			this.score = score;
			this.highScores = highScores;
			this.myPlayer = myPlayer;
			this.enemy = enemy;
			this.item = item;
		
			
		}
		public static void main(String[] arg0) {
			myPlayer = new player("Name");
			enemy = new Monster("Monster");
			item = new Item("Coin", 1);
			
			System.out.println(myPlayer.toString());
			System.out.println(enemy.toString());
			System.out.println(item.toString());
		}
}
