package com.alexdrexler.javagame.graphics;

/**
 * Creates individual Sprites from SpriteSheet.
 * @author alexdrexler
 */
public class Sprite {

	public final int SIZE;
	private int x,y;
	private SpriteSheet sheet;
	public int[] pixels;
	
	public static Sprite grass = new Sprite(16,0,0,SpriteSheet.testSheet);
	public static Sprite voidSprite = new Sprite(16, 0x777777);
	
	/**
	 * Sprite constructor from SpriteSheet.
	 * @param size	Size of one dimension of the sprite.
	 * @param x		X "coordinate" of the sprite on the sprite sheet.
	 * @param y		Y "coordinate" of the sprite on the sprite sheet.
	 * @param sheet	Sprite sheet that contains the sprite.
	 */
	public Sprite (int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[size*size];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	/**
	 * Sprite constructor solid color.
	 * @param size	Size of one dimension of the sprite.
	 * @param color	Color of the sprite.
	 */
	public Sprite (int size, int color) {
		SIZE = size;
		pixels = new int[size*size];
		setColor(color);
	}
	
	/**
	 * Makes every pixel in the sprite one specified color.
	 * @param color	The color of the sprite.
	 */
	private void setColor(int color) {
		for (int i = 0; i<pixels.length;i++) pixels[i] = color;
	}
	
	/**
	 * Populates pixels array from specified location on SpriteSheet.
	 */
	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x=0; x < SIZE; x++) {
				pixels [x+y*SIZE] = sheet.pixels[(x+this.x) + (y+this.y) * sheet.SIZE];
			}
		}
	}
}
