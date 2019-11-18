package edu.sjsu.cs151.tetris.view;

import edu.sjsu.cs151.tetris.model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectLevelPanel extends PlayerPanel
{
	public SelectLevelPanel()
	{
		JFrame frame = new JFrame();
		frame.setSize(605, 800);
		
		
		JPanel selectLevelPanel = new JPanel();
		selectLevelPanel.setPreferredSize(new Dimension(800, 400));
		selectLevelPanel.setBackground(new Color(255,229,204));
		selectLevelPanel.setOpaque(true);
		
		Leaderboard playerList = new Leaderboard();
		playerList.readPlayers();
		ArrayList<Player> list = playerList.getPlayer();
		
		
		Player player = getLoadPlayer();
		
		
		System.out.println(player.getName());
		System.out.println(player.getPlayerHighScore());
		
		JLabel selectLevel = new JLabel("Select a Level");
		selectLevel.setFont(new Font("TimesRoman", Font.BOLD, 72));
		setLabelCenter(selectLevel);
		selectLevel.setBackground(new Color(255,229,204));
		selectLevel.setOpaque(true);
		
	
		JButton [] levelButton = new JButton[6];
		
		Container contentPane = new Container();
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		contentPane.setLayout(gridbag);
		
		
		c.fill = GridBagConstraints.CENTER; 
		c.ipady = 5;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;
		
		gridbag.setConstraints(selectLevel, c);
		contentPane.add(selectLevel);
		
		for( int i = 1; i <= 5; i++)
		{
			if (player.isLevelUnlocked(i) == true)
			{
				levelButton[i] = new JButton("Level   " + i);
				levelButton[i].setFont(new Font("TimesRoman", Font.BOLD, 36));
				levelButton[i].setBackground(Color.BLACK);
				levelButton[i].setOpaque(true);
				levelButton[i].setBorderPainted(true);
				c.ipady = 25;
				c.gridy = 10;
				levelButton[i].addActionListener(event -> frame.setVisible(false));
				levelButton[i].addActionListener(event -> new InGamePanel());
				
			}
			
			else
			{
				Icon lock = new ImageIcon("src/edu/sjsu/cs151/tetris/view/locked.png");
				levelButton[i] = new JButton(lock);
				levelButton[i].setBackground(Color.BLACK);
				levelButton[i].setOpaque(true);
				levelButton[i].setBorderPainted(true);
				c.ipady = 5;
			}
			c.fill = GridBagConstraints.HORIZONTAL; 
			c.gridy = 5;
			c.weightx = 1;
			c.gridy = i+2;
			c.gridwidth = 1;
			
			gridbag.setConstraints(levelButton[i], c);
			contentPane.add(levelButton[i]);
		}
        
		selectLevelPanel.setLayout(new BorderLayout());
		selectLevelPanel.add(contentPane, BorderLayout.CENTER);

		frame.add(selectLevelPanel);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

