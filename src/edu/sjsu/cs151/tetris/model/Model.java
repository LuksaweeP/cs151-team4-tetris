package edu.sjsu.cs151.tetris.model;

public class Model 
{
	public Model()
	{
		newPlayfield = new Playfield();
		newLeaderboard = new Leaderboard();
		newPlayer = new Player();
		curTetromino = new Tetromino();
		nextTetromino = new Tetromino();;
	}
	
	public Playfield getPlayfield()
	{
		return newPlayfield;
	}
	
	public Leaderboard getLeaderboard()
	{
		return newLeaderboard;
	}
	
	public Player getPlayer()
	{
		return newPlayer;
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
	
	private Playfield newPlayfield;
	private Leaderboard newLeaderboard;
	private Player newPlayer;
	private Tetromino curTetromino;
	private Tetromino nextTetromino;
	boolean roundStarted = false;
	boolean roundOver = false;
}

