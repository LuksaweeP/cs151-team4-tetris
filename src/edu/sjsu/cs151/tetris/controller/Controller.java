package edu.sjsu.cs151.tetris.controller;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

import edu.sjsu.cs151.tetris.model.Model;
import edu.sjsu.cs151.tetris.view.View;


public class Controller implements Runnable
{
	public Controller(View view, Model model, BlockingQueue<Message> queue)
	{
		this.view = view;
		this.model = model;
		this.queue = queue;
	}
	
	public static void mainLoop() throws Exception
	{
		
			
		
	}
	
	public static void updateGameInfo()
	{
		
	}
	
	public void run()
	{
		
	}
	
	private View view;
	private  Model model;
	static BlockingQueue<Message> queue;
	
}

