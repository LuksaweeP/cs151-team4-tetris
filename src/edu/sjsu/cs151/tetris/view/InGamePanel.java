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

class InGamePanel extends Panel {
	public InGamePanel() {
		JFrame frame = new JFrame();
		frame.setSize(600, 800);

		JLabel level = new JLabel(" Level : ______");
		level.setFont(new Font("TimesRoman", Font.BOLD, 24));
		level.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel name = new JLabel("Player: Name");
		name.setFont(new Font("TimesRoman", Font.BOLD, 24));
		name.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel score = new JLabel(" Score : ______");
		score.setFont(new Font("TimesRoman", Font.BOLD, 24));
		score.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel pause = new JLabel("esc - PAUSE");
		pause.setFont(new Font("TimesRoman", Font.BOLD, 24));
		
		JPanel gameInfo = new JPanel();
		gameInfo.setPreferredSize(new Dimension(200, 800));
		gameInfo.setBackground(new Color(176, 196, 222));
		
		
		JPanel playerPanel = new JPanel();
		playerPanel.setPreferredSize(new Dimension(200, 500));
		playerPanel.setBackground(new Color(176, 196, 222));
		playerPanel.setOpaque(true);
		playerPanel.add(level);
		playerPanel.add(name);
		playerPanel.add(score);
		
		JPanel nextTetrominoPanel = new JPanel();
		nextTetrominoPanel.setPreferredSize(new Dimension(200, 200));
		nextTetrominoPanel.setBackground(new Color(176, 196, 222));
		nextTetrominoPanel.setOpaque(true);
		
		JPanel pausePanel = new JPanel();
		pausePanel.setPreferredSize(new Dimension(200, 100));
		pausePanel.setBackground(new Color(176, 196, 222));
		pausePanel.setOpaque(true);
		pausePanel.add(pause);
		
		
		gameInfo.setLayout(new BoxLayout(gameInfo, BoxLayout.Y_AXIS));
		gameInfo.add(playerPanel);
		gameInfo.add(nextTetrominoPanel);
		gameInfo.add(pausePanel);

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
					new PausePanel();
					break;
				}
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	Tetromino cur = new Tetromino();
	Block [] blockCur = new Block[4];
	Tetromino next = new Tetromino();
	Block [] blockNext = new Block[4];
}
