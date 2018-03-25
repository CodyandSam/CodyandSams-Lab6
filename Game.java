package Game;

import java.util.Random;
import java.util.Scanner;

import Iteration3.Animal;

public class Game {
	
		
		private int score;
		int[] highScores; // this is going to be an array
		private static player myPlayer; // This will be the player object
		
		
		
		public Game(int score, int[] highScores) {
			this.score = score;
			this.highScores = highScores;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}
		
}