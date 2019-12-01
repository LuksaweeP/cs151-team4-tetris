package edu.sjsu.cs151.tetris.controller;
import edu.sjsu.cs151.tetris.model.Model;
import edu.sjsu.cs151.tetris.view.View;

import java.util.concurrent.BlockingQueue;

public class TimeController implements Runnable
{
	private Model model;
	private View view;
	private BlockingQueue <Message> controllerToViewQueue;	
	
	/**
	 * @param m Model shared with controller.
	 */
	public void setModel(Model model, View view)
	{
		this.model = model;
		this.view = view;
	}
	
	/**
	 * @param c BlockingQueue shared with controller.
	 */
	public void setControllerToViewQueue(BlockingQueue<Message> controllerToViewQueue) 
	{
		this.controllerToViewQueue = controllerToViewQueue;
	}
	
	/**
	 * Main method of this class. It checks is it possible for falling figure to move one lvl down.
	 * If not it checks is it a loose or not, remove full lines, add points and pass it to View, random new figure,
	 * send information about falling figure and next figure to the View by BlockingQueue of Message objects. Figure drops every 0.5s.
	 */
	private void startTimer() throws InterruptedException
	{	
		Message message;
		while(true)
		{
			//continue;
			System.out.println("");
			while (view.getViewAllPanels().getInGamePanel().getGameStart() == true)
			{
				if(model.getGameRule().getLost()) 
				{
					Thread.sleep(300);
					continue;
				}

				if(model.getGameRule().isFallEnable())
				{
					model.getGameRule().moveDown();
				}
				
			
				else if(model.getGameRule().isOver())
				{
					model.getGameRule().setGetLost(true);
					message = new Message(Message.ValveResponse.LOST);
					System.out.println("TIMECONTROLLER: OVER");
					controllerToViewQueue.put(message);
				}
					else
					{
						model.getGameRule().figureCopy();
						model.getGameRule().newFigure();
						
						if(model.getGameRule().removeFullLines())
						{
							message = new Message(Message.ValveResponse.SCORES_UPDATE, model.getGameRule().getScores());
							controllerToViewQueue.put(message);
						}
						
						message = new Message(Message.ValveResponse.CHANGE_NEXT, model.getGameRule().getNext());
						controllerToViewQueue.put(message);
					}
				message = new Message(Message.ValveResponse.REDRAW, model.getGameRule().getData() );
				controllerToViewQueue.put(message);
				Thread.sleep(300);
			}
		}
	}
	
	public void run()
	{
		
			try {
				startTimer();
			} 
			catch (InterruptedException e) 
			{
				System.out.println(e);
			}
		
		
	}
}

