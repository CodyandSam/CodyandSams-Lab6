package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener{
	private String imagePath;
	private int Xposition;
	private int Yposition;
	
	public Movement(int Xposition, int Yposition, String imagePath) {
		this.imagePath = imagePath;
		this.Xposition = Xposition;
		this.Yposition = Yposition;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D) {
			Xposition += 20;
		}
		else if(e.getKeyCode() == KeyEvent.VK_A) {
			Xposition -= 20;
		}
		else if(e.getKeyCode() == KeyEvent.VK_W) {
			Yposition += 20;
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			Yposition -= 20;
		}
		
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
