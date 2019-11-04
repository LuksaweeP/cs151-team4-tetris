package edu.sjsu.cs151.tetris.animation;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class TetrominoAnimation {

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		final MoveableShape zShape = new ZShape(0, 0, TETROMINO_WIDTH);
		final MoveableShape IShape = new IShape(0, 0, TETROMINO_WIDTH);

		ShapeIcon icon1 = new ShapeIcon(zShape, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon icon2 = new ShapeIcon(IShape, ICON_WIDTH, ICON_HEIGHT);

		final JLabel label1 = new JLabel(icon1);
		final JLabel label2 = new JLabel(icon2);
		frame.setLayout(new FlowLayout());

		frame.add(label1);
		frame.add(label2);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		final int DELAY = 10;
		// Milliseconds between timer ticks
		ActionListener listener = event -> {
			zShape.translate(0, 1);
			label1.repaint();
		};
		Timer t = new Timer(DELAY, listener);
		t.start();

	}

	private static final int ICON_WIDTH = 600;
	private static final int ICON_HEIGHT = 600;
	private static final int TETROMINO_WIDTH = 100;
}
