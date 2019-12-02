package edu.sjsu.cs151.tetris.view;

import edu.sjsu.cs151.tetris.model.*;
import edu.sjsu.cs151.tetris.animation.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class InGamePanel extends JPanel{
	public InGamePanel() {
		
		inGamePanel = new JPanel();
		inGamePanel.setSize(600, 800);
		inGamePanel.setFocusable(true);

		level = new JLabel();
		level.setFont(new Font("TimesRoman", Font.BOLD, 24));
		level.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		name = new JLabel();
		name.setFont(new Font("TimesRoman", Font.BOLD, 24));
		name.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		score = new JLabel();
		score.setFont(new Font("TimesRoman", Font.BOLD, 24));
		score.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel pause = new JLabel		("esc        PAUSE      ");
		pause.setFont(new Font("TimesRoman", Font.BOLD, 20));
		
		JLabel moveLeft = new JLabel	(" <-          Move Left  ");
		moveLeft.setFont(new Font("TimesRoman", Font.BOLD, 20));
		
		JLabel moveRight = new JLabel	("   ->          Move Right  ");
		moveRight.setFont(new Font("TimesRoman", Font.BOLD, 20));
		
		JLabel rotate = new JLabel		("z          Rotate      ");
		rotate.setFont(new Font("TimesRoman", Font.BOLD, 20));
		
		JLabel dropFaster = new JLabel	(" Space   Drop faster");
		dropFaster.setFont(new Font("TimesRoman", Font.BOLD, 20));
		
		JPanel gameInfo = new JPanel();
		gameInfo.setPreferredSize(new Dimension(200, 800));
		gameInfo.setBackground(new Color(176, 196, 222));
				
		JPanel playerPanel = new JPanel();
		playerPanel.setPreferredSize(new Dimension(200, 400));
		playerPanel.setBackground(new Color(176, 196, 222));
		playerPanel.setOpaque(true);
		playerPanel.add(name);
		playerPanel.add(level);
		playerPanel.add(score);
		
		JPanel nextTetrominoPanel = new JPanel();
		nextTetrominoPanel.setPreferredSize(new Dimension(200, 400));
		nextTetrominoPanel.setBackground(new Color(176, 196, 222));
		nextTetrominoPanel.setOpaque(true);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setPreferredSize(new Dimension(200, 200));
		controlPanel.setBackground(new Color(176, 196, 222));
		controlPanel.setOpaque(true);
		//controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
		controlPanel.add(pause);
		controlPanel.add(moveLeft);
		controlPanel.add(moveRight);
		controlPanel.add(rotate);
		controlPanel.add(dropFaster);
		
		
		gameInfo.setLayout(new BoxLayout(gameInfo, BoxLayout.Y_AXIS));
		gameInfo.add(playerPanel);
		gameInfo.add(nextTetrominoPanel);
		gameInfo.add(controlPanel);

		JPanel center = new JPanel();
		center.setPreferredSize(new Dimension(400, 800));
		center.setBackground(new Color(0, 0, 0));
		center.setOpaque(true);
		
		colors = new Color[20][10];
		for(int i = 0; i< 20 ; ++i)
			for(int j = 0; j<10; ++j)
				colors[i][j] = Color.DARK_GRAY;
		
		boardGamePanel = new BoardGamePanel(colors);
		boardGamePanel.setPreferredSize(new Dimension(400, 800));
		boardGamePanel.setVerifyInputWhenFocusTarget(true);
		boardGamePanel.setVisible(true);
		
		inGamePanel.setLayout(new BorderLayout());
		inGamePanel.add(boardGamePanel, BorderLayout.CENTER);
		inGamePanel.add(gameInfo, BorderLayout.WEST);
		inGamePanel.setVisible(true);
	}
	
	public void setLevelInGamePanel(String playerLevel)
	{
		this.playerLevel = playerLevel;
	}
	
	public String getLevelInGamePanel()
	{
		return playerLevel;
	}
	
	public void setPlayerInGamePanel(String playerName)
	{
		this.playerName = playerName;
	}
	
	public String getNameInGamePanel()
	{
		return playerName;
	}
	
	public void setScoreInGamePanel(String playerScore)
	{
		this.playerScore = playerScore;
	}
	
	public String getScoreInGamePanel()
	{
		return playerScore;
	}
	
	public JPanel getInGamePanel()
	{
		return inGamePanel;
	}
	
	public void setLabelName(String name)
	{
		this.name.setText("Name:   " + name);
	}
	
	public JLabel getNameLabel()
	{
		return name;
	}
	
	public void setScoreLabel(String score)
	{
		this.score.setText("Score:   " + score);
	}
	
	public JLabel getScoreLabel()
	{
		return score;
	}
	
	public void setLevelLabel(String level)
	{
		this.level.setText("Level:   " + level);
	}
	
	public JLabel getLevelLabel()
	{
		return level;
	}
	
	public void setAScore(int aScore)
	{
		this.aScore = this.aScore + aScore;
	}
	
	public void setALevel(int aLevel)
	{
		this.aLevel = aLevel;
	}
	
	public int getAScore()
	{
		return aScore;
	}
	
	public int getALevel()
	{
		return aLevel;
	}
	
	public BoardGamePanel getBoardGamePanel()
	{
		return boardGamePanel;
	}
	
	public void setLost(boolean lost)
	{
		this.lost = lost;
	}
	
	public void setGameStart(boolean gameStart)
	{
		this.gameStart = gameStart;
	}
	
	public boolean getGameStart()
	{
		return gameStart;
	}
	
	
	
	
	Tetromino cur = new Tetromino();
	Block [] blockCur = new Block[4];
	Tetromino next = new Tetromino();
	Block [] blockNext = new Block[4];
	
	private String playerLevel;
	private String playerName;
	private String playerScore;
	
	private JPanel inGamePanel;
	private JLabel name;
	private JLabel score;
	private JLabel level;
	
	private BoardGamePanel boardGamePanel;
	
	private int aScore;
	private int aLevel;
	private Color[][] colors;
	private boolean lost = false;
	private boolean gameStart = false; // to make to new figure drop
}
