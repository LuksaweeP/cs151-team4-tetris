package edu.sjsu.cs151.tetris.controller;

public class DoNewGameValve implements Valve
{
	
	public ValveResponse excute(Message message)
	{
		if (message.getClass()) != NewGameMessage.class)
			return ValveResponse.MISS;
			
			
			return ValveResponse.EXECUTED;
}
	}
}
