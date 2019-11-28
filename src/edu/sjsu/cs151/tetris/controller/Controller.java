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



public class Controller
{
	public Controller(View view, Model model)
	{
		this.view = view;
		this.model = model;
		//updateGameInfo();
	}
	
	public void mainLoop()
	{

			
		
	}
	
	
	public void updateGameInfo()
	{
		/**
		 * WelcomePanel
		 */
		view.getFrame().add(view.getWelcomePanel().getWelcomePanel());
		view.getFrame().setVisible(true);

		/**
		 * MainPanel
		 */
		//welcomeButton
		view.getWelcomePanel().getWelcomeButton().addActionListener(event -> view.getFrame().remove(view.getWelcomePanel().getWelcomePanel()));		
		view.getWelcomePanel().getWelcomeButton().addActionListener(event -> view.getFrame().add(view.getMainPanel().getMainPanel()));		
		view.getWelcomePanel().getWelcomeButton().addActionListener(event -> view.getFrame().pack());		
		
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
		
		/**
		 * PlayerPanel
		 */
		//createButton
		view.getPlayerPanel().getCreateButton().addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = view.getPlayerPanel().getInputBox().getText();
				System.out.println(input);
				
				boolean validname = model.getLeaderboard().isValidNewPlayers(input);
				if(validname)
				{
					model.getLeaderboard().addNewPlayer(input);
					model = new Model();
					
					model.getLeaderboard().loadPlayer(input);
					
					view.getInGamePanel().setPlayerInGamePanel(input);
					view.getInGamePanel().setLevelLabel("0");
					view.getInGamePanel().setScoreLabel("0");
					view.getInGamePanel().setLabelName(input);
					
					view.getFrame().remove(view.getPlayerPanel().getPlayerPanel());
					view.getFrame().add(view.getInGamePanel().getInGamePanel());
					view.getInGamePanel().getInGamePanel().setFocusable(true);
					view.getInGamePanel().getInGamePanel().requestFocusInWindow();
					view.getFrame().repaint();
					view.getFrame().setSize(600, 800);
					view.getFrame().pack();
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
		
		//loadPlayer
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
					view.getInGamePanel().setScoreLabel("0");
					view.getInGamePanel().setLabelName(text);
					
					Player loadPlayer = model.getLeaderboard().loadPlayer(text);
					System.out.println("Load Player:  " + loadPlayer.getName());
					System.out.println("highScore: " + loadPlayer.getPlayerHighScore());
					
					view.getPlayerPanel().setLoadPlayer(loadPlayer);			
					view.setSelectLevelPanel();					
					
					view.getFrame().remove(view.getPlayerPanel().getPlayerPanel());		
					view.getFrame().add(view.getSelectLevelPanel().getSelectLevelPanel());
					view.getFrame().repaint();
					view.getFrame().setSize(600, 800);
					view.getFrame().pack();
					
					/**
					 * InGamePanel
					 */
					//case select level unlock
					for(int i = 1; i < 5; i++)
					{
						if(loadPlayer.isLevelUnlocked(i) == true)
						{
							String selectLevel = Integer.toString(i);
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getInGamePanel().setLevelLabel(selectLevel));
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getFrame().remove(view.getSelectLevelPanel().getSelectLevelPanel()));
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getFrame().add(view.getInGamePanel().getInGamePanel()));	
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getInGamePanel().getInGamePanel().requestFocusInWindow());
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getInGamePanel().getInGamePanel().setFocusable(true));
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getFrame().repaint());
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getFrame().setSize(600, 800));	
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getFrame().pack());
							view.getSelectLevelPanel().getLevelButton()[i].addActionListener(event -> view.getFrame().setVisible(true));	
						}
					}		
				}	
		});		
		}
		
		//back
		view.getPlayerPanel().getBackButton().addActionListener(event -> view.getFrame().remove(view.getPlayerPanel().getPlayerPanel()));
		view.getPlayerPanel().getBackButton().addActionListener(event -> view.getFrame().add(view.getMainPanel().getMainPanel()));	
		view.getPlayerPanel().getBackButton().addActionListener(event -> view.getFrame().repaint());
		view.getPlayerPanel().getBackButton().addActionListener(event -> view.getFrame().setSize(600, 800));	
		view.getPlayerPanel().getBackButton().addActionListener(event -> view.getFrame().pack());
		
		/**
		 * LeaderboardPanel
		 */
		view.getLeaderboardPanel().getBackButton().addActionListener(event -> view.getFrame().remove(view.getLeaderboardPanel().getLeaderboardPanel()));
		view.getLeaderboardPanel().getBackButton().addActionListener(event -> view.getFrame().add(view.getMainPanel().getMainPanel()));	
		view.getLeaderboardPanel().getBackButton().addActionListener(event -> view.getFrame().repaint());
		view.getLeaderboardPanel().getBackButton().addActionListener(event -> view.getFrame().setSize(600, 800));	
		view.getLeaderboardPanel().getBackButton().addActionListener(event -> view.getFrame().pack());
		
		/**
		 * QuitPanel
		 */
		//no
		view.getQuitPanel().getNo().addActionListener(event -> view.getFrame().remove(view.getQuitPanel().getQuitPane()));
		view.getQuitPanel().getNo().addActionListener(event -> view.getFrame().add(view.getMainPanel().getMainPanel()));
		view.getQuitPanel().getNo().addActionListener(event -> view.getFrame().repaint());
		view.getQuitPanel().getNo().addActionListener(event -> view.getFrame().pack());
		
		//yes
		view.getQuitPanel().getYes().addActionListener(event -> view.getFrame().dispatchEvent(new WindowEvent(view.getFrame(), WindowEvent.WINDOW_CLOSING)));
		
		
		/**
		 * InGamePanel
		 */

		view.getInGamePanel().getInGamePanel().addKeyListener(new KeyAdapter() {
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

					view.getFrame().remove(view.getInGamePanel().getInGamePanel());
					view.getFrame().add(view.getPausePanel().getPausePanel());
					view.getFrame().repaint();
					view.getFrame().setSize(600, 800);	
					view.getFrame().pack();
					break;
				}
			}
		});
		
		/**
		 * PausePanel
		 */
		//back
		view.getPausePanel().getBack().addActionListener(event -> view.getFrame().remove(view.getPausePanel().getPausePanel()));
		view.getPausePanel().getBack().addActionListener(event -> view.getFrame().add(view.getInGamePanel().getInGamePanel()));
		view.getPausePanel().getBack().addActionListener(event -> view.getFrame().repaint());
		view.getPausePanel().getBack().addActionListener(event -> view.getFrame().setSize(600, 800));	
		view.getPausePanel().getBack().addActionListener(event -> view.getFrame().pack());
				
		//LeaderBoardInPausePanel
		view.getPausePanel().getLeaderboardsButton().addActionListener(event -> view.getFrame().remove(view.getPausePanel().getPausePanel()));
		view.getPausePanel().getLeaderboardsButton().addActionListener(event -> view.getFrame().add(view.getLeaderboardInPausePanel().getLeaderboardPanel()));
		view.getPausePanel().getLeaderboardsButton().addActionListener(event -> view.getFrame().repaint());
		view.getPausePanel().getLeaderboardsButton().addActionListener(event -> view.getFrame().setSize(600, 800));	
		view.getPausePanel().getLeaderboardsButton().addActionListener(event -> view.getFrame().pack());
		
		//ControlsPanel
		view.getPausePanel().getControlsButton().addActionListener(event -> view.getFrame().remove(view.getPausePanel().getPausePanel()));
		view.getPausePanel().getControlsButton().addActionListener(event -> view.getFrame().add(view.getControlsPanel().getControlsPanel()));
		view.getPausePanel().getControlsButton().addActionListener(event -> view.getFrame().repaint());
		view.getPausePanel().getControlsButton().addActionListener(event -> view.getFrame().setSize(600, 800));	
		view.getPausePanel().getControlsButton().addActionListener(event -> view.getFrame().pack());
			
		//retrunToMainMnuButton
		view.getPausePanel().getReturnToMainManuButton().addActionListener(event -> view.getFrame().remove(view.getPausePanel().getPausePanel()));
		view.getPausePanel().getReturnToMainManuButton().addActionListener(event -> view.getFrame().add(view.getMainPanel().getMainPanel()));	
		view.getPausePanel().getReturnToMainManuButton().addActionListener(event -> view.getFrame().repaint());
		view.getPausePanel().getReturnToMainManuButton().addActionListener(event -> view.getFrame().setSize(600, 800));	
		view.getPausePanel().getReturnToMainManuButton().addActionListener(event -> view.getFrame().pack());
		
		/**
		 * LeaderboardInGame
		 */
		view.getLeaderboardInPausePanel().getBackButton().addActionListener(Event -> view.getFrame().remove(view.getLeaderboardInPausePanel().getLeaderboardPanel()));
		view.getLeaderboardInPausePanel().getBackButton().addActionListener(event -> view.getFrame().add(view.getPausePanel().getPausePanel()));	
		view.getLeaderboardInPausePanel().getBackButton().addActionListener(event -> view.getFrame().repaint());
		view.getLeaderboardInPausePanel().getBackButton().addActionListener(event -> view.getFrame().setSize(600, 800));	
		view.getLeaderboardInPausePanel().getBackButton().addActionListener(event -> view.getFrame().pack());
		
		
		/**
		 * ControlPanel
		 */
		view.getControlsPanel().getBack().addActionListener(event -> view.getFrame().remove(view.getControlsPanel().getControlsPanel()));
		view.getControlsPanel().getBack().addActionListener(event -> view.getFrame().add(view.getPausePanel().getPausePanel()));	
		view.getControlsPanel().getBack().addActionListener(event -> view.getFrame().repaint());
		view.getControlsPanel().getBack().addActionListener(event -> view.getFrame().setSize(600, 800));	
		view.getControlsPanel().getBack().addActionListener(event -> view.getFrame().pack());
	}
	
	
	
	private View view;
	private Model model;
	//private ActionListener actionListener;
	
}

