package edu.sjsu.cs151.tetris.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MainPanel 
{
	public MainPanel()
	{
		JFrame frame = new JFrame();
		frame.setSize(600, 800);
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setSize(605, 800);
	
		JLabel gameLabel = new JLabel("TERIS");
		gameLabel.setFont(new Font("TimesRoman", Font.BOLD, 84));
		gameLabel.setOpaque(true);
		gameLabel.setVisible(true);
		
		
		JButton playgameButton = new JButton("Play Game");
		setMainPanelButton(playgameButton);
		
		JButton leaderboardsButton = new JButton("Leaderboards");
		setMainPanelButton(leaderboardsButton);
		
		JButton quitButton = new JButton("Quit");
		setMainPanelButton(quitButton);
		
		mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(gameLabel);
		mainPanel.add(playgameButton);
		mainPanel.add(leaderboardsButton);
		mainPanel.add(quitButton);
		
		mainPanel.setVisible(true);
		
		frame.setLayout(new BorderLayout());
		frame.add(mainPanel, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JButton setMainPanelButton(JButton button)
	{
		button.setFont(new Font("TimesRoman", Font.BOLD, 48));
		button.setBackground(Color.darkGray);
		button.setSize(400, 150);
		button.setVisible(true);
		
		return button;
	}
	
	public JPanel getMainPanel()
	{
		return mainPanel;
	}
	
	JPanel mainPanel;
	
	
}

