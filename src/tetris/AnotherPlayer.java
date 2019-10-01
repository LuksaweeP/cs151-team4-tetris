package tetris;

public class AnotherPlayer {

}


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
	
	protected Player next;
	protected Player head;
	private int index;
	
	// level = 1, 2, 3, 4, 5
	private int[] highScoresAtLevel = new int[5];
	
	//
	private int[][] highAllLevelScore = new int[3][10];
	
	/**
	 * The Player Constructor.
	 */
	public Player() 
	{
		playerName = null;
		playerScoreLevel1 = -1;
		playerScoreLevel2 = -1;
		playerScoreLevel3 = -1;
		playerScoreLevel4 = -1;
		playerScoreLevel5 = -1;
		playerScoreMax = -1;
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
		
		else if (playerScoreLevel2 > playerScoreMax)
			playerScoreMax = playerScoreLevel2;
		
		else if (playerScoreLevel3 > playerScoreMax)
			playerScoreMax = playerScoreLevel3;
		
		else if (playerScoreLevel4 > playerScoreMax)
			playerScoreMax = playerScoreLevel4;
		
		else if (playerScoreLevel5 > playerScoreMax)
			playerScoreMax = playerScoreLevel5;
	}
	
	public int getPlayerScoreMax()
	{
		return playerScoreMax;
	}

	/**
	 * 
	 * @param aName given new username
	 */
	public void addNewPlayer(Player newPlayer)
	{
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader("/Users/Luksawee/Desktop/MyFile.txt"));
			
			
			while (br.ready()) 
			{
				// The output from br.readLine() is string; therefore we need to convert from string to int.
				result.add(Integer.parseInt((br.readLine())));
				
				//instructor code line
				//result.add(Integer.getInteger(br.readLine()));
			}
		
		try 
		{
			FileWriter writer = new FileWriter("/Users/Luksawee/Desktop/MyFile.txt", true);
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
	
	public boolean isLevelUnlocked(String aName, int aLevel)
	{
		Player temp = head;
		if (temp == null)
		{
			System.out.println("No username!!");
			return false;
		}
				
		else 
			while (temp.next != null)
			{
				if (temp.getName() == aName)
				{
					switch (aLevel) 
					{
						case 1:
							if (temp.playerScoreLevel1 > 0)
							return true;
						break;
					}
				}
				temp = temp.next;
			}
		return false;
	}	
			

	public static void main(String[] args) 
	{
		Player newPlayer = new Player();
		newPlayer.setName("Fern");
		 
		System.out.println("Name: " + newPlayer.getName());
		System.out.println("Score Level: " + newPlayer.getPlayerScoreLevel1());
		
		newPlayer.setPlayerScoreLevel1(50);
		System.out.println("Score Level: " + newPlayer.getPlayerScoreLevel1());
		
		newPlayer.getPlayerScoreLevel1();
		
		newPlayer.addNewPlayer(newPlayer);
		
	}
}
		

