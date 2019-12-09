package edu.sjsu.cs151.tetris.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;

/**
 * Class that contains all panel classes
 * @author Luksawee
 * @author Nick
 */
public class View
{
	/**
	 * The constructor of the View
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
	 * Method to return frame
	 * @return frame the current frame
	 */
	public JFrame getFrame()
	{
		return frame;
	}
	
	/**
	 * Method to return the welcome panel
	 * @return welcomePanel the welcome panel
	 */
	public WelcomePanel getWelcomePanel()
	{
		return welcomePanel;
	}
	
	/**
	 * Method to return the main panel
	 * @return mainPanel the main panel
	 */
	public MainPanel getMainPanel()
	{
		return mainPanel;
	}
	
	/**
	 * Method to return the player panel
	 * @return playerPanel the player panel
	 */
	public PlayerPanel getPlayerPanel()
	{
		return playerPanel;
	}
	
	/**
	 * Method to return the level select panel
	 * @return selectPanel the level select panel
	 */
	public SelectLevelPanel getSelectLevelPanel()
	{
		return selectLevelPanel;
	}
	
	/**
	 * Method to return the leaderboard panel
	 * @return leaderboardPanel the leaderboard panel
	 */
	public LeaderboardPanel getLeaderboardPanel()
	{
		return leaderboardPanel;
	}
	
	/**
	 * Method to return the quit panel
	 * @return quitPanel the quit panel
	 */
	public QuitPanel getQuitPanel()
	{
		return quitPanel;
	}
	
	/**
	 * Method to return the in-game panel
	 * @return inGamePanel the in-game panel
	 */
	public InGamePanel getInGamePanel()
	{
		return inGamePanel;
	}
	
	/**
	 * Method to return the game over panel
	 * @return gameOverPanel the game over panel
	 */
	public GameOverPanel getGameOverPanel()
	{
		return gameOverPanel;
	}
	
	/**
	 * Method to return the controls panel
	 * @return controlsPanel the controls panel
	 */
	public ControlsPanel getControlsPanel()
	{

		return controlsPanel;
	}
	
	/**
	 * Method to return the pause menu leaderboard panel
	 * @return leaderboardInPausePanel the pause menu leaderboard panel
	 */ 
	public LeaderboardInPausePanel getLeaderboardInPausePanel()
	{
		return leaderboardInPausePanel;
	}
	
	/**
	 * Method to return the pause panel
	 * @return pausePanel the pause panel
	 */
	public PausePanel getPausePanel()
	{
		return pausePanel;
	}
	
	/**
	 * Method to add a component into frame
	 * @param c the desired component
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
	 * Method to set the pause menu leaderboard panel
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
