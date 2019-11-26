package edu.sjsu.cs151.tetris.controller;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.sun.xml.internal.ws.api.message.Message;

import edu.sjsu.cs151.tetris.model.Playfield;
import edu.sjsu.cs151.tetris.view.View;


public class Controller implements Runnable
{
	public Controller(View view, Playfield playfield, LinkedBlockingQueue<Message> queue)
	{
		this.view = view;
		this.playfield = playfield;
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
	private Playfield playfield;
	static LinkedBlockingQueue<Message> queue;
	
}

