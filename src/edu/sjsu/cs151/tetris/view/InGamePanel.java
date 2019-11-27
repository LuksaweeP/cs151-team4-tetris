package edu.sjsu.cs151.tetris.view;

import edu.sjsu.cs151.tetris.model.*;
import edu.sjsu.cs151.tetris.animation.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class InGamePanel extends PlayerPanel {
	public InGamePanel() {
		getPlayerFrame().setVisible(false);
		
		frame = new JFrame();
		frame.setSize(600, 800);

		JLabel level = new JLabel("Level:  " + playerLevel);
		level.setFont(new Font("TimesRoman", Font.BOLD, 24));
		level.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel name = new JLabel("Name:  " + playerName);
		name.setFont(new Font("TimesRoman", Font.BOLD, 24));
		name.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel score = new JLabel("Score  :" +  playerScore);
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
		playerPanel.add(level);
		playerPanel.add(name);
		playerPanel.add(score);
		
		JPanel nextTetrominoPanel = new JPanel();
		nextTetrominoPanel.setPreferredSize(new Dimension(200, 200));
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
		
		MoveableShape curr = new DrawTetromino('O', 0, 0, 35);
		
		cur.setRandomShape();
		cur.setBlocks();
		blockCur = cur.getBlocks();
	
		frame.setLayout(new BorderLayout());
		frame.add(center, BorderLayout.EAST);
		frame.add(gameInfo, BorderLayout.WEST);
		frame.setVisible(true);
		
		frame.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {

				/*
				 *Case press esc to pause the game
				 */
				case KeyEvent.VK_ESCAPE:
					int pauseDalay = 0;
					//Timer tPause = new Timer(pauseDalay, "");
					//tPause.start();
					frame.setVisible(false);
					new PausePanel();
					break;
				}
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setInGameInvisible(JFrame frame)
	{
		this.frame.setVisible(false);
	}
	
	public JFrame getInGameFrame()
	{
		return frame;
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
	
	
	
	Tetromino cur = new Tetromino();
	Block [] blockCur = new Block[4];
	Tetromino next = new Tetromino();
	Block [] blockNext = new Block[4];
	
	private String playerLevel;
	private String playerName;
	private String playerScore;
	
	static JFrame frame;
}
