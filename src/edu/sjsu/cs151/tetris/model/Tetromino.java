package edu.sjsu.cs151.tetris.model;


/**
 * A class for managing the Tetromino game pieces and handle their movement.
 */
public class Tetromino curTetromino; {
	/**
	 * Default Tetromino constructor.
	 */
	public Tetromino() {
		// Default set to 'I'
		shape = 'I';
		blocks[0] = new Block(0, 0);
		blocks[1] = new Block(0, 1);
		blocks[2] = new Block(0, 2);
		blocks[3] = new Block(0, 3);
	}

	/**
	 * This constructs a Tetromino.
	 * 
	 * @param aShape The shape to set the Tetromino to the constructor.
	 */
	public Tetromino(char aShape) {
		shape = Character.toUpperCase(aShape);
		switch (shape) {
		case 'I':
			blocks[0] = new Block(0, 0);
			blocks[1] = new Block(0, 1);
			blocks[2] = new Block(0, 2);
			blocks[3] = new Block(0, 3);
			break;
		case 'O':
			blocks[0] = new Block(0, 0);
			blocks[1] = new Block(1, 0);
			blocks[2] = new Block(0, 1);
			blocks[3] = new Block(1, 1);
			break;
		case 'T':
			blocks[0] = new Block(0, 0);
			blocks[1] = new Block(1, 0);
			blocks[2] = new Block(2, 0);
			blocks[3] = new Block(1, 1);
			break;
		case 'Z':
			blocks[0] = new Block(0, 0);
			blocks[1] = new Block(1, 0);
			blocks[2] = new Block(1, 1);
			blocks[3] = new Block(2, 1);
			break;
		case 'S':
			blocks[0] = new Block(2, 0);
			blocks[1] = new Block(1, 0);
			blocks[2] = new Block(1, 1);
			blocks[3] = new Block(0, 1);
			break;
		case 'L':
			blocks[0] = new Block(0, 0);
			blocks[1] = new Block(0, 1);
			blocks[2] = new Block(0, 2);
			blocks[3] = new Block(1, 2);
			break;
		case 'J':
			blocks[0] = new Block(1, 0);
			blocks[1] = new Block(1, 1);
			blocks[2] = new Block(1, 2);
			blocks[3] = new Block(0, 2);
			break;
		}
	}

	/**
	 * This method sets the shape of the Tetromino to one of the following:
	 * I,O,T,S,Z,L,J.
	 * 
	 * @param aShape The shape to set the Tetromino to.
	 */
	public void setShape(char aShape) {
		shape = aShape;
	}

	/**
	 * This method set generate new Tetromino shape randomly using the Singleton SingleRandom.
	 */
	public void setRandomShape() {
		char[] array = { 'I', 'O', 'T', 'S', 'Z', 'L', 'J' };
		SingleRandom rand = SingleRandom.getInstance();
		int num = rand.nextInt(array.length);
		char randShape = array[num];
		setShape(randShape);
	}

	/**
	 * This method fills the Tetromino with Block Objects and sets their initial
	 * position.
	 */
	public void setBlocks() {
		//setRandomShape();
		switch (shape) {
		case 'I':
			blocks[0] = new Block(0, 0);
			blocks[1] = new Block(0, 1);
			blocks[2] = new Block(0, 2);
			blocks[3] = new Block(0, 3);
			break;
		case 'O':
			blocks[0] = new Block(0, 0);
			blocks[1] = new Block(1, 0);
			blocks[2] = new Block(0, 1);
			blocks[3] = new Block(1, 1);
			break;
		case 'T':
			blocks[0] = new Block(0, 0);
			blocks[1] = new Block(1, 0);
			blocks[2] = new Block(2, 0);
			blocks[3] = new Block(1, 1);
			break;
		case 'Z':
			blocks[0] = new Block(0, 0);
			blocks[1] = new Block(1, 0);
			blocks[2] = new Block(1, 1);
			blocks[3] = new Block(2, 1);
			break;
		case 'S':
			blocks[0] = new Block(2, 0);
			blocks[1] = new Block(1, 0);
			blocks[2] = new Block(1, 1);
			blocks[3] = new Block(0, 1);
			break;
		case 'L':
			blocks[0] = new Block(0, 0);
			blocks[1] = new Block(0, 1);
			blocks[2] = new Block(0, 2);
			blocks[3] = new Block(1, 2);
			break;
		case 'J':
			blocks[0] = new Block(1, 0);
			blocks[1] = new Block(1, 1);
			blocks[2] = new Block(1, 2);
			blocks[3] = new Block(0, 2);
			break;
		}
	}

