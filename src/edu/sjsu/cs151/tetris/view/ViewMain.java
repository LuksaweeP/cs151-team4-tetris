package edu.sjsu.cs151.tetris.view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.concurrent.BlockingQueue;

import javax.swing.JButton;

import edu.sjsu.cs151.tetris.controller.GameInfo;
import edu.sjsu.cs151.tetris.controller.Message;

/**
 *  View class has 2 queues to communicate with controller.
 *  This class gets the interaction from the player and stores the data in order to redraw the BoardGamePanel.
 *  @author Luksawee
 *  @author Nick
 */
public class ViewMain implements Runnable
{
	/**
	 * The main View constructor
	 */
	public ViewMain()
	{
		view = new View();
		
		colors = new Color[20][10];
		for(int i=0; i < 20; ++i)
			for(int j=0; j < 10; ++j)
				colors[i][j] = Color.DARK_GRAY;
		
		panel = new BoardGamePanel(colors);
		panel.setVisible(true);
		
		gameInfo = new GameInfo();
		
		actionListenner();
		
	}
	
	/**
	 * Method to add action listener to each button.
	 */
	public void actionListenner()
	{
		// Add action Listener to each JButton.
		// WelcomePanel
		view.getFrame().add(view.getWelcomePanel().getWelcomePanel());	
		view.getFrame().setVisible(true);
		
		// welcomeButton
		view.getWelcomePanel().getWelcomeButton().addActionListener(event -> view.getFrame().remove(view.getWelcomePanel().getWelcomePanel()));		
		view.getWelcomePanel().getWelcomeButton().addActionListener(event -> view.getFrame().add(view.getMainPanel().getMainPanel()));		
		view.getWelcomePanel().getWelcomeButton().addActionListener(event -> view.getFrame().pack());

		// MainPanel
		// playgameButton
		view.getMainPanel().getPlaygameButtun().addActionListener(event -> view.getFrame().remove(view.getMainPanel().getMainPanel()));	
		view.getMainPanel().getPlaygameButtun().addActionListener(event -> view.getFrame().add(view.getPlayerPanel().getPlayerPanel()));
		view.getMainPanel().getPlaygameButtun().addActionListener(event -> view.getFrame().repaint());
		view.getMainPanel().getPlaygameButtun().addActionListener(event -> view.getFrame().setSize(600, 800));
		view.getMainPanel().getPlaygameButtun().addActionListener(event -> view.getFrame().pack());
		
		//leaderboardButton
		view.getMainPanel().getLeaderboardsButton().addActionListener(event -> view.getFrame().remove(view.getMainPanel().getMainPanel()));
		view.getMainPanel().getLeaderboardsButton().addActionListener(event -> view.add(view.getLeaderboardPanel().getLeaderboardPanel()));
		view.getMainPanel().getLeaderboardsButton().addActionListener(event -> view.getFrame().repaint());
		view.getMainPanel().getLeaderboardsButton().addActionListener(event -> view.getFrame().setSize(600, 800));
		view.getMainPanel().getLeaderboardsButton().addActionListener(event -> view.getFrame().pack());
		
		//quit
		view.getMainPanel().getQuitButton().addActionListener(event -> view.getFrame().remove(view.getMainPanel().getMainPanel()));
		view.getMainPanel().getQuitButton().addActionListener(event -> view.getFrame().add(view.getQuitPanel().getQuitPane()));
		view.getMainPanel().getQuitButton().addActionListener(event -> view.getFrame().repaint());
		view.getMainPanel().getQuitButton().addActionListener(event -> view.getFrame().setSize(600, 800));
		view.getMainPanel().getQuitButton().addActionListener(event -> view.getFrame().pack());
		
		// PlayerPanel
		// createButton
		view.getPlayerPanel().getCreateButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = view.getPlayerPanel().getInputBox().getText();
				System.out.println(input);
				
				
				boolean validname = gameInfo.getModel().getLeaderboard().isValidNewPlayers(input);
				System.out.println(validname);
				
				if(validname)
				{
					gameInfo.getModel().getLeaderboard().addNewPlayer(input);
					gameInfo.getModel().getLeaderboard().loadPlayer(input);
					gameInfo.getModel().getGameRule().setLevel(1);
					
					view.getInGamePanel().setPlayerInGamePanel(input);
					view.getInGamePanel().setLabelName(input);	
					view.getInGamePanel().getBoardGamePanel().setPlayerName(input);
					
					view.getInGamePanel().setLevelLabel(Integer.toString(1));
					view.getInGamePanel().getBoardGamePanel().setLevel(1);
					
					view.getInGamePanel().setScoreLabel(Integer.toString(0));
					view.getInGamePanel().getBoardGamePanel().setScores(0);
					
					view.getInGamePanel().setGameStart(true);
					view.getFrame().remove(view.getPlayerPanel().getPlayerPanel());
					view.getFrame().add(view.getInGamePanel().getInGamePanel());
					view.getInGamePanel().getInGamePanel().setFocusable(true);
					view.getInGamePanel().getInGamePanel().requestFocusInWindow();
					view.getFrame().pack();
					view.getFrame().setSize(800, 890);
					view.getFrame().repaint();		
					view.getFrame().setVisible(true);
				}
				
				if(!validname)
				{
					view.getPlayerPanel().getInputBox().setText("INVALID NAME");
					view.getPlayerPanel().getInputBox().addMouseListener(new MouseAdapter(){
			            @Override
			            public void mouseClicked(MouseEvent e){
			            	view.getPlayerPanel().getInputBox().setText("");
			            }
			        });
				}
			}
		});
		
		// loadPlayer
		int numberOfLoadPlayer = view.getPlayerPanel().getExistPlayerButton().length;
		for(int i = 0; i < numberOfLoadPlayer; i++)
		{
			view.getPlayerPanel().getExistPlayerButton()[i].addMouseListener(new MouseAdapter()
			{
				public void mousePressed(MouseEvent e)
				{
					Object o = e.getSource();
					JButton pressedButton = (JButton) o;
					String text = pressedButton.getText();
					
					view.getInGamePanel().setPlayerInGamePanel(text);
					view.getInGamePanel().setScoreLabel(Integer.toString(gameInfo.getModel().getGameRule().getScores()));
					view.getInGamePanel().getBoardGamePanel().setScores(gameInfo.getModel().getGameRule().getScores());
					view.getInGamePanel().setLabelName(text);
					
					gameInfo.getModel().getLeaderboard().loadPlayer(text);
					
					view.getPlayerPanel().setLoadPlayer(gameInfo.getModel().getLeaderboard().loadPlayer(text));			
					view.setSelectLevelPanel();					
					
					view.getFrame().remove(view.getPlayerPanel().getPlayerPanel());		
					view.getFrame().add(view.getSelectLevelPanel().getSelectLevelPanel());
					view.getFrame().repaint();
					//view.getFrame().pack();
					view.getFrame().setVisible(true);
					
					// InGamePanel
					//case select level unlock
					for(int i = 1; i <= 5; i++)
					{
						if(gameInfo.getModel().getLeaderboard().loadPlayer(text).isLevelUnlocked(i) == true)
						{
							String selectLevel = Integer.toString(i);
							int level = i;
							
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getInGamePanel().getBoardGamePanel().setPlayerName(gameInfo.getModel().getLeaderboard().loadPlayer(text).getName()));
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getInGamePanel().getBoardGamePanel().setLevel(level));
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getInGamePanel().getBoardGamePanel().setLevel(gameInfo.getModel().getGameRule().getLevel()));
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> gameInfo.getModel().getGameRule().setLevel(level));
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getInGamePanel().setLevelLabel(selectLevel));
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getInGamePanel().setGameStart(true));
							
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getFrame().remove(view.getSelectLevelPanel().getSelectLevelPanel()));
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getFrame().setSize(800, 890));							
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getFrame().add(view.getInGamePanel().getInGamePanel()));	
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getInGamePanel().getInGamePanel().requestFocusInWindow());
							
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getInGamePanel().getInGamePanel().setFocusable(true));
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getFrame().repaint());	
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getFrame().pack());
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getFrame().setVisible(true));	
							
						}
					}		
				}	
		});		
		}
		
		// back
		view.getPlayerPanel().getBackButton().addActionListener(event -> view.getFrame().remove(view.getPlayerPanel().getPlayerPanel()));
		view.getPlayerPanel().getBackButton().addActionListener(event -> view.getFrame().add(view.getMainPanel().getMainPanel()));	
		view.getPlayerPanel().getBackButton().addActionListener(event -> view.getFrame().setSize(600, 800));
		view.getPlayerPanel().getBackButton().addActionListener(event -> view.getFrame().repaint());
		view.getPlayerPanel().getBackButton().addActionListener(event -> view.getFrame().pack());
		
		// LeaderboardPanel
		view.getLeaderboardPanel().getBackButton().addActionListener(event -> view.getFrame().remove(view.getLeaderboardPanel().getLeaderboardPanel()));
		view.getLeaderboardPanel().getBackButton().addActionListener(event -> view.getFrame().add(view.getMainPanel().getMainPanel()));	
		view.getLeaderboardPanel().getBackButton().addActionListener(event -> view.getFrame().repaint());
		view.getLeaderboardPanel().getBackButton().addActionListener(event -> view.getFrame().setSize(600, 800));	
		view.getLeaderboardPanel().getBackButton().addActionListener(event -> view.getFrame().pack());
		
		// QuitPanel
		// no
		view.getQuitPanel().getNo().addActionListener(event -> view.getFrame().remove(view.getQuitPanel().getQuitPane()));
		view.getQuitPanel().getNo().addActionListener(event -> view.getFrame().setSize(600, 800));
		view.getQuitPanel().getNo().addActionListener(event -> view.getFrame().add(view.getMainPanel().getMainPanel()));
		view.getQuitPanel().getNo().addActionListener(event -> view.getFrame().repaint());	
		view.getQuitPanel().getNo().addActionListener(event -> view.getFrame().pack());
		
		// yes
		view.getQuitPanel().getYes().addActionListener(event -> view.getFrame().dispatchEvent(new WindowEvent(view.getFrame(), WindowEvent.WINDOW_CLOSING)));
		
		
		// InGamePanel
		view.getInGamePanel().getInGamePanel().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {

				// Case press esc to pause the game
				case KeyEvent.VK_ESCAPE:	
					view.getInGamePanel().setGameStart(false);
					view.getFrame().remove(view.getInGamePanel().getInGamePanel());
					view.getFrame().add(view.getPausePanel().getPausePanel());
					view.getFrame().repaint();
					view.getFrame().setSize(600, 800);	
					view.getFrame().pack();
					break;
				
				case KeyEvent.VK_LEFT:
					message = new Message(Message.ValveResponse.MOVE_LEFT);
					try 
					{
						viewToControllerQueue.put(message);
					} 
					catch (InterruptedException e1) {}
					break;
					
				case KeyEvent.VK_RIGHT:
					message = new Message(Message.ValveResponse.MOVE_RIGHT);
					try 
					{
						viewToControllerQueue.put(message);
					} 
					catch (InterruptedException e1) {}
					break;
				
				case KeyEvent.VK_Z:
					message = new Message(Message.ValveResponse.ROTATE_LEFT);
					
					try 
					{
						viewToControllerQueue.put(message);
					} 
					catch (InterruptedException e1) {}
					break;
				
				case KeyEvent.VK_SPACE:
					message = new Message(Message.ValveResponse.FASTER);
					
					try 
					{
						viewToControllerQueue.put(message);
					} 
					catch (InterruptedException e1) {}
					break;
				
				case KeyEvent.VK_ENTER:
					if(lost)
					{
						view.getInGamePanel().setGameStart(true);
						view.getInGamePanel().getBoardGamePanel().setLost(false);
						lost = false;
						message = new Message(Message.ValveResponse.RESTART);
						try 
						{
							viewToControllerQueue.put(message);
						} 
						catch (InterruptedException e1) {}
					}
					
					if(winLevel)
					{
						view.getInGamePanel().setGameStart(true);
						view.getInGamePanel().getBoardGamePanel().setWinLevel(false);
						winLevel = false;
						message = new Message(Message.ValveResponse.GET_NEXTLEVEL);
						try 
						{
							viewToControllerQueue.put(message);
						} 
						catch (InterruptedException e1) {}
					}
					
					break;		
				}
			}
			public void keyReleased(KeyEvent e) {}
		});
		
		// PausePanel
		// back
		view.getPausePanel().getBack().addActionListener(event -> view.getInGamePanel().setGameStart(true));
		view.getPausePanel().getBack().addActionListener(event -> view.getFrame().remove(view.getPausePanel().getPausePanel()));
		view.getPausePanel().getBack().addActionListener(event -> view.getFrame().setSize(800, 890));	
		view.getPausePanel().getBack().addActionListener(event -> view.getFrame().add(view.getInGamePanel().getInGamePanel()));
		view.getPausePanel().getBack().addActionListener(event -> view.getFrame().repaint());
		view.getPausePanel().getBack().addActionListener(event -> view.getFrame().pack());
				
		// LeaderBoardInPausePanel
		view.getPausePanel().getLeaderboardsButton().addActionListener(event -> view.getFrame().remove(view.getPausePanel().getPausePanel()));
		view.getPausePanel().getLeaderboardsButton().addActionListener(event -> view.getFrame().add(view.getLeaderboardInPausePanel().getLeaderboardPanel()));
		view.getPausePanel().getLeaderboardsButton().addActionListener(event -> view.getFrame().repaint());
		view.getPausePanel().getLeaderboardsButton().addActionListener(event -> view.getFrame().setSize(600, 800));	
		view.getPausePanel().getLeaderboardsButton().addActionListener(event -> view.getFrame().pack());
		
		// ControlsPanel
		view.getPausePanel().getControlsButton().addActionListener(event -> view.getFrame().remove(view.getPausePanel().getPausePanel()));
		view.getPausePanel().getControlsButton().addActionListener(event -> view.getFrame().add(view.getControlsPanel().getControlsPanel()));
		view.getPausePanel().getControlsButton().addActionListener(event -> view.getFrame().repaint());
		view.getPausePanel().getControlsButton().addActionListener(event -> view.getFrame().setSize(600, 800));	
		view.getPausePanel().getControlsButton().addActionListener(event -> view.getFrame().pack());
			
		view.getPausePanel().getReturnToMainManuButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{				
				message = new Message(Message.ValveResponse.GET_NEWGAME);
			
				try 
				{
					viewToControllerQueue.put(message);
				} 
				catch (InterruptedException e1) {}
				
				view.getFrame().remove(view.getPausePanel().getPausePanel());
				view.getFrame().add(view.getMainPanel().getMainPanel());	
				view.getFrame().pack();
				view.getFrame().setSize(600, 800);	
				view.getFrame().repaint();
				
				//viewAllPanels.getFrame().pack();
			}
		});
		
		
		// LeaderboardInGame
		view.getLeaderboardInPausePanel().getBackButton().addActionListener(Event -> view.getFrame().remove(view.getLeaderboardInPausePanel().getLeaderboardPanel()));
		view.getLeaderboardInPausePanel().getBackButton().addActionListener(event -> view.getFrame().add(view.getPausePanel().getPausePanel()));	
		view.getLeaderboardInPausePanel().getBackButton().addActionListener(event -> view.getFrame().repaint());
		view.getLeaderboardInPausePanel().getBackButton().addActionListener(event -> view.getFrame().setSize(600, 800));	
		view.getLeaderboardInPausePanel().getBackButton().addActionListener(event -> view.getFrame().pack());
			
		// ControlPanel
		view.getControlsPanel().getBack().addActionListener(event -> view.getFrame().remove(view.getControlsPanel().getControlsPanel()));
		view.getControlsPanel().getBack().addActionListener(event -> view.getFrame().add(view.getPausePanel().getPausePanel()));	
		view.getControlsPanel().getBack().addActionListener(event -> view.getFrame().repaint());
		view.getControlsPanel().getBack().addActionListener(event -> view.getFrame().setSize(600, 800));	
		view.getControlsPanel().getBack().addActionListener(event -> view.getFrame().pack());
	}
	
	/**
	 * Method to get viewAllPanels
	 * @return view the view
	 */
	public View getViewAllPanels()
	{
		return view;
	}
	
	/**
	 * Method to set controller to the view queue
	 * @param c BlockingQueue used to receiving requests from Controller and TimeController
	 */
	public void setControllerToViewQueue(BlockingQueue<Message> c) 
	{
		controllerToViewQueue = c;
    }

	/**
	 * Method to set the view to the controller queue
	 * @param v Blocking Queue used to sending requests to Controller
	 */
    public void setViewToControllerQueue(BlockingQueue<Message> v) 
    {
        viewToControllerQueue = v;
    }
	
    /**
     * Runnable method to handle the view
     */
	public void run()
	{
		try 
		{
			while (lost != true)
			{
				System.out.print("");
				while (view.getInGamePanel().getGameStart() == true)
				{
					loop();
				}
			}
		}
		catch (Exception exception) 
		{
		}
	}
	
	/**
	 * Loop that performs Controller and TimeController requests.
	 */
	private void loop() throws InterruptedException
	{
		Message message;
		try
		{
			while(true)
			{
				/* Checking a queue */
					message = controllerToViewQueue.take();
					if(message == null)
					{
						continue;
					}
					
					switch(message.getValveResponse())
					{
						case REDRAW:
							redraw(message.getData());
							break;
					
						case CHANGE_NEXT: 
							view.getInGamePanel().getBoardGamePanel().setNext(message.getAdd());
							break;
						
						case SCORES_UPDATE:
							view.getInGamePanel().getBoardGamePanel().setScores(message.getAdd());
							view.getInGamePanel().setScoreLabel(Integer.toString(message.getAdd()));
							break;
							
						case LEVEL_UPDATE:
							view.getInGamePanel().setLevelLabel(Integer.toString(message.getAdd()));
							view.getInGamePanel().getBoardGamePanel().setLevel(message.getLevel());
							break;	
							
						case LOST:
							lost = true;
							view.getInGamePanel().getBoardGamePanel().setLost(lost);
							view.getInGamePanel().setGameStart(false);
							break;
							
						case WIN:
							winLevel = true;
							view.getInGamePanel().getBoardGamePanel().setWinLevel(winLevel);
							view.getInGamePanel().setGameStart(false);
							break;
							
						case GET_NEWGAME:
							lost = true;
							view.getInGamePanel().getBoardGamePanel().setLost(lost);
							view.getInGamePanel().setGameStart(false);
							break;
							
						case INFO_UPDATE:
							lost = false;
							view.getInGamePanel().getBoardGamePanel().setLost(lost);
							view.getInGamePanel().setGameStart(true);
							
							view.getInGamePanel().getBoardGamePanel().setScores(message.getAdd());
							view.getInGamePanel().getBoardGamePanel().setLevel(message.getLevel());
							
							view.getInGamePanel().setScoreLabel(Integer.toString(message.getAdd()));
							view.getInGamePanel().setLevelLabel(Integer.toString(message.getLevel()));
							break;

						default: 
							break;
					}
				}
			}
		
				catch (InterruptedException e) 
				{
				}
	}
	
	/**
     * This method replace the figure id by adequate java.awt.Color. After doing this, it call redraw method from Panel and pass there
     * as a parameter two dimensional array of java.awt.Color objects.
     * @param board	two dimensional array of data (int values which are figures id).
     */
	public void redraw(int [][] board)
	{
		for(int i = 0; i < 20; ++i)
		{
			for( int j = 0; j < 10; ++j)
			{
				switch (board[i][j])
				{
					//empty
					case 0:	colors[i][j] = Color.GRAY; 
						break;
					//J - shape
					case 1:	colors[i][j] = Color.BLUE; 
						break;
					//Z shape
					case 2:	colors[i][j] = Color.RED; 
						break;
					//L shape
					case 3:	colors[i][j] = Color.ORANGE; 
						break;
					//S shape
					case 4:	colors[i][j] = new Color(102,255,102);  ;
						break;
					//I shape
					case 5:	colors[i][j] = Color.CYAN; 
						break;
					//O shape
					case 6:	colors[i][j] = Color.YELLOW; 
						break;
					//T shape
					case 7:	colors[i][j] = Color.PINK; 
						break;	
				}
			}
		}
		view.getInGamePanel().getBoardGamePanel().redraw(colors);	
	}
	
	/** 
	 * Method to set lost game
	 * @param lost the lost boolean value
	 */
	public void setLost(boolean lost)
	{
		this.lost = lost;
	}
	
	/**
	 * Method to set win level
	 * @param winLevel the boolean value for win
	 */
	public void setWinLevel(boolean winLevel)
	{
		this.winLevel = winLevel;
	}
	
	private boolean lost = false;
	private Color [][] colors;
	private BlockingQueue <Message> controllerToViewQueue;
	private BlockingQueue <Message> viewToControllerQueue;
	private View view;
	private Message message;
	private BoardGamePanel panel;
	private boolean winLevel = false;
	private GameInfo gameInfo;
}		