package edu.sjsu.cs151.tetris.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class that create the control panel.
 * @author Luksawee
 *
 */
public class ControlsPanel extends Panel
{
	public ControlsPanel()
	{	
	controlsPanel = new JPanel();
	controlsPanel.setPreferredSize(new Dimension(600, 800));
	
	JPanel backPanel = new JPanel();
	backPanel.setBackground(new Color(204,229,255));
	backPanel.setOpaque(true);
	backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.X_AXIS));
	
	back = new JButton("   <-  Back   ");
	back.setFont(new Font("TimesRoman", Font.BOLD, 30));
	back.setBackground(Color.WHITE);
	back.setOpaque(true);
	back.setAlignmentX(Component.CENTER_ALIGNMENT);
	back.setAlignmentY(Component.BOTTOM_ALIGNMENT);
	back.setVisible(true);


	JLabel back1 = new JLabel("                   ");  // create empty box
	back1.setFont(new Font("TimesRoman", Font.BOLD, 100));
	back1.setVisible(true);
	
	backPanel.add(back);
	backPanel.add(back1);
	
	JPanel icon = new JPanel();
	icon.setBackground(new Color(204,229,255));
	icon.setOpaque(true);
	icon.setLayout(new FlowLayout());
	
	JPanel iconZ = iconZ();
	iconZ.setBackground(new Color(204,229,255));
	iconZ.setOpaque(true);
	
	JPanel iconT = iconT();
	iconT.setBackground(new Color(204,229,255));
	iconT.setOpaque(true);
	
	JPanel iconO = iconO();
	iconO.setBackground(new Color(204,229,255));
	iconO.setOpaque(true);
	
	icon.add(iconO);
	icon.add(iconT);
	icon.add(iconZ);
		
	JLabel esc = new JLabel("ESC");
	esc.setFont(new Font("TimesRoman", Font.BOLD, 36));	
	
	JLabel left = new JLabel("<-");
	left.setBackground(new Color(204,229,255));
	left.setOpaque(true);
	left.setFont(new Font("TimesRoman", Font.BOLD, 36));	
	
	JLabel right = new JLabel("->");
	right.setBackground(new Color(204,229,255));
	right.setOpaque(true);
	right.setFont(new Font("TimesRoman", Font.BOLD, 36));	
	
	JLabel z = new JLabel("z");
	z.setBackground(new Color(204,229,255));
	z.setOpaque(true);
	z.setFont(new Font("TimesRoman", Font.BOLD, 36));	
	
	JLabel space = new JLabel("space           ");
	space.setBackground(new Color(204,229,255));
	space.setOpaque(true);
	space.setFont(new Font("TimesRoman", Font.BOLD, 36));	
	
	JPanel leftPanel = new JPanel();
	leftPanel.setSize(250, 400);
	leftPanel.setBackground(new Color(204,229,255));
	leftPanel.setOpaque(true);
	leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
	leftPanel.add(esc);
	leftPanel.add(left);
	leftPanel.add(right);
	leftPanel.add(z);
	leftPanel.add(space);
	
	JLabel pause = new JLabel("Pause");
	pause.setBackground(new Color(204,229,255));
	pause.setOpaque(true);
	pause.setFont(new Font("TimesRoman", Font.BOLD, 36));	

	
	JLabel moveLeft = new JLabel("Move LEFT");
	moveLeft.setBackground(new Color(204,229,255));
	moveLeft.setOpaque(true);
	moveLeft.setFont(new Font("TimesRoman", Font.BOLD, 36));	
	
	JLabel moveRight = new JLabel("Move RIGHT");
	moveRight.setBackground(new Color(204,229,255));
	moveRight.setOpaque(true);
	moveRight.setFont(new Font("TimesRoman", Font.BOLD, 36));	
	
	JLabel rotate = new JLabel("rotate");
	rotate.setBackground(new Color(204,229,255));
	rotate.setOpaque(true);
	rotate.setFont(new Font("TimesRoman", Font.BOLD, 36));	
	
	JLabel speedUp = new JLabel("Speed Up");
	speedUp.setBackground(new Color(204,229,255));
	speedUp.setOpaque(true);
	speedUp.setFont(new Font("TimesRoman", Font.BOLD, 36));	
	
	JPanel containner = new JPanel();
	containner.setLayout(new BoxLayout(containner, BoxLayout.Y_AXIS));
	
	JPanel box1 = new JPanel(new GridLayout(1, 10));
	box1.setPreferredSize(new Dimension(600, 100));
	box1.setBackground(new Color(204,229,255));
	box1.setOpaque(true);
	JPanel box2 = new JPanel(new GridLayout(1, 10));
	box2.setBackground(new Color(204,229,255));
	box2.setOpaque(true);
	JPanel box3 = new JPanel(new GridLayout(1, 10));
	box3.setBackground(new Color(204,229,255));
	box3.setOpaque(true);
	
	containner.add(box1);
	containner.add(box2);
	containner.add(box3);
	containner.setVisible(true);
	
	JPanel rightPanel = new JPanel();
	rightPanel.setBackground(new Color(204,229,255));
	rightPanel.setOpaque(true);
	rightPanel.setSize(250, 400);
	rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
	
	rightPanel.add(pause);
	rightPanel.add(moveLeft);
	rightPanel.add(moveRight);
	rightPanel.add(rotate);
	rightPanel.add(speedUp);
	

	JPanel panel = new JPanel();
	panel.setBackground(new Color(204,229,255));
	leftPanel.setOpaque(true);
	panel.add(containner);
	panel.add(leftPanel);
	panel.add(rightPanel);

	controlsPanel.setLayout(new BorderLayout());
	controlsPanel.add(backPanel, BorderLayout.NORTH);
	controlsPanel.add(panel, BorderLayout.CENTER);
	controlsPanel.add(icon, BorderLayout.SOUTH);
	
	controlsPanel.setVisible(true);	
	}
	
	/**
	 * Method to get controlPanel
	 * @return controlsPanel
	 */
	public JPanel getControlsPanel()
	{
		return controlsPanel;
	}
	
	/**
	 * Method to return the back button
	 * @return back button
	 */
	public JButton getBack()
	{
		return back;
	}
	
	private JPanel controlsPanel;
	private JButton back;
}
