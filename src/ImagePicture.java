import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ImagePicture extends Picture {

/**
* Private Data/Attributes
*/
private ImageIcon image;

/**
* Constructor with the ImageIcon passed in
*/
public ImagePicture(ImageIcon img) {
// call the superclass/parent class constructor
super();
this.image = img;
if (img != null) {
    int width = img.getIconWidth(); // Ensure img is not null before accessing its methods
    int height = img.getIconHeight();
    // Other operations related to img...
} else {
	//leave blank, nothing will happen
}
}

/**
* Overloaded Constructor
* Takes image x and y
*/
public ImagePicture(ImageIcon img, int x, int y) {
//call the superclass, parentclass constructor
super(x,y,img.getIconWidth(),img.getIconHeight());
this.image = img;
}

/**
* @param image the image to set
*/
public void setImage(ImageIcon image) {
this.image = image;
}

/**
* @param get image
*/
public ImageIcon getImage() {
	return image;
}

/**
* Override the paint method from the Picture
*/
public void paint(Graphics g) {
this.image.paintIcon(this, g, getxPosition(), getyPosition());
}

/**
* @param args
*/
public static void main(String[] args) {
// JFrame for testing
JFrame f = new JFrame();

f.setSize(400, 350);

//create image picture object
ImagePicture p = new ImagePicture(new ImageIcon("minion.png"));

// add the p object
f.add(p);

f.setVisible(true);

JOptionPane.showMessageDialog(null, "WAIT!!!");

//Create a new ImagePicture object
ImagePicture p1 = new ImagePicture(new ImageIcon("gru.png"),100, 100);

//add p1
f.add(p1);

//show it!
f.setVisible(true);

//wait
JOptionPane.showMessageDialog(null, "WAIT!!!");

//test the moving of p
p.setxPosition(300);
p.setyPosition(200);

p.repaint();

JOptionPane.showMessageDialog(null, "WAIT!!!");
//test the setImage method
p1.setImage(new ImageIcon("minion.png"));

p1.repaint();

}

}
