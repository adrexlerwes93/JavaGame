package com.alexdrexler.javagame.graphics;

/**
 * Populates array of pixels to be displayed.
 * @author alexdrexler
 */
public class Screen {
	private int width, height;
	public int[] pixels;
	
	/**
	 * Screen constructor. Defines size of pixels array.
	 * @param width		Width of screen.
	 * @param height	Height of screen.
	 */
	public Screen (int width,int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width*height];
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
	public void render() {
		clear();
		for (int y = 0; y<height; y++) {
			if(y<0 || y>=height) break;
			for (int x = 0; x<width; x++) {
				if(x<0 || x>=width) break;
				pixels[x+y*width] = 0xff00ff;
			}
		}
	}
}
