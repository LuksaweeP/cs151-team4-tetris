package edu.sjsu.cs151.tetris.animation;
import edu.sjsu.cs151.tetris.model.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public class DrawTetromino implements MoveableShape {

	/**
	 * Constructs a car item.
	 * 
	 * @param x     the left of the bounding rectangle
	 * @param y     the top of the bounding rectangle
	 * @param width the width of the bounding rectangle
	 */
	public DrawTetromino(char shape, int width) {
		this.shape = shape;
		this.width = width;
	}

	public void translate(int dx, int dy) {
		x += dx;
		y += dy;
	}

	public void draw(Graphics2D g2) {
		 tetromino.setShape(shape);
		 tetromino.setBlocks();
		 blocks = tetromino.getBlocks();
		 Rectangle2D.Double [] zBlock = new Rectangle2D.Double[4];
		 
		 // (double x, double y, double w, double h)
		// Z Shape
		 
		for (int i = 0; i < 4; i++)
		{
			x = blocks[i].getXPosition();
			y = blocks[i].getYPosition();
			zBlock[i] = new Rectangle2D.Double((x * width / 4), (y * width / 4) , width / 4, width / 4);
			
			if(shape == 'Z')
				g2.setColor(Color.pink);
				
			if(shape == 'I')
				g2.setColor(Color.blue);
			
			if(shape == 'O')
				g2.setColor(Color.yellow);
			
			if(shape == 'L')
				g2.setColor(Color.red);
			
			if(shape == 'T')
				g2.setColor(Color.gray);
			
			if(shape == 'J')
				g2.setColor(Color.green);
			
			g2.fill(zBlock[i]);
			g2.setColor(Color.black);
			g2.draw(zBlock[i]);
			
		}
	 }

	private int x;
	private int y;
	private char shape;
	private int width;
	Block [] blocks = new Block[4];
	Tetromino tetromino = new Tetromino();
}

