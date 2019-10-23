package model;

/**
 * A class for creating a play field with a 2D grid of size height x width that can spawn in Tetrominos,
 * and award points to the player when necessary.
 * This class use the Immutable pattern to not allow the player to change the size of the play field.
 * The default playfield is (Height x Width) = 20 x 10
 */
public class Playfield 
{
	private final int gridHeight = 20;
	private final int gridWidth = 10;
	private int[][] grid;
	Tetromino Tetromino;
	
	/**
	 * The Playfield Constructor.
	 * The default playfield size = 20 x 10
	 */
	public Playfield() 
	{
		grid = new int[gridHeight][gridWidth];
		for( int i = 0; i < gridHeight; i++)
			for (int j = 0; j < gridWidth; j++)
				grid[i][j] = 0;
	}
	
	/**
	 * Sets the Grid Height to the given amount.
	 * @param height The height to set.
	 */
	//public void setGridHeight(int height) 
	//{
		//assert height >= 20 && height <= 24 : "violated precondition 20 <= height <= 24" ;
		//gridHeight = height;
	//}
	
	/**
	 * Sets the Grid Width to the given amount.
	 * @param width The width to set.
	 */
	//public void setGridWidth(int width) 
	//{
		//assert width == 10 : "violated precondition width = 10";
		//gridWidth = width;
	//}
	
	/**
	 * A method to get the Grid Height.
	 * @return The grid's height.
	 */
	public int getGridHeight() 
	{
		return gridHeight;
	}
	
	/**
	 * A method to get the Grid Width.
	 * @return The grid's width.
	 */
	public int getGridWidth() 
	{
		return gridWidth;
	}
	
	/**
	 * A method to spawn a Tetromino onto the top of Playfield.
	 * @param tetromino The Tetromino to spawn
	 */
	public void spawnTetromino(Tetromino tetromino) 
	{
		
	}
	
	/**
	 * A method to check if a row is full of blocks.
	 * @return True if row is full, false if not.
	 */
	public boolean checkRow() {
		return true;
	}
	
	/**
	 * A method to award points to the player's score when necessary.
	 */
	public void awardPoints() {
		
	}
	
	/**
	 * A method to draw the Play Field to the window.
	 */
	public void drawPlayfield() {
		
	}
}
