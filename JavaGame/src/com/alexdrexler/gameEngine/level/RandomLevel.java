package com.alexdrexler.gameEngine.level;

import java.util.Random;

import com.alexdrexler.gameEngine.level.tile.Tile;

/**
 * Randomly generates tiles for a level.
 * @author alexdrexler
 */
public class RandomLevel extends Level {
	
	private static final Random random = new Random();
	private int[] tilesInt;

	/**
	 * RandomLevel constructor. 
	 * @param width		Width of level in number of tiles.
	 * @param height	Height of level in number of tiles.
	 */
	public RandomLevel(int width, int height) {
		super(width, height);
		tilesInt = new int[tiles.length];
		generateLevel();
	}
	
	/**
	 * Populates tiles array randomly.
	 */
	protected void generateLevel() {
		for (int i = 0; i < tilesInt.length; i++) tilesInt[i] = random.nextInt(4);
	}

	/**
	 * Returns the tile at a certain point in the level.
	 * @param x	X coordinate of tile. (in tiles)
	 * @param y	Y coordinate of tile. (in tiles)
	 * @return	Tile.
	 */
	public Tile getTile(int x, int y) {
		if (x<0 || y<0 || x>=width || y>=height) return Tile.voidTile;
		if (tilesInt[x+y*width]<2) return Tile.grass;
		if (tilesInt[x+y*width]==2) return Tile.flowers;
		if (tilesInt[x+y*width]==3) return Tile.rock;
		return Tile.voidTile;
	}
}
