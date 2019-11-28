package edu.sjsu.cs151.tetris.view;

import edu.sjsu.cs151.tetris.model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class PlayerPanel extends Panel {
	public PlayerPanel() {
		playerPanel = new JPanel();
		playerPanel.setSize(600, 800);
		
		JPanel backPanel = new JPanel();
		backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.X_AXIS));

		back = new JButton("   <-  Back   ");
		back.setFont(new Font("TimesRoman", Font.BOLD, 30));
		back.setBackground(Color.BLACK);
		back.setOpaque(true);
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		back.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		back.setVisible(true);

		JLabel back1 = new JLabel("       "); // create empty box
		back1.setFont(new Font("TimesRoman", Font.BOLD, 100));
		back1.setVisible(true);

		backPanel.add(back);
		backPanel.add(back1);

		JLabel createPlayerLabel = new JLabel("Create New Player");
		createPlayerLabel.setFont(new Font("TimesRoman", Font.BOLD, 36));
		createPlayerLabel.setVisible(true);

		inputBox = new JTextField(15);
		inputBox.setSize(600, 100);
		inputBox.setFont(new Font("TimesRoman", Font.BOLD, 30));
		inputBox.setBackground(Color.LIGHT_GRAY);
		inputBox.setOpaque(true);

		createButton = new JButton("   Create   ");
		setButton(createButton, 36);
		createButton.setVisible(true);
		
		JLabel loadPlayerLabel = new JLabel("Load Player");
		loadPlayerLabel.setFont(new Font("TimesRoman", Font.BOLD, 36));
		loadPlayerLabel.setVisible(true);
		
		JLabel box = new JLabel("                   "); // create empty box
		box.setFont(new Font("TimesRoman", Font.BOLD, 50));
		box.setVisible(true);

		JPanel northPanel = new JPanel();
		northPanel.setPreferredSize(new Dimension(600, 300));
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
		northPanel.add(backPanel);
		backPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

		northPanel.add(createPlayerLabel);
		createPlayerLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

		northPanel.add(inputBox);
		northPanel.add(createButton);
		createButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		northPanel.add(box);
		northPanel.add(loadPlayerLabel);

		Leaderboard playerList = new Leaderboard();
		//playerList.readPlayers();
		ArrayList<Player> list = playerList.getPlayer();
		number = playerList.getNumberPlayers(); // number of players
		//System.out.println("Number of load player: " + number);
		String[] players = new String[number];
		existPlayer = new JButton[number];
		
		Container contentPane = new Container();
		contentPane.setBackground(Color.lightGray);
		contentPane.setVisible(true);
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		contentPane.setLayout(gridbag);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 5;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;

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
						
			gridbag.setConstraints(existPlayer[i], c);
			contentPane.add(existPlayer[i]);
		}
		
		JScrollPane jScrollPane = new JScrollPane(contentPane);
		jScrollPane.setPreferredSize(new Dimension(600, 500));
		
		jScrollPane.getViewport().setBackground(Color.lightGray);
		jScrollPane.setOpaque(true);
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    jScrollPane.getViewport().add(contentPane);
	    
		playerPanel.setLayout(new BorderLayout());
		playerPanel.add(northPanel, BorderLayout.NORTH);
		playerPanel.add(jScrollPane, BorderLayout.CENTER);
		
		playerPanel.setVisible(true);
	}
	
	public void setLoadPlayer(Player player) {
		loadPlayer = player;
	}
	
	public Player getLoadPlayer() {
		return loadPlayer;
	}

	public JButton getCreateButton() {
		return createButton;
	}
	
	public JButton getBackButton() {
		return back;
	}

	public JTextField getInputBox() {
		return inputBox;
	}

	public JPanel getPlayerPanel() {
		return playerPanel;
	}
	
	public JButton[] getExistPlayerButton()
	{
		return existPlayer;
	}

	static Player loadPlayer;
	private JTextField inputBox;
	private JButton createButton;
	private JPanel playerPanel;
	private JButton back;
	private JButton [] existPlayer;
	private int number;

}