package edu.sjsu.cs151.tetris.animation;
import edu.sjsu.cs151.tetris.model.*;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class TetrominoAnimation {

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		final MoveableShape zShape = new DrawTetromino('Z' , TETROMINO_WIDTH);
		final MoveableShape IShape = new DrawTetromino('I', TETROMINO_WIDTH);
		final MoveableShape OShape = new DrawTetromino('O', TETROMINO_WIDTH);

		ShapeIcon iconZ = new ShapeIcon(zShape, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon iconI = new ShapeIcon(IShape, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon iconO = new ShapeIcon(OShape, ICON_WIDTH, ICON_HEIGHT);

		final JLabel labelZ = new JLabel(iconZ);
		final JLabel labelI = new JLabel(iconI);
		final JLabel labelO = new JLabel(iconO);

		frame.setLayout(new FlowLayout());
		frame.add(labelZ);
		frame.add(labelI);
		frame.add(labelO);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		final int delayZ = 10;
		// Milliseconds between timer ticks
		ActionListener listenerZ = event -> {
			zShape.translate(0, 1);
			labelZ.repaint();
		};

		final int delayI = 5;
		// Milliseconds between timer ticks
		ActionListener listenerI = event -> {
			IShape.translate(0, 1);
			labelI.repaint();
		};
		Timer z = new Timer(delayZ, listenerI);
		z.start();

		Timer i = new Timer(delayI, listenerI);
		i.start();
		i.setRepeats(true);

	}

	private static final int ICON_WIDTH = 100;
	private static final int ICON_HEIGHT = 600;
	private static final int TETROMINO_WIDTH = 100;
	Block [] blocks = new Block[4];
	Tetromino tetromino = new Tetromino();
}

