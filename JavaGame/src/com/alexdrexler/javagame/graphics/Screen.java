package com.alexdrexler.javagame.graphics;

import java.util.Random;

import com.alexdrexler.javagame.level.tile.Tile;

/**
 * Populates array of pixels to be displayed.
 * @author alexdrexler
 */
public class Screen {
	public int width;
	public int height;
	public int[] pixels;
	public final int MAP_SIZE = 4;
	public int[] tiles = new int[MAP_SIZE*MAP_SIZE];
	public int xOffset, yOffset;
	
	private Random random = new Random();
	
	/**
	 * Screen constructor. Defines size of pixels array.
	 * @param width		Width of screen.
	 * @param height	Height of screen.
	 */
	public Screen (int width,int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width*height];
		
		for (int i = 0;i<tiles.length;i++){
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	/**
	 * Clear previous image from pixels array.
	 */
	public void clear() {
		for (int i=0; i<pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite) {
		xp -= xOffset; 
		yp -= yOffset;
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[x+y*sprite.SIZE];
				if (col != 0xffff00ff) {
					pixels[xa+ya*width] = col;
				}
			}
		}
	}
	
	/**
	 * Render a tile that is present on the screen.
	 * @param xp	X location of tile on screen.
	 * @param yp	Y location of tile on screen.
	 * @param tile		Tile to be rendered.
	 */
	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset; 
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				pixels[xa+ya*width] = tile.sprite.pixels[x+y*tile.sprite.SIZE];
			}
		}
	}
	
	/**
	 * Set offset based on screen location
	 * @param xOffset
	 * @param yOffset
	 */
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
