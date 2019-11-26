package edu.sjsu.cs151.tetris.model;

public class PlayfieldTest {
	public static void main(String[] args) {
		char[] array = { 'I', 'O', 'T', 'S', 'Z', 'L', 'J' };
		int number = array.length;

		Model model = new Model();
		int[][] screen = model.getGrid();

		Tetromino curr = new Tetromino('J');

		// curr.setBlocks();
		curr.getBlocks();

		curr.moveRight();
		curr.moveRight();
		curr.moveRight();
		curr.moveRight();

		curr.moveDown();
		curr.moveDown();
		curr.moveDown();
		curr.moveDown();

		curr.rotateLeft();
		curr.rotateLeft();
		curr.rotateLeft();
		curr.rotateLeft();

		System.out.println(curr.getShape());

		Block[] block = new Block[4];
		block = curr.getBlocks();

		for (int i = 0; i < block.length; i++) {
			int x = block[i].getXPosition();
			int y = block[i].getYPosition();
			System.out.println(x + " , " + y);
		}

		for (int i = 0; i < block.length; i++) {
			screen[block[i].getYPosition()][block[i].getXPosition()] = 1;
		}

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(screen[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
