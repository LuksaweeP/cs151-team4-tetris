package edu.sjsu.cs151.tetris.view;

import edu.sjsu.cs151.tetris.model.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LeaderboardPanel extends Panel {
	public LeaderboardPanel() {
		leaderboardPanel = new JPanel();
		leaderboardPanel.setSize(600, 800);

		JPanel backPanel = new JPanel();
		backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.X_AXIS));
		
		back = new JButton("   <-  Back   ");
		setButton(back, 36);
		//back.addActionListener(event -> frame.setVisible(false));
		//back.addActionListener(event -> new MainPanel());

		JLabel back1 = new JLabel("                   ");  // create empty box
		back1.setFont(new Font("TimesRoman", Font.BOLD, 100));
		back1.setVisible(true);
		
		backPanel.add(back);
		backPanel.add(back1);
		
		JPanel bigPanel = new JPanel();
		bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.Y_AXIS));
		bigPanel.setOpaque(true);
		bigPanel.setVisible(true);
		
		JLabel leaderBoard = new JLabel("Leaderboard");
		leaderBoard.setFont(new Font("TimesRoman", Font.BOLD, 48));
		setLabelCenter(leaderBoard);

		JPanel namePanel = new JPanel();
		namePanel.setSize(250, 400);
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
		
		JPanel scorePanel = new JPanel();
		scorePanel.setSize(250, 400);
		scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.Y_AXIS));
			
		Leaderboard playerList = new Leaderboard();
		ArrayList<Player> list = playerList.getPlayer();
		int number = playerList.getNumberPlayers(); // number of players
		String[] players = new String[number];
		int []highScore = new int[number];
		Player player = new Player();

		for (int i = 0; i < number; i++) {
			player = list.get(i);
			players[i] = player.getName();
			highScore[i] = player.getPlayerHighScore();
		}

		quickSort(players, highScore); // sort player to get highscore
		
		JLabel [] nameLabel = new JLabel [number];
		JLabel [] scoreLabel = new JLabel [number];
		String score;
		
		if (number < 5)
		{
			for( int i = number - 1; i >= 0; i--)
			{
				score = Integer.toString(highScore[i]);
				nameLabel[i] = new JLabel(players[i]);
				nameLabel[i].setFont(new Font("TimesRoman", Font.BOLD, 36));
				
				scoreLabel[i] = new JLabel(score);
				scoreLabel[i].setFont(new Font("TimesRoman", Font.BOLD, 36));
				
				namePanel.add(nameLabel[i]);
				scorePanel.add(scoreLabel[i]);
			}
		}
		
		if (number >= 5)
		{
			for( int i = number - 1; i >= number - 5; i--)
			{
				score = Integer.toString(highScore[i]);
				nameLabel[i] = new JLabel(players[i]);
				nameLabel[i].setFont(new Font("TimesRoman", Font.BOLD, 36));
				
				scoreLabel[i] = new JLabel(score);
				scoreLabel[i].setFont(new Font("TimesRoman", Font.BOLD, 36));
				
				namePanel.add(nameLabel[i]);
				scorePanel.add(scoreLabel[i]);
			}
		}
		
		JPanel scoreTable = new JPanel();
		namePanel.setSize(250, 400);
		namePanel.setOpaque(true);
		scoreTable.setLayout(new FlowLayout());
		
		JLabel box1 = new JLabel("                           ");
		box1.setFont(new Font("TimesRoman", Font.BOLD, 36));
		
		scoreTable.add(namePanel);
		scoreTable.add(box1);
		scoreTable.add(scorePanel);
		
		JLabel box2 = new JLabel("                           ");
		box2.setFont(new Font("TimesRoman", Font.BOLD, 36));
		
		JPanel box3 = empty2Boxs();
		box3.setSize(50, 100);
		box3.setVisible(true);
		
		JPanel box4 = empty2Boxs();
		box4.setSize(50, 100);
		box4.setVisible(true);
		
		bigPanel.add(box3);
		bigPanel.add(leaderBoard);
		bigPanel.add(box2);
		bigPanel.add(scoreTable);
		bigPanel.add(box4);
		
		leaderboardPanel.setLayout(new BorderLayout());
		leaderboardPanel.add(backPanel, BorderLayout.NORTH);
		leaderboardPanel.add(bigPanel, BorderLayout.CENTER);
		
		leaderboardPanel.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Function to sort array by using quickSort
	 * 
	 * @param array The original unsorted array
	 */
	public void quickSort(String[] name, int[] array) {
		int p = 0;
		int n = array.length - 1;
		quickSort(name, array, p, n);
	}

	public void quickSort(String[] name, int[] array, int p, int r) {
		if (p < r) {
			int q = partition(name, array, p, r);
			quickSort(name, array, p, q - 1);
			quickSort(name, array, q + 1, r);
		}
	}

	public int partition(String[] name, int[] array, int p, int r) {
		int x = array[r];
		int i = p - 1;
		for (int j = p; j <= r - 1; j++) {
			if (array[j] <= x) {
				i++;
				swap(array, i, j);
				swap(name, i, j);
			}
		}
		swap(array, i + 1, r);
		swap(name, i + 1, r);
		return i + 1;
	}

	// Swap two nodes of the heap at index first second
	private void swap(int[] array, int first, int seconds) {
		int tmp;
		tmp = array[first];
		array[first] = array[seconds];
		array[seconds] = tmp;
	}

	private void swap(String[] array, int first, int seconds) {
		String tmp;
		tmp = array[first];
		array[first] = array[seconds];
		array[seconds] = tmp;
	}
	
	public JButton getBackButton()
	{
		return back;
	}
	
	public JPanel getLeaderboardPanel()
	{
		return leaderboardPanel;
	}
	
	JButton back;
	JPanel leaderboardPanel;
}
