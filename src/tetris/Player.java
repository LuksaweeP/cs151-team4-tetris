package tetris;

public class Player {
	private String playerName;
	private int[] unlockedLevels = new int[10];
	private int[] highScores = new int[10];
	
	public Player() {
		
	}
	
	public void setName() {
		
	}
	
	public void setHighScore() {
		
	}
	
	public String getName() {
		return playerName;
	}
	
	public int getHighScore(int level) {
		return highScores[level - 1];
	}
	
	public Boolean isLevelUnlocked() {
		return false;
	}
	
	public void unlockLevel() {
		
	}

	public void addPlayer() {
		
	}
}
