package com.alexdrexler.gameEngine.graphics;

import java.util.Random;

import com.alexdrexler.gameEngine.entity.mob.Player;
import com.alexdrexler.gameEngine.level.tile.Tile;

/**
 * Populates array of pixels to be displayed.
 * @author alexdrexler
 */
public class Screen {
	public int width, height;
	public int[] pixels;
	public int xOffset, yOffset;
	private Random random = new Random();
	
	
	/**
	 * Screen constructor. Defines size of pixels array.
	 * @param width		Width of screen.
	 * @param height	Height of screen.
	 */
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width*height];
	}
	
	/**
	 * Clear previous image from pixels array.
	 */
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
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
		for (int y=0; y < tile.sprite.SIZE; y++) {
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
	 * Renders a mob entity.
	 * @param xp X location of mob on screen.
	 * @param yp Y location of mob on screen.
	 * @param sprite Sprite to be rendered
	 * @param flip Determines whether sprite must be flipped.
	 */
	public void renderMob(int xp, int yp, Sprite sprite, int flip) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y=0; y < 16; y++) {
			int ya = y + yp;
			int ys = y;
			if(flip == 2 || flip == 3) ys = 15-y;
			for (int x = 0; x < 16; x++) {
				int xa = x + xp;
				int xs = x;
				if(flip == 1 || flip == 3) xs = 15-x;
				
				if (xa < -16 || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[xs+ys*16];
				if (col != 0xffff00ff) pixels[xa+ya*width] = col;
			}
		}
	}
	
	/**
	 * Sets the offset of area to be rendered on screen.
	 * @param xOffset
	 * @param yOffset
	 */
	public void setOffset( int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}

