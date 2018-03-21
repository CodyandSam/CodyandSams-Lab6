package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import Iteration3.Animal;

public class Game {
	
		
		private int score;
		private int highScores; // this is going to be an array
		private static player myPlayer; // This will be the player object
		private static Monster enemy; // This will be the enemy object
		private static Item item; // This will be the item object
		
		
		
		public Game(int score, int highScores, player myPlayer, Monster enemy, Item item, player character) {
			this.score = score;
			this.highScores = highScores;
			this.myPlayer = myPlayer;
			this.enemy = enemy;
			this.item = item;
		
			
		}
		
}