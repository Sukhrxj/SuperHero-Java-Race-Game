import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Picture extends JComponent {
	/**
	 * Instance variables (attributes)
	 */
	private Color color;
	private int xPosition, yPosition, myWidth, myHeight;
	
	/**
	 * Default constructor
	 */
	public Picture() {
		//initialize instance data
		this.color = color.red;
		this.xPosition = 0;
		this.yPosition = 0;
		this.myWidth = 50;
		this.myHeight = 25;
		
	}
	//Getter for color
	public Color getColor() {
		return color;
	}
	/**
	 * Constructor for a specified location
	 */
	public Picture (int x, int y, int w, int h) {
		this.color = color.blue;
		this.xPosition = x;
		this.yPosition = y;
		this.myWidth = w;
		this.myHeight = h;
	}
	
	/**
	 * Setter method for colour
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	/**
	 * Setter method for colour using red green and blue
	 */
	public void setColor(int r, int g, int b) {
		this.color = new Color (r, g, b);
	}
	/**
	 * Setter and getter methods for x position
	 */
	public int getxPosition() {
		return xPosition;
	}
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	/**
	 * Setter and getter methods for y position
	 */
	public int getyPosition() {
		return yPosition;
	}
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	/**
	 * Setter and getter methods for width
	 */
	public int getMyWidth() {
		return myWidth;
	}
	public void setMyWidth(int myWidth) {
		this.myWidth = myWidth;
	}
	/**
	 * Setter and getter methods for height
	 */
	public int getMyHeight() {
		return myHeight;
	}
	public void setMyHeight(int myHeight) {
		this.myHeight = myHeight;
	}
	/**
	 * The paint method - overrides the JComponent paint method
	 */
	public void paint(Graphics g) {
		g.setColor(this.color);
		g.drawRect(this.xPosition, this.yPosition, this.myWidth, this.myHeight);
		g.drawOval(this.xPosition, this.yPosition, this.myWidth, this.myHeight);
		g.fillOval(this.xPosition + this.myWidth / 4, this.yPosition, (this.myWidth / 2), (this.myHeight));
		
	}
	
	/**
	 * Self Testing Main Method
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
	// Better off in a different class
		//create a jFrame to paint on
		JFrame f = new JFrame("Tesing Frame");
		
		f.setSize(400, 350);
		
		//create a pic object
		Picture p = new Picture();
		
		//add p picture to frame
		f.add(p);
		
		//set frame visible
		f.setVisible(true);
		
		//wait
		JOptionPane.showMessageDialog(null, "Wait!");
		
		// test the new constructor 
		Picture p1 = new Picture(200, 50, 100, 50);
		
		//add p1 picture to frame
		f.add(p1);
		
		//set frame visible
		f.setVisible(true);
		
		//wait
		JOptionPane.showMessageDialog(null, "Wait!");
		
		//change p1 colour to black
		p1.setColor(Color.black);
		
		//repaint
		p1.repaint();
		
		//wait
		JOptionPane.showMessageDialog(null, "Wait!");
		
		//change x and y positions
		p.setxPosition(100);
		p.setyPosition(250);
		
		//repaint
		f.repaint();
		
		//wait
		JOptionPane.showMessageDialog(null, "Wait!");
		
		p1.setMyHeight(p1.getMyHeight()/2);
		p1.setMyWidth(p1.getMyWidth()*2);
		
		//repaint
		p1.repaint();
		
		//wait
		JOptionPane.showMessageDialog(null, "Wait!");
		
		//move p to the right 
		for (int i = 0; i < 20; i++) {
			//change x position
			p.setxPosition(p.getxPosition()+ 10);
			//delay movement 
			Thread.sleep(50);
			//repaint
			p.repaint();
		}
		//wait
		JOptionPane.showMessageDialog(null, "Wait!");
		
		//change p colour
		p.setColor(200, 0, 200);
		p.repaint();
		
		
	}
}
