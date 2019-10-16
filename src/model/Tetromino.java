package model;

/**
 * A class for managing the Tetromino game pieces and handle their movement.
 */
public class Tetromino {
	private char shape;
	private Block[] blocks = new Block[4];
	
	/**
	 * Default Tetromino constructor.
	 */
	public Tetromino() {
		// Default set to 'I'
		shape = 'I';
		blocks[0] = new Block(0,0);
		blocks[1] = new Block(0,1);
		blocks[2] = new Block(0,2);
		blocks[3] = new Block(0,3);
	}
	
	/**
	 * This constructs a Tetromino.
	 * @param aShape The shape to set the Tetromino to.
	 */
	public Tetromino(char aShape) {
		shape = Character.toUpperCase(aShape);
		switch(shape) {
			case 'I' : 
				blocks[0] = new Block(0,0);
				blocks[1] = new Block(0,1);
				blocks[2] = new Block(0,2);
				blocks[3] = new Block(0,3);
				break;
			case 'O' :
				blocks[0] = new Block(0,0);
				blocks[1] = new Block(0,1);
				blocks[2] = new Block(1,0);
				blocks[3] = new Block(1,1);
				break;
			case 'T' :
				blocks[0] = new Block(0,0);
				blocks[1] = new Block(1,0);
				blocks[2] = new Block(1,1);
				blocks[3] = new Block(2,0);
				break;
			case 'S' :
				blocks[0] = new Block(1,0);
				blocks[1] = new Block(2,0);
				blocks[2] = new Block(1,1);
				blocks[3] = new Block(0,1);
				break;
			case 'Z' :
				blocks[0] = new Block(0,0);
				blocks[1] = new Block(0,1);
				blocks[2] = new Block(1,1);
				blocks[3] = new Block(1,2);
				break;
			case 'L' :
				blocks[0] = new Block(0,0);
				blocks[1] = new Block(0,1);
				blocks[2] = new Block(0,2);
				blocks[3] = new Block(1,2);
				break;
			case 'J' :
				blocks[0] = new Block(1,0);
				blocks[1] = new Block(1,1);
				blocks[2] = new Block(1,2);
				blocks[3] = new Block(0,2);
				break;
			default : // default 'I'
				blocks[0] = new Block(0,0);
				blocks[1] = new Block(0,1);
				blocks[2] = new Block(0,2);
				blocks[3] = new Block(0,3);
				break;
		}
	}
		
	/**
	 * This method sets the shape of the Tetromino to one of the following: I,O,T,S,Z,L,J.
	 * @param aShape The shape to set the Tetromino to.
	 */
	public void setShape(char aShape) 
	{
		shape = aShape;
	}
	
	/**
	 * This method set generate new Tetromino shape randomly
	 */
	public void setRandomShape()
	{
		char [] array = {'I', 'O', 'T', 'S', 'Z', 'L', 'J'};
		int number = array.length;
		int index = (int)(Math.random() * number);
		char rand = array[index];
		setShape(rand);
	}
	
	/**
	 * This method fills the Tetromino with Block Objects and sets their initial position.
	 */
	public void setBlocks() 
	{
		
	}
	
	/**
	 * This method returns the shape of the Tetromino.
	 * @return The shape of the Tetromino game piece.
	 */
	public char getShape() 
	{
		return shape;
	}
	
	/**
	 * This method returns the array that contains each Block object of the Tetromino.
	 * @return The array that contains Block Objects of the Tetromino.
	 */
	public Block[] getBlocks() {
		return blocks;
	}
	
	/**
	 * This method moves the Tetromino one unit to the left.
	 */
	public void moveLeft() {
		
	}
	
	/**
	 * This method moves the Tetromino one unit to the right.
	 */
	public void moveRight() {
		
	}
	
	/**
	 * This method rotates the Tetromino 90 degrees to the left.
	 */
	public void rotateLeft() {
		
	}
	
	/**
	 * This method rotates the Tetromino 90 degrees to the right.
	 */
	public void rotateRight() {
		
	}
	
	/**
	 * This method moves the Tetromino one unit downward.
	 */
	public void moveDown() {
		
	}
	
	/**
	 * This method draws the tetromino to the window using its current location.
	 */
	public void drawTetromino() {
		
	}
}
