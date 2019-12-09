package edu.sjsu.cs151.tetris.controller;

public interface Valve 
{
	public ValveResponse excute(Message message);

	public enum ValveResponse 
	{
	MISS,
	EXECUTED,
	FINISH;
	}
}