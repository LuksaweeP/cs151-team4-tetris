package model;
/**
 * A class for managing a player's name, unlocked levels, and high-scores.
 */
public class Player
{	
	/**
	 * The Player Constructor.
	 */
	public Player() 
	{
		playerName = null;
		playerLevel = new int[] { 0, -1, -1, -1, -1};
		playerScore = new int[] { 0, 0, 0, 0, 0, 0};
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
	 * Sets the player's level.
	 * @param aLevel
	 */
	public void setPlayerLevel(int aLevel)
	{
		playerScore[aLevel-1] = 0;
	}
	
	/**
	 * THe method to get the level score
	 * @return The playerScore
	 */
	public int[] getPlayerLevel()
	{
		return playerLevel;
	}
	
	/**
	 * Sets the player's score at given level.
	 * @param aName The provided score.
	 */
	public void setPlayerScore(int aLevel, int aScore)
	{
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
	public void setPlayerScoreMax()
	{
		for(int i =0; i < 5; i++)
		{
			if(playerScore[i] >= playerScore[i+1] )
				playerScore[5] = playerScore[i];
			else
				playerScore[5] = playerScore[i+1];
		}
	}
	
	/**
	 * The method to get the max score
	 * @return the max player's score
	 */
	public int getPlayerScoreMax()
	{
		return playerScore[5];
	}
		
	private String playerName;	
	private int [] playerLevel;	// level = 1, 2, 3, 4, 5
	private int [] playerScore;	// 1, 2, 3, 4, 5, max
}

		

