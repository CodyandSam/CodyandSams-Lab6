package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements KeyListener {
	Random myRand = new Random();
	int max = 750;
	int min = 50;
	boolean play = true;
	
	Game myGame = new Game(0, null);
	player myPlayer = new player("Luigi", 100, 100, "./src/Luigi.png");
	Monster myMonster = new Monster("Bowser", 700, 500, "./src/Bowser.jpg");
	ImageIcon myMonsterIcon = new ImageIcon(myMonster.getImagePath());
	ImageIcon myIcon = new ImageIcon(myPlayer.getImagePath());
	ImageIcon myItemIcon = new ImageIcon("./src/Game/goldCoin.jpg");
	Timer myTimer = new Timer(200, new TimerListener());
	Rectangle m;
	Rectangle p;
	Rectangle i;
	int score1 = 0;
	int highScore = 0;
	int itemsCollected = 0;
	int numItems = 5;
	int level = 1;
	int pauseGame = 0; // variable used to stop key listener from adding unwanted items from key presses during win screen
	Item[] myItems = new Item[numItems];
	Rectangle[] myItemIcons = new Rectangle[myItems.length];

	
	public Panel() {
		setPreferredSize(new Dimension(800, 800));
		setBackground(Color.white);

		if(play) {
	
			for (int i = 0; i < myItems.length; i++) {
				Item myItem2 = new Item("Coin", 10, myRand.nextInt(max - min) + min, myRand.nextInt(max - min) + min,
						"./src/Coin.png");
				myItems[i] = myItem2;
				myItemIcons[i] = new Rectangle(myItems[i].getX(), myItems[i].getY(), 20, 20);
			}
		}

		addKeyListener(this);
		setFocusable(true);
		myTimer.start();
	}

	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		
		if(play) {
			p = new Rectangle(myPlayer.getX(), myPlayer.getY(), 40, 40);
			m = new Rectangle(myMonster.getX(), myMonster.getY(), 55, 55);
			
			if(itemsCollected == myItemIcons.length) {
				myTimer.stop();
				
				System.out.println(numItems);
				page.setColor(Color.RED);
				page.setFont(new Font("serif", Font.BOLD, 30));
				page.drawString("You Win.", 190, 300);
				page.setFont(new Font("serif", Font.BOLD, 20));
				page.drawString("Your Score: " + myGame.getScore(), 190, 350);
				page.drawString("Press Enter for Next Level", 190, 400);
				page.drawString("High Score: ", 190, 450);
				
				if(pauseGame == 0) {
					pauseGame+=1; 
					level += 1;
					numItems +=5;
				}
				if(myGame.getScore() > highScore){
					highScore = myGame.getScore();
					page.drawString("" + highScore, 300, 450);
				}
				else {
					page.drawString("" + highScore, 300, 450);
				}
		
				
				
				myPlayer.setX(1000);
				myMonster.setY(1000);
				
				
			}
			
			if(m.intersects(p) == false) {
				for(int i = 0; i < myItemIcons.length; i++) {
					if(p.intersects(myItemIcons[i])) {
						myItemIcons[i].setLocation(1000, 1000);
						myItems[i].setX(1000);
						myGame.setScore(myGame.getScore() + 10);
						itemsCollected++;
					}
				}
				for (int i = 0; i < myItemIcons.length; i++) {
					page.drawImage(myItemIcon.getImage(), myItems[i].getX(), myItems[i].getY(), 20, 20, null);
				}
				
				page.drawImage(myIcon.getImage(), myPlayer.getX(), myPlayer.getY(), 40, 40, null);
				page.drawImage(myMonsterIcon.getImage(), myMonster.getX(), myMonster.getY(), 55, 55, null);
				page.setColor(Color.BLACK);
				page.setFont(new Font("serif", Font.BOLD, 20));
				page.drawString("Level: " + level,700 , 50);
				page.drawString("Score:" + myGame.getScore(), 700, 100);
	
				// borders
				page.setColor(Color.black);
				page.fillRect(0, 0, 3, 797);// x y width height
				page.fillRect(0, 0, 797, 3);
				page.fillRect(797, 0, 3, 797);
				page.fillRect(0, 797, 797, 3);
	
			}
			else if(m.intersects(p)){
				myTimer.stop();
				numItems = 5;
				level = 1;
				System.out.println(numItems);
				page.setColor(Color.RED);
				page.setFont(new Font("serif", Font.BOLD, 30));
				page.drawString("You Lose.", 190, 300);
				page.setFont(new Font("serif", Font.BOLD, 20));
				page.drawString("Your Score: " + myGame.getScore(), 190, 350);
				page.drawString("Press Enter to restart", 190, 400);
			
				page.drawString("High Score: ", 190, 450);
				if(myGame.getScore() > highScore){
					highScore = myGame.getScore();
					myTimer.stop();
					page.drawString("" + highScore, 300, 450);
				}
				else {
					page.drawString("" + highScore, 300, 450);
				}
				
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(m.intersects(p) || itemsCollected == myItemIcons.length) {
			myPlayer.setX(myPlayer.getX());
			myPlayer.setY(myPlayer.getY());
		}
		else {
			if (arg0.getKeyCode() == KeyEvent.VK_D) {
				myPlayer.moveRight();
			} else if (arg0.getKeyCode() == KeyEvent.VK_A) {
				myPlayer.moveLeft();
			} else if (arg0.getKeyCode() == KeyEvent.VK_W) {
				myPlayer.moveUp();
			} else if (arg0.getKeyCode() == KeyEvent.VK_S) {
				myPlayer.moveDown();
			}
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			myTimer.start();
			pauseGame = 0;
			myItems = new Item[numItems];
			myItemIcons = new Rectangle[myItems.length];
			play = true;
			itemsCollected = 0;
			myGame.setScore(0);
			myPlayer.setX(myRand.nextInt(700));
			myPlayer.setY(myRand.nextInt(700));
			myMonster.setX(myRand.nextInt(700));
			myMonster.setY(myRand.nextInt(700));
			
			for (int i = 0; i < myItems.length; i++) {
				Item myItem2 = new Item("Coin", 10, myRand.nextInt(max - min) + min, myRand.nextInt(max - min) + min,
						"./src/Coin.png");
				myItems[i] = myItem2;
				myItemIcons[i] = new Rectangle(myItems[i].getX(), myItems[i].getY(), 20, 20);
			}
		}
		
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	private class TimerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(m.intersects(p) || itemsCollected == myItemIcons.length) {
					myMonster.setX(myMonster.getX());
					myMonster.setY(myMonster.getY());
					
				}
				else {
					if (myPlayer.getX() > myMonster.getX()) { // Down
						myMonster.setX(myMonster.getX() + 20);
					} 
					else if (myPlayer.getX() < myMonster.getX()) {// Up
						myMonster.setX(myMonster.getX() - 20);
					}
					if (myPlayer.getY() > myMonster.getY()) {// Right
						myMonster.setY(myMonster.getY() + 20);
					} 
					else if (myPlayer.getY() < myMonster.getY()) {// Left
						myMonster.setY(myMonster.getY() - 20);
					}
				}
				

			repaint();
		}
	}
	
	
}