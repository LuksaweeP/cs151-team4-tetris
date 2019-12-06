package edu.sjsu.cs151.tetris.model;

import java.util.ArrayList;

/**
 * The class that wrap all the model information that will use in the controller.
 * @author Luksawee
 *
 */
public class Model 
{
	/**
	 * The construction
	 */
	public Model()
	{
		player = new Player();
		block = new Block();
		tetromino = new Tetromino();
		leaderboard = new Leaderboard();
		gameRule = new GameRule();
	}
	
	/**
	 * The method to get the player.
	 * @return player
	 */
	public Player getPlayer()
	{	
		return player;
	}
	
	/**
	 * The method to get the block.
	 * @return block
	 */
	public Block getBlock()
	{
		return block;
	}
	
	/**
	 * The method to get tetromino.
	 * @return tetromino
	 */
	public Tetromino getTetromino()
	{
		return tetromino;
	}
	
	/**
	 * The method to get the leaderboard
	 * @return leaderboard
	 */
	public Leaderboard getLeaderboard()
	{
		return leaderboard;
	}
	
	/**
	 * The method to set the start.
	 * @param start
	 */
	public void setStarted(boolean start)
	{
		this.start = start;
	}
	
	/**
	 * The method to set start new game.
	 * @return
	 */
	public boolean isStarted()
	{
		return start;
	}
	
	/**
	 * The method to get the GameRule
	 * @return gameRule
	 */
	public GameRule getGameRule()
	{
		return gameRule;
	}
	
	private Player player;
	private Block block;
	private Tetromino tetromino;
	private Leaderboard leaderboard;
	private boolean start = false;
	private boolean gameOver = false;
	private boolean gameWin = false;
	private GameRule gameRule;
}
