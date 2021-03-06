package com.alexdrexler.javagame.level;

import com.alexdrexler.javagame.graphics.Screen;
import com.alexdrexler.javagame.level.tile.Tile;

/**
 * Loads tiles for a level.
 * @author alexdrexler
 */
public class Level {
	
	protected int width, height;
	protected Tile[] tiles;
	
	/**
	 * Level constructor for random map generation
	 * @param width		Width of level in number of tiles.
	 * @param height	Height of level in number of tiles.
	 */
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new Tile[width*height];
	}
	
	/**
	 * Level constructor for map generation from PNG image.
	 * @param path	Path to PNG image of level in directory.
	 */
	public Level(String path) {
		loadLevel(path);
	}
	
	/**
	 * Loads level mapping from PNG image.
	 * @param path	Path to PNG image of level in directory.
	 */
	protected void loadLevel(String path) {
	}
	
	/**
	 * Populates tiles array.
	 */
	protected void generateLevel() {
	}
	
	/**
	 * Process any changes to the level.
	 */
	public void update() {
	}
	
	/**
	 * Returns the tile at a certain point in the level.
	 * @param x	X coordinate of tile. (in tiles)
	 * @param y	Y coordinate of tile. (in tiles)
	 * @return	Tile.
	 */
	public Tile getTile(int x, int y) {
		return Tile.voidTile;
	}
	
	/**
	 * Renders the necessary pixels of the map based on location of screen.
	 * @param xScroll	X coordinate of current screen location. (in pixels)
	 * @param yScroll	Y coordinate of current screen location. (in pixels)
	 * @param screen	Screen object that renders level.
	 */
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll>>4, x1 = (xScroll+screen.width + 16)>>4;
		int y0 = yScroll>>4, y1 = (yScroll+screen.height + 16)>>4;
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
	}
}
