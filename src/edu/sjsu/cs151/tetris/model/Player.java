package edu.sjsu.cs151.tetris.model;

/**
 * A class for managing a player's name, unlocked levels, and high-scores for each player.
 * @author Luksawee
 * @author Nick
 */
public class Player
{	
	/**
	 * The Player Constructor.
	 */
	public Player() 
	{
		playerName = null;
		playerScore = new int[] { 0, -1, -1, -1, -1, 0};
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
	 * Sets the player's score at given level.
	 * @param aName The provided name
	 * @param aScore The provided score
	 */
	public void setPlayerScore(int aLevel, int aScore)
	{
		if (playerScore[aLevel-1] <= aScore)
			playerScore[aLevel-1] = aScore;
	}
	
	/**
	 * Method to get the player score
	 * @return playerScore The player score
	 */
	public int[] getPlayerScore()
	{
		return playerScore;
	}
	
	/**
	 * The method to set the player highscore
	 */
	public void setPlayerHighScore()
	{
		for(int i =0; i < 5 ; i++)
		{
			if(playerScore[i] >= playerScore[5] )
				playerScore[5] = playerScore[i];
		}
	}
	
	/**
	 * The method to get the max score
	 * @return playerScore[5] the max player's score
	 */
	public int getPlayerHighScore()
	{
		return playerScore[5];
	}
	
	/**
	 * Method to check if a level is unlocked
	 * @param aLevel the level to check
	 * @return true if level is unlocked, false if not
	 */
	public boolean isLevelUnlocked (int aLevel)
	{
		if (playerScore [aLevel - 1] > -1)
				return true;
		
		else
			return false;
	}
		
	private String playerName;	
	private int [] playerScore;	// 1, 2, 3, 4, 5, max
}

		

