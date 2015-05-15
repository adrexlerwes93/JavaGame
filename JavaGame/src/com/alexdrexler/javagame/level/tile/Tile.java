package com.alexdrexler.javagame.level.tile;

import com.alexdrexler.javagame.graphics.Screen;
import com.alexdrexler.javagame.graphics.Sprite;

/**
 * Creates a tile that contains an image and some basic information.
 * Building block of a level.
 * @author alexdrexler
 */
public class Tile {

	public int x,y;
	public Sprite sprite;
	
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new GrassTile(Sprite.flower);
	public static Tile rock = new GrassTile(Sprite.rock);
	
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
		screen.renderTile(x<<4, y<<4, this);
	}
	
	/**
	 * Returns whether tile is solid.
	 * @return Whether tile is solid. Duh.
	 */
	public boolean solid() {
		return false;
	}
}
