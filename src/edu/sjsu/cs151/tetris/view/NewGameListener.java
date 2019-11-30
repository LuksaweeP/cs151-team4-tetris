package edu.sjsu.cs151.tetris.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameListener implements ActionListener
{
	public void actionPerformed (ActionEvent event)
	{
		try
		{
			queue.put(new NewGameMessage());
		}

		catch(InterruptedException exception)
		{
			exception.printStackTrace();
		}
	}
}

