package edu.sjsu.cs151.tetris.model;

import java.util.Random;

/**
 * A Singleton class for creating one instance of a random number generator.
 */
public class SingleRandom {
	/**
	 * This method creates the random number generator as a new Random from java.util.Random
	 */
	private SingleRandom() { 
		generator = new Random(); 
	}
	
	/**
	 * This method sets the seed for this instance of the random number generator
	 * @param seed the seed to set the random generator
	 */
	public void setSeed (int seed) { 
		generator.setSeed(seed); 
	}
	
	/**
	 * This method returns a random int in the range of [-2^31, (2^31)-1]
	 * @return The next random int generated in this instance's sequence
	 */
	public int nextInt() { 
		return generator.nextInt(); 
	}
	
	/**
	 * This methods returns the only instance of SingleRandom
	 * @return The single class instance
	 */
	public static SingleRandom getInstance() { 
		return instance; 
	}
	
	/**
	 * This method returns a random number between 0 (inclusive) and i (exclusive).
	 * @param i The upper bound of the random number range (exclusive)
	 * @return The random integer
	 */
	public int nextInt(int i) {
		return generator.nextInt(i);
	}
	
	private Random generator;
	private static SingleRandom instance = new SingleRandom();
	
}