	/**
	 * This method returns the shape of the Tetromino.
	 * 
	 * @return The shape of the Tetromino game piece.
	 */
	public char getShape() {
		return shape;
	}

	/**
	 * This method returns the array that contains each Block object of the
	 * Tetromino.
	 * 
	 * @return The array that contains Block Objects of the Tetromino.
	 */
	public Block[] getBlocks() {
		return blocks;
	}

	/**
	 * The method to return the width of the tetromino
	 * 
	 * @return the width of the tetromino
	 */
	public int getBlockWidth() {
		int minX = blocks[0].getXPosition();
		int maxX = blocks[0].getXPosition();
		for (int i = 1; i < 4; i++) {
			if (minX > blocks[i].getXPosition())
				minX = blocks[i].getXPosition();

			if (maxX < blocks[i].getXPosition())
				maxX = blocks[i].getXPosition();
		}

		int blockWidth = Math.abs(maxX - minX) + 1;
		return blockWidth;
	}

	/**
	 * This method return the height of the Tetromino
	 * 
	 * @return the height of the block
	 */
	public int getBlockHeight() {
		int minY = blocks[0].getYPosition();
		int maxY = blocks[0].getYPosition();
		for (int i = 1; i < 4; i++) {
			if (minY > blocks[i].getYPosition())
				minY = blocks[i].getYPosition();

			if (maxY < blocks[i].getYPosition())
				maxY = blocks[i].getYPosition();
		}

		int blockHeight = Math.abs(maxY - minY) + 1;
		return blockHeight;
	}

	/**
	 * This method calculates the lowest Y coordinate of a tetromino.
	 * @return the lowest Y coordinate
	 */
	public int getMaxY() {
		int maxY = blocks[0].getYPosition();
		for (int i = 1; i < 4; i++) {
			if (maxY < blocks[i].getYPosition())
				maxY = blocks[i].getYPosition();
		}
		return maxY;
	}
	
	/**
	 * This method calculates and return the index of the blocks at the lowest Y coordinate of a tetromino.
	 * @return the lowest Y coordinate
	 */
	public int getIndexSkirt() {
		int maxY = blocks[3].getYPosition();
		int index = 3;
		for (int i = 2; i <= 0; i--) 
		{
			if (maxY < blocks[i].getYPosition())
			{
				maxY = blocks[i].getYPosition();
				index = i;
			}		
		}
		return index;
	}
	
	/**
	 * This method moves the Tetromino one unit to the left.
	 */
	public void moveLeft() {
		for (int i = 0; i < 4; i++) {
			int x = blocks[i].getXPosition() - 1;
			blocks[i].setXPosition(x);
		}
	}

	/**
	 * This method moves the Tetromino one unit to the right.
	 */
	public void moveRight() {
		for (int i = 0; i < 4; i++) {
			int x = blocks[i].getXPosition() + 1;
			blocks[i].setXPosition(x);
		}
	}

	/**
	 * This method moves the Tetromino down one unit.
	 */
	public void moveDown() {

		for (int i = 0; i < 4; i++) {
			int x = blocks[i].getYPosition() + 1;
			blocks[i].setYPosition(x);
		}

	}

