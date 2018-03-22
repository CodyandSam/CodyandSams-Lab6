package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements KeyListener{
	
	Random myRand = new Random();
  int max = 750;
	int min = 50;
	player myPlayer = new player("Luigi", 100, 100, "./src/Luigi.png");
	Monster myMonster = new Monster("Bowser", 200, 200, "./src/Bowser.jpg");
	Item1 myItem;
	ImageIcon myMonsterIcon = new ImageIcon(myMonster.getImagePath());
	ImageIcon myIcon = new ImageIcon(myPlayer.getImagePath());
  ImageIcon itemIcon1;

	Timer myTimer = new Timer(500, new TimerListener());
	
	public Panel(){
		
		setPreferredSize(new Dimension(800, 800));
		addKeyListener(this);
		setFocusable(true);
		myTimer.start();
	}
	
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);

		page.drawImage(myIcon.getImage(), myPlayer.getX(), myPlayer.getY(), 40, 40, null);
		page.drawImage(myMonsterIcon.getImage(), myMonster.getX(), myMonster.getY(), 55, 55, null);
			
    for(int i = 0; i<30;i++) {
	    	myItem1 = new Item("Coin",10,myRand.nextInt((max-min)+min),myRand.nextInt((max-min)+min),"./src/Game/goldCoin.jpg");
		    itemIcon1 = new ImageIcon(myItem1.getImagePath());
	    	page.drawImage(itemIcon1.getImage(), myItem1.getX(), myItem1.getY(), 40, 40, null);
		}
		//borders
		page.setColor(Color.black);
		page.fillRect(0, 0, 3, 797);//x y width height
		page.fillRect(0, 0, 797, 3);
		page.fillRect(797, 0, 3, 797);
		page.fillRect(0, 797, 797, 3);

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_D) {
			myPlayer.moveRight();
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_A) {
			myPlayer.moveLeft();
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_W) {
			myPlayer.moveUp();
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_S) {
			myPlayer.moveDown();
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
	
	private class TimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(myPlayer.getX() > myMonster.getX()) {
				myMonster.setX(myMonster.getX() + 20);
			}
			else if(myPlayer.getX() < myMonster.getX()) {
				myMonster.setX(myMonster.getX() - 20);
			}
			if(myPlayer.getY() > myMonster.getY()) {
				myMonster.setY(myMonster.getY() + 20);
			}
			else if(myPlayer.getY() < myMonster.getY()) {
				myMonster.setY(myMonster.getY() - 20);
			}
			
			repaint();
		}
	}
}
