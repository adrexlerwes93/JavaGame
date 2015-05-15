package com.alexdrexler.javagame.level;

import java.util.Random;

/**
 * Randomly generates tiles for a level.
 * @author alexdrexler
 */
public class RandomLevel extends Level {
	
	private static final Random random = new Random();

	/**
	 * RandomLevel constructor. 
	 * @param width		Width of level in number of tiles.
	 * @param height	Height of level in number of tiles.
	 */
	public RandomLevel(int width, int height) {
		super(width, height);
		generateLevel();
	}
	
	/**
	 * Populates tiles array randomly.
	 */
	private void generateLevel() {
		for (int i = 0;i < tiles.length;i++) tiles[i] = random.nextInt(4);
	}
}
