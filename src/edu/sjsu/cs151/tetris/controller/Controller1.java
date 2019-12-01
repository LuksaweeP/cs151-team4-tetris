package edu.sjsu.cs151.tetris.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import edu.sjsu.cs151.tetris.model.*;
import edu.sjsu.cs151.tetris.view.*;



public class Controller1
{
	public Controller1(ViewAllPanels viewAllPanels, Model model)
	{
		this.viewAllPanels = viewAllPanels;
		this.model = model;
		updateGameInfo();
	}
	
	public void mainLoop()
	{

			
		
	}
	
	
	public void updateGameInfo()
	{
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
					
					viewAllPanels.getFrame().remove(viewAllPanels.getPlayerPanel().getPlayerPanel());
					viewAllPanels.getFrame().add(viewAllPanels.getInGamePanel().getInGamePanel());
					viewAllPanels.getInGamePanel().getInGamePanel().setFocusable(true);
					viewAllPanels.getInGamePanel().getInGamePanel().requestFocusInWindow();
					viewAllPanels.getFrame().repaint();
					//viewAllPanels.getFrame().setSize(600, 800);
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
							viewAllPanels.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> viewAllPanels.getFrame().remove(viewAllPanels.getSelectLevelPanel().getSelectLevelPanel()));
							viewAllPanels.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> viewAllPanels.getFrame().add(viewAllPanels.getInGamePanel().getInGamePanel()));	
							viewAllPanels.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> viewAllPanels.getInGamePanel().getInGamePanel().requestFocusInWindow());
							viewAllPanels.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> viewAllPanels.getInGamePanel().getInGamePanel().setFocusable(true));
							viewAllPanels.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> viewAllPanels.getFrame().repaint());
							//viewAllPanels.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> viewAllPanels.getFrame().setSize(600, 800));	
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
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {

				/*
				 *Case press esc to pause the game
				 */
				case KeyEvent.VK_ESCAPE:
					//int pauseDalay = 0;
					//Timer tPause = new Timer(pauseDalay, "");
					//tPause.start();

					viewAllPanels.getFrame().remove(viewAllPanels.getInGamePanel().getInGamePanel());
					viewAllPanels.getFrame().add(viewAllPanels.getPausePanel().getPausePanel());
					viewAllPanels.getFrame().repaint();
					viewAllPanels.getFrame().setSize(600, 800);	
					viewAllPanels.getFrame().pack();
					break;
				
				case KeyEvent.VK_LEFT:
					break;
					
				case KeyEvent.VK_RIGHT:
					break;
				
				case KeyEvent.VK_Z:
					break;
				
				case KeyEvent.VK_SPACE:
					break;
					
					
				}
			}
		});
		
		/**
		 * PausePanel
		 */
		//back
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
	
	
	
	private ViewAllPanels viewAllPanels;
	private Model model;
	//private ActionListener actionListener;
	
}

