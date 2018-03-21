package Game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel extends JPanel implements KeyListener{
	
	player myPlayer = new player("Mario", 100, 100, "./src/Mario.png");
	Monster myMonster = new Monster("Bowser", 200, 200, "./src/Bowser.jpg");
	ImageIcon myMonsterIcon = new ImageIcon(myMonster.getImagePath());
	ImageIcon myIcon = new ImageIcon(myPlayer.getImagePath());

	public Panel(){
		setPreferredSize(new Dimension(800, 800));
		addKeyListener(this);
		setFocusable(true);
	}
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		page.drawImage(myIcon.getImage(), myPlayer.getX(), myPlayer.getY(), 75, 75, null);
		page.drawImage(myMonsterIcon.getImage(), myMonster.getX(), myMonster.getY(), 100, 100, null);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_D) {
			myPlayer.setX(myPlayer.getX() + 20);
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_A) {
			myPlayer.setX(myPlayer.getX() - 20);
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_W) {
			myPlayer.setY(myPlayer.getY() - 20);
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_S) {
			myPlayer.setY(myPlayer.getY() + 20);
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
}
