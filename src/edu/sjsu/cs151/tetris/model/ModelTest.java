package edu.sjsu.cs151.tetris.model;

import java.util.Scanner;

/**
 * A Class to test the Tetris game logic implemented in the edu.sjsu.cs151.tetris.model package
 */
public class ModelTest {

	/**
	 * The main method to test the game logic.
	 * @param args unused
	 */
	public static void main(String[] args) {
		Player user = new Player();
		Leaderboard leaderBoard = new Leaderboard();
		int level = 0;
		Playfield playField = new Playfield();;
		Scanner sc = new Scanner(System.in);
		String input;
		Boolean gameOver = false;
		
		
			System.out.println("Welcome to Tetris!");
			
			// Read in data from players.txt into Leaderboard's playerList
			// Display the playerList in the console
			
			System.out.println("Are you a new Player? (yes/no)");
			input = sc.nextLine();
			if(input.equals("yes")) {
				System.out.println("Enter a new username: ");
				input = sc.nextLine();
				user.setName(input);
				level = 1;
				System.out.println("\nStarting Level 1...");
			}
			else if (input.equals("no")){
				System.out.println("Enter your username to load: \n");
				input = sc.nextLine();
				
				// Check to see if the entered username is valid
				// Set user equal to the existing Player in the leaderBoard playerList
				
				System.out.println("Select Level: ");
				
				// Display unlocked levels in console
				
				input = sc.nextLine();
				
				// Check if level is unlocked
				
				level = Integer.parseInt(input);
			}
			else {
				System.out.println("Invalid input");
			}
			
			// Start gameplay
			while (!gameOver) {
				Tetromino currTetromino = new Tetromino();
				currTetromino.setRandomShape();
				playField.spawnTetromino(currTetromino);
				
				// while currTetromino is still falling it can be moved
				while (playField.getFallingStatus()) {
					playField.fallingTetromino(currTetromino);
					System.out.println("Tetromino is falling!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Tetromino has landed!");
				
				// Check if game over
				
				gameOver = true;
				playField.gameOver(user);
			}
		

	}

}
