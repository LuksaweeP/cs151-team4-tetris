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
import javax.swing.JFrame;

import edu.sjsu.cs151.tetris.controller.Message;
import edu.sjsu.cs151.tetris.model.Model;
import edu.sjsu.cs151.tetris.model.Player;

/**
 *  View class has 2 queues to communicate with controller.
 *  This class get the interaction from the player and store the data in order to redraw the BoardGamePanel.
*/
public class View implements Runnable
{
	public View()
	{
		viewAllPanels = new ViewAllPanels();
		
		colors = new Color[20][10];
		for(int i=0; i < 20; ++i)
			for(int j=0; j < 10; ++j)
				colors[i][j] = Color.DARK_GRAY;
		
		BoardGamePanel panel = new BoardGamePanel(colors);
		panel.setVisible(true);
		
		model = new Model();
		
		/**
		 * Add action Listener to each JButton.
		 */
		/**
		 * WelcomePanel
		 */
		viewAllPanels.getFrame().add(viewAllPanels.getWelcomePanel().getWelcomePanel());
		viewAllPanels.getFrame().setVisible(true);

		/**
		 * MainPanel
		 */
		//welcomeButton
		viewAllPanels.getWelcomePanel().getWelcomeButton().addActionListener(event -> viewAllPanels.getFrame().remove(viewAllPanels.getWelcomePanel().getWelcomePanel()));		
		viewAllPanels.getWelcomePanel().getWelcomeButton().addActionListener(event -> viewAllPanels.getFrame().add(viewAllPanels.getMainPanel().getMainPanel()));		
		viewAllPanels.getWelcomePanel().getWelcomeButton().addActionListener(event -> viewAllPanels.getFrame().pack());		
		
		// playgameButton
		viewAllPanels.getMainPanel().getPlaygameButtun().addActionListener(event -> viewAllPanels.getFrame().remove(viewAllPanels.getMainPanel().getMainPanel()));	
		viewAllPanels.getMainPanel().getPlaygameButtun().addActionListener(event -> viewAllPanels.getFrame().add(viewAllPanels.getPlayerPanel().getPlayerPanel()));
		viewAllPanels.getMainPanel().getPlaygameButtun().addActionListener(event -> viewAllPanels.getFrame().repaint());
		viewAllPanels.getMainPanel().getPlaygameButtun().addActionListener(event -> viewAllPanels.getFrame().setSize(600, 800));
		viewAllPanels.getMainPanel().getPlaygameButtun().addActionListener(event -> viewAllPanels.getFrame().pack());

		
		//leaderboardButton
		viewAllPanels.getMainPanel().getLeaderboardsButton().addActionListener(event -> viewAllPanels.getFrame().remove(viewAllPanels.getMainPanel().getMainPanel()));
		viewAllPanels.getMainPanel().getLeaderboardsButton().addActionListener(event -> viewAllPanels.add(viewAllPanels.getLeaderboardPanel().getLeaderboardPanel()));
		viewAllPanels.getMainPanel().getLeaderboardsButton().addActionListener(event -> viewAllPanels.getFrame().repaint());
		viewAllPanels.getMainPanel().getLeaderboardsButton().addActionListener(event -> viewAllPanels.getFrame().setSize(600, 800));
		viewAllPanels.getMainPanel().getLeaderboardsButton().addActionListener(event -> viewAllPanels.getFrame().pack());
		
		//quit
		viewAllPanels.getMainPanel().getQuitButton().addActionListener(event -> viewAllPanels.getFrame().remove(viewAllPanels.getMainPanel().getMainPanel()));
		viewAllPanels.getMainPanel().getQuitButton().addActionListener(event -> viewAllPanels.getFrame().add(viewAllPanels.getQuitPanel().getQuitPane()));
		viewAllPanels.getMainPanel().getQuitButton().addActionListener(event -> viewAllPanels.getFrame().repaint());
		viewAllPanels.getMainPanel().getQuitButton().addActionListener(event -> viewAllPanels.getFrame().setSize(600, 800));
		viewAllPanels.getMainPanel().getQuitButton().addActionListener(event -> viewAllPanels.getFrame().pack());
		
		/**
		 * PlayerPanel
		 */
		//createButton
		viewAllPanels.getPlayerPanel().getCreateButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = viewAllPanels.getPlayerPanel().getInputBox().getText();
				System.out.println(input);
				
				boolean validname = model.getLeaderboard().isValidNewPlayers(input);
				if(validname)
				{
					model.getLeaderboard().addNewPlayer(input);
					model = new Model();
					model.getLeaderboard().loadPlayer(input);
					
					viewAllPanels.getInGamePanel().setPlayerInGamePanel(input);
					viewAllPanels.getInGamePanel().setLevelLabel("0");
					viewAllPanels.getInGamePanel().setScoreLabel("0");
					viewAllPanels.getInGamePanel().setLabelName(input);
					
					viewAllPanels.getInGamePanel().setGameStart(true);
					viewAllPanels.getFrame().remove(viewAllPanels.getPlayerPanel().getPlayerPanel());
					viewAllPanels.getFrame().add(viewAllPanels.getInGamePanel().getInGamePanel());
					viewAllPanels.getInGamePanel().getInGamePanel().setFocusable(true);
					viewAllPanels.getInGamePanel().getInGamePanel().requestFocusInWindow();
					viewAllPanels.getFrame().repaint();
					viewAllPanels.getFrame().pack();
					viewAllPanels.getFrame().setVisible(true);
				}
				
				if(!validname)
				{
					viewAllPanels.getPlayerPanel().getInputBox().setText("INVALID NAME");
					viewAllPanels.getPlayerPanel().getInputBox().addMouseListener(new MouseAdapter(){
			            @Override
			            public void mouseClicked(MouseEvent e){
			            	viewAllPanels.getPlayerPanel().getInputBox().setText("");
			            }
			        });
				}
			}
		});
		
		//loadPlayer
		int numberOfLoadPlayer = viewAllPanels.getPlayerPanel().getExistPlayerButton().length;
		for(int i = 0; i < numberOfLoadPlayer; i++)
		{
			viewAllPanels.getPlayerPanel().getExistPlayerButton()[i].addMouseListener(new MouseAdapter()
			{
				public void mousePressed(MouseEvent e)
				{
					Object o = e.getSource();
					JButton pressedButton = (JButton) o;
					String text = pressedButton.getText();
					
					viewAllPanels.getInGamePanel().setPlayerInGamePanel(text);
					viewAllPanels.getInGamePanel().setScoreLabel("0");
					viewAllPanels.getInGamePanel().setLabelName(text);
					
					Player loadPlayer = model.getLeaderboard().loadPlayer(text);
					System.out.println("Load Player:  " + loadPlayer.getName());
					System.out.println("highScore: " + loadPlayer.getPlayerHighScore());
					
					viewAllPanels.getPlayerPanel().setLoadPlayer(loadPlayer);			
					viewAllPanels.setSelectLevelPanel();					
					
					viewAllPanels.getFrame().remove(viewAllPanels.getPlayerPanel().getPlayerPanel());		
					viewAllPanels.getFrame().add(viewAllPanels.getSelectLevelPanel().getSelectLevelPanel());
					viewAllPanels.getFrame().repaint();
					viewAllPanels.getFrame().setSize(600, 800);
					viewAllPanels.getFrame().pack();
					
					/**
					 * InGamePanel
					 */
					//case select level unlock
					for(int i = 1; i < 5; i++)
					{
						if(loadPlayer.isLevelUnlocked(i) == true)
						{
							String selectLevel = Integer.toString(i);
							viewAllPanels.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> viewAllPanels.getInGamePanel().setLevelLabel(selectLevel));
							viewAllPanels.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> viewAllPanels.getInGamePanel().setGameStart(true));
							viewAllPanels.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> viewAllPanels.getFrame().remove(viewAllPanels.getSelectLevelPanel().getSelectLevelPanel()));
							
							viewAllPanels.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> viewAllPanels.getFrame().add(viewAllPanels.getInGamePanel().getInGamePanel()));	
							viewAllPanels.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> viewAllPanels.getInGamePanel().getInGamePanel().requestFocusInWindow());
							viewAllPanels.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> viewAllPanels.getInGamePanel().getInGamePanel().setFocusable(true));
							viewAllPanels.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> viewAllPanels.getInGamePanel().getBoardGamePanel().requestFocusInWindow());
							viewAllPanels.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> viewAllPanels.getInGamePanel().getBoardGamePanel().setFocusable(true));
							viewAllPanels.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> viewAllPanels.getFrame().repaint());	
							viewAllPanels.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> viewAllPanels.getFrame().pack());
							viewAllPanels.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> viewAllPanels.getFrame().setVisible(true));
							
						}
					}		
				}	
		});		
		}
		
		//back
		viewAllPanels.getPlayerPanel().getBackButton().addActionListener(event -> viewAllPanels.getFrame().remove(viewAllPanels.getPlayerPanel().getPlayerPanel()));
		viewAllPanels.getPlayerPanel().getBackButton().addActionListener(event -> viewAllPanels.getFrame().add(viewAllPanels.getMainPanel().getMainPanel()));	
		viewAllPanels.getPlayerPanel().getBackButton().addActionListener(event -> viewAllPanels.getFrame().repaint());
		viewAllPanels.getPlayerPanel().getBackButton().addActionListener(event -> viewAllPanels.getFrame().setSize(600, 800));	
		viewAllPanels.getPlayerPanel().getBackButton().addActionListener(event -> viewAllPanels.getFrame().pack());
		
		/**
		 * LeaderboardPanel
		 */
		viewAllPanels.getLeaderboardPanel().getBackButton().addActionListener(event -> viewAllPanels.getFrame().remove(viewAllPanels.getLeaderboardPanel().getLeaderboardPanel()));
		viewAllPanels.getLeaderboardPanel().getBackButton().addActionListener(event -> viewAllPanels.getFrame().add(viewAllPanels.getMainPanel().getMainPanel()));	
		viewAllPanels.getLeaderboardPanel().getBackButton().addActionListener(event -> viewAllPanels.getFrame().repaint());
		viewAllPanels.getLeaderboardPanel().getBackButton().addActionListener(event -> viewAllPanels.getFrame().setSize(600, 800));	
		viewAllPanels.getLeaderboardPanel().getBackButton().addActionListener(event -> viewAllPanels.getFrame().pack());
		
		/**
		 * QuitPanel
		 */
		//no
		viewAllPanels.getQuitPanel().getNo().addActionListener(event -> viewAllPanels.getFrame().remove(viewAllPanels.getQuitPanel().getQuitPane()));
		viewAllPanels.getQuitPanel().getNo().addActionListener(event -> viewAllPanels.getFrame().add(viewAllPanels.getMainPanel().getMainPanel()));
		viewAllPanels.getQuitPanel().getNo().addActionListener(event -> viewAllPanels.getFrame().repaint());
		viewAllPanels.getQuitPanel().getNo().addActionListener(event -> viewAllPanels.getFrame().pack());
		
		//yes
		viewAllPanels.getQuitPanel().getYes().addActionListener(event -> viewAllPanels.getFrame().dispatchEvent(new WindowEvent(viewAllPanels.getFrame(), WindowEvent.WINDOW_CLOSING)));
		
		
		/**
		 * InGamePanel
		 */	
		viewAllPanels.getInGamePanel().getInGamePanel().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {

				/*
				 *Case press esc to pause the game
				 */
				case KeyEvent.VK_ESCAPE:	
					
					viewAllPanels.getFrame().remove(viewAllPanels.getInGamePanel().getInGamePanel());
					viewAllPanels.getFrame().add(viewAllPanels.getPausePanel().getPausePanel());
					viewAllPanels.getFrame().repaint();
					viewAllPanels.getFrame().setSize(600, 800);	
					viewAllPanels.getFrame().pack();
					break;
				
				case KeyEvent.VK_LEFT:
					message = new Message(Message.ValveResponse.MOVE_LEFT);
					
					try 
					{
						System.out.println(message.getValveResponse());
						viewToControllerQueue.put(message);
					} 
					catch (InterruptedException e1) {}
					break;
					
				case KeyEvent.VK_RIGHT:
					message = new Message(Message.ValveResponse.MOVE_RIGHT);
					
					try 
					{
						System.out.println(message.getValveResponse());
						viewToControllerQueue.put(message);
					} 
					catch (InterruptedException e1) {}
					break;
				
				case KeyEvent.VK_Z:
					message = new Message(Message.ValveResponse.ROTATE_LEFT);
					
					try 
					{
						System.out.println(message.getValveResponse());
						viewToControllerQueue.put(message);
					} 
					catch (InterruptedException e1) {}
					break;
				
				case KeyEvent.VK_SPACE:
					message = new Message(Message.ValveResponse.FASTER);
					
					try 
					{
						System.out.println(message.getValveResponse());
						System.out.println("FASTER ");
						viewToControllerQueue.put(message);
					} 
					catch (InterruptedException e1) {}
					break;
				
				case KeyEvent.VK_ENTER:
					System.out.println("LOST CASE");
					if(lost) 
					{
						viewAllPanels.getInGamePanel().setGameStart(true);
						lost = false;
						view.getViewAllPanels().getInGamePanel().setLost(lost);
						message = new Message(Message.ValveResponse.RESTART);
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
		
		/**
		 * PausePanel
		 */
		//back
		viewAllPanels.getPausePanel().getBack().addActionListener(event -> viewAllPanels.getInGamePanel().setGameStart(true));
		viewAllPanels.getPausePanel().getBack().addActionListener(event -> viewAllPanels.getFrame().remove(viewAllPanels.getPausePanel().getPausePanel()));
		viewAllPanels.getPausePanel().getBack().addActionListener(event -> viewAllPanels.getFrame().add(viewAllPanels.getInGamePanel().getInGamePanel()));
		viewAllPanels.getPausePanel().getBack().addActionListener(event -> viewAllPanels.getFrame().repaint());
		//viewAllPanels.getPausePanel().getBack().addActionListener(event -> viewAllPanels.getFrame().setSize(600, 800));	
		viewAllPanels.getPausePanel().getBack().addActionListener(event -> viewAllPanels.getFrame().pack());
				
		//LeaderBoardInPausePanel
		viewAllPanels.getPausePanel().getLeaderboardsButton().addActionListener(event -> viewAllPanels.getFrame().remove(viewAllPanels.getPausePanel().getPausePanel()));
		viewAllPanels.getPausePanel().getLeaderboardsButton().addActionListener(event -> viewAllPanels.getFrame().add(viewAllPanels.getLeaderboardInPausePanel().getLeaderboardPanel()));
		viewAllPanels.getPausePanel().getLeaderboardsButton().addActionListener(event -> viewAllPanels.getFrame().repaint());
		viewAllPanels.getPausePanel().getLeaderboardsButton().addActionListener(event -> viewAllPanels.getFrame().setSize(600, 800));	
		viewAllPanels.getPausePanel().getLeaderboardsButton().addActionListener(event -> viewAllPanels.getFrame().pack());
		
		//ControlsPanel
		viewAllPanels.getPausePanel().getControlsButton().addActionListener(event -> viewAllPanels.getFrame().remove(viewAllPanels.getPausePanel().getPausePanel()));
		viewAllPanels.getPausePanel().getControlsButton().addActionListener(event -> viewAllPanels.getFrame().add(viewAllPanels.getControlsPanel().getControlsPanel()));
		viewAllPanels.getPausePanel().getControlsButton().addActionListener(event -> viewAllPanels.getFrame().repaint());
		viewAllPanels.getPausePanel().getControlsButton().addActionListener(event -> viewAllPanels.getFrame().setSize(600, 800));	
		viewAllPanels.getPausePanel().getControlsButton().addActionListener(event -> viewAllPanels.getFrame().pack());
			
		//retrunToMainMnuButton
		viewAllPanels.getPausePanel().getReturnToMainManuButton().addActionListener(event -> viewAllPanels.getFrame().remove(viewAllPanels.getPausePanel().getPausePanel()));
		viewAllPanels.getPausePanel().getReturnToMainManuButton().addActionListener(event -> viewAllPanels.getFrame().add(viewAllPanels.getMainPanel().getMainPanel()));	
		viewAllPanels.getPausePanel().getReturnToMainManuButton().addActionListener(event -> viewAllPanels.getFrame().repaint());
		viewAllPanels.getPausePanel().getReturnToMainManuButton().addActionListener(event -> viewAllPanels.getFrame().setSize(600, 800));	
		viewAllPanels.getPausePanel().getReturnToMainManuButton().addActionListener(event -> viewAllPanels.getFrame().pack());
		
		/**
		 * LeaderboardInGame
		 */
		viewAllPanels.getLeaderboardInPausePanel().getBackButton().addActionListener(Event -> viewAllPanels.getFrame().remove(viewAllPanels.getLeaderboardInPausePanel().getLeaderboardPanel()));
		viewAllPanels.getLeaderboardInPausePanel().getBackButton().addActionListener(event -> viewAllPanels.getFrame().add(viewAllPanels.getPausePanel().getPausePanel()));	
		viewAllPanels.getLeaderboardInPausePanel().getBackButton().addActionListener(event -> viewAllPanels.getFrame().repaint());
		viewAllPanels.getLeaderboardInPausePanel().getBackButton().addActionListener(event -> viewAllPanels.getFrame().setSize(600, 800));	
		viewAllPanels.getLeaderboardInPausePanel().getBackButton().addActionListener(event -> viewAllPanels.getFrame().pack());
		
		
		/**
		 * ControlPanel
		 */
		
		viewAllPanels.getControlsPanel().getBack().addActionListener(event -> viewAllPanels.getFrame().remove(viewAllPanels.getControlsPanel().getControlsPanel()));
		viewAllPanels.getControlsPanel().getBack().addActionListener(event -> viewAllPanels.getFrame().add(viewAllPanels.getPausePanel().getPausePanel()));	
		viewAllPanels.getControlsPanel().getBack().addActionListener(event -> viewAllPanels.getFrame().repaint());
		viewAllPanels.getControlsPanel().getBack().addActionListener(event -> viewAllPanels.getFrame().setSize(600, 800));	
		viewAllPanels.getControlsPanel().getBack().addActionListener(event -> viewAllPanels.getFrame().pack());
		
	}
	
	public void setGameStart(boolean gameStart)
	{
		this.gameStart = gameStart;
	}

	public ViewAllPanels getViewAllPanels()
	{
		return viewAllPanels;
	}
	
	/**
	 * @param c BlockingQueue used to receiving requests from Controller and TimeController
	 */
	public void setControllerToViewQueue(BlockingQueue<Message> c) 
	{
		controllerToViewQueue = c;
    }

	/**
	 * @param v Blocking Queue used to sending requests to Controller
	 */
    public void setViewToControllerQueue(BlockingQueue<Message> v) 
    {
        viewToControllerQueue = v;
    }
	
	public void run()
	{
		try 
		{
			//System.out.println("VIEW: Try");
			while (lost != true)
			{
				System.out.print("");
				
				while (viewAllPanels.getInGamePanel().getGameStart() == true)
				{
					System.out.println("VIEW: RUN()");
					loop();
				}
			}
			
		}
		catch (Exception exception) 
		{
			System.out.println(exception);
		}
	}
	
	/**
	 * Loop that performs Controller and TimeController requests.
	 */
	private void loop() throws InterruptedException
	{
		Message message;
		System.out.println("VIEW: LOOP IN VIEW");
		try
		{
			while(true)
			{
				/* Checking a queue */
					message = controllerToViewQueue.take();
					if(message == null)
					{
						//System.out.println("VIEW: MESSAGE NULL");
						continue;
					}
					
					switch(message.getValveResponse())
					{
						case REDRAW:
							System.out.println("VIEW: REDRAW");
							redraw(message.getData());
							break;
					
						case CHANGE_NEXT: 
							//System.out.println("CIEW: SETNEXT");
							viewAllPanels.getInGamePanel().getBoardGamePanel().setNext(message.getAdd());
							break;
						
						case SCORES_UPDATE:
							//System.out.println("VIEW: SCORE");
							viewAllPanels.getInGamePanel().getBoardGamePanel().setScores(message.getAdd());
							break;
							
						case LOST:
							lost = true;
							//System.out.println("VIEW: LOST");
							viewAllPanels.getInGamePanel().getBoardGamePanel().setLost(lost);
							viewAllPanels.getInGamePanel().getBoardGamePanel().redraw();
							break;
							
						default: 
							//System.out.println("default");
							break;
					}
				}
			}
		
				
				catch (InterruptedException e) 
				{
					System.out.println(e);
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
					case 0:	colors[i][j] = Color.GRAY;
						break;
					case 1:	colors[i][j] = Color.BLUE;
						break;
					case 2:	colors[i][j] = Color.RED;
						break;
					case 3:	colors[i][j] = Color.ORANGE;
						break;
					case 4:	colors[i][j] = Color.GREEN;
						break;
					case 5:	colors[i][j] = Color.CYAN;
						break;
					case 6:	colors[i][j] = Color.YELLOW;
						break;
					case 7:	colors[i][j] = Color.PINK;
						break;	
				}
			}
		}
		//System.out.println("VIEW: REDRAW()");
		viewAllPanels.getInGamePanel().getBoardGamePanel().redraw(colors);
		
	}
	
	private boolean lost = false;
	private Color [][] colors;
	private BlockingQueue <Message> controllerToViewQueue;
	private BlockingQueue <Message> viewToControllerQueue;
	private ViewAllPanels viewAllPanels;
	private Message message;
	private Model model;
	private View view;
	private JFrame frame;
	
	
}		