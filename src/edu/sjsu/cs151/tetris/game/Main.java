package edu.sjsu.cs151.tetris.game;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import edu.sjsu.cs151.tetris.controller.Controller;
import edu.sjsu.cs151.tetris.controller.Message;
import edu.sjsu.cs151.tetris.controller.TimeController;
import edu.sjsu.cs151.tetris.model.Model;
import edu.sjsu.cs151.tetris.view.View;

public class Main {

	private View view;
	private Model model;
	private Controller controller;
	private TimeController tController;

	private Thread controllerThread;
	private Thread viewThread;
	private Thread tControllerThread;

	/* Creating BlockongQueues */
	private BlockingQueue<Message> controllerToViewQueue = new LinkedBlockingQueue<Message>();
	private BlockingQueue<Message> viewToControllerQueue = new LinkedBlockingQueue<Message>();

	public Main() {
		/* Creating MVC (with 2 controllers) */
		model = new Model();
		view = new View();
		controller = new Controller();
		tController = new TimeController();

		/* Passing BlockingQueues and model to Controller */
		controller.setModel(model);
		controller.setControllerToViewQueue(controllerToViewQueue);
		controller.setViewToControllerQueue(viewToControllerQueue);

		/*
		 * TimeController does not need viewToController BlockingQueue because it does
		 * not interact with user
		 */
		tController.setModel(model, view);
		tController.setControllerToViewQueue(controllerToViewQueue);

		/*
		 * View does not need Model (data) because all it needs it receives from
		 * messages
		 */
		view.setControllerToViewQueue(controllerToViewQueue);
		view.setViewToControllerQueue(viewToControllerQueue);

		/* Creating and running threads */
		controllerThread = new Thread(controller);
		viewThread = new Thread(view);
		tControllerThread = new Thread(tController);
		controllerThread.start();
		viewThread.start();
		tControllerThread.start();
	}
}
