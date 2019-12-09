package edu.sjsu.cs151.tetris.animation;

import java.awt.Graphics2D;

/**
 * Interface for a moveable shape
 * @author Luksawee
 * @author Nick
 */
public interface MoveableShape
{
	/**
	 * Method to draw the shape
	 * @param g2 The graphics context
	 */
	void draw(Graphics2D g2);

	/**
	 * Moves the shape by a given amount.
	 * @param dx the amount to translate in x-direction
	 * @param dy the amount to translate in y-direction
	 */
    void translate(int dx, int dy);
    
    /**
     * Moves the shape up a given amount
     * @param dx x value
     * @param dy y value
     */
    void moveUp(int dx, int dy);
    
    /**
     * Method that returns the y value
     * @return y the y value
     */
    int getY();
}