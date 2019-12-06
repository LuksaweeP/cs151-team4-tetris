package edu.sjsu.cs151.tetris.controller;
import edu.sjsu.cs151.tetris.model.Model;
import edu.sjsu.cs151.tetris.view.ViewMain;

import java.util.concurrent.BlockingQueue;

/**
 * The class that will generate new figure, manage game over, and win the level which will implement as Runnable.
 * @author Luksawee
 */
public class TimeController implements Runnable
{
	/**
	 * The method to set the model, and viewMain to TimeController.
	 * @param Model shared with controller.
	 */
	public void setModel(Model model, ViewMain viewMain)
	{
		this.model = model;
		this.viewMain = viewMain;
	}
	
	/**
	 * The method to set the queue to controllerToViewQueue 
	 * @param controllerToViewQueu BlockingQueue shared with controller.
	 */
	public void setControllerToViewQueue(BlockingQueue<Message> controllerToViewQueue) 
	{
		this.controllerToViewQueue = controllerToViewQueue;
	}
	
	/**
	 * Main method of this class. It checks is it possible for falling figure to move one step down.
	 * If not it checks is it a loose or not, remove full lines, add points and pass it to View, random new figure,
	 * send information about falling figure and next figure to the View by BlockingQueue of Message objects. Figure drops every 0.5s.
	 */
	private void startTimer() throws InterruptedException
	{	
		Message message;
		while(true)
		{
			//continue;
			System.out.print("");
			while (viewMain.getViewAllPanels().getInGamePanel().getGameStart() == true)
			{
				if(model.getGameRule().getLost()) 
				{
					Thread.sleep(500);
					continue;
				}
				
				if(model.getGameRule().getWin()) 
				{
					Thread.sleep(500);
					continue;
				}

				if(model.getGameRule().isFallEnable())
				{
					model.getGameRule().moveDown();
				}
										
				else if(model.getGameRule().isOver())
				{
					model.getGameRule().setGetLost(true);
					message = new Message(Message.ValveResponse.LOST, model.getGameRule().getScores(), model.getGameRule().getLevel());
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
				
				if (model.getGameRule().isWin())
				{
					model.getGameRule().setWin(true);
					message = new Message(Message.ValveResponse.WIN, model.getGameRule().getScores(), model.getGameRule().getLevel());				
					controllerToViewQueue.put(message);
				}
				
				message = new Message(Message.ValveResponse.REDRAW, model.getGameRule().getData() );
				controllerToViewQueue.put(message);

				switch (model.getGameRule().getLevel())
				{
				case 1:
					Thread.sleep(500);
					break;
				case 2:
					Thread.sleep(400);
					break;
				case 3:
					Thread.sleep(300);
					break;
				case 4:
					Thread.sleep(250);
					break;
				case 5:
					Thread.sleep(200);
					break;
				default:
					Thread.sleep(300);
					break;
				}
			}
		}
	}
	
	/**
	 * Overwrite run()
	 */
	public void run()
	{
		try 
		{	
			startTimer();
			
		} 
			catch (InterruptedException e) 
			{
			}
	}
	
	private Model model;
	private ViewMain viewMain;
	private BlockingQueue <Message> controllerToViewQueue;	
}

