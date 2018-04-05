//Authors -- Cody Wood -- Sam Clement

package Game;

import java.io.FileNotFoundException;

import javax.swing.JFrame;

public class Frame {
	public static void main(String[] arg0) throws FileNotFoundException{
		JFrame myFrame = new JFrame("MY GAME!");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel myPanel = new Panel();
		myFrame.getContentPane().add(myPanel);
		
		myFrame.setResizable(false);
		myFrame.pack();
		myFrame.setVisible(true);
	}
}