package edu.sjsu.cs151.tetris.controller;

import java.util.concurrent.BlockingQueue;

import edu.sjsu.cs151.tetris.model.Model;

/**
 * Class which interact to the user
 */
public class Controller implements Runnable
{
	private Model model;
	
	private BlockingQueue <Message> controllerToViewQueue;
	private BlockingQueue <Message> viewToControllerQueue;
	
	/**
	 * @param m Model object shared with TimeController
	 */
	public void setModel(Model model)
	{
		this.model = model;
	}
	
	/**
	 * @param c BlockingQueue used to sending requests to View (shared with TimeController)
	 */
	public void setControllerToViewQueue(BlockingQueue<Message> controllerToViewQueue) 
	{
		this.controllerToViewQueue = controllerToViewQueue;
	}
	
	/**
	 * @param v Blocking Queue used to receiving requests from user (View)
	 */
	public void setViewToControllerQueue(BlockingQueue<Message> viewToControllerQueue) 
	{
		this.viewToControllerQueue = viewToControllerQueue;
	}
	
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
			if(model.getGameRule().getLost() == true)
			{
				if(message.getValveResponse() == Message.ValveResponse.RESTART) 
					{
						model.getGameRule().restart();
						message = new Message(Message.ValveResponse.SCORES_UPDATE, model.getGameRule().getScores());
						controllerToViewQueue.put(message);
					}
				else 
					continue;
			}
			
			
			switch (message.getValveResponse())
			{
				
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
						message = new Message(Message.ValveResponse.LOST);
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
}


