import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class UniverseLoadingScreen extends JFrame {
	//private data variables
	private ImageIcon loadingScreen; // for loading screen
	
	/**
	 * Constructor for loading screen
	 */
	public UniverseLoadingScreen() {
		///call the JFrame Constructor
		super("LOADING...");

		// set the layout to null (flexible) which means I have to place everything myself 
		setLayout (null);

		// set the size of the window and the location
		setSize (850, 480);
		setLocation(100, 40);
		
		//load picture files 
		loadingScreen = new ImageIcon("MarvelLoadingScreen.png");
		
		// make the frame visible, not resizable
		setVisible(true);
		setResizable(false);

		setDefaultCloseOperation(EXIT_ON_CLOSE); //stops the program when the window is x'ed
	}
	
	/**
	 * Graphics method - used to paint loading screen and loading bar
	 */
	public void paint (Graphics g) {
		int x = 25, y = 395; // starting coordinates of the loading bar
		int xSpeed = 1; //speeds for the x direction
		int delay = 5; //variable to slow down the loading bar (delay)
		
		// For loop used for graphics
			//(displaying background with loading screen on top)
			for (int i = 0; i <1000; i++) {
				//paint loading screen at (0,0)
				loadingScreen.paintIcon(this, g, 0,  0);
				
				// change location of the loading bar by x speed 
				x = x + xSpeed; 
						
				// set colour of loading bar to red
				g.setColor(Color.RED);
				// draws rectangle (loading bar) at location (x,y)
				g.fillRect(x, y, 40, 32);
								
				//use a try/catch structure to put program to sleep for 5 ms (pauses for 5 milliseconds)
					try {
						Thread.sleep(delay); //delay the program 
						}
					catch (Exception error) {
						// leave blank DO SOMETHING HERE!
						}
								
				//stop the loop if the ball gets to 788 pixels
				if (x> 788) {
					break; //stop loop
				}
								}
				//Stop displaying window once loading bar reaches 440
					//(in x direction)
				setVisible(false);
				
				// Create a window object
				UniverseMenu myGame = new UniverseMenu();
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		// Create a window object, call on constructor
		UniverseLoadingScreen myGame = new UniverseLoadingScreen();

	}
}
