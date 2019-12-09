package edu.sjsu.cs151.tetris.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.sjsu.cs151.tetris.animation.*;

/**
 * Class that use to set the format for panel
 * @author Luksawee
 * @author Nick
 */
public class Panel 
{
	/**
	 * Method to set format for buttons
	 * @param button the button to set the format
	 * @param fontSize the size of font
	 * @return button the formatted button
	 */
	public JButton setButton(JButton button, int fontSize)
	{
		button.setFont(new Font("TimesRoman", Font.BOLD, fontSize));
		button.setBackground(Color.WHITE);
		button.setOpaque(true);
		button.setBorderPainted(true);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		button.setVisible(true);
		return button;
	}
	
	/**
	 * Method to set label at the center
	 * @param label the label to set
	 * @return label the set label
	 */
	public JLabel setLabelCenter(JLabel label)
	{
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setOpaque(true);
		label.setVisible(true);	
		return label;
	}
	
	/**
	 * Method to create empty box size 3
	 * @return containner the container with 3 boxes in it
	 */
	public JPanel empty3Boxs()
	{
		JPanel containner = new JPanel();
		containner.setLayout(new BoxLayout(containner, BoxLayout.Y_AXIS));
		
		JPanel box1 = new JPanel(new GridLayout(1, 10));
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
		
		return containner;
	}
	
	/**
	 * Method to create empty box size 2
	 * @return containner the container with 2 boxes in it
	 */
	public JPanel empty2Boxs()
	{
		JPanel containner = new JPanel();
		containner.setLayout(new BoxLayout(containner, BoxLayout.Y_AXIS));
		
		JPanel box1 = new JPanel(new GridLayout(1, 10));
		JPanel box2 = new JPanel(new GridLayout(1, 10));
		
		containner.add(box1);
		containner.add(box2);
		
		return containner;
	}
	
	/**
	 * Method to create figure Z
	 * @return panelZ the Z panel
	 */
	public JPanel iconZ()
	{
		MoveableShape zShape = new DrawTetromino('Z', 0, 0, 30);
		ShapeIcon iconZ = new ShapeIcon(zShape, 95, 65);
		JLabel labelZ = new JLabel(iconZ);
		
		JPanel panelZ = new JPanel();
		panelZ.add(labelZ);
		
		return panelZ;
	}
	
	/**
	 * Method to create figure I
	 * @return panelI the I panel
	 */
	public JPanel iconI()
	{	
		MoveableShape iShape = new DrawTetromino('I', 0, 0, 30);
		ShapeIcon iconI = new ShapeIcon(iShape, 35, 125);
		JLabel labelI = new JLabel(iconI);
		
		JPanel panelI = new JPanel();
		panelI.add(labelI);
		
		return panelI;
	}
	
	/**
	 * Method to create figure O
	 * @return panelO the O panel
	 */
	public JPanel iconO()
	{	
		MoveableShape oShape = new DrawTetromino('O', 0, 0, 30);
		ShapeIcon iconO = new ShapeIcon(oShape, 65, 65);
		JLabel labelO = new JLabel(iconO);
		
		JPanel panelO = new JPanel();
		panelO.add(labelO);
		
		return panelO;
	}
	
	/**
	 * Method to create figure L
	 * @return panelL the L panel
	 */
	public JPanel iconL()
	{
		MoveableShape lShape = new DrawTetromino('L', 0, 0, 30);
		ShapeIcon iconL = new ShapeIcon(lShape, 65, 95);
		JLabel labelL = new JLabel(iconL);
		
		JPanel panelL = new JPanel();
		panelL.add(labelL);
		
		return panelL;
	}
	
	/**
	 * Method to create figure T
	 * @return panelT the T panel
	 */
	public JPanel iconT()
	{
		MoveableShape tShape = new DrawTetromino('T', 0, 0, 30);
		ShapeIcon iconT = new ShapeIcon(tShape, 95, 65);
		JLabel labelT = new JLabel(iconT);
		
		JPanel panelT = new JPanel();
		panelT.add(labelT);
		
		return panelT;
	}
	
	/**
	 * Method to create figure J
	 * @return panelJ the J panel
	 */
	public JPanel iconJ()
	{
		MoveableShape jShape = new DrawTetromino('J', 0, 0, 30);
		ShapeIcon iconJ = new ShapeIcon(jShape, 35, 95);
		JLabel labelJ = new JLabel(iconJ);
		
		JPanel panelJ = new JPanel();
		panelJ.add(labelJ);
		
		return panelJ;
	}
	
	/**
	 * Method to create figure S
	 * @return panelS the S panel
	 */
	public JPanel iconS()
	{
		MoveableShape sShape = new DrawTetromino('S', 0, 0, 30);
		ShapeIcon iconS = new ShapeIcon(sShape, 95, 65);
		JLabel labelS = new JLabel(iconS);
		
		JPanel panelS = new JPanel();
		panelS.add(labelS);
		
		return panelS;
	}
	
	JPanel panel = new JPanel();
}


