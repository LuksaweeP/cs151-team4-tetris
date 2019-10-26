package edu.sjsu.cs151.tetris.model;

/**
 * A class for creating a play field with a 2D grid of size height x width that can spawn in Tetrominos,
 * and award points to the player when necessary.
 * The default playfield is (Height x Width) = 20 x 10
 */
public class Playfield 
{
	/**
	 * The Playfield Constructor.
	 * The default playfield size = 20 x 10
	 */
	public Playfield() 
	{
		grid = new int[gridHeight][gridWidth];
		for (int i = 0; i < gridHeight; i++)
			for( int j = 0; j < gridWidth; j++)
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
	 * A method to get the Grid 
	 * @return The grid's width.
	 */
	public int [][] getGrid() 
	{
		return grid;
	}
	
	/**
	 * A method to spawn a Tetromino onto the top-left-side of Playfield.
	 * @param tetromino The Tetromino to spawn
	 */
	public void spawnTetromino(Tetromino tetromino) 
	{
		int tetrominoHeight = tetromino.getBlockHeight();
		int tetrominoWidth = tetromino.getBlockWidth();
		
		for (int i = 0; i < tetrominoHeight; i++)
		{
			for (int j = 0; j < tetrominoWidth; j++)
			{
				if (grid[i][j]== 1)
				{
					gameOver(player);
					break;
				}
			}
		}
		tetromino.getBlocks();
	}

	/**
	 * A method to check if a row is full of blocks.
	 * @return True if row is full, false if not.
	 */
	public boolean isRowFull(int index) 
	{
		for (int i = 0; i < gridWidth; i++ )
		{
			if(grid[index][i] == 0)
				return false;
		}
		return true;
	}
	
	/**
	 * This method to count the full rows
	 * @return
	 */
	public int countFullRows()
	{
		int fullrows = 0;
		for(int i = 0; i < gridHeight; i++)
		{
			if(isRowFull(i))
				fullrows++;
		}
		return fullrows;
	}
	
	/**
	 * This method will count player score
	 */
	public void countScore()
	{
		int addScore = 0;
		int lines = countFullRows();
		if (lines == 1)
			addScore = 100 * level;
		if (lines == 2)
			addScore = 300 * level;
		if (lines == 3)
			addScore = 500 * level;
		if (lines == 4)
			addScore = 800 * level;
		
		score = score + addScore;
	}
	/**
	 * This method to remove the full row
	 */
	public void removeRow(int index)
	{
		for (int i = 0; i < gridWidth; i++)
			grid[index][i] = 0;
		
		for (int j = index; j > 0; j--)
		{
			for(int k = 0; k < gridWidth; k++)
				grid[j][k] = grid[j-1][k];
		}
	}

	/**
	 * A method to draw the Play Field to the window.
	 */
	public void drawPlayfield() {
		
	}
	
	public void gameOver(Player player)
	{
		System.out.println("Game Over!");
		player.setPlayerScore(level, score);
		player.setPlayerHighScore();
	}
	
	private final int gridHeight = 20;
	private final int gridWidth = 10;
	private int[][] grid;
	private int score = 0;
	private int level = 1;
	Tetromino curTetromino;
	Tetromino nextTetromino;
	Player player;
	
}


