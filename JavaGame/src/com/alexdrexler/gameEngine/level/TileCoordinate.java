package com.alexdrexler.gameEngine.level;

/**
 * Stores the location of a specific tile on the map as an x and y coordinate.
 * @author alexdrexler
 */
public class TileCoordinate {
	
	private int x, y;
	private final int TILE_SIZE = 16;
	
	/**
	 * TileCoordinate constructor.
	 * @param x X location of tile on map.
	 * @param y Y location of tile on map.
	 */
	public TileCoordinate(int x, int y) {
		this.x = x * TILE_SIZE;
		this.y = y * TILE_SIZE;
	}
	
	/**
	 * Returns X coordinate
	 * @return X coordinate
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Returns Y coordinate
	 * @return Y coordinate
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Returns X and Y coordinates
	 * @return X and Y coordinate array.
	 */
	public int[] getXY() {
		return new int[] {x,y};
	}

}
