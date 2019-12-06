package edu.sjsu.cs151.tetris.controller;

import edu.sjsu.cs151.tetris.model.Model;

/**
 * The class that wrap up all the model
 */
public class GameInfo 
{
	/**
	 * The construction of GameInfo
	 */
	public GameInfo()
	{
		this.model = new Model();
	}
	
	/**
	 * The method to get the model
	 * @return model
	 */
	public Model getModel()
	{
		return model;
	}
	
	Model model;
}
