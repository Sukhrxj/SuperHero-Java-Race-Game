import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Universe extends JFrame implements ActionListener {
	
	//Private instance variables
	private ImagePicture background, whiteSquare, whiteSquare2, whiteSquare3;
	private MarvelHero heroes[];
	private JPanel racePanel, heroesPanel;
	private TextPicture gameTitle, team1, team2;
	private JButton btnRoll, btnExit, btnStop;
	private Timer timer;   // animation timer
	private Die d1, d2;
	
	/**
	 * Constructor
	 */
	public Universe(ImagePicture gameBackground, String teamSetName2, String teamSetName, String backgroundName) {
		///call the JFrame Constructor
		super("Universe");
		
		//set size and location of frame
		setSize(850, 500);
		setLocation(100, 40);
		
		//create panel for menu and set bounds
		racePanel = new JPanel();
		racePanel.setLayout(null);
		racePanel.setOpaque(false);
		racePanel.setBounds(0, 0, 850, 500);
		
		//create TextPicture for game header
		gameTitle = new TextPicture("THE UNIVERSE", 175, 15);
		//set font for header
		gameTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
		//set colour for header
		gameTitle.setColor(Color.BLACK);
		//set bounds for header
		gameTitle.setBounds(175, 15, 500, 40);
		//add header to menu panel (onto window)
		racePanel.add(gameTitle);
		
		//create TextPicture for team 1 header
		team1 = new TextPicture("Team" + teamSetName + ":", 5, 20);
		//set font for header
		team1.setFont(new Font("SansSerif", Font.BOLD, 20));
		//set colour for header
		team1.setColor(Color.BLACK);
		//set bounds for header
		team1.setBounds(5, 20, 500, 40);
		//add header to menu panel (onto window)
		racePanel.add(team1);
		
		//create TextPicture for team 2 header
		team2 = new TextPicture("Team" + teamSetName2 + ":", 5, 30);
		//set font for header
		team2.setFont(new Font("SansSerif", Font.BOLD, 20));
		//set colour for header
		team2.setColor(Color.BLACK);
		//set bounds for header
		team2.setBounds(5, 240, 500, 40);
		//add header to menu panel (onto window)
		racePanel.add(team2);
		
		// Load and add the white square
		whiteSquare = new ImagePicture(new ImageIcon("WhiteSquare.png"));
		whiteSquare.setBounds(350, 10, 150, 30);
        racePanel.add(whiteSquare);
        
        // Load and add the white square
     	whiteSquare2 = new ImagePicture(new ImageIcon("WhiteSquare.png"));
     	whiteSquare2.setBounds(10, 250, 150, 30);
        racePanel.add(whiteSquare2);
             
        // Load and add the white square
        whiteSquare3 = new ImagePicture(new ImageIcon("WhiteSquare.png"));
     	whiteSquare3.setBounds(10, 20, 150, 30);
        racePanel.add(whiteSquare3);     
	    
	    // Create roll button
	    btnRoll = new JButton("Roll");
	    // Set bounds
	    btnRoll.setBounds(570, 5, 80, 20);
	    // Add button to buttonPanel
	    racePanel.add(btnRoll);
	    
	    //Create JButton for stop
	    btnStop = new JButton("Stop");
	    // Set bounds
	    btnStop.setBounds(660, 5, 80, 20);
	    // Add button to buttonPanel
	    racePanel.add(btnStop);
	    	
	    //Create JButton for exit
	    btnExit = new JButton("Exit");
	    // Set bounds
	    btnExit.setBounds(750, 5, 80, 20);
	    // Add button to buttonPanel
	    racePanel.add(btnExit);
        
        // Initialize dice
     	d1 = new Die(12);
     	d2 = new Die(12);
     	
     	timer = new Timer(20, this);  // creates a timer and this class as the listener. set to fire every 20ms
        timer.setInitialDelay(5); // set the initial delay to 5 ms before it starts
        
        heroes = new MarvelHero[4]; // There are 4 heroes, set heroes size to 4
        // Initialize 4 MarvelHero objects with the same x-coordinate (30) and different y-coordinates
        heroes[0] = new MarvelHero(new ImageIcon("SpiderMan.png"), 30, 20, "Spider-Man");
        heroes[1] = new MarvelHero(new ImageIcon("AntMan.png"), 30, 100, "Ant-Man");
        heroes[2] = new MarvelHero(new ImageIcon("IronMan.png"), 30, 200, "Iron-Man");
        heroes[3] = new MarvelHero(new ImageIcon("DeadPool.png"), 30, 300 , "Deadpool");

        // Initialize heroesPanel
        heroesPanel = new JPanel(); 
        heroesPanel.setLayout(new GridLayout(1, 1)); // Set layout for heroesPanel
        heroesPanel.setOpaque(false);
        // Set bounds of the heroes panel
        heroesPanel.setBounds(0, 0, 850, 500);
        
        // Add heroes to the heroesPanel
        for (MarvelHero hero : heroes) {
        	heroesPanel.add(hero);
        	// Set bounds for each hero within heroesPanel
            hero.setBounds(hero.getxPosition(), hero.getyPosition(), hero.getMyWidth(), hero.getMyHeight());
        }
        
        // Add the heroesPanel to the racePanel
        racePanel.add(heroesPanel);
        
        // Load and set the background image using ImagePicture
	    ImageIcon backgroundImageIcon = new ImageIcon(backgroundName);
	    background = new ImagePicture(backgroundImageIcon, 0, 0);
	    background.setImage(backgroundImageIcon);
	    background.setBounds(0, 0, racePanel.getWidth(), racePanel.getHeight());
	    racePanel.add(background);
        
        // Add race panel to the frame
        add(racePanel);
        
		// Make window visible
        setVisible(true);
        //Make window non resizable 
        setResizable(false);
        //Stops the program when the window is x'ed
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		//Create myGame object, call constructor
		//Universe myGame = new Universe();
	}

	public void actionPerformed(ActionEvent e) {//Method for when buttons are pressed
		//if roll button is pressed
		if (e.getSource() == timer) {
			if (e.getSource() == btnRoll) {
            // Perform action for Roll button     
            // Loop through each hero's turn
	        for (int i = 0; i < heroes.length; i++) {
	        	// Roll the dice for the heroes
	        	int dice1Value = d1.rollDie(); // Roll the first die
	            int dice2Value = d2.rollDie(); // Roll the second die
	            
	            // Calculate the sum of the dice rolls
	            int sum = dice1Value + dice2Value;

	            // Calculate the steps to move the hero
	            int steps = heroes[i].setSteps(dice1Value, dice2Value);

	            // Move the hero based on steps (assuming step size is 10 pixels for both x and y)
	            int dx = 10 * steps; 

	            // Move the hero using the move method in the MarvelHero class
	            heroes[i].move(dx);
	            
	            //repaint race panel with updated hero position
	            racePanel.repaint();
	            
	            // Stop the hero when reaching the finish position (around 820 pixels)
	            if (heroes[i].getX() >= 820) {
	                // Stop further movements if the hero reaches the designated position
	                break;
	            }
	            
	            // Reading steps from the file
	            //initalize steps array
	            String[] stepsArray = null;
				try {
					stepsArray = HighScores.readFile("StepsFile.txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//initialize team steps array 
	            int[] teamSteps = new int[stepsArray.length];
	            //loop through steps array and assign step values to team steps array
	            for (int i1 = 0; i1 < stepsArray.length; i1++) {
	                teamSteps[i1] = Integer.parseInt(stepsArray[i1]);
	            }

	            // Get the winning team
	            int winningTeam = HighScores.whoWon(teamSteps);

	            // Displaying the winning team
	            JOptionPane.showMessageDialog(null, "The winning team is: Team " + winningTeam);

	            // Displaying each hero's number of steps
	            //create and initalize numHeros, assign teamSteps length value
	            int numHeroes = teamSteps.length;
	            //loop to display how many steps each hero took
	            for (int i1 = 0; i1 < numHeroes; i1++) {
	                JOptionPane.showMessageDialog(null, heroes[i].getName() + (i1 + 1) + " took " + teamSteps[i1] + " steps.");
	            }
	        }
            
		}
	        }// if exit button is clicked
			else if (e.getSource() == btnExit) { 
			//make game window not visible
			setVisible(false);
			//display thank you message
			JOptionPane.showMessageDialog(null, "Thank You For Playing");
	}
			else if (e.getSource() == btnStop) {// if stop button is clicked
	        	timer.stop(); //stop timer, heroes stop moving
			}

}
}
