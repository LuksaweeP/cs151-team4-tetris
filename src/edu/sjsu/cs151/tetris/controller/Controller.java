package edu.sjsu.cs151.tetris.controller;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

import com.sun.xml.internal.ws.api.message.Message;

public class Controller 
{
	public Controller(View view, Model model, BlockingQueue<Message> queue)
	{
		this.view = view;
		this.model = model;
		this.queue = queue;
	}
	
	public static void mainLoop() throws Exception
	{
		ValveResponse response = ValveResponse.EXECUTED;
		Message message = null;
		while (response != ValveResponse.FINISH)
		{
			try
			{
				message = (Message)messageQueue.take();
			}
			
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			
			for(Valve valve : valves)
			{
				response = valve.execute(message);
				if (response != ValveResponse.MISS)
					break;
			}
		}
	}
	
	public static void updateGameInfo()
	{
		
	}
	
	private static View view;
	private static Model model;
	static BlockingQueue<Message> queue;
	static LinkedList <Valve> valves;
	
}

