package edu.sjsu.cs151.tetris.controller;

import java.util.concurrent.BlockingQueue;

import com.sun.xml.internal.ws.api.message.Message;

import edu.sjsu.cs151.tetris.model.Model;
import edu.sjsu.cs151.tetris.view.View;

public class Controller 
{
	public Controller(View view, Model model, BlockingQueue<Message> queue)
	{
		this.view = view;
		this.model = model;
		this.queue = queue;
	}
	
	public static void mainLoop()
	{
		
	}
	
	public static void updateGameInfo()
	{
		
	}
	
	private static View view;
	private static Model model;
	BlockingQueue<Message> queue;
	
}

