package edu.sjsu.cs151.tetris.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
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
		mainPanel.setSize(550, 800);
	
		JLabel gameLabel = new JLabel("T E R I S");	
		gameLabel.setFont(new Font("TimesRoman", Font.BOLD, 84));
		gameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		gameLabel.setOpaque(true);
		gameLabel.setVisible(true);		

		JButton playgameButton = new JButton	("    Play Game   ");
		setMainPanelButton(playgameButton);
		
		JButton leaderboardsButton = new JButton(" Leaderboards ");
		setMainPanelButton(leaderboardsButton);
		
		JButton quitButton = new JButton		("         Quit         ");
		setMainPanelButton(quitButton);
		
		JPanel box1 = new JPanel(new GridLayout(1, 10));
		JPanel box2 = new JPanel(new GridLayout(1, 10));
		JPanel box3 = new JPanel(new GridLayout(1, 10));
		JPanel box4 = new JPanel(new GridLayout(1, 10));
		JPanel box5 = new JPanel(new GridLayout(1, 10));
		JPanel box6 = new JPanel(new GridLayout(1, 10));
		JPanel box7 = new JPanel(new GridLayout(1, 10));
		JPanel box8 = new JPanel(new GridLayout(1, 10));
		JPanel box9 = new JPanel(new GridLayout(1, 10));
        
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));		
		mainPanel.add(box1);
		mainPanel.add(box2);
		mainPanel.add(box3);
		mainPanel.add(gameLabel);
		
		mainPanel.add(box4);
		mainPanel.add(playgameButton);
		
		mainPanel.add(box5);
		mainPanel.add(leaderboardsButton);
		
		mainPanel.add(box6);
		mainPanel.add(quitButton);
		mainPanel.add(box7);
		mainPanel.add(box8);
		mainPanel.add(box9);
		
		mainPanel.setVisible(true);
		
		frame.setLayout(new BorderLayout());
		frame.add(mainPanel, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JButton setMainPanelButton(JButton button)
	{
		button.setFont(new Font("TimesRoman", Font.BOLD, 48));
		button.setSize(400, 150);
		button.setBackground(Color.BLACK);
		button.setOpaque(true);
		button.setBorderPainted(true);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		button.setVisible(true);
		
		return button;
	}
	
	JPanel mainPanel;
}
