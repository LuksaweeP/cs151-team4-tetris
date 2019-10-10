package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A class for managing a player's name, unlocked levels, and high-scores.
 */
public class Player
{
	private String playerName;
	private int playerScoreLevel1;
	private int playerScoreLevel2;
	private int playerScoreLevel3;
	private int playerScoreLevel4;
	private int playerScoreLevel5;
	private int playerScoreMax;
		
	// level = 1, 2, 3, 4, 5
	private int[] highScoresAtLevel = new int[5];
	
	// rank, name score from 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
	private int[][] highAllLevelScore = new int[3][10];
	
	/**
	 * The Player Constructor.
	 */
	public Player() 
	{
		playerName = null;
		playerScoreLevel1 = 0;
		playerScoreLevel2 = -1;
		playerScoreLevel3 = -1;
		playerScoreLevel4 = -1;
		playerScoreLevel5 = -1;
		playerScoreMax = 0;
	}

	/**
	 * Sets the Player name.
	 * @param aName The provided name.
	 */
	public void setName(String aName) 
	{
		playerName = aName;
	}
	
	/**
	 * A method to return the Player's name.
	 * @return The Player's name.
	 */
	public String getName() 
	{
		return playerName;
	}
	
	/**
	 * Sets the player's score at level 1.
	 * @param aName The provided score.
	 */
	public void setPlayerScoreLevel1(int aScore) 
	{
		playerScoreLevel1 = aScore;
	}
	
	/**
	 * A method to return player's score at level 1
	 * @return player's score at level 1
	 */
	public int getPlayerScoreLevel1() 
	{
		return playerScoreLevel1;
	}
	
	/**
	 * Sets the player's score at level 2.
	 * @param aName The provided score.
	 */
	public void setPlayerScoreLevel2(int aScore) 
	{
		playerScoreLevel2 = aScore;
	}
	
	/**
	 * A method to return player's score at level 2
	 * @return player's score at level 2
	 */
	public int getPlayerScoreLevel2() 
	{
		return playerScoreLevel2;
	}
	
	/**
	 * Sets the player's score at level 3.
	 * @param aName The provided score.
	 */
	public void setPlayerScoreLevel3(int aScore) 
	{
		playerScoreLevel3 = aScore;
	}
	
	/**
	 * A method to return player's score at level 3
	 * @return player's score at level 3
	 */
	public int getPlayerScoreLevel3() 
	{
		return playerScoreLevel3;
	}
	
	/**
	 * Sets the player's score at level 4.
	 * @param aName The provided score.
	 */
	public void setPlayerScoreLevel4(int aScore) 
	{
		playerScoreLevel4 = aScore;
	}
	
	/**
	 * A method to return player's score at level 4
	 * @return player's score at level 4
	 */
	public int getPlayerScoreLevel4() 
	{
		return playerScoreLevel4;
	}
	
	/**
	 * Sets the player's score at level 5.
	 * @param aName The provided score.
	 */
	public void setPlayerScoreLevel5(int aScore) 
	{
		playerScoreLevel5 = aScore;
	}
	
	/**
	 * A method to return player's score at level 5
	 * @return player's score at level 5
	 */
	public int getPlayerScoreLevel5() 
	{
		return playerScoreLevel5;
	}
	
	public void setPlayerScoreMax()
	{
		if (playerScoreLevel1 > playerScoreMax)
			playerScoreMax = playerScoreLevel1;
		
		if (playerScoreLevel2 > playerScoreMax)
			playerScoreMax = playerScoreLevel2;
		
		if (playerScoreLevel3 > playerScoreMax)
			playerScoreMax = playerScoreLevel3;
		
		if (playerScoreLevel4 > playerScoreMax)
			playerScoreMax = playerScoreLevel4;
		
		if (playerScoreLevel5 > playerScoreMax)
			playerScoreMax = playerScoreLevel5;
	}
	
	public int getPlayerScoreMax()
	{
		return playerScoreMax;
	}

	/**
	 * This method will check wheter not username has already token.
	 * @param newPlayer newPlayer the obj in the player
	 * @return true is the 
	 */
	public boolean checkExistedPlayers(Player newPlayer)
	{
		ArrayList<String> allUsers = new ArrayList<String>();
		
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader("/Users/Luksawee/Desktop/players.txt"));
			while (br.ready()) 
			{
				// The output from br.readLine() is string; therefore we need to convert from string to int.
				allUsers.add(br.readLine());
			}
		//close file
		br.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
		int numberUsers = allUsers.size();
		String [] existedUsername;
		String [] usernameTable = new String[numberUsers];
		/**
		 * case: there is an existed username.
		 */
		for (int i = 0; i < numberUsers; i++)
		{
			existedUsername = allUsers.get(i).split(", ");
			usernameTable[i] = existedUsername[0];
				if(usernameTable[i].equals(newPlayer.getName()))
				{
					System.out.println("Invalid new username");
					return true;
				}
		}
		return false;
	}
	
	/**
	 * This method is used to add new player.
	 * @param aName given new player
	 */
	public void addNewPlayer(Player newPlayer)
	{
		if (checkExistedPlayers(newPlayer) == false)
		{
			try 
			{
				FileWriter writer = new FileWriter("/Users/Luksawee/Desktop/players.txt", true);
				writer.write(newPlayer.getName());
				writer.write(", ");
				writer.write(Integer.toString(newPlayer.getPlayerScoreLevel1()));
				writer.write(", ");
				writer.write(Integer.toString(newPlayer.getPlayerScoreLevel2()));
				writer.write(", ");
				writer.write(Integer.toString(newPlayer.getPlayerScoreLevel3()));
				writer.write(", ");
				writer.write(Integer.toString(newPlayer.getPlayerScoreLevel4()));
				writer.write(", ");
				writer.write(Integer.toString(newPlayer.getPlayerScoreLevel5()));
				writer.write(", ");
				writer.write(Integer.toString(newPlayer.getPlayerScoreMax()));
				writer.write("\r\n");
				writer.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		else
			System.out.println("The username has already taken");	
	}
		
	
	/**
	 * Sets the high score for the level.  
	 * @param aScore The provided score. 
	 * @param aLevel The provided Level.
	 */
	public void setHighScoreAtLevel(int aScore, int aLevel) 
	{
		// to set highscore at given level
		if (aScore > highScoresAtLevel[aLevel])
		{
			highScoresAtLevel[aLevel] = aScore;
		}
	}
	
	/**
	 * A method to return the Player's high score for a given level.
	 * @param level The level.
	 * @return The Player's high score for a level.
	 */
	public int getHighScoreAtLevel(int level) 
	{
		return highScoresAtLevel[level - 1];
	}
	
	/**
	 * This method will check the level which player has already unlock
	 * @param newPlayer the object o
	 * @param aLevel level which want to check
	 * @return true if the player have already unlocked the given level
	 */
	public boolean isLevelUnlocked(Player newPlayer, int aLevel)
	{ 
		switch(aLevel)
		{
			case 1: 
				if (newPlayer.getPlayerScoreLevel1() != -1)
						return true;
						break;
			case 2: 
				if (newPlayer.getPlayerScoreLevel2() != -1)
						return true;
						break;
			case 3: 
				if (newPlayer.getPlayerScoreLevel3() != -1)
						return true;
						break;
			case 4: 
				if (newPlayer.getPlayerScoreLevel4() != -1)
						return true;	
						break;
			case 5: 
				if (newPlayer.getPlayerScoreLevel5() != -1)
						return true;
						break;
		}
			return false;		
	}		
}

		

