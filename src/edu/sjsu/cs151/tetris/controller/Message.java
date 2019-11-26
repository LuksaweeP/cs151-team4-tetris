package edu.sjsu.cs151.tetris.controller;





	/**
	 * Class created to allow communication between View and Controller.
	 */


	public class Message 
	{
		public static enum TYPE {REDRAW, CHANGE_NEXT, SCORES_UPDATE, LOOSE, MOVE_LEFT, MOVE_RIGHT, FASTER, ROTATE_LEFT, ROTATE_RIGHT, RESTART;};
		private TYPE type;
		private int add_info;
		private int [][] data;
		
		/**
		 * @param t Type of the message we create
		 */
		public Message(TYPE t)
		{
			type = t;
			add_info = 0;
		}
		
		/**
		 * @param t	Type of the message we create.
		 * @param a	Additional information for example scores while updating scores.
		 */
		public Message (TYPE t, int a)
		{
			type = t;
			add_info = a;
		}
		
		/**
		 * @param t	Type of the message we create.
		 * @param d	Two dimensional array with data to be shown on the board type int.
		 */
		public Message (TYPE t, int [][] d)
		{
			type = t;
			data = d;
		}
		
		/**
		 * @return Type of the received message.
		 */
		public TYPE getType()
		{
			return type;
		}
		
		/**
		 * @return Additional information (single int value)
		 */
		public int getAdd()
		{
			return add_info;
		}	
		
		/**
		 * @return Received data to be shown on the screen.
		 */
		public int[][] getData()
		{
			return data;
		}
	}

