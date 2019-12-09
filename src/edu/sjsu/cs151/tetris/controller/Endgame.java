package edu.sjsu.cs151.tetris.controller;

public class Endgame implements Valve
{

	@Override
	public ValveResponse excute(Message message) {
		if( message.getValveResponse() == Message.ValveResponse.EXIT)
		return ValveResponse.FINISH;
		
		return ValveResponse.EXECUTED;
	}

}
