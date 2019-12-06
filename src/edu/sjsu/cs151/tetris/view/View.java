package edu.sjsu.cs151.tetris.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;

/**
 * Class that contain all panel class.
 * @author Luksawee
 */
public class View
{
	/**
	 * The construction of the View
	 */
	public View()
	{
		frame = new JFrame("TETRIS");
		frame.setSize(600, 800);
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Method to return frame.
	 * @return frame
	 */
	public JFrame getFrame()
	{
		return frame;
	}
	
	/**
	 * Method to return welcomePanel.
	 * @return welcomePanel
	 */
	public WelcomePanel getWelcomePanel()
	{
		return welcomePanel;
	}
	
	/**
	 * Method to return mainPanel.
	 * @return mainPanel
	 */
	public MainPanel getMainPanel()
	{
		return mainPanel;
	}
	
	/**
	 * Method to return playerPanel.
	 * @return playerPanel
	 */
	public PlayerPanel getPlayerPanel()
	{
		return playerPanel;
	}
	
	/**
	 * Method to return selectLevelPanel.
	 * @return selectPanel
	 */
	public SelectLevelPanel getSelectLevelPanel()
	{
		return selectLevelPanel;
	}
	
	/**
	 * Method to return leaderboardPanel.
	 * @return leaderboardPanel
	 */
	public LeaderboardPanel getLeaderboardPanel()
	{
		return leaderboardPanel;
	}
	
	/**
	 * Method to return quitpanel.
	 * @return quitPanel.
	 */
	public QuitPanel getQuitPanel()
	{
		return quitPanel;
	}
	
	/**
	 * Method to return InGamePanel.
	 * @return inGamePanel
	 */
	public InGamePanel getInGamePanel()
	{
		return inGamePanel;
	}
	
	/**
	 * Method to return gameOverPanel.
	 * @return gameOverPanel
	 */
	public GameOverPanel getGameOverPanel()
	{
		return gameOverPanel;
	}
	
	/**
	 * Method to return controlsPanel.
	 * @return controlsPanel
	 */
	public ControlsPanel getControlsPanel()
	{

		return controlsPanel;
	}
	
	/**
	 * Method to return leaderboardInPausePanel.
	 * @return leaderboardInPausePanel
	 */ 
	public LeaderboardInPausePanel getLeaderboardInPausePanel()
	{
		return leaderboardInPausePanel;
	}
	
	/**
	 * Method to return pausePanel
	 * @return pausePanel
	 */
	public PausePanel getPausePanel()
	{
		return pausePanel;
	}
	
	/**
	 * Method to add component into frame
	 * @param c compponent
	 */
	public void add(Component c)
	{
		frame.add(c);
	}
	
	/**
	 * Method to set selectLevel to the new SelectLevelPanel() 
	 * to let the player can load different name when they play game.
	 */
	public void setSelectLevelPanel()
	{
		this.selectLevelPanel = new SelectLevelPanel();
	}
	
	/**
	 * Method to set the player Panel.
	 */
	public void setPlayerPanel()
	{
		this.playerPanel = new PlayerPanel();
	}
	
	/**
	 * Method to setLeaderBoard.
	 */
	public void setLeaderBoardPanel()
	{
		this.leaderboardPanel = new LeaderboardPanel();
	}
	
	/**
	 * Method to set leaderBoardInPausePanel.
	 */
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
