package model;
import java.util.ArrayList;

/**
 * A class for managing the in game leaderboard.
 */
public class Leaderboard {
	private ArrayList<Player> playerList;
	
	/**
	 * This constructs a Leaderboard of Players.
	 */
	public Leaderboard() {
		
	}
	
	/**
	 * This method reads in new players and adds them to the list of players.
	 */
	public void readPlayers() {
		
	}
	
	/**
	 * This method returns the current list of players.
	 * @return The list of players
	 */
	public ArrayList<Player> getPlayerList(){
		return playerList;
	}
	
	/**
	 * This method takes the player list and sorts it by high score.
	 * @return The list of players sorted by score
	 */
	public ArrayList<Player> sortPlayers() {
		return playerList;
	}
}
