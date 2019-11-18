package edu.sjsu.cs151.tetris.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PausePanel extends Panel
{
	public PausePanel()
	{
			JFrame frame = new JFrame();
			frame.setSize(600, 800);
			
			JPanel controlsPanel = new JPanel();
			controlsPanel.setSize(550, 800);
			
			JPanel iconL = iconL();
			JPanel iconI = iconI();
			JPanel iconO = iconO();
						
			JPanel backPanel = new JPanel();
			backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.X_AXIS));
			
			JButton back = new JButton("   <-  Back   ");
			setButton(back, 36);
			back.addActionListener(event -> frame.setVisible(false));
			
			JLabel back1 = new JLabel("                   ");  // create empty box
			back1.setFont(new Font("TimesRoman", Font.BOLD, 100));
			back1.setVisible(true);
			
			backPanel.add(back);
			backPanel.add(back1);

			JButton leaderboardsButton = new JButton	(" Leaderboards ");
			setButton(leaderboardsButton, 48);
			leaderboardsButton.addActionListener(event -> new LeaderboardInPausePanel());
			
			JButton controlsButton = new JButton(" Controls ");
			setButton(controlsButton, 48);
			controlsButton.addActionListener(event -> new ControlsPanel());
			
			JButton returnToMainManuButton = new JButton		("  Return to Main Manu  ");
			setButton(returnToMainManuButton, 40);
			returnToMainManuButton.addActionListener(event -> frame.setVisible(false));
			returnToMainManuButton.addActionListener(event -> new MainPanel());
			
			JPanel box1 = empty2Boxs();					
			JPanel box2 = new JPanel(new GridLayout(1, 10));			
			JPanel box3 = new JPanel(new GridLayout(1, 10));			
			JPanel box4 = empty2Boxs();
	        
			controlsPanel.setLayout(new BoxLayout(controlsPanel, BoxLayout.Y_AXIS));					
			controlsPanel.add(box1);		
			controlsPanel.add(leaderboardsButton);
			
			controlsPanel.add(box2);
			controlsPanel.add(controlsButton);
			
			controlsPanel.add(box3);
			controlsPanel.add(returnToMainManuButton);
			controlsPanel.add(box4);
			
			controlsPanel.setVisible(true);
			
			frame.setLayout(new BorderLayout());
			frame.add(backPanel, BorderLayout.NORTH);
			frame.add(controlsPanel, BorderLayout.CENTER);
			frame.add(iconI, BorderLayout.WEST);
			frame.add(iconL, BorderLayout.EAST);
			frame.add(iconO, BorderLayout.SOUTH);
			
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
