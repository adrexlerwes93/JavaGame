package com.alexdrexler.gameEngine.level;

import java.util.ArrayList;
import java.util.List;

import com.alexdrexler.gameEngine.entity.Entity;
import com.alexdrexler.gameEngine.graphics.Screen;
import com.alexdrexler.gameEngine.graphics.SpriteSheet;
import com.alexdrexler.gameEngine.level.tile.Tile;

/**
 * Loads tiles for a level.
 * @author alexdrexler
 */
public class Level {
	
	protected int width, height;
	protected SpriteSheet sheet;
	protected int[] tiles;
	
	private List<Entity> entities = new ArrayList<Entity>();
	
	
	/**
	 * Level constructor for random map generation
	 * @param width		Width of level in number of tiles.
	 * @param height	Height of level in number of tiles.
	 */
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width*height];
		generateLevel();
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
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
	}
	
	/**
	 * Add each entity to the level.
	 * @param e Entity to be added.
	 */
	public void add(Entity e) {
		entities.add(e);
	}
	
	/**
	 * Returns the tile at a certain point in the level.
	 * @param x	X coordinate of tile. (in tiles)
	 * @param y	Y coordinate of tile. (in tiles)
	 * @return	Tile.
	 */
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (tiles[x+y*width] == 0xff00ff00) return Tile.grass;
		if (tiles[x+y*width] == 0xffffff00) return Tile.flowers;
		if (tiles[x+y*width] == 0xff7f7f00) return Tile.rock;
		return Tile.voidTile;
	}
	
	/**
	 * Renders the necessary pixels of the map based on location of screen.
	 * @param xScroll	X coordinate of current screen location. (in pixels)
	 * @param yScroll	Y coordinate of current screen location. (in pixels)
	 * @param screen	Screen object that renders level.
	 */
	public void render(int xScroll,int yScroll,Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4, x1 = (xScroll+screen.width+16) >> 4;
		int y0 = yScroll >> 4, y1 = (yScroll+screen.height+16) >> 4;
		
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
	}
}
