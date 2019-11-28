package edu.sjsu.cs151.tetris.view;

import java.awt.Component;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

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
	 
	private JFrame frame;
	private WelcomePanel welcomePanel = new WelcomePanel();
	private MainPanel mainPanel = new MainPanel();
	private PlayerPanel playerPanel = new PlayerPanel();
	private SelectLevelPanel selectLevelPanel;
	private LeaderboardPanel leaderboardPanel = new LeaderboardPanel();
	private QuitPanel quitPanel = new QuitPanel();
	private InGamePanel inGamePanel = new InGamePanel();
	private GameOverPanel gameOverPanel;
	private ControlsPanel controlsPanel = new ControlsPanel();
	private LeaderboardInPausePanel leaderboardInPausePanel;
	private PausePanel pausePanel = new PausePanel();
}