	/**
	 * This method rotates the Tetromino 90 degrees to the left 1 turn. Rotating
	 * clockwise
	 */
	public void rotateLeft() {
		switch (shape) {
		case 'I':
			if (blocks[0].getXPosition() == blocks[3].getXPosition()) {
				for (int i = 0; i < 4; i++) {
					blocks[i].setXPosition(blocks[i].getXPosition() - 2 + i);
					blocks[i].setYPosition(blocks[i].getYPosition() + 2 - i);
				}
				break;
			}


			if (blocks[0].getYPosition() == blocks[3].getYPosition()) {
				for (int i = 0; i < 4; i++) {
					blocks[i].setXPosition(blocks[i].getXPosition() + 2 - i);
					blocks[i].setYPosition(blocks[i].getYPosition() - 2 + i);
				}
				break;
			}

		case 'O': // O cannot rotate
			break;

		case 'T':
			// block[0] is the pin point
			if (blocks[0].getXPosition() < blocks[2].getXPosition()) {
				for (int i = 1; i < 3; i++) {
					blocks[i].setXPosition(blocks[i].getXPosition() - i);
					blocks[i].setYPosition(blocks[i].getYPosition() + i);
				}
				blocks[3].setXPosition(blocks[3].getXPosition() - 2);
				System.out.println(1);
				break;
			}

			if (blocks[0].getYPosition() < blocks[2].getYPosition()) {
				for (int i = 1; i < 3; i++) {
					blocks[i].setXPosition(blocks[i].getXPosition() - i);
					blocks[i].setYPosition(blocks[i].getYPosition() - i);
				}
				blocks[3].setYPosition(blocks[3].getYPosition() - 2);
				System.out.println(2);
				break;
			}

			if (blocks[0].getXPosition() > blocks[2].getXPosition()) {
				for (int i = 1; i < 3; i++) {
					blocks[i].setXPosition(blocks[i].getXPosition() + i);
					blocks[i].setYPosition(blocks[i].getYPosition() - i);
				}
				blocks[3].setXPosition(blocks[3].getXPosition() + 2);
				System.out.println(3);
				break;
			}

			if (blocks[0].getYPosition() > blocks[2].getYPosition()) {
				for (int i = 1; i < 3; i++) {
					blocks[i].setXPosition(blocks[i].getXPosition() + i);
					blocks[i].setYPosition(blocks[i].getYPosition() + i);
				}
				blocks[3].setYPosition(blocks[3].getYPosition() + 2);
				System.out.println(4);
				break;
			}

		case 'Z':
			// block[0] is the pin point
			if (blocks[0].getXPosition() < blocks[1].getXPosition()) {
				blocks[1].setXPosition(blocks[1].getXPosition() - 1);
				blocks[1].setYPosition(blocks[1].getYPosition() + 1);

				blocks[2].setYPosition(blocks[2].getYPosition() - 2);

				blocks[3].setXPosition(blocks[3].getXPosition() - 3);
				blocks[3].setYPosition(blocks[3].getYPosition() + 1);
				System.out.println(1);
				break;
			}

			if (blocks[0].getYPosition() < blocks[1].getYPosition()) {
				blocks[1].setXPosition(blocks[1].getXPosition() - 1);
				blocks[1].setYPosition(blocks[1].getYPosition() - 1);

				blocks[2].setXPosition(blocks[2].getXPosition() - 2);

				blocks[3].setXPosition(blocks[3].getXPosition() - 1);
				blocks[3].setYPosition(blocks[3].getYPosition() - 3);
				System.out.println(2);
				break;
			}

			if (blocks[0].getXPosition() > blocks[1].getXPosition()) {
				blocks[1].setXPosition(blocks[1].getXPosition() + 1);
				blocks[1].setYPosition(blocks[1].getYPosition() - 1);

				blocks[2].setXPosition(blocks[2].getXPosition() + 2);

				blocks[3].setXPosition(blocks[3].getXPosition() + 3);
				blocks[3].setYPosition(blocks[3].getYPosition() - 1);

				System.out.println(3);
				break;
			}

			if (blocks[0].getYPosition() > blocks[1].getYPosition()) {
				blocks[1].setXPosition(blocks[1].getXPosition() + 1);
				blocks[1].setYPosition(blocks[1].getYPosition() + 1);

				blocks[2].setYPosition(blocks[2].getYPosition() + 2);

				blocks[3].setXPosition(blocks[3].getXPosition() + 1);
				blocks[3].setYPosition(blocks[3].getYPosition() + 3);
				System.out.println(4);
				break;
			}

		case 'S':
			// block[0] is the pin point
			if (blocks[0].getXPosition() > blocks[1].getXPosition()) {
				blocks[1].setXPosition(blocks[1].getXPosition() + 1);
				blocks[1].setYPosition(blocks[1].getYPosition() - 1);

				blocks[2].setYPosition(blocks[2].getYPosition() - 2);

				blocks[3].setXPosition(blocks[3].getXPosition() + 1);
				blocks[3].setYPosition(blocks[3].getYPosition() - 3);
				System.out.println(1);
				break;
			}

			if (blocks[0].getYPosition() > blocks[1].getYPosition()) {
				blocks[1].setXPosition(blocks[1].getXPosition() + 1);
				blocks[1].setYPosition(blocks[1].getYPosition() + 1);

				blocks[2].setXPosition(blocks[2].getXPosition() + 2);

				blocks[3].setXPosition(blocks[3].getXPosition() + 3);
				blocks[3].setYPosition(blocks[3].getYPosition() + 1);
				System.out.println(2);
				break;
			}

			if (blocks[0].getXPosition() < blocks[1].getXPosition()) {
				blocks[1].setXPosition(blocks[1].getXPosition() - 1);
				blocks[1].setYPosition(blocks[1].getYPosition() + 1);

				blocks[2].setYPosition(blocks[2].getYPosition() + 2);

				blocks[3].setXPosition(blocks[3].getXPosition() - 1);
				blocks[3].setYPosition(blocks[3].getYPosition() + 3);

				System.out.println(3);
				break;
			}

			if (blocks[0].getYPosition() < blocks[1].getYPosition()) {
				blocks[1].setXPosition(blocks[1].getXPosition() - 1);
				blocks[1].setYPosition(blocks[1].getYPosition() - 1);

				blocks[2].setXPosition(blocks[2].getXPosition() - 2);

				blocks[3].setXPosition(blocks[3].getXPosition() - 3);
				blocks[3].setYPosition(blocks[3].getYPosition() - 1);
				System.out.println(4);
				break;
			}

		case 'L':
			// block[0] is the pin point
			if (blocks[0].getYPosition() < blocks[2].getYPosition()) {
				for (int i = 1; i < 3; i++) {
					blocks[i].setXPosition(blocks[i].getXPosition() - i);
					blocks[i].setYPosition(blocks[i].getYPosition() - i);
				}
				blocks[3].setXPosition(blocks[3].getXPosition() - 3);
				blocks[3].setYPosition(blocks[3].getYPosition() - 1);

				System.out.println(1);
				break;
			}

			if (blocks[0].getXPosition() > blocks[2].getXPosition()) {
				for (int i = 1; i < 3; i++) {
					blocks[i].setXPosition(blocks[i].getXPosition() + i);
					blocks[i].setYPosition(blocks[i].getYPosition() - i);
				}
				blocks[3].setXPosition(blocks[3].getXPosition() + 1);
				blocks[3].setYPosition(blocks[3].getYPosition() - 3);

				System.out.println(2);
				break;
			}

			if (blocks[0].getYPosition() > blocks[2].getYPosition()) {
				for (int i = 1; i < 3; i++) {
					blocks[i].setXPosition(blocks[i].getXPosition() + i);
					blocks[i].setYPosition(blocks[i].getYPosition() + i);
				}
				blocks[3].setXPosition(blocks[3].getXPosition() + 3);
				blocks[3].setYPosition(blocks[3].getYPosition() + 1);
				System.out.println(3);
				break;
			}

			if (blocks[0].getXPosition() < blocks[2].getXPosition()) {
				for (int i = 1; i < 3; i++) {
					blocks[i].setXPosition(blocks[i].getXPosition() - i);
					blocks[i].setYPosition(blocks[i].getYPosition() + i);
				}
				blocks[3].setXPosition(blocks[3].getXPosition() - 1);
				blocks[3].setYPosition(blocks[3].getYPosition() + 3);
				System.out.println(4);
				break;
			}

		case 'J':
			// block[0] is the pin point
			if (blocks[0].getYPosition() < blocks[2].getYPosition()) {
				for (int i = 1; i < 3; i++) {
					blocks[i].setXPosition(blocks[i].getXPosition() - i);
					blocks[i].setYPosition(blocks[i].getYPosition() - i);
				}
				blocks[3].setXPosition(blocks[3].getXPosition() - 1);
				blocks[3].setYPosition(blocks[3].getYPosition() - 3);

				System.out.println(1);
				break;
			}

			if (blocks[0].getXPosition() > blocks[2].getXPosition()) {
				for (int i = 1; i < 3; i++) {
					blocks[i].setXPosition(blocks[i].getXPosition() + i);
					blocks[i].setYPosition(blocks[i].getYPosition() - i);
				}
				blocks[3].setXPosition(blocks[3].getXPosition() + 3);
				blocks[3].setYPosition(blocks[3].getYPosition() - 1);

				System.out.println(2);
				break;
			}

			if (blocks[0].getYPosition() > blocks[2].getYPosition()) {
				for (int i = 1; i < 3; i++) {
					blocks[i].setXPosition(blocks[i].getXPosition() + i);
					blocks[i].setYPosition(blocks[i].getYPosition() + i);
				}
				blocks[3].setXPosition(blocks[3].getXPosition() + 1);
				blocks[3].setYPosition(blocks[3].getYPosition() + 3);
				System.out.println(3);
				break;
			}

			if (blocks[0].getXPosition() < blocks[2].getXPosition()) {
				for (int i = 1; i < 3; i++) {
					blocks[i].setXPosition(blocks[i].getXPosition() - i);
					blocks[i].setYPosition(blocks[i].getYPosition() + i);
				}
				blocks[3].setXPosition(blocks[3].getXPosition() - 3);
				blocks[3].setYPosition(blocks[3].getYPosition() + 1);
				System.out.println(4);
				break;
			}
		}
	}

	private char shape; // To specify the type of Tetromino
	private Block[] blocks = new Block[4]; // Each Tetromino has 4 blocks
	//Tetromino curTromino;
	//Tetromino nextTromino;
}
