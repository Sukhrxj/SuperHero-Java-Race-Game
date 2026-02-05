import javax.swing.ImageIcon;

public class MarvelHero extends ImagePicture{
	private int steps, totalSteps, maxSteps;
	private String name;
	private ImageIcon image;

	public MarvelHero(ImageIcon img, int x, int y, String name) {
		super(img, x, y);
		this.name = name;
		this.steps = 0;
	}


	/**
	 * @return the totalSteps
	 */
	public int getTotalSteps() {
		return totalSteps;
	}

	/**
	 * @param totalSteps the totalSteps to set
	 */
	public void setTotalSteps(int totalSteps) {
		this.totalSteps = totalSteps;
	}

	/**
	 * @return the maxSteps
	 */
	public int getMaxSteps() {
		return maxSteps;
	}

	/**
	 * @param maxSteps the maxSteps to set
	 */
	public void setMaxSteps(int maxSteps) {
		this.maxSteps = maxSteps;
	}

	/**
	 * @return the image
	 */
	public ImageIcon getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(ImageIcon image) {
		this.image = image;
	}

	/**
	 * @param steps the steps to set
	 * @return 
	 * @return 
	 */
	public int setSteps(int d1, int d2) {
		if (d1 + d2 == 4 || d1 + d2 == 6 || d1 + d2 == 24) {
			this.steps = 0;
		} 

		else {

			this.steps = d1 + d2;
		}
		return this.steps;
	}

	public int getSteps () {
		return steps;
	}

	public String getName() {
		return name;

	}
	
	// Method to move the hero by a specified amount
    public void move(int dx) {
        // Get the current position of the hero
        int currentX = this.getxPosition();
        int currentY = this.getyPosition();

        // Calculate the new position
        int newX = currentX + dx;

        // Set the new position for the hero
        this.setxPosition(newX);
        this.setyPosition(currentY);
    }


	public static void main(String[] args) {
		
		// Create a MarvelHero object
	    MarvelHero hero = new MarvelHero(new ImageIcon("gru.png"), 0, 0, "Hero");

	    // Test the getName method
	    System.out.println("Name: " + hero.getName());

	    // Test the getSteps and setSteps methods
	    System.out.println("Initial steps: " + hero.getSteps());
	    hero.setSteps(2, 3);
	    System.out.println("Steps after setting to 5: " + hero.getSteps()); //should display 5
	    
	    hero.setSteps(3, 3);
	    System.out.println("Steps after setting to 6: " + hero.getSteps()); //should display 0

	    
	    // Test the getTotalSteps and setTotalSteps methods
	    System.out.println("Initial total steps: " + hero.getTotalSteps());
	    hero.setTotalSteps(10);
	    System.out.println("Total steps after setting to 10: " + hero.getTotalSteps());

	    // Test the getMaxSteps and setMaxSteps methods
	    System.out.println("Initial max steps: " + hero.getMaxSteps());
	    hero.setMaxSteps(20);
	    System.out.println("Max steps after setting to 20: " + hero.getMaxSteps());

	    // Test the getImage and setImage methods
	    System.out.println("Initial image: " + hero.getImage());
	    hero.setImage(new ImageIcon("gru.png"));
	    System.out.println("Image after setting to gru.png: " + hero.getImage());
	}
	
}