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

class QuitPanel extends Panel
{
	public QuitPanel()
	{
		JFrame frame = new JFrame();
		frame.setSize(605, 800);
		
		JPanel quitPanel = new JPanel();
		quitPanel.setPreferredSize(new Dimension(800, 400));
		quitPanel.setBackground(new Color(176,196,222));
		quitPanel.setOpaque(true);
		
		JLabel confirm = new JLabel("  Are you sure?  ");
		confirm.setBackground(new Color(176,196,222));
		confirm.setOpaque(true);
		confirm.setFont(new Font("TimesRoman", Font.BOLD, 84));	
		setLabelCenter(confirm);
		
		JButton yes = new JButton("  YES  ");
		setButton(yes, 48);
		yes.addActionListener(event -> frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)));
		
		JButton no = new JButton("  NO  ");
		setButton(no, 48);
		no.addActionListener(event -> frame.setVisible(false));
		no.addActionListener(event -> new MainPanel());
		
		JPanel box1 = new JPanel(new GridLayout(1, 10));
		box1.setBackground(new Color(176,196,222));
		JPanel box2 = new JPanel(new GridLayout(1, 10));
		box2.setBackground(new Color(176,196,222));
		JPanel box3 = new JPanel(new GridLayout(1, 10));
		box3.setBackground(new Color(176,196,222));
		JPanel box4 = new JPanel(new GridLayout(1, 10));
		box4.setBackground(new Color(176,196,222));
		
        
		quitPanel.setLayout(new BoxLayout(quitPanel, BoxLayout.Y_AXIS));		
		quitPanel.add(box1);
		quitPanel.add(confirm);
		
		quitPanel.add(box2);
		quitPanel.add(yes);
		
		quitPanel.add(box3);
		quitPanel.add(no);
		quitPanel.add(box4);

		quitPanel.setVisible(true);
		
		frame.setLayout(new BorderLayout());		
		frame.add(quitPanel, BorderLayout.CENTER);

		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

