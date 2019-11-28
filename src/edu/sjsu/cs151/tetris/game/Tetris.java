package edu.sjsu.cs151.tetris.game;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.sun.xml.internal.ws.api.message.Message;

import edu.sjsu.cs151.tetris.controller.Controller;
import edu.sjsu.cs151.tetris.model.Model;
import edu.sjsu.cs151.tetris.model.Playfield;
import edu.sjsu.cs151.tetris.view.View;


/**
A class that houses the main method for the Tetris program.
 */
public class Tetris 
{
	
	//private static BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
	private static View view;
	private static Playfield playfield;
	
	/**
	The Main Method for Tetris.
	@param args Unused.  
	 */
	public static void main(String[] args) 
	{
		//view = View.init(queue);
		//playfield = new Playfield();
		
		//Controller game = new Controller(view, playfield, queue);
		////game.mainLoop();
		//view.dispose();
		//queue.clear();
		

			View view = new View();
			Model model = new Model();
			Controller controller = new Controller(view, model);
			controller.updateGameInfo();

	}

}
