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

public class QuitPanel extends Panel
{
	public QuitPanel()
	{
		quitPanel = new JPanel();
		quitPanel.setPreferredSize(new Dimension(600, 800));
		quitPanel.setBackground(new Color(176,196,222));
		quitPanel.setOpaque(true);
		
		JLabel confirm = new JLabel("  Are you sure?  ");
		confirm.setBackground(new Color(176,196,222));
		confirm.setOpaque(true);
		confirm.setFont(new Font("TimesRoman", Font.BOLD, 84));	
		setLabelCenter(confirm);
		
		yes = new JButton("  YES  ");
		setButton(yes, 48);
		
		no = new JButton("  NO  ");
		setButton(no, 48);
		
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
	
		quitPanel.setVisible(true);
	}
	
	public JPanel getQuitPane()
	{
		return quitPanel;
	}
	
	public JButton getYes()
	{
		return yes;
	}
	
	public JButton getNo()
	{
		return no;
	}
	
	private JPanel quitPanel;
	private JButton yes;
	private JButton no;
}

