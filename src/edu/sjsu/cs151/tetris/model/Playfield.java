package edu.sjsu.cs151.tetris.model;

/**
 * A class for creating a play field with a 2D grid of size height x width that
 * can spawn in Tetrominos, and award points to the player when necessary. The
 * default playfield is (Height x Width) = 20 x 10
 */
public class Playfield {
	/**
	 * The Playfield Constructor. The default playfield size = 20 x 10
	 */
	public Playfield() {
		grid = new int[gridHeight][gridWidth];
		for (int i = 0; i < gridHeight; i++)
			for (int j = 0; j < gridWidth; j++)
				grid[i][j] = 0;
	}

	/**
	 * A method to get the Grid Height.
	 * 
	 * @return The grid's height.
	 */
	public int getGridHeight() {
		return gridHeight;
	}

	/**
	 * A method to get the Grid Width.
	 * 
	 * @return The grid's width.
	 */
	public int getGridWidth() {
		return gridWidth;
	}

	/**
	 * A method to get the Grid
	 * 
	 * @return The grid's width.
	 */
	public int[][] getGrid() {
		return grid;
	}

	/**
	 * The method to get the level of the game
	 * 
	 * @param aLevel
	 */
	public void setLevel(int aLevel) {
		level = aLevel;
	}

	/**
	 * This method return the level
	 * 
	 * @return
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * A method to spawn a Tetromino onto the top-left-side of Playfield.
	 * 
	 * @param tetromino The Tetromino to spawn
	 */
	public void spawnTetromino(Tetromino tetromino) {
		reachBottom = false;
		int tetrominoHeight = tetromino.getBlockHeight();
		int tetrominoWidth = tetromino.getBlockWidth();

		for (int i = 0; i < tetrominoHeight; i++) {
			for (int j = 0; j < tetrominoWidth; j++) {
				if (grid[i][j] == 1) {
					gameOver = true;
					gameOver();
					break;
				}
			}
		}
		tetromino.getBlocks();
	}

	public boolean isGameOver() {
		return gameOver;
	}

	/**
	 * A method to check if a row is full of blocks.
	 * 
	 * @return True if row is full, false if not.
	 */
	public boolean isRowFull(int index) {
		for (int i = 0; i < gridWidth; i++) {
			if (grid[index][i] == 0)
				return false;
		}
		return true;
	}

	/**
	 * This method to count the full rows
	 * 
	 * @return
	 */
	public int countFullRows() {
		int fullrows = 0;
		for (int i = 0; i < gridHeight; i++) {
			if (isRowFull(i))
				fullrows++;
		}
		return fullrows;
	}

	/**
	 * This method will count player score
	 */
	public void countScore() {
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
	public void removeRow(int index) {
		for (int i = 0; i < gridWidth; i++)
			grid[index][i] = 0;

		for (int j = index; j > 0; j--) {
			for (int k = 0; k < gridWidth; k++)
				grid[j][k] = grid[j - 1][k];
		}
	}

	/**
	 * This method is used when the game is over and saves the score to the Player.
	 * 
	 * @param player the player to save the score to
	 */
	public void gameOver() {
		System.out.println("Game Over!");
		System.out.println("Score: " + score);
	}

	/**
	 * This method moves the tetromino down the grid if there is room
	 * 
	 * @param tetromino the tetromino to be moved
	 */
	public void fallingTetromino(Tetromino tetromino) {
		Boolean canMove = false;
		Block[] blocks = tetromino.getBlocks();
		for (int i = 0; i < 4; i++) {
			if (gridHeight - blocks[i].getYPosition() > 1)
				canMove = true;
			else {
				canMove = false;
				tetrominoIsFalling = false;
				break;
			}
		}
		if (canMove) {
			tetromino.moveDown();
			tetrominoIsFalling = true;
		}
	}

	/**
	 * This method returns the value of tetrominoIsFalling
	 * 
	 * @return the status of the current Tetromino
	 */
	public Boolean getFallingStatus() {
		return tetrominoIsFalling;
	}

	public void reachBottom(Tetromino tetromino) {
		Block[] blocks = tetromino.getBlocks();
		int index = tetromino.getIndexSkirt();

		for (int i = index; i >= 0; i--) {
			int x = blocks[i].getXPosition();
			int y = blocks[i].getYPosition();
			if ((gridHeight - 1 - blocks[i].getYPosition() <= 0) || (grid[y + 1][x] == 1)) {
				reachBottom = true;
				break;
			}
		}

		if (!reachBottom) {
			tetromino.moveDown();
		}

		if (reachBottom) {

			for (int j = 3; j >= 0; j--) {
				int x = blocks[j].getXPosition();
				int y = blocks[j].getYPosition();
				System.out.println(x + " , " + y);
				grid[y][x] = 1;
			}
			System.out.println("Reach bottom");

		}
	}

	public boolean getReachBottom() {
		return reachBottom;
	}

	private final int gridHeight = 20;
	private final int gridWidth = 10;
	private int[][] grid;
	private int score = 0;
	private int level;
	private Boolean tetrominoIsFalling = true; // default to true
	private Boolean reachBottom = false; // default to false
	private Boolean gameOver = false;
	Tetromino curTetromino;
	Tetromino nextTetromino;
	Player player;
}
