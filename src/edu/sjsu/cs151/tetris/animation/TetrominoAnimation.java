package edu.sjsu.cs151.tetris.animation;
import edu.sjsu.cs151.tetris.model.*;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class TetrominoAnimation {

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		final MoveableShape zShape = new DrawTetromino('Z', 0, 0, TETROMINO_WIDTH);
		final MoveableShape iShape = new DrawTetromino('I', 0, 0, TETROMINO_WIDTH);
		final MoveableShape oShape = new DrawTetromino('O', 0, 0, TETROMINO_WIDTH);
		final MoveableShape lShape = new DrawTetromino('L', 0, 0, TETROMINO_WIDTH);
		final MoveableShape tShape = new DrawTetromino('T', 0, 0, TETROMINO_WIDTH);
		final MoveableShape jShape = new DrawTetromino('J', 0, 0, TETROMINO_WIDTH);
		final MoveableShape sShape = new DrawTetromino('S', 0, 0, TETROMINO_WIDTH);

		ShapeIcon iconZ = new ShapeIcon(zShape, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon iconI = new ShapeIcon(iShape, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon iconO = new ShapeIcon(oShape, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon iconL = new ShapeIcon(lShape, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon iconT = new ShapeIcon(tShape, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon iconJ = new ShapeIcon(jShape, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon iconS = new ShapeIcon(sShape, ICON_WIDTH, ICON_HEIGHT);

		final JLabel labelZ = new JLabel(iconZ);
		final JLabel labelI = new JLabel(iconI);
		final JLabel labelO = new JLabel(iconO);
		final JLabel labelL = new JLabel(iconL);
		final JLabel labelT = new JLabel(iconT);
		final JLabel labelJ = new JLabel(iconJ);
		final JLabel labelS = new JLabel(iconS);
		
		frame.setLayout(new FlowLayout());
		frame.add(labelZ);
		frame.add(labelI);
		frame.add(labelO);
		frame.add(labelL);
		frame.add(labelT);
		frame.add(labelJ);
		frame.add(labelS);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		// Z shape
		while (iconZ.getIconHeight() < 600)
		{
			final int delayZ = 100;
			// Milliseconds between timer ticks
			ActionListener listenerZ = event -> {
				zShape.translate(0, 1);
				labelZ.repaint();
			};
			Timer z = new Timer(delayZ, listenerZ);
			z.start();
		}
		
		
		// I shape
		final int delayI = 500;
		// Milliseconds between timer ticks
		ActionListener listenerI = event -> {
			iShape.translate(0, 1);
			labelI.repaint();
		};
		Timer i = new Timer(delayI, listenerI);
		i.start();
	}

	private static final int ICON_WIDTH = 100;
	private static final int ICON_HEIGHT = 600;
	private static final int TETROMINO_WIDTH = 100;
	Block[] blocks = new Block[4];
	Tetromino tetromino = new Tetromino();
}

