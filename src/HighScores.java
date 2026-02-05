import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class HighScores {

	/*
	 * Default Constructor
	 */
	public HighScores() {
	}

	/**
	 *  Method to calculate how many dice rolls each player
	 *  completed the race in.
	 *  
	 *  It takes a file separate from the one that whoWon
	 *  takes, instead of steps, it records how many rolls
	 *  each player finished the race in
	 */
	public static int[] playerRolls(int[] rolls)  {

		// each pair of numbers, excluding EOF is a new team
		int numPlayers = rolls.length;

		// create and initialize array for player total rolls
		int[] playerTotalRolls = new int[numPlayers];

		// for loop to calculate total rolls for each player
		for (int i = 0; i < numPlayers; i++) {
			playerTotalRolls[i] = rolls[i];
		}

		return playerTotalRolls;
	}


	/**
	 *  Method to calculate who won
	 *  
	 *  Calculates for a pair in the text file, excluding EOF.
	 *  Minimum 2 teams (4 lines of code)
	 *  
	 *  Returns the winning team number
	 */
	public static int whoWon (int[] step) {

		// each pair of numbers, excluding EOF is a new team
		int numTeams = step.length/2;

		// create and initialize array for team total steps
		int[] teamTotalSteps = new int[numTeams];

		// for loop to calculate total steps for each team
		for (int i = 0; i < step.length; i += 2) {

			// calculate the current team, divides by two for ONE team
			int teamSteps = i / 2;

			// calculate the total steps for the team, i+1 because teamSteps divides
			// by two in order to get a single team.
			teamTotalSteps[teamSteps] = step[i] + step[i + 1];
		}

		// find team with most steps
		int maxSteps = teamTotalSteps[0];
		int winningTeam = 0;

		// for loop to find the team with the highest step
		for (int i = 1; i < numTeams; i++) {

			// check to see if the total steps at i is greater than
			// current max number of steps, which is at [0]
			if (teamTotalSteps[i] > maxSteps) {

				// update maxSteps with total steps of current team (at i)
				maxSteps = teamTotalSteps[i];

				// winning team is i
				winningTeam = i;
			}

		}

		// Return the winning team 
		// adds 1 so that it prevents it from saying team 0 won
		return winningTeam + 1;
	}

	/**
	 * Method that opens the file for reading and makes
	 * it available for other classes
	 * 
	 */
	public static int[] readTeamStep (String fileName, int x) throws IOException {
		// max size of array
		int maxSize = 20;

		// declare variable for steps
		int[] steps = new int[maxSize];


		// opens the fileName
		FileReader fr = new FileReader(fileName);
		BufferedReader input = new BufferedReader (fr);

		for (int i = 0; i < maxSize; i++) {

			// read line
			String line = input.readLine();		

			// stop if EOF
			if (line.equals("EOF")) {
				break;
			}

			// each step array is 1 readLine
			steps[i] = Integer.parseInt(line);
		}

		// close file/stream
		input.close();

		// return steps
		return steps;
	}

	/**
	 * Method that opens the file for reading and makes
	 * it available for other classes
	 */
	public static String[] readFile (String fileName) throws IOException {
		// Declare variables to read the line
		String lineContents;
		int counter = -1;

		// opens the fileName
		FileReader fr = new FileReader(fileName);
		BufferedReader input = new BufferedReader (fr);

		// do-while loop to read the amount of lines 
		do {

			lineContents = input.readLine();
			counter = counter + 1;

		} while (!lineContents.equals("EOF"));

		// declare and create a string array
		String fileInfo[] = new String[counter];

		// opens the fileName
		fr = new FileReader(fileName);
		input = new BufferedReader (fr);

		// loop to read each record
		for (int i = 0; i < counter; i++) {

			fileInfo[i] = input.readLine();

		}

		// close the stream or file
		input.close();

		// return the array
		return fileInfo;
	}

	/**
	 * Method that writes to a file, and can be run through other methods.
	 */
	public static void writeToFile(String writeFile, String info[]) throws IOException {

		// setup fileWriter and printWriter
		FileWriter fileW = new FileWriter(writeFile);
		PrintWriter output = new PrintWriter(fileW);

		// loop to write formatted output and then save item to file
		for (int i = 0; i < info.length; i = i + 1) {
			output.println(info[i]);
		}

		// adds EOF to the end of the file
		output.println("EOF");

		// writes to file and closes it
		fileW.close(); 
	}

	/**
	 * @param args
	 * @throws IOException 
	 * 
	 * Self-Testing Main
	 */
	public static void main(String[] args) throws IOException {

		//>>>>>>>>>>>>>>> the file to be read  <<<<<<<<<<<<<<<<<<<<<<<
		String array[] = readFile("StepsFile.txt");
		System.out.println("READ FILE:");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}


		//>>>>>>>>>>>>>>>> test to see if we could get the steps for individual heroes <<<<<<<<<<<<<<<<<<<<<<<
		System.out.println("\n" + "each team steps:");

		int maxSize = 20;

		int[] teamSteps = new int[maxSize];

		for (int i = 0; i < array.length; i++) {
			teamSteps = readTeamStep("StepsFile.txt", i);

			System.out.println(teamSteps[i]);
		}

		//>>>>>>>>>>>>>>>> print out a specific hero's steps <<<<<<<<<<<<<<<<<<<<<<<
		System.out.println("\n" + teamSteps[2]);

		//>>>>>>>>>>>>>>>>> calculate winning team <<<<<<<<<<<<<<<<<<<<<<<
		int winningTeam;

		winningTeam = whoWon(teamSteps);

		System.out.println("\n" + "The winning team is: Team " + winningTeam);


		//>>>>>>>>>>>>>>>>> roll dice values to see if file can be written to <<<<<<<<<<<<<<<<<<<<<<<

		// Create 4 dice with 12 faces for each hero
		Die d1 = new Die(12);   
		Die d2 = new Die(12);
		Die d3 = new Die(12);
		Die d4 = new Die(12);

		// create variables to store dice values
		int d1Total = 0;
		int d2Total = 0;
		int d3Total = 0;
		int d4Total = 0;

		int counter = 0;
		int[] counterArray = null;

		// for loop to roll the dice
		for (int i = 1; i <= 1000; i++) {

			// roll the dice
			d1.rollDie();
			d2.rollDie();
			d3.rollDie();
			d4.rollDie();

			// check if sum of d1 and d2 equals to 4, 6, 24, if so, skip the current iteration of this loop for d1 and d2
			// (in other words, it skips d1 and d2's rolls for the current loop its on)
			if (d1.getValue() + d2.getValue() == 4 || d1.getValue() + d2.getValue() == 6 || d1.getValue() + d2.getValue() == 24) {
				continue;
			}

			// if it does not equal 4, 6 or 24, add the dtotal with the dice current value with the total value of dice for d1 and d2
			d1Total = d1Total + d1.getValue();
			d2Total = d2Total + d2.getValue();

			// check if sum of d3 and d4 equals to 4, 6, 24, if so, skip the current iteration of this loop for d3 and d4
			// (in other words, it skips d3 and d4's rolls for the current loop its on)
			if (d3.getValue() + d4.getValue() == 4 || d3.getValue() + d4.getValue() == 6 || d3.getValue() + d4.getValue() == 24) {
				continue;
			}

			d3Total = d3Total + d3.getValue();
			d4Total = d4Total + d4.getValue();
		}

		// print out the total amount of steps
		System.out.println("\n");
		System.out.println(d1Total);
		System.out.println(d2Total);
		System.out.println(d3Total);
		System.out.println(d4Total);

		//>>>>>>>>>>>>>>>>> test if file can be written to <<<<<<<<<<<<<<<<<<<<<<<

		// make a new saved file
		String savedFile = "newStepsFile.txt";

		// assign d values to array elements
		array [0] = String.valueOf(d1Total);
		array [1] = String.valueOf(d2Total);
		array [2] = String.valueOf(d3Total);
		array [3] = String.valueOf(d4Total);

		// writes to file by calling writeToFile method
		writeToFile(savedFile, array);

		// the contents of the file that was saved
		System.out.println("\nWRITE TO FILE:");

		// for loop to read the StepsFile.txt file 
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);     
		}


		//>>>>>>>>>>>>>>>>> check which team won from the new file <<<<<<<<<<<<<<<<<<<<<<<

		System.out.println("\n");
		System.out.println("\nCHECK WHICH TEAM WON");

		int maxSizeNew = 4;

		int[] teamStepNew = new int[maxSize];

		for (int i = 0; i < array.length; i++) {
			teamStepNew = readTeamStep("newStepsFile.txt", i);

			System.out.println(teamStepNew[i]);
		}

		winningTeam = whoWon(teamStepNew);

		System.out.println("\n" + "The winning team is: Team " + winningTeam);

		//>>>>>>>>>>>>>>>>> test playerRoll method to see if we could grab individual rolls <<<<<<<<<<<<<<<<<<<<<<<
		String rollFile = "IndividualRolls.txt";
		String[] rollsArray = readFile(rollFile);

		// Convert string array to int array
		int[] rolls = new int[maxSize];
		
		for (int i = 0; i < rollsArray.length; i++) {
			
			rolls[i] = Integer.parseInt(rollsArray[i]);
			
		}

		// Call the playerRolls method to get total rolls per player
		int[] playerTotalRolls = playerRolls(rolls);

		// Print or use playerTotalRolls as needed
		System.out.println("\nPLAYER TOTAL ROLLS:");
		
		for (int i = 0; i < rollsArray.length; i++) {
			
			System.out.println("Player " + (i + 1) + " completed the race in " + playerTotalRolls[i] + " rolls.");
		
		}

	}

}