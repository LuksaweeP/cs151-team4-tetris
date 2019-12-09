package edu.sjsu.cs151.tetris.controller;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

import edu.sjsu.cs151.tetris.model.Model;

/**
 * Class which interact to the user with we will implements as Runnable.
 */
public class Controller implements Runnable
{
	/**
	 * The method to set the controller to the model.
	 * @param m Model object shared with TimeController
	 */
	public void setModel(Model model)
	{
		this.model = model;
	}
	
	/**
	 * The method to set the controlller to view queue
	 * @param controllerToViewQueue BlockingQueue used to sending requests to View (shared with TimeController)
	 */
	public void setControllerToViewQueue(BlockingQueue<Message> controllerToViewQueue) 
	{
		this.controllerToViewQueue = controllerToViewQueue;
	}
	
	/**
	 * The method to set the view to controller queue.
	 * @param viewToControllerQueue Blocking Queue used to receiving requests from user (View)
	 */
	public void setViewToControllerQueue(BlockingQueue<Message> viewToControllerQueue) 
	{
		this.viewToControllerQueue = viewToControllerQueue;
	}
	
	/**
	 * Overwrite run method of Runnable.
	 */
	public void run()
	{
		try 
		{
			loop();
		}
		catch (Exception exception) {}
	}
	
	/**
	 * Main controller method (mainly loop). It is responsible for rotating figures, moving them right and left and rotate them.
	 * All of this actions are done by Model methods but Controller decides what to do and when by calling Model methods.
	 */
	private void loop() throws InterruptedException
	{
		/* We create new message and send to View next figure id */
		Message message;
		message = new Message(Message.ValveResponse.CHANGE_NEXT, model.getGameRule().getNext());
		controllerToViewQueue.put(message);
		
		/* main loop */
		while(true)
		{
			message = viewToControllerQueue.take();
			
			if(message == null)
			{
				continue;
			}
					
			/* If the game is lost and user pressed enter the game is being restarted. All other messages are ignored */
			if (model.getGameRule().getLost() == true)
			{
				if(message.getValveResponse() == Message.ValveResponse.RESTART) 
					{
					
						int level = model.getGameRule().getLevel();
						model.getGameRule().restart();
						
						model.getGameRule().setLevel(level);			
						message = new Message(Message.ValveResponse.INFO_UPDATE, model.getGameRule().getScores(), model.getGameRule().getLevel());
						controllerToViewQueue.put(message);
					}
				else 
					continue;
			}
			
			else if (model.getGameRule().getWin() == true)
			{
				if(message.getValveResponse() == Message.ValveResponse.GET_NEXTLEVEL) 
					{
					
						int level = model.getGameRule().getLevel();
						model.getGameRule().restart();
						System.out.println("WIN" + model.getGameRule().getWin() );
						model.getGameRule().setLevel(level + 1);			
						message = new Message(Message.ValveResponse.INFO_UPDATE, model.getGameRule().getScores(), model.getGameRule().getLevel());
						controllerToViewQueue.put(message);
					}
				else 
					continue;
			}
			
			switch (message.getValveResponse())
			{
			
			case GET_NEWGAME:
					model.getGameRule().restart();
					message = new Message(Message.ValveResponse.SCORES_UPDATE, model.getGameRule().getScores());
					System.out.println(model.getGameRule().getScores());
					message = new Message(Message.ValveResponse.LEVEL_UPDATE, model.getGameRule().getLevel());
					System.out.println(model.getGameRule().getLevel());
					message = new Message(Message.ValveResponse.REDRAW, model.getGameRule().getData());
					controllerToViewQueue.put(message);
					break;
				
			case MOVE_LEFT:
				if(model.getGameRule().isLeftEnable()) 
				{
					model.getGameRule().moveLeft();
					message = new Message(Message.ValveResponse.REDRAW, model.getGameRule().getData());
					controllerToViewQueue.put(message);
				}
				break;
				
			case MOVE_RIGHT:
				if(model.getGameRule().isRightEnable())
				{
					model.getGameRule().moveRight();
					message = new Message(Message.ValveResponse.REDRAW, model.getGameRule().getData());
					controllerToViewQueue.put(message);
				}
				break;
				
			case ROTATE_LEFT:
				if(!model.getGameRule().isLeftRotationEnable()) 
					break;	
				model.getGameRule().rotateLeft();
				message = new Message(Message.ValveResponse.REDRAW, model.getGameRule().getData());
				controllerToViewQueue.put(message);
				break;
				
			case ROTATE_RIGHT:
				if(!model.getGameRule().isRightRotationEnable()) 
					break;
				model.getGameRule().rotateRight();
				message = new Message(Message.ValveResponse.REDRAW, model.getGameRule().getData());
				controllerToViewQueue.put(message);
				break;
				
				/* Faster figure's falling is dropping it one lvl down while space bar is pressed */
			case FASTER:
				if(model.getGameRule().isFallEnable()) 
					model.getGameRule().moveDown();
					/* Checking if the game is not lost */
					else if(model.getGameRule().isOver() && !model.getGameRule().getLost())
					{
						System.out.println("GAME OVER");
						model.getGameRule().setGetLost(true);
						message = new Message(Message.ValveResponse.LOST, model.getGameRule().getScores(), model.getGameRule().getLevel());
						controllerToViewQueue.put(message);
					}
						else 
						{   
							model.getGameRule().figureCopy();
							model.getGameRule().newFigure();
							/* If there were any full lines we send to View new scores amount */
							if(model.getGameRule().removeFullLines())
							{
								message = new Message(Message.ValveResponse.SCORES_UPDATE, model.getGameRule().getScores());
								controllerToViewQueue.put(message);
								System.out.println("Get Score");
								//message = new Message(Message.ValveResponse.LEVEL_UPDATE, model.getGameRule().getLevel());
								//controllerToViewQueue.put(message);
								//System.out.println(model.getGameRule().getLevel());
							}
							message = new Message(Message.ValveResponse.CHANGE_NEXT, model.getGameRule().getNext());
							controllerToViewQueue.put(message);
						}
				
				message = new Message(Message.ValveResponse.REDRAW, model.getGameRule().getData());
				controllerToViewQueue.put(message);
				break;
				
			default:
				break;
			}
		}
	}
	public void mainLoop() throws Exception 
	{
		Valve.ValveResponse response = Valve.ValveResponse.EXECUTED;
	    Message message = null;
	    while (response != Valve.ValveResponse.FINISH) 
	    {
	      try {
	        message = this.controllerToViewQueue.take();
	      } catch (InterruptedException e) 
	      {
	        e.printStackTrace();
	      } 
	    }
	}
	
	private Model model;
	
	private BlockingQueue <Message> controllerToViewQueue;
	private BlockingQueue <Message> viewToControllerQueue;
	private ArrayList<Valve> valves = new ArrayList<>();
	
}


