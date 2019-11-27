package edu.sjsu.cs151.tetris.model;

import java.util.ArrayList;

public class Model 
{
	public Model()
	{
		player = new Player();
		block = new Block();
		tetromino = new Tetromino();
		leaderboard = new Leaderboard();
		playfield = new Playfield();
	}
	
	public Player getPlayer()
	{	
		return player;
	}
	
	public Block getBlock()
	{
		return block;
	}
	
	public Tetromino getTetromino()
	{
		return tetromino;
	}
	
	public Leaderboard getLeaderboard()
	{
		return leaderboard;
	}
	
	public Playfield getPlayfield()
	{
		return playfield;
	}
	
	
	private Player player;
	private Block block;
	private Tetromino tetromino;
	private Leaderboard leaderboard;
	private Playfield playfield;
}
