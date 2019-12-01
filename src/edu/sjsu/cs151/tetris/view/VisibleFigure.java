package edu.sjsu.cs151.tetris.view;

import java.awt.Color;

/**
 * The class to determine color and shape of each figure that will show to a player.
 */

public class VisibleFigure {
	public static final Color[][][] FiguresList = 
		{
				
				{	//empty-shape
					{Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY},
					{Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY},
					{Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY},
					{Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY}
				},
				
				{	//J - shape
					{Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY},
					{Color.BLUE, Color.BLUE, Color.BLUE, Color.GRAY},
					{Color.GRAY, Color.GRAY, Color.BLUE, Color.GRAY},
					{Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY}
				},
				
				{	//Z - shape
					{Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY},
					{Color.RED, Color.RED, Color.GRAY, Color.GRAY},
					{Color.GRAY, Color.RED, Color.RED, Color.GRAY},
					{Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY}
				},
				
				{	//L - shape
					{Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY},
					{Color.GRAY, Color.GRAY, Color.ORANGE, Color.GRAY},
					{Color.ORANGE, Color.ORANGE, Color.ORANGE, Color.GRAY},
					{Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY}
				},
				
				{	//S - shape
					{Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY},
					{Color.GRAY, Color.GRAY, Color.GREEN, Color.GREEN},
					{Color.GRAY, Color.GREEN, Color.GREEN, Color.GRAY},
					{Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY}
				},
				
				{	//I - shape
					{Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY},
					{Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY},
					{Color.CYAN, Color.CYAN, Color.CYAN, Color.CYAN},
					{Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY}
				},
				
				{	//O - shape
					{Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY},
					{Color.GRAY, Color.YELLOW, Color.YELLOW, Color.GRAY},
					{Color.GRAY, Color.YELLOW, Color.YELLOW, Color.GRAY},
					{Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY}
				},
				
				{	//T - shape
					{Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY},
					{Color.GRAY, Color.PINK, Color.GRAY, Color.GRAY},
					{Color.PINK, Color.PINK, Color.PINK, Color.GRAY},
					{Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY}
				}
		};
}