package edu.sjsu.cs151.tetris.animation;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

//import animation.CarShape;
//import animation.MoveableShape;
//import animation.ShapeIcon;

public class TetrominoAnimation {

	public static void main(String[] args) {
		JFrame frame = new JFrame();

	      final MoveableShape shape
	            = new TetrominoShape(0, 0, TETROMINO_WIDTH);

	      ShapeIcon icon = new ShapeIcon(shape,
	            ICON_WIDTH, ICON_HEIGHT);

	      final JLabel label = new JLabel(icon);
	      frame.setLayout(new FlowLayout());
	      frame.add(label);

	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.pack();
	      frame.setVisible(true);

	      final int DELAY = 100;
	      // Milliseconds between timer ticks
	      ActionListener listener = event -> {shape.translate(0, 1); label.repaint(); };
	  	  Timer t = new Timer(DELAY, listener);
	      t.start();
	   }
	
	   private static final int ICON_WIDTH = 400;
	   private static final int ICON_HEIGHT = 600;
	   private static final int TETROMINO_WIDTH = 100;
}
