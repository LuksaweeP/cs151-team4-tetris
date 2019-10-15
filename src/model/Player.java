package model;

/**
 * A class for managing a player's name, unlocked levels, and high-scores for each player.
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
	 * @param aName The provided score.
	 */
	public void setPlayerScore(int aLevel, int aScore)
	{
		if (playerScore[aLevel-1] <= aScore)
			playerScore[aLevel-1] = aScore;
	}
	
	/**
	 * THe method to get the player score
	 * @return The playerScore
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
	 * @return the max player's score
	 */
	public int getPlayerHighScore()
	{
		return playerScore[5];
	}
	
	public boolean isLevelUnlocked (int aLevel)
	{
		if (playerScore [aLevel - 1] > -1)
				return true;
		
		else
			return false;
	}
		
	private String playerName;	
	private int [] playerScore;	// 1, 2, 3, 4, 5, max
	Player next;
}

		

