package edu.sjsu.cs151.tetris.model;

import java.util.Random;
import java.awt.Point;

/**
 * A class for creating a play field with a 2D grid of size height x width that
 * can spawn in Tetrominos, and award points to the player when necessary. 
 * The default playfield is (Height x Width) = 20 x 10. 
 * THis class also contains all game rule
 */
public class GameRule 
{
	private int [][] board;	
	private int [][] boardToPlayer = new int [20][10];
	private int fShape;  /*to get the index of the figure*/
	private int fRotation;  /*0, 1, 2, 3 which will determine the position of each figure after move*/
	private Block fPosition;  /*to record the first block of figure when it will drop in the board*/
	private int nextFigure;
	private int scores; /*player's score*/
	/**
	 * Information if the game is lost. True means game is over.
	 */
	public boolean lost;
	SingleRandom rand = SingleRandom.getInstance();
	
	public GameRule()
	{
		restart();
	}
	
	/**
	 * This method will prepare all data for the new figure.
	 */
	public void restart()
	{
		/*specify board to have size 20 x 10*/
		board = new int [20][10];
		for (int i = 0; i < 20; ++i)
			for(int j = 0; j < 10; ++j)
				board[i][j] = 0;
		
	
		fShape = rand.nextInt(7); /*we have 7 type of the figure*/
		fRotation = 0; /*we will start from the first index in the Figure*/
		fPosition = new Block(4, 0);  /*keep the first position of the 1 block of the tetronimo to make it show in the middle of the board*/
		nextFigure = rand.nextInt(7);
		scores = 0;
		lost = false;
	}
	
	/**
	 * This method change current figure ID to next figure id, random new figure and set falling figure coordinates.
	 */
	public void newFigure()
	{
		fPosition.setXPosition(4);
		fPosition.setYPosition(0);
		fShape = nextFigure;
		nextFigure = rand.nextInt(7);
	}
		
	/**
	 * @return next figure id
	 */
	public int getNext()
	{
		return nextFigure;
	}
	
	/**
	 * @return scores
	 */
	public int getScores()
	{
		return scores;
	}
	
	/**
	 * This method checks is it possible for the figure to drop one 1 block down?
	 * @return true if it is possible, false if it is not.
	 */
	public boolean isFallEnable()
	{
		for(int i = 0; i < 4; ++i)
		{
			/* We check every block of falling figure if it will not be under the board in Y position */
			if(fPosition.getYPosition() + Figure.FiguresList[fShape][fRotation][i].getYPosition() >= 21)
				return false;
			
			/* We check the collision of every figure's block */
			if(board[fPosition.getYPosition() + Figure.FiguresList[fShape][fRotation][i].getYPosition()][fPosition.getXPosition() + Figure.FiguresList[fShape][fRotation][i].getXPosition()] != 0)
				return false;
		}
		return true;
	}
	
	/**
	 * Method which checks if the figure is possible to move left
	 * @return true if it is possible, false if it is not.
	 */
	public boolean isLeftEnable()
	{
		for(int i=0; i<4; ++i)
		{
			/* Checking if the figure is on the leftest side*/
			if(fPosition.getXPosition() + Figure.FiguresList[fShape][fRotation][i].getXPosition() <= 0 ) 
				return false;
			
			/* Checking collision for every figure's block */
			if(board[fPosition.getYPosition() + Figure.FiguresList[fShape][fRotation][i].getYPosition()][fPosition.getXPosition() + Figure.FiguresList[fShape][fRotation][i].getXPosition() - 1] != 0)
				return false;
		}
		return true;
	}
	
	/**
	 * Method which checks if the figure is possible to move right the falling figure.
	 * @return true if it is possible, false if it is not.
	 */
	public boolean isRightEnable()
	{
		for(int i=0; i<4; ++i)
		{
			/* Checking if the figure is on the rightest side*/
			if(fPosition.getXPosition() + Figure.FiguresList[fShape][fRotation][i].getXPosition() >=9 ) 
				return false;
			
			/* Checking collision for every figure's block */
			if(board[fPosition.getYPosition() + Figure.FiguresList[fShape][fRotation][i].getYPosition()][fPosition.getXPosition() + Figure.FiguresList[fShape][fRotation][i].getXPosition() + 1] != 0)
				return false;
		}
		return true;
	}
	
	
	
	/**
	 * Method that checks if the figure is possible to rotate right the falling figure.
	 * @return true if it is possible, false if it is not.
	 */
	public boolean isRightRotationEnable()
	{
		int nextPos = fRotation - 1;
		if(nextPos < 0) 
			nextPos = 3;
		
		for(int i=0; i < 4; ++i)
		{
			/* Checking if the figure can rotate or not */
			if(fPosition.getXPosition() + Figure.FiguresList[fShape][nextPos][i].getYPosition() > 9)
				return false;
			
			/* Checking collision for every figure's block */
			if(board[fPosition.getYPosition() + Figure.FiguresList[fShape][nextPos][i].getYPosition()][fPosition.getXPosition() + Figure.FiguresList[fShape][nextPos][i].getXPosition()] != 0)
				return false;
		
				
		}
		return true;
	}
	
