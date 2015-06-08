package com.alexdrexler.gameEngine.graphics;

import java.awt.Color;

/**
 * Creates individual Sprites from SpriteSheet.
 * @author alexdrexler
 */
public class Sprite {

	/**********************************************
	 * Static sprite objects to be rendered.
	 */
	//tiles
	public static Sprite voidSprite = new Sprite(16, Color.GRAY.getRGB());
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite flowers = new Sprite(16, 0, 1, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 0, 2, SpriteSheet.tiles);
	public static Sprite water = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite brick = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite lava = new Sprite(16, 3, 0, SpriteSheet.tiles);
	public static Sprite spawn0 = new Sprite(16, 4, 0, SpriteSheet.tiles);
	public static Sprite spawn1 = new Sprite(16, 5, 0, SpriteSheet.tiles);
	public static Sprite spawn2 = new Sprite(16, 4, 1, SpriteSheet.tiles);
	public static Sprite spawn3 = new Sprite(16, 5, 1, SpriteSheet.tiles);
	//mobs
	//player
	public static Sprite player_up = new Sprite(16, 0, 9, SpriteSheet.tiles);
	public static Sprite player_down = new Sprite(16, 2, 9, SpriteSheet.tiles);
	public static Sprite player_left = new Sprite(16, 3, 9, SpriteSheet.tiles);
	public static Sprite player_right = new Sprite(16, 1, 9, SpriteSheet.tiles);
	public static Sprite player_up_1 = new Sprite(16, 0, 8, SpriteSheet.tiles);
	public static Sprite player_up_2 = new Sprite(16, 2, 8, SpriteSheet.tiles);
	public static Sprite player_down_1 = new Sprite(16, 0, 8, SpriteSheet.tiles);
	public static Sprite player_down_2 = new Sprite(16, 2, 8, SpriteSheet.tiles);
	public static Sprite player_left_1 = new Sprite(16, 0, 8, SpriteSheet.tiles);
	public static Sprite player_left_2 = new Sprite(16, 1, 8, SpriteSheet.tiles);
	public static Sprite player_right_1 = new Sprite(16, 0, 8, SpriteSheet.tiles);
	public static Sprite player_right_2 = new Sprite(16, 1, 8, SpriteSheet.tiles);
	//test mob
	public static Sprite temp_mob = new Sprite(16, 0, 7, SpriteSheet.tiles);
	/**********************************************/
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	
	/**
	 * Sprite constructor from SpriteSheet.
	 * @param size	Size of one dimension of the sprite.
	 * @param x		X "coordinate" of the sprite on the sprite sheet.
	 * @param y		Y "coordinate" of the sprite on the sprite sheet.
	 * @param sheet	Sprite sheet that contains the sprite.
	 */
	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColor(color);
	}
	
	/**
	 * Sprite constructor solid color.
	 * @param size	Size of one dimension of the sprite.
	 * @param color	Color of the sprite.
	 */
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[size*size];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	/**
	 * Makes every pixel in the sprite one specified color.
	 * @param color	The color of the sprite.
	 */
	private void setColor(int color) {
		for (int i = 0; i< pixels.length; i++) {
			pixels[i] = color;
		}
	}
	
	/**
	 * Populates pixels array from specified location on SpriteSheet.
	 */
	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels [x+y*SIZE] = sheet.pixels[(x + this.x) + (y + this.y)*sheet.SIZE];
			}
		}
	}
	
}
