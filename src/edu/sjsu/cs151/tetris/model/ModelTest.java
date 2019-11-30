package edu.sjsu.cs151.tetris.model;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * A Class to test the Tetris game logic implemented in the edu.sjsu.cs151.tetris.model package
 */
public class ModelTest {

	/**
	 * The main method to test the game logic.
	 * @param args unused
	 */
	public static void main(String[] args) 
	{
		
		SingleRandom rand = SingleRandom.getInstance();
		int num;
		
		for (int i = 0; i < 100; i++)
		{
			num = rand.nextInt(7);
			System.out.println(num);
		}
		
		
		
				
		
		Leaderboard playerList = new Leaderboard();
		//playerList.readPlayers();
		Playfield playField = new Playfield();
		ArrayList <Player> list = playerList.getPlayer();
		int number = playerList.getNumberPlayers();
		int level = 1;

		Player players = new Player();
		for (int i =0; i < number; i++)
		{
			players = list.get(i);
			System.out.print(players.getName() + " ");
			int [] playerScore = players.getPlayerScore();
			for (int score: playerScore)
				System.out.print(score + " ");
			System.out.println();
		}
		
		Scanner sc = new Scanner(System.in);
		String input;
		System.out.println("Welcome to Tetris!");
			
			// Read in data from players.txt into Leaderboard's playerList
			// Display the playerList in the console
			System.out.println("Are you a new Player? (yes/no)");
			input = sc.nextLine();
			Player newPlayer = new Player();
			
			if(input.equals("yes")) 
			{
				System.out.println("Enter a new username: ");
				input = sc.nextLine();
				while (playerList.isValidNewPlayers(input) == false)
				{
					System.out.println("Enter a new username: ");
					input = sc.nextLine();
					newPlayer.setName(input);
				}
				playerList.addNewPlayer(input);
				level = 1;
				playField.setLevel(level);
				
			}
			else if (input.equals("no")){
				System.out.println("Enter your username to load: ");
				input = sc.nextLine();
				newPlayer = playerList.loadPlayer(input);
				int [] loadPlayerScore = newPlayer.getPlayerScore();
				System.out.print(newPlayer.getName() + " ");
				for (int score: loadPlayerScore)
					System.out.print(score + " ");
				
				System.out.println();
				// Display unlocked levels in console
				System.out.println("Enter the level to download: ");
				input = sc.nextLine();
				
				// Check if level is unlocked
				level = Integer.parseInt(input);
				while (!newPlayer.isLevelUnlocked(level))
				{
					System.out.println("Enter the level to download: ");
					input = sc.nextLine();
					level = Integer.parseInt(input);
				}
				playField.setLevel(level);
			}
			
			playField.getLevel();
			Tetromino currTetromino = new Tetromino();
			currTetromino.setRandomShape();
			currTetromino.setBlocks();
			playField.spawnTetromino(currTetromino);

			Tetromino nextTetromino = new Tetromino();
			
			while (!playField.isGameOver()) 
			{
				
				nextTetromino.setRandomShape();
				System.out.println(currTetromino.getShape());
				
				// while currTetromino is still falling it can be moved
				while (!playField.getReachBottom()) {
					playField.reachBottom(currTetromino);
					
					//System.out.println(" Tetromino is falling!");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				currTetromino = nextTetromino;
				currTetromino.setBlocks();
				playField.spawnTetromino(currTetromino);
			}
			
			newPlayer.setPlayerScore(level, playField.getScore());
	}
}
