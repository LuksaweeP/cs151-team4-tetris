package edu.sjsu.cs151.tetris.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PausePanel extends Panel
{
	public PausePanel()
	{
			pausePanel = new JPanel();
			pausePanel.setPreferredSize(new Dimension(600, 800));

			JPanel controlsPanel = new JPanel();
			controlsPanel.setPreferredSize(new Dimension(400, 800));
			
			JPanel iconL = iconL();
			JPanel iconI = iconI();
			JPanel iconO = iconO();
						
			JPanel backPanel = new JPanel();
			backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.X_AXIS));
			
			back = new JButton("   <-  Back   ");
			back.setBackground(Color.WHITE);
			setButton(back, 36);

			JLabel back1 = new JLabel("                   ");  // create empty box
			back1.setFont(new Font("TimesRoman", Font.BOLD, 50));
			back1.setVisible(true);
			
			backPanel.add(back);
			backPanel.add(back1);

			leaderboardsButton = new JButton	(" Leaderboards ");
			leaderboardsButton.setBackground(Color.WHITE);
			setButton(leaderboardsButton, 48);
			
			controlsButton = new JButton(" Controls ");
			controlsButton.setBackground(Color.WHITE);
			setButton(controlsButton, 48);
			
			returnToMainManuButton = new JButton		("  Return to Main Menu  ");
			returnToMainManuButton.setBackground(Color.WHITE);
			setButton(returnToMainManuButton, 40);
				
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
			
			pausePanel.setLayout(new BorderLayout());
			pausePanel.add(backPanel, BorderLayout.NORTH);
			pausePanel.add(controlsPanel, BorderLayout.CENTER);
			pausePanel.add(iconI, BorderLayout.WEST);
			pausePanel.add(iconL, BorderLayout.EAST);
			pausePanel.add(iconO, BorderLayout.SOUTH);
			
			pausePanel.setVisible(true);
	}
	
	public JPanel getPausePanel()
	{
		return pausePanel;
	}
	
	public JButton getBack()
	{
		return back;
	}
	
	public JButton getLeaderboardsButton()
	{
		return leaderboardsButton;
	}
	
	public JButton getControlsButton()
	{
		return controlsButton;
	}
	
	public JButton getReturnToMainManuButton()
	{
		return returnToMainManuButton;
	}
	
	private JPanel pausePanel;
	private JButton back;
	private JButton leaderboardsButton;
	private JButton controlsButton;
	private JButton returnToMainManuButton;
}
