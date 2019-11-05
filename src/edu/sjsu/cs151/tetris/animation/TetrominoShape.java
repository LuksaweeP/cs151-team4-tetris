package edu.sjsu.cs151.tetris.animation;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class TetrominoShape implements MoveableShape
{
	   /**
	      Constructs a car item.
	      @param x the left of the bounding rectangle
	      @param y the top of the bounding rectangle
	      @param width the width of the bounding rectangle
	   */
	   public TetrominoShape(int x, int y, int width)
	   {
	      this.x = x;
	      this.y = y;
	      this.width = width;
	   }

	   public void translate(int dx, int dy)
	   {
	      x += dx;
	      y += dy;
	   }
	   
	   public void moveUp(int dx, int dy) {
			x -= dx;
			y -= dy;
		}

	   public void draw(Graphics2D g2)
	   {
		   // (double x, double y, double w, double h)
		   // Z Shape
	      Rectangle2D.Double block1
	            = new Rectangle2D.Double(x, y , width / 4, width / 4);
	      Rectangle2D.Double block2
	            = new Rectangle2D.Double(x + (width / 4), y, width / 4, width / 4);
	      Rectangle2D.Double block3
	            = new Rectangle2D.Double(x + (width / 4), y + (width / 4), width / 4, width / 4);
	      Rectangle2D.Double block4
          		= new Rectangle2D.Double(x + 2*(width / 4), y + (width / 4), width / 4, width / 4);
	      
	      g2.setColor(Color.red);
	      g2.fill(block1);
	      g2.fill(block2);
	      g2.fill(block3);
	      g2.fill(block4);
	      g2.setColor(Color.black);
	      g2.draw(block1);
	      g2.draw(block2);
	      g2.draw(block3);
	      g2.draw(block4);
	   }
	   
	   private int x;
	   private int y;
	   private int width;
}
