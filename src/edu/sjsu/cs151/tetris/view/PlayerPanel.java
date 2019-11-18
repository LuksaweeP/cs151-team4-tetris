package edu.sjsu.cs151.tetris.view;

import edu.sjsu.cs151.tetris.model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class PlayerPanel extends Panel
{
	public PlayerPanel()
	{
		JFrame frame = new JFrame();
		frame.setSize(600, 800);
		
		JPanel playGamePanel = new JPanel();
		playGamePanel.setSize(550, 800);
		playGamePanel.setLayout(new BoxLayout(playGamePanel, BoxLayout.Y_AXIS));
		
		JPanel backPanel = new JPanel();
		backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.X_AXIS));
		
		JButton back = new JButton("   <-  Back   ");
		back.setFont(new Font("TimesRoman", Font.BOLD, 30));
		back.setBackground(Color.BLACK);
		back.setOpaque(true);
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		back.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		back.setVisible(true);
		
		back.addActionListener(event -> frame.setVisible(false));
		back.addActionListener(event -> new MainPanel());

		JLabel back1 = new JLabel("                   ");  // create empty box
		back1.setFont(new Font("TimesRoman", Font.BOLD, 100));
		back1.setVisible(true);
		
		backPanel.add(back);
		backPanel.add(back1);
		
		JLabel createPlayerLabel = new JLabel("Create New Player");
		createPlayerLabel.setFont(new Font("TimesRoman", Font.BOLD, 36));
		createPlayerLabel.setVisible(true);
		
		JTextField inputBox = new JTextField(15);  
		inputBox.setFont(new Font("TimesRoman", Font.BOLD, 30));
		inputBox.setBackground(Color.LIGHT_GRAY);
		inputBox.setOpaque(true);
			
		JButton createButton = new JButton("   Create   ");
		setButton(createButton, 36);
		createButton.setVisible(true);
		createButton.addActionListener(event -> new InGamePanel());
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
		northPanel.add(backPanel);
		backPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		northPanel.add(createPlayerLabel);
		createPlayerLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		northPanel.add(inputBox);
		
		northPanel.add(createButton);
		createButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel loadPlayerLabel = new JLabel("Load Player");
		loadPlayerLabel.setFont(new Font("TimesRoman", Font.BOLD, 36));
		loadPlayerLabel.setVisible(true);
		
		Leaderboard playerList = new Leaderboard();
		playerList.readPlayers();
		ArrayList<Player> list = playerList.getPlayer();
		int number = playerList.getNumberPlayers(); // number of players
		String[] players = new String[number];
		JButton [] existPlayer = new JButton[number];
		
		Container contentPane = new Container();
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		contentPane.setLayout(gridbag);
		
		c.fill = GridBagConstraints.HORIZONTAL; 
		c.ipady = 5;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;
		gridbag.setConstraints(loadPlayerLabel, c);
		contentPane.add(loadPlayerLabel);
		
		Player player = new Player();

		for (int i = 0; i < number; i++) {
			player = list.get(i);
			players[i] = player.getName();
			String name = player.getName();
			existPlayer[i] = new JButton(players[i]);
			existPlayer[i].setFont(new Font("TimesRoman", Font.PLAIN, 30));
			existPlayer[i].setBackground(Color.BLACK);
			existPlayer[i].setOpaque(true);
			existPlayer[i].setBorderPainted(true);
			c.ipady = 5;
			c.weightx = 0.5;
			c.gridx = 2;
			c.gridy = i + 2;
			c.gridwidth = 1;

			existPlayer[i].addMouseListener(new MouseAdapter()
			{
				public void mousePressed(MouseEvent e)
				{
					Object o = e.getSource();
					JButton pressedButton = (JButton) o;
					String text = pressedButton.getText();
					
					System.out.println(text);
					loadPlayer = playerList.loadPlayer(text);
					
					System.out.println(loadPlayer.getName());
					System.out.println(loadPlayer.getPlayerHighScore());
					
					frame.setVisible(false);
					new SelectLevelPanel();
				}	
			});
			
			gridbag.setConstraints(existPlayer[i], c);
			contentPane.add(existPlayer[i]);
			
		}
		
		frame.setLayout(new BorderLayout());
		frame.add(northPanel, BorderLayout.NORTH);
		frame.add(contentPane, BorderLayout.CENTER);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Player getLoadPlayer()
	{
		return loadPlayer;
	}
	
	static Player loadPlayer;
}

