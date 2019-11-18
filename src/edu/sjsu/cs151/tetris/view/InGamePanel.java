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

class InGamePanel extends Panel {
	public InGamePanel() {
		JFrame frame = new JFrame();
		frame.setSize(600, 800);
		
		JLabel level = new JLabel("Level: ______");
		level.setFont(new Font("TimesRoman", Font.BOLD, 24));
		JLabel name = new JLabel("Player Name");
		name.setFont(new Font("TimesRoman", Font.BOLD, 24));
		JLabel score = new JLabel("Score: ______");
		score.setFont(new Font("TimesRoman", Font.BOLD, 24));
		
		JPanel gameInfo = new JPanel();
		gameInfo.setPreferredSize(new Dimension(200,800));
		gameInfo.setBackground(new Color(176,196,222));
		gameInfo.setOpaque(true);
		gameInfo.setLayout(new BoxLayout(gameInfo, BoxLayout.Y_AXIS));
		gameInfo.add(level);
		gameInfo.add(name);
		gameInfo.add(score);
		
		JPanel center = new JPanel();
		center.setPreferredSize(new Dimension(400,800));
		center.setBackground(new Color(0,0,0));
		center.setOpaque(true);
		
		frame.setLayout(new BorderLayout());
		frame.add(center, BorderLayout.CENTER);
		frame.add(gameInfo, BorderLayout.WEST);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
