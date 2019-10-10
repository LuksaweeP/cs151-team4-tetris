package model;

/**
 * A class for managing a Block and its location.
 */
public class Block {
	private int xPosition;
	private int yPosition;
	
	/**
	 * The Default Block Constructor.
	 */
	public Block(){
		this.xPosition = 0;
		this.yPosition = 0;
	}
	
	/**
	 * The Block Constructor.
	 * @param x The X position. 
	 * @param y The Y position.
	 */
	public Block(int x, int y){
		this.xPosition = x;
		this.yPosition = y;
	}
	/**
	 * A method to set the X position of the Block.
	 * @param x The X position.
	 */
	public void setXPosition(int x){
		this.xPosition = x;
	}
	
	/**
	 * A method to set the Y position of the Block.
	 * @param y The Y position.
	 */
	public void setYPosition(int y){
		this.yPosition = y;
	}
	
	/**
	 * A Method to return the X position.
	 * @return The X position.
	 */
	public int getXPosition(){
		return xPosition;
	}
	
	/**
	 * A Method to return the Y position.
	 * @return The Y position.
	 */
	public int getYPosition(){
		return yPosition;
	}
}
