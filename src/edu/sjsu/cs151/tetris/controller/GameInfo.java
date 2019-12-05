package edu.sjsu.cs151.tetris.controller;

import edu.sjsu.cs151.tetris.model.Model;

public class GameInfo 
{
	public GameInfo()
	{
		this.model = new Model();
	}
	
	public Model getModel()
	{
		return model;
	}
	
	Model model;
}
