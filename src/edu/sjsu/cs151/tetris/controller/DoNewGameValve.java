package edu.sjsu.cs151.tetris.controller;

import com.sun.xml.internal.ws.api.message.Message;

public class DoNewGameValve implements Valve
{
	public ValveResponse execute(Message message)
	{
		if(Message.getClass() != NewGameMessage.class)
			return ValveResponse.MISS;
		
			
			return ValveResponse.EXECUTED;
	}
}
