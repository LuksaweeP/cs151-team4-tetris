package model;
import java.io.*;

/**
 * A class for managing a player's name, unlocked levels, and high-scores.
 */
public class AnotherPlayer {
	private String playerName;
	private int[] unlockedLevels = new int[10];
	private int[] highScores = new int[10];
	
	/**
	 * The Player Constructor.
	 */
	public AnotherPlayer() {
		
	}
	
	/**
	 * Sets the Player name.
	 * @param aName The provided name.
	 */
	public void setName(String aName) {
		
	}
	
	/**
	 * Sets the high score for the level.  
	 * @param aScore The provided score. 
	 * @param aLevel The provided Level.
	 */
	public void setHighScore(int aScore, int aLevel) {
		
	}
	
	/**
	 * A method to return the Player's name.
	 * @return The Player's name.
	 */
	public String getName() {
		return playerName;
	}
	
	/**
	 * A method to return the Player's high score for a given level.
	 * @param level The level.
	 * @return The Player's high score for a level.
	 */
	public int getHighScore(int level) {
		return highScores[level - 1];
	}
	
	/**
	 * A method that returns true or false to determine if the given level is unlocked.
	 * @param aLevel The level to check.
	 * @return True if the Level is unlocked, false if not.
	 */
	public boolean isLevelUnlocked(int aLevel) {
		return false;
	}
	
	/**
	 * A method to unlock the provided level.
	 * @param aLevel The level to unlock.
	 */
	public void unlockLevel(int aLevel) {
		
	}
	
	/**
	 * A method to add the given Player and its data to a .txt file to save its progress.
	 */
	public void addPlayer() {
		try (FileWriter fw = new FileWriter("players.txt", true)){
			BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            // File Format: name highScores[0] highScores[1] ...
            // Can determine what level is unlocked by how many scores there are
            pw.println(this.playerName + "0"); 
            this.unlockedLevels[0] = 1;
            this.highScores[0] = 0;
		} catch(IOException io) {
			// error
		}
	}
}
