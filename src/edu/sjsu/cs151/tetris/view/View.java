package edu.sjsu.cs151.tetris.view;

import java.util.concurrent.BlockingQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.sjsu.cs151.tetris.controller.Message;

public class View implements Runnable
{
	public View()
	{
		new WelcomePanel();
		
	}
	
	public void init() throws InterruptedException
	{
		Message message;
		while(true)
		{
			/* At the begin we check the request queue */
			message = controllerToViewQueue.take();
			if(message == null)
				continue;
			switch(message.getType())
			{
			case REDRAW:	
					redraw(message.getData());
					break;
			case CHANGE_NEXT: 
					panel.setNext(message.getAdd());
					break;
			case SCORES_UPDATE:
					panel.setScores(message.getAdd());
					break;
			case LOOSE:
					loose = true;
					panel.setLoose(loose);
					panel.redraw();
					break;
			default: 
					break;
			}
	{
		
	}
	
	public void change()
	{
		
	}
	
	public void addMessage()
	{
		
	}
	
	public void dispose()
	{
		
	}
	
	public void run()
	{
		try 
		{
			init();
		}
		catch (Exception exception) {}
	}
	
	//static BlockingQueue<Message> queue;
	View view;
	private JFrame frame;

}

