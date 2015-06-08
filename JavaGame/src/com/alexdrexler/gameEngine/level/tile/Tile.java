package com.alexdrexler.gameEngine.level.tile;

import com.alexdrexler.gameEngine.graphics.Screen;
import com.alexdrexler.gameEngine.graphics.Sprite;

/**
 * Creates a tile that contains an image and some basic information.
 * Building block of a level.
 * @author alexdrexler
 */
public class Tile {
	
	/**********************************************
	 * Static tile objects to be rendered by level.
	 */
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flowers = new FlowerTile(Sprite.flowers);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile water = new WaterTile(Sprite.water);
	public static Tile brick = new GrassTile(Sprite.brick);
	public static Tile lava = new WaterTile(Sprite.lava);
	
	/**********************************************/
	
	public int x,y;
	public Sprite sprite;
	
	/**
	 * Tile constructor.
	 * @param sprite	Sprite image for the tile.
	 */
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	/**
	 * Renders the pixels of the tile
	 * @param x			X location of tile on screen.
	 * @param y			Y location of tile on screen.
	 * @param screen	Screen object that renders tile.
	 */
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	/**
	 * Returns whether tile is solid.
	 * @return Whether tile is solid. Duh.
	 */
	public boolean solid() {
		return false;
	}
	
}
