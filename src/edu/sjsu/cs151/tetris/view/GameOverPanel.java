package edu.sjsu.cs151.tetris.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverPanel extends Panel
{
	public GameOverPanel()
	{
		JFrame frame = new JFrame();
		frame.setSize(605, 800);
		
		JPanel quitPanel = new JPanel();
		quitPanel.setPreferredSize(new Dimension(800, 400));
		quitPanel.setBackground(new Color(128,128,128));
		quitPanel.setOpaque(true);
		
		JLabel gameOver = new JLabel("  GAME OVER!!!  ");
		gameOver.setBackground(new Color(128,128,128));
		gameOver.setOpaque(true);
		gameOver.setFont(new Font("TimesRoman", Font.BOLD, 64));	
		setLabelCenter(gameOver);
		
		JButton retryButton = new JButton("  Retry Level  ");
		setButton(retryButton, 48);
		//retryButton.addActionListener(event -> frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)));
		
		JButton returnToMainManu = new JButton("  Return to Main Manu  ");
		setButton(returnToMainManu, 48);
		returnToMainManu.addActionListener(event -> frame.setVisible(false));
		returnToMainManu.addActionListener(event -> new MainPanel());
		
		JPanel box1 = new JPanel(new GridLayout(1, 10));
		box1.setBackground(new Color(128,128,128));
		JPanel box2 = new JPanel(new GridLayout(1, 10));
		box2.setBackground(new Color(128,128,128));
		JPanel box3 = new JPanel(new GridLayout(1, 10));
		box3.setBackground(new Color(128,128,128));
		JPanel box4 = new JPanel(new GridLayout(1, 10));
		box4.setBackground(new Color (128,128,128));
		
        
		quitPanel.setLayout(new BoxLayout(quitPanel, BoxLayout.Y_AXIS));		
		quitPanel.add(box1);
		quitPanel.add(gameOver);
		
		quitPanel.add(box2);
		quitPanel.add(retryButton);
		
		quitPanel.add(box3);
		quitPanel.add(returnToMainManu);
		quitPanel.add(box4);

		quitPanel.setVisible(true);
		
		frame.setLayout(new BorderLayout());		
		frame.add(quitPanel, BorderLayout.CENTER);

		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

