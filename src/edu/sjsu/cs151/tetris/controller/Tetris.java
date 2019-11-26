package edu.sjsu.cs151.tetris.controller;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A class that houses the main method for the Tetris program.
 */
public class Tetris {

	private static BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
	private static View view;
	private static Model model;

	/**
	 * The Main Method for Tetris.
	 * 
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		view = view.init();
		model = new Model();

		Controller game = new Controller(view, model, queue);
		game.mainLoop();
		view.dispose();
		queue.clear();

	}

}
