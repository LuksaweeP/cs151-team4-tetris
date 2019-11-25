package edu.sjsu.cs151.tetris.model;

public class Model 
{
	public Model()
	{
		playfield = new Playfield();
		leaderboard = new Leaderboard();
		player = new Player();
		curTetromino = new Tetromino();
		nextTetromino = new Tetromino();;
	}
	
	public Playfield getPlayfield()
	{
		return playfield;
	}
	
	public Leaderboard getLeaderboard()
	{
		return leaderboard;
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
	public Tetromino getCurTetromino()
	{
		return curTetromino;
	}
	
	public Tetromino getNextTetromino()
	{
		return nextTetromino;
	}
	
	public boolean isStarted()
	{
		return roundStarted;
	}
	
	public boolean isOver()
	{
		return roundOver;
	}
	
	private Playfield playfield;
	private Leaderboard leaderboard;
	private Player player;
	private Tetromino curTetromino;
	private Tetromino nextTetromino;
	boolean roundStarted = false;
	boolean roundOver = false;
}