	/**
	 * Method that checks if the figure is possible to rotate left the falling figure.
	 * @return true if it is possible, false if it is not.
	 */
	public boolean isLeftRotationEnable()
	{
		int nextPos = (fRotation + 1) % 4;
		
		for(int i = 0; i < 4; ++i)
		{
			/* Checking if the figure can rotate or not */
			if(fPosition.getXPosition() + Figure.FiguresList[fShape][nextPos][i].getXPosition() > 9)
				return false;
			/* Checking collision for every figure's block */
			if(board[fPosition.getYPosition() + Figure.FiguresList[fShape][nextPos][i].getYPosition()][fPosition.getXPosition() + Figure.FiguresList[fShape][nextPos][i].getXPosition()] != 0) 
				return false;
		}
		return true;
	}
	
	/**
	 * Move left falling figure (change figure's position)
	 */
	public void moveLeft()
	{
		int currPos = fPosition.getXPosition();
		fPosition.setXPosition(currPos - 1);
	}
	
	/**
	 * Move left falling figure (change figure's position)
	 */
	public void moveRight()
	{
		int currPos = fPosition.getXPosition();
		fPosition.setXPosition(currPos + 1);
	}
	
	/**
	 * Move left falling figure (change figure's position)
	 */
	public void moveDown()
	{
		int currPos = fPosition.getYPosition();
		fPosition.setYPosition(currPos + 1);
	}
	
	/**
	 * Method changes rotation number to greater one. If it is 4 it is changed to 0.
	 */
	public void rotateRight()
	{
		fRotation = (fRotation + 1) % 4;
	}
	
	/**
	 * Method changes rotation number to lower one. If it is lower than 0 it is changed to 3.
	 */
	public void rotateLeft()
	{
		if(fRotation==0) 
			fRotation = 3;
		
		else 
			fRotation = fRotation - 1;
	}
	
	/**
	 * Method to check the line is getting full or not?
	 * If the line is full, we remove that line and out, and move the top line down.
	 * We also add point when we remove the line.
	 * @return Amount of full lines detected. 
	 */
	public boolean removeFullLines()
	{
		boolean isLineFull = true;
		int lines = 0;
		int tmp = 10;
		
		/* Checking all rows starting from the top */
		for(int i = 2; i < 22; ++i)
		{
			/* If it detects empty block line is not full so change isLineFull to false and break */
			for (int j = 0; j < 10; ++j)
			{
				
				if(board[i][j]==0) 
				{
					isLineFull = false;
					break;
				}
			}
			/* If it wasn't a full line we check next one */
			if(isLineFull==false) 
			{
				isLineFull=true; 
				continue;
			}
			
			/* Move everything (except falling figure) */
			++lines;
			for(int j = 0; j < 10; ++j)
				for(int k = i; k >= 2; --k)
				{
					board[k][j]=board[k-1][j];
				}
		}
		/* We simply calculate amount of points */
		for (int i=0; i<lines; ++i)
		{
			scores += tmp;
			tmp *= 2;
		}
		
		if(lines!=0) 
			return true;
		
		return false;
	}
	
	/**
	 * Method checks if the game is lost (is any figure's block on forbidden place).
	 * @return true if game is lost, false if it is not.
	 */
	public boolean isOver()
	{
		for(int i = 0; i < 4; ++i)
			if(fPosition.getYPosition() + Figure.FiguresList[fShape][fRotation][i].getYPosition() < 2)
				return true;
		
		return false;
	}

	/**
	 * After the figure fell down to the bottom, we copy every figure.
	 */
	public void figureCopy()
	{
		for(int i=0; i<4; ++i)
			board[fPosition.getYPosition() + Figure.FiguresList[fShape][fRotation][i].getYPosition()][fPosition.getXPosition() + Figure.FiguresList[fShape][fRotation][i].getXPosition()] = fShape;
	}
	
	/**
	 * @return Two dimensional array with all data.
	 */
	public int [][] getData()
	{
		
		/* Copying main array of data (only the part which is visible on the board) */
		for(int i = 0; i < 20; ++i)
			for(int j = 0; j < 10; ++j)
			{
				boardToPlayer[i][j] = board[i+2][j];
			}
		/* Copying the falling figure */
		for(int i=0; i < 4; ++i)
			if(fPosition.getYPosition() + Figure.FiguresList[fShape][fRotation][i].getYPosition() >= 2)
				boardToPlayer[fPosition.getYPosition() + Figure.FiguresList[fShape][fRotation][i].getYPosition() - 2][fPosition.getXPosition() + Figure.FiguresList[fShape][fRotation][i].getXPosition()] = fShape;
			
		return boardToPlayer;
	}
}
