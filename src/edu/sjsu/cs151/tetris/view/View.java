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
	
	public JFrame getFrame()
	{
		return frame;
	}
	
	public WelcomePanel getWelcomePanel()
	{
		return welcomePanel;
	}
	
	public MainPanel getMainPanel()
	{
		return mainPanel;
	}
	
	public PlayerPanel getPlayerPanel()
	{
		return playerPanel;
	}
	
	public SelectLevelPanel getSelectLevelPanel()
	{
		return selectLevelPanel;
	}
	
	public LeaderboardPanel getLeaderboardPanel()
	{
		return leaderboardPanel;
	}
	
	public QuitPanel getQuitPanel()
	{
		return quitPanel;
	}
	
	public InGamePanel getInGamePanel()
	{
		return inGamePanel;
	}
	
	public GameOverPanel getGameOverPanel()
	{
		return gameOverPanel;
	}
	
	public ControlsPanel getControlsPanel()
	{
		return controlsPanel;
	}
	
	public LeaderboardInPausePanel getLeaderboardInPausePanel()
	{
		return leaderboardInPausePanel;
	}
	
	private JFrame frame;
	private WelcomePanel welcomePanel = new WelcomePanel();
	private MainPanel mainPanel = new MainPanel();
	private PlayerPanel playerPanel = new PlayerPanel();
	private SelectLevelPanel selectLevelPanel = new SelectLevelPanel();
	private LeaderboardPanel leaderboardPanel = new LeaderboardPanel();
	private QuitPanel quitPanel = new QuitPanel();
	private InGamePanel inGamePanel = new InGamePanel();
	private GameOverPanel gameOverPanel = new GameOverPanel();
	private ControlsPanel controlsPanel = new ControlsPanel();
	private LeaderboardInPausePanel leaderboardInPausePanel = new LeaderboardInPausePanel();
}

