package com.alexdrexler.javagame.graphics;

import java.util.Random;

/**
 * Populates array of pixels to be displayed.
 * @author alexdrexler
 */
public class Screen {
	private int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 4;
	public int[] tiles = new int[MAP_SIZE*MAP_SIZE];
	
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
	
	/**
	 * Fill pixels array with current image.
	 */
	public void render(int xOffset, int yOffset) {
		clear();
		for (int y = 0; y<height; y++) {
			int yy = y+yOffset;
			if(y<0 || y>=height) break;
			for (int x = 0; x<width; x++) {
				int xx = x+xOffset;
				if(x<0 || x>=width) break;
				int tileIndex = ((xx>>4)&(MAP_SIZE-1))+((yy>>4)&(MAP_SIZE-1)) * MAP_SIZE;
				pixels[x+y*width] = tiles[tileIndex];
			}
		}
	}
}
