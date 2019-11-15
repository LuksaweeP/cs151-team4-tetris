package edu.sjsu.cs151.tetris.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class QuitPanel 
{
	public QuitPanel()
	{
		JFrame frame = new JFrame();
		frame.setSize(605, 800);
		
		JPanel quitPanel = new JPanel();
		quitPanel.setPreferredSize(new Dimension(400, 400));
		quitPanel.setBackground(new Color(176,196,222));
		quitPanel.setOpaque(true);
		
		JLabel confirm = new JLabel("  Are you sure?  ");
		confirm.setBackground(new Color(176,196,222));
		confirm.setOpaque(true);
		confirm.setFont(new Font("TimesRoman", Font.BOLD, 84));	
		confirm.setAlignmentX(Component.CENTER_ALIGNMENT);
		confirm.setOpaque(true);
		confirm.setVisible(true);	
		
				
		JButton yes = new JButton("  YES  ");
		setQuitButton(yes);
		yes.addActionListener(event -> frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)));
		
		JButton no = new JButton("  NO  ");
		setQuitButton(no);
		no.addActionListener(event -> new MainPanel());
		
		JPanel box1 = new JPanel(new GridLayout(1, 10));
		JPanel box2 = new JPanel(new GridLayout(1, 10));
		JPanel box3 = new JPanel(new GridLayout(1, 10));
		box3.setBackground(new Color(176,196,222));
		JPanel box4 = new JPanel(new GridLayout(1, 10));
		box4.setBackground(new Color(176,196,222));
		JPanel box5 = new JPanel(new GridLayout(1, 10));
		box5.setBackground(new Color(176,196,222));
		JPanel box6 = new JPanel(new GridLayout(1, 10));
		box6.setBackground(new Color(176,196,222));
		JPanel box7 = new JPanel(new GridLayout(1, 10));
		JPanel box8 = new JPanel(new GridLayout(1, 10));
		JPanel box9 = new JPanel(new GridLayout(1, 10));
        
		quitPanel.setLayout(new BoxLayout(quitPanel, BoxLayout.Y_AXIS));		
		quitPanel.add(box1);
		quitPanel.add(box2);
		quitPanel.add(box3);
		quitPanel.add(confirm);
		
		quitPanel.add(box4);
		quitPanel.add(yes);
		
		quitPanel.add(box5);
		quitPanel.add(no);
		quitPanel.add(box6);
		quitPanel.add(box7);
		quitPanel.add(box8);
		
		quitPanel.setVisible(true);
		
		frame.setLayout(new BorderLayout());
		frame.add(quitPanel, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JButton setQuitButton(JButton button)
	{
		button.setFont(new Font("TimesRoman", Font.BOLD, 36));
		button.setSize(400, 150);
		button.setBackground(Color.BLACK);
		button.setOpaque(true);
		button.setBorderPainted(true);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		button.setVisible(true);
		return button;
	}
}

