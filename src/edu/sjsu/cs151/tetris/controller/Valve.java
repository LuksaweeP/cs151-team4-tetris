package edu.sjsu.cs151.tetris.controller;

import com.sun.xml.internal.ws.api.message.Message;

public interface Valve 
{
	public ValveResponse execute(Message message);
}
