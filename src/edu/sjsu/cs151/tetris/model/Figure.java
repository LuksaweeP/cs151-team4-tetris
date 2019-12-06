package edu.sjsu.cs151.tetris.model;

/**
 * A class for creating figures which will use in GameRule class.
 * @author Luksawee
 */

public class Figure 
{
		public static final Block[][][] FiguresList = {
				
			// empty
			{
				
			},		
			// J-Figure
			{
				{ new Block(0, 1), new Block(1, 1), new Block(2, 1), new Block(2, 2) },
				{ new Block(1, 0), new Block(1, 1), new Block(1, 2), new Block(0, 2) },
				{ new Block(0, 1), new Block(1, 1), new Block(2, 1), new Block(0, 0) },
				{ new Block(1, 0), new Block(1, 1), new Block(1, 2), new Block(2, 0) }
			},
			
			// Z-Figure
			{
				{ new Block(0, 0), new Block(1, 0), new Block(1, 1), new Block(2, 1) },
				{ new Block(1, 0), new Block(0, 1), new Block(1, 1), new Block(0, 2) },
				{ new Block(0, 0), new Block(1, 0), new Block(1, 1), new Block(2, 1) },
				{ new Block(1, 0), new Block(0, 1), new Block(1, 1), new Block(0, 2) }
			},
			
			
			// L-Figure
			{
				{ new Block(0, 1), new Block(1, 1), new Block(2, 1), new Block(2, 0) },
				{ new Block(1, 0), new Block(1, 1), new Block(1, 2), new Block(2, 2) },
				{ new Block(0, 1), new Block(1, 1), new Block(2, 1), new Block(0, 2) },
				{ new Block(1, 0), new Block(1, 1), new Block(1, 2), new Block(0, 0) }
			},
		
			
			// S-Figure
			{
				{ new Block(1, 0), new Block(2, 0), new Block(0, 1), new Block(1, 1) },
				{ new Block(0, 0), new Block(0, 1), new Block(1, 1), new Block(1, 2) },
				{ new Block(1, 0), new Block(2, 0), new Block(0, 1), new Block(1, 1) },
				{ new Block(0, 0), new Block(0, 1), new Block(1, 1), new Block(1, 2) }
			},
			
			
			// I-Figure
			{
				{ new Block(0, 1), new Block(1, 1), new Block(2, 1), new Block(3, 1) },
				{ new Block(1, 0), new Block(1, 1), new Block(1, 2), new Block(1, 3) },
				{ new Block(0, 1), new Block(1, 1), new Block(2, 1), new Block(3, 1) },
				{ new Block(1, 0), new Block(1, 1), new Block(1, 2), new Block(1, 3) }
			},
			
			// O-Figure
			{
				{ new Block(0, 0), new Block(0, 1), new Block(1, 0), new Block(1, 1) },
				{ new Block(0, 0), new Block(0, 1), new Block(1, 0), new Block(1, 1) },
				{ new Block(0, 0), new Block(0, 1), new Block(1, 0), new Block(1, 1) },
				{ new Block(0, 0), new Block(0, 1), new Block(1, 0), new Block(1, 1) }
			},
			
			// T-Figure
			{
				{ new Block(1, 0), new Block(0, 1), new Block(1, 1), new Block(2, 1) },
				{ new Block(1, 0), new Block(0, 1), new Block(1, 1), new Block(1, 2) },
				{ new Block(0, 1), new Block(1, 1), new Block(2, 1), new Block(1, 2) },
				{ new Block(1, 0), new Block(1, 1), new Block(2, 1), new Block(1, 2) }
			}
	};
}
