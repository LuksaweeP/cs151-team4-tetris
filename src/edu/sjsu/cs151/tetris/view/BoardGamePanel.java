package edu.sjsu.cs151.tetris.view;

import java.awt.*;
import javax.swing.*;

/**
 * BoardGamePanel is the 2 dimension array of data to show the tetromino to the user.
 */
public class BoardGamePanel extends JPanel
{
	public BoardGamePanel(Color[][] colors)
	{
		this.colors = colors;
	}
	
	/**
	 * If true it means that the game the player lost.
	 */
	public void setLost(boolean lost)
	{
		this.lost = lost;
	}
	
	/**
	 * @param scores points amount player have in current moment.
	 */
	public void setScores(int scores)
	{
		this.scores = scores;
	}
	
	/**
	 * @param next ID of the next figure which will fall (figure which should be shown on the right panel.
	 */
	public void setNext(int next)
	{
		nextShape = next;
	}
	
	/**
	 * This method is used to simply redraw full interface of the game. All we need is colors array (when we want to redraw board 
	 * with falling object). 
	 */
	public void redraw (Color[][] colors)
	{
		this.colors = colors;
		repaint();
	}
	
	/**
	 * Second redraw method used to redraw interface when game over, and it will not change the boardgamePanel
	 */
	public void redraw()
	{
		repaint();
	}
	
	/**
	 * First we paint all board on the dark gray color. Next we draw all the main board squares using colors double array. 
	 * Next using NextFigures we draw figure that will be next and the last one is to show scores. If the game is over it shows 
	 * this string on the board.
	 */
	public void paintComponent(Graphics g)
	{
		//mainboard
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 400, 800);
		
		
		g.setColor(new Color(176, 196, 222));
		g.fillRect(0, 801, 401, 890);
		
		g.setColor(new Color(176, 196, 222));
		g.fillRect(401, 0, 200, 890);
		
		//this playfield panel
		for(int i=0; i < 20; ++i)
			for(int j=0; j <10; ++j)
			{
				g.setColor(colors[i][j]);
				g.fillRect(40*j, 40*i, 38, 38);
			}
		
		// next testromino
		for(int i = 0; i < 4; ++i)
			for(int j=0; j<4; ++j)
			{
				g.setColor(VisibleFigure.FiguresList[nextShape][i][j]);
				g.fillRect(451 + 25*j, 401 + 25*i, 23, 23);
			}
		
		g.setColor(Color.BLACK);
		g.setFont(font);
		g.drawString("Name: " + name , 415, 50);
		g.drawString("Level: " + level, 415, 75);
		g.drawString("Score: " + scores, 415, 100);
		
		g.setColor(Color.BLACK);
		g.setFont(font);
		g.drawString("esc       PAUSE" , 415, 650);
		g.drawString("<-        Move Left" , 415, 675);
		g.drawString("<-        Move Right" , 415, 700);
		g.drawString("z          Rotate" , 415, 725);
		g.drawString("space   Drop Faster" , 415, 750);
		

		if(lost)
		{
			g.setColor(Color.WHITE);
			g.setFont(font1);
			g.drawString("GAME OVER", 50, 300);
			g.setFont(font);
			g.drawString("(Press ENTER to play again)", 70, 350);
		}
		
		if(winLevel)
		{
			g.setColor(Color.WHITE);
			g.setFont(font1);
			g.drawString("GAME WIN", 90, 300);
			g.setFont(font);
			g.drawString("(Press ENTER to play next Level)", 70, 350);
		}
	}
	
	public void setPlayerName(String name)
	{
		this.name = name;
	}
	
	public void setLevel(int level)
	{
		this.level = level;
	}
	
	public int getScore()
	{
		return scores;
	}
	
	public void setWinLevel(boolean winLevel)
	{
		this.winLevel = winLevel;
	}
	

	
	private static final long serialVersionUID = -8715353373678321308L;
	private Color [][] colors;
	private int nextShape;
	private String name;
	private int scores;
	private int level;
	private boolean lost = false;
	private Font font = new Font("Dialog", Font.BOLD, 18);
	private Font font1 = new Font("Dialog", Font.BOLD, 50);
	private boolean winLevel = false;
	
}

