import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.Component;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Font;

public class TextPicture extends Picture {
	//Declare private global variables for the text (title) and font
	private String title = "";
	private Font myFont;
	
	/**
	 * Methods to set and get title
	 */
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Methods to set and get font
	 */

	public Font getMyFont() {
		return myFont;
	}

	public void setMyFont(Font myFont) {
		this.myFont = myFont;
	}

	/**
	 * TextPicture method -  sets x and y, font and title
	 */
	 public TextPicture (final String title, final int x, final int y) {
		 this.setxPosition(x);
		 this.setyPosition(y);
		 this.myFont = myFont;
		 //this.myFont = new Font("Monospaced", 0, 24);
		 this.title = title;
	    }
	 
	/**
	 *Paint method - sets font, draws text, sets colour
	*/
    public void paint(final Graphics g) {
        g.setColor(this.getColor());
        g.setFont(this.myFont);
        g.drawString(this.title, this.getxPosition(), this.getyPosition());
    }


	/**
	 * Self Testing Main Method
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		//Create and set size for window
		JFrame f = new JFrame("Testing");
		f.setSize(400, 350);
		
		//declare and initialize title and textpicture
		final String title = "My title";
		final TextPicture p1 = new TextPicture(title, 100, 50);
	    
		//add p1, text picture to frame
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
		p1.setxPosition(100);
		p1.setyPosition(250);
				
		//repaint
		f.repaint();
				
		//wait
		JOptionPane.showMessageDialog(null, "Wait!");
				
		//move p to the right 
		for (int i = 0; i < 15; i++) {
			//change x position
			p1.setxPosition(p1.getxPosition()+ 10);
			//delay movement 
			Thread.sleep(50);
			//repaint
			p1.repaint();
		}
		
		//wait
		JOptionPane.showMessageDialog(null, "Wait!");
				
		//change p colour
		p1.setColor(200, 0, 200);
		p1.repaint();	

	}

}
