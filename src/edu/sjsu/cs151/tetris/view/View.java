package edu.sjsu.cs151.tetris.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View
{
	public View()
	{
		frame = new JFrame("TETRIS");
		frame.setSize(600, 800);
		welcomePanel = new WelcomePanel();
	}
	
	private JFrame frame;
	private WelcomePanel welcomePanel;
	private MainPanel mainPanel;
	private PlayerPanel playerPanel;
	private SelectLevelPanel selectLevelPanel;
	private LeaderboardPanel leaderboardPanel;
	private QuitPanel quitPanel;
	private InGamePanel inGamePanel;
	private GameOverPanel gameOverPanel;
	private ControlsPanel cintrolsPanel;
	private LeaderboardInPausePanel leaderboardInPausePanel;

	
	
	
}

