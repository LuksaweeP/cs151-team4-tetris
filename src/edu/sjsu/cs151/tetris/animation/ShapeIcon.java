package edu.sjsu.cs151.tetris.animation;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * An icon that contains a moveable shape.
 * @author Nick
 * @author Luksawee
 */
public class ShapeIcon implements Icon
{
	/**
	 * ShapeIcon constructor
	 * @param shape the desired shape
	 * @param width the icon width
	 * @param height the icon height
	 */
	public ShapeIcon(MoveableShape shape, int width, int height)
	{
		this.shape = shape;
		this.width = width;
		this.height = height;
	}

	/**
	 * Returns the Icon width
	 * @return width the icon width
	 */
	public int getIconWidth()
	{
		return width;
	}

	/**
	 * Returns the Icon height
	 * @return height the icon height
	 */
	public int getIconHeight()
	{
		return height;
	}

	/**
	 * Method to paint the icon with the desired shape
	 * @param c the component
	 * @param g the graphics context
	 * @param x the x value
	 * @param y the y value
	 */
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D) g;
		shape.draw(g2);
	}

	private int width;
	private int height;
	private MoveableShape shape;
}


