package edu.sjsu.cs151.tetris.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;

public class View
{
	public View()
	{
		frame = new JFrame("TETRIS");
		frame.setSize(600, 800);
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	
	public PausePanel getPausePanel()
	{
		return pausePanel;
	}
	
	public void add(Component c)
	{
		frame.add(c);
	}
	
	public void setSelectLevelPanel()
	{
		this.selectLevelPanel = new SelectLevelPanel();
	}
	
	public void setPlayerPanel()
	{
		this.playerPanel = new PlayerPanel();
	}
	
	public void setLeaderBoardPanel()
	{
		this.leaderboardPanel = new LeaderboardPanel();
	}
	
	public void setLeaderBoarInPausePanel()
	{
		this.leaderboardInPausePanel = new LeaderboardInPausePanel();
	}
	
	
	private JFrame frame;
	private WelcomePanel welcomePanel = new WelcomePanel();
	private MainPanel mainPanel = new MainPanel();
	private PlayerPanel playerPanel = new PlayerPanel();
	private SelectLevelPanel selectLevelPanel;
	private LeaderboardPanel leaderboardPanel = new LeaderboardPanel();
	private QuitPanel quitPanel = new QuitPanel();
	private InGamePanel inGamePanel = new InGamePanel();
	private GameOverPanel gameOverPanel = new GameOverPanel();
	private ControlsPanel controlsPanel = new ControlsPanel();
	private LeaderboardInPausePanel leaderboardInPausePanel = new LeaderboardInPausePanel();
	private PausePanel pausePanel = new PausePanel();
	private Color [][] colors;
}
