package edu.sjsu.cs151.tetris.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MainPanel extends Panel
{
	public MainPanel()
	{
		JFrame frame = new JFrame();
		frame.setSize(600, 800);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setSize(550, 800);
		
		JPanel iconZ = iconZ();
		JPanel iconL = iconL();
		JPanel iconO = iconO();
		
		JLabel gameLabel = new JLabel("T E R I S");	
		gameLabel.setFont(new Font("TimesRoman", Font.BOLD, 84));
		setLabelCenter(gameLabel);
			

		JButton playgameButton = new JButton	("    Play Game   ");
		setButton(playgameButton, 48);
		
		JButton leaderboardsButton = new JButton(" Leaderboards ");
		setButton(leaderboardsButton, 48);
		leaderboardsButton.addActionListener(event -> frame.setVisible(false));
		leaderboardsButton.addActionListener(event -> new LeaderboardPanel());
		
		JButton quitButton = new JButton		("         Quit         ");
		setButton(quitButton, 48);
		quitButton.addActionListener(event -> frame.setVisible(false));
		quitButton.addActionListener(event -> new QuitPanel());
		
		JPanel box1 = empty3Boxs();
		JPanel box2 = new JPanel(new GridLayout(1, 10));
		JPanel box3 = new JPanel(new GridLayout(1, 10));
		JPanel box4 = new JPanel(new GridLayout(1, 10));
		JPanel box5 = empty3Boxs();
        
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		
		mainPanel.add(box1);
		mainPanel.add(gameLabel);
		
		mainPanel.add(box2);
		mainPanel.add(playgameButton);
		
		mainPanel.add(box3);
		mainPanel.add(leaderboardsButton);
		
		mainPanel.add(box4);
		mainPanel.add(quitButton);
		mainPanel.add(box5);
		
		mainPanel.setVisible(true);
		
		frame.setLayout(new BorderLayout());
		frame.add(mainPanel, BorderLayout.CENTER);
		frame.add(iconZ, BorderLayout.WEST);
		frame.add(iconL, BorderLayout.EAST);
		frame.add(iconO, BorderLayout.SOUTH);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


