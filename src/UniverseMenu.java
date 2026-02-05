import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class UniverseMenu extends JFrame implements ActionListener{
	
	//instance variable for components
	
	private ImagePicture menuBackground, raceTrack, SkyBackground, cartoonBackground, gameBackground;
	private ImagePicture player1team1, player2team1, player1team2, player2team2;
	private TextPicture team, team2, backgrounds;
	private JPanel backgroundPanel, menuPanel; //panel to divide the GUI
	private JTextField teamName, teamName2;
	private ImageIcon background;
	private JButton clearTeamName1, clearTeamName2, setName, setName2, setPlayers, setPlayers2, exitBtn, setBackground, startBtn;
	private JComboBox team1player1, team1player2, team2player1, team2player2, backgroundSelect;
	
	//instance variables for variables
	private String teamSetName= "", teamSetName2= "", player1 = "", player2 = "", player3 = "", player4= "", backgroundName = "";

	public static Universe menuInfo; //send information from menus to the Universe game
	
	/**
	 * Constructor 
	 */
	public UniverseMenu() {
		///call the JFrame Constructor
		super("Universe Menu");

		// set the layout to null (flexible) which means I have to place everything myself 
				// original layout is called is flow layout (left to right)
		setLayout (null);

	    setSize(864, 500);
	    setLocation(100, 40);
	    
	    //initalize gamebackground
	    gameBackground = new ImagePicture(background);
	    
	    //create panel for background and set bounds
	    backgroundPanel = new JPanel();
		backgroundPanel.setLayout(new GridLayout(1, 1));
		backgroundPanel.setBounds(0, 0, 850, 480);
		
		//create panel for menu and set bounds
		menuPanel = new JPanel();
		menuPanel.setLayout(null);
		menuPanel.setOpaque(false);
		menuPanel.setBounds(0, 0, 850, 480);
		
		//create TextPicture for "team #1" header
		team = new TextPicture("Team #1", 40, 38);
		//set font for header
		team.setFont(new Font("SansSerif", Font.BOLD, 20));
		//set colour for header
		team.setColor(Color.BLACK);
		//set bounds for header
		team.setBounds(40, 38, 500, 40);
		//add header to menu panel (onto window)
		menuPanel.add(team);
		
		//create text box for user to input team 1's name
		teamName = new JTextField("Enter Team #1's Name Here (Press Clear)");
		//set bounds of textbox
		teamName.setBounds(16, 82, 225, 20);
		//add textbox to menu panel (onto the window)
		menuPanel.add(teamName);
		
		//create button to clear text box for user to input team 1's name
		clearTeamName1 = new JButton("Clear");
		//set bounds for button
		clearTeamName1.setBounds(155, 105, 80, 15);
		//add button to menu panel
		menuPanel.add(clearTeamName1);
		
		//create button to set team 1's name
		setName = new JButton("Set Team Name");
		//set bounds for button
		setName.setBounds(20, 105, 130, 15);
		//add button to menu panel
		menuPanel.add(setName);
		
		//create button to set team 1's players
		setPlayers = new JButton("Set Players");
		//set bounds for button
		setPlayers.setBounds(70, 170, 100, 15);
		//add button to menu panel
		menuPanel.add(setPlayers);
		
		//initialize string array for players
		String tplayer1 [] = {"Spider-Man"};
		//create combobox which allows user to select between the characters in the player array
		team1player1 = new JComboBox(tplayer1);
		//set bounds of combo box
		team1player1.setBounds(20, 147, 100, 18);
		//add combo box to menu panel
		menuPanel.add(team1player1);
				
		//initialize string array for players
		String t1player2 [] = {"Ant-Man"};
		//create combobox which allows user to select between the characters in the player array
		team1player2 = new JComboBox(t1player2);
		//set bounds of combo box
		team1player2.setBounds(125, 147, 100, 18);
		//add combo box to menu panel
		menuPanel.add(team1player2);
		
		//create TextPicture for "team #2" header
		team2 = new TextPicture("Team #2", 343, 36);
		//set font for header
		team2.setFont(new Font("SansSerif", Font.BOLD, 20));
		//set colour for header
		team2.setColor(Color.BLACK);
		//set bounds for header
		team2.setBounds(343, 36, 500, 40);
		//add header to menu panel (onto window)
		menuPanel.add(team2);
				
		//create text box for user to input team 2's name
		teamName2 = new JTextField("Enter Team #2's Name Here (Press Clear)");
		//set bounds of textbox
		teamName2.setBounds(615, 80, 225, 20);
		//add textbox to menu panel (onto the window)
		menuPanel.add(teamName2);
				
		//create button to clear text box for user to input team 2's name
		clearTeamName2 = new JButton("Clear");
		//set bounds for button
		clearTeamName2.setBounds(755, 105, 80, 15);
		//add button to menu panel
		menuPanel.add(clearTeamName2);
		
		//create button to set team 2's name
		setName2 = new JButton("Set Team Name");		
		//set bounds for button
		setName2.setBounds(620, 105, 130, 15);
		//add button to menu panel
		menuPanel.add(setName2);
				
		//create button to set team 2's players
		setPlayers2 = new JButton("Set Players");
		//set bounds for button
		setPlayers2.setBounds(680, 170, 100, 15);
		//add button to menu panel
		menuPanel.add(setPlayers2);
				
		//initialize string array for players
		String t2player1 [] = {"Iron-Man"};
		//create combobox which allows user to select between the characters in the player array
		team2player1 = new JComboBox(t2player1);
		//set bounds of combo box
		team2player1.setBounds(625, 147, 100, 18);
		//add combo box to menu panel
		menuPanel.add(team2player1);
		
		//initialize string array for players
		String t2player2 [] = {"Deadpool"};
		//create combobox which allows user to select between the characters in the player array
		team2player2 = new JComboBox(t2player2);
		//set bounds of combo box
		team2player2.setBounds(730, 147, 100, 18);
		//add combo box to menu panel
		menuPanel.add(team2player2);
		
		//create TextPicture for "Backgrounds" header
		backgrounds = new TextPicture("BACKGROUNDS", 300, 35);
		//set font for header
		backgrounds.setFont(new Font("SansSerif", Font.BOLD, 20));
		//set colour for header
		backgrounds.setColor(Color.BLACK);
		//set bounds for header
		backgrounds.setBounds(50, 190, 500, 40);
		//add header to menu panel (onto window)
		menuPanel.add(backgrounds);
		
		//add background option 1
		raceTrack = new ImagePicture(new ImageIcon("RaceTrackMini.png"));
		raceTrack.setBounds(60, 235, 220, 140);
		menuPanel.add(raceTrack);
		
		//add background option 2
		SkyBackground = new ImagePicture(new ImageIcon("SkyBackgroundMini.jpg"));
		SkyBackground.setBounds(315, 235, 220, 140);
		menuPanel.add(SkyBackground);
		
		//add background option 3
		cartoonBackground = new ImagePicture(new ImageIcon("CartoonBackgroundMini.png"));
		cartoonBackground.setBounds(570, 235, 220, 140);
		menuPanel.add(cartoonBackground);
		
		//initialize string array for the different backgrounds
		String backgrounds [] = {"Race-Track", "Sky", "Cartoon"};
		//create combobox which allows user to select between the backgrounds in the backgrounds array
		backgroundSelect = new JComboBox(backgrounds);
		//set bounds of combo box
		backgroundSelect.setBounds(380, 405, 100, 18);
		//add combo box to menu panel
		menuPanel.add(backgroundSelect);
		
		//create button to set background of game
		setBackground = new JButton("Set Background");
		//set bounds for button
		setBackground.setBounds(365, 427, 130, 15);
		//add button to menu panel
		menuPanel.add(setBackground);
		
		//create button to set team 2's players
		startBtn = new JButton("START GAME!");
		//set bounds for button
		startBtn.setBounds(710, 10, 120, 15);
		//add button to menu panel
		menuPanel.add(startBtn);
		
		//create button to set team 2's players
		exitBtn = new JButton("Exit");
		//set bounds for button
		exitBtn.setBounds(640, 10, 65, 15);
		//add button to menu panel
		menuPanel.add(exitBtn);
		
		//add background for menu
		menuBackground = new ImagePicture(new ImageIcon("UniverseMenuBackground.png"));
		menuBackground.setBounds(0, 0, 850, 480);
		menuPanel.add(menuBackground);

		// Add menuPanel to the frame (UniverseMenu)
		add(menuPanel);
		
		// Add action listeners to buttons
	    clearTeamName1.addActionListener(this);
	    clearTeamName2.addActionListener(this);
	    setName.addActionListener(this);
	    setName2.addActionListener(this);
	    setPlayers.addActionListener(this);
	    setPlayers2.addActionListener(this);
	    setBackground.addActionListener(this);
	    exitBtn.addActionListener(this);
	    startBtn.addActionListener(this);
	    
	    //Add actionlisteners for comboboxes 
	    setBackground.addActionListener(this);
		
		// make the frame visible, not resizable
		setVisible(true);
		setResizable(false);

		setDefaultCloseOperation(EXIT_ON_CLOSE); //stops the program when the window is x'ed
}
	/**
	 * Method if buttons are clicked
	 */
	public void actionPerformed(ActionEvent evt) {
		// If clear buttons for team names are pressed
		if (evt.getSource() == clearTeamName1) {
			//set text field to "" (blank)
			teamName.setText("");
		}
		else if (evt.getSource() == clearTeamName2) {
			//set text field to "" (blank)
			teamName2.setText("");
		} 
		//If set team name buttons are pressed
		else if (evt.getSource() == teamName) {
			//Get input from user on team 1s name
			teamSetName = (teamName.getText());
		}
		else if (evt.getSource() == teamName2) {
			//Get input from user on team 2s name
			teamSetName2 = (teamName2.getText());
		}
		// Button for when team 1 sets their players
		else if (evt.getSource() == setPlayers) {
			
		    // Assign selected option from combo box to player1
		    player1 = String.valueOf(team1player1.getSelectedItem());
		    
		    // Assign the image based on the selected player for player1team1
		    if (player1.equals("Spider-Man")) { //If player 1 is equal to spiderman
		    	//assign spiderman image to player 1 team 1 image picture
		        player1team1.setImage(new ImageIcon("SpiderMan.png"));
		        player1 = "SpiderMan.png";
		        	        
		    } else { //Nothing
		    }

		    // Assign selected option from combo box to player2
		    player2 = String.valueOf(team1player2.getSelectedItem());
		    // Assign the image based on the selected player for player2team1
		        
		    if (player2.equals("Ant-Man")) {//If player 2 is equal to antman
		    	//assign antman image to player 2 team 1 image picture
		        player2team1.setImage(new ImageIcon("AntMan.png"));
		        player2 = "AntMan.png";         
		    } else {//Nothing
		    }
		}
		
		// Button for when team 2 sets their players
		else if (evt.getSource() == setPlayers2) {
			
		    // Assign selected option from combo box to player3
		    player3 = String.valueOf(team2player1.getSelectedItem());
		    
		    	if (player3.equals("Iron-Man")) {//If player 3 is equal to ironman
		    	//assign ironman image to player 1 team 2 image picture
		        player1team2.setImage(new ImageIcon("IronMan.png"));
		        player3 = "IronMan.png";
		        
		    } else {//Nothing
		    }

		    // Assign selected option from combo box to player4
		    player4 = String.valueOf(team2player2.getSelectedItem());
		    
		    if (player4.equals("Deadpool")) {//else player 4 is equal to deadpool
		    	//assign deadpool image to player 2 team 1 image picture
		        player2team2.setImage(new ImageIcon("DeadPool.png"));
		        player4 = "DeadPool.png";
		    }		
		}
		
		//Button to set games background
			else if (evt.getSource() == setBackground) {
				//assign selected option from combo box to background
				backgroundName = String.valueOf(backgroundSelect.getSelectedItem());
				//if background is equal to race track
				if (backgroundName.equals("Race-Track")) {
					//assign racetrack image to game background
					gameBackground.setImage(new ImageIcon("RaceTrack.png"));
					//assign image name to background name variable
					backgroundName = "RaceTrack.png";
				}
				//if background is equal to sky
				else if (backgroundName.equals("Sky")) {
					//assign sky image to game background
					gameBackground.setImage(new ImageIcon("SkyBackground.jpg"));
					//assign image name to background name variable
					backgroundName = "SkyBackground.jpg";
				}
				//if background is equal to cartoon
				else if (backgroundName.equals("Cartoon")) {
					//assign cartoon image to game background
					gameBackground.setImage(new ImageIcon("CartoonBackground.png"));
					//assign image name to background name variable
					backgroundName = "CartoonBackground.png";
		}
	}
		//Button to exit game
			else if (evt.getSource() == exitBtn) {
				//make window not visible
				setVisible(false);
			}
		
		//Button to start game
			else if (evt.getSource() == startBtn) {
				//send information to universe game class
				menuInfo = new Universe(gameBackground, teamSetName2, teamSetName, backgroundName);
				//make window not visible
				setVisible(false);
			}
}
	
	/**
	 * Main Method
	 */
	public static void main(String[] args) {
		// Create a window object, calls on constructor
		UniverseMenu myGame = new UniverseMenu();
		

	}

}

