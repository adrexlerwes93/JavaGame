package com.alexdrexler.gameEngine.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Reads in Sprite sheet PNG files to be used for Sprite creation.
 * **SPRITE SHEETS MUST BE SQUARE**
 * @author alexdrexler
 */
public class SpriteSheet {
	
	/**********************************************
	 * Static spritesheets to be referenced.
	 */
	public static SpriteSheet tiles = new SpriteSheet("/gameEngine/spritesheets/spritesheet1.png", 256);
	
	/**********************************************/

	private String path;
	public final int SIZE;
	public int[] pixels;
	
	/**
	 * SpriteSheet constructor.
	 * @param path	Path to PNG file in directory.
	 * @param size	Size of one dimension of the PNG image.
	 */
	public SpriteSheet(String path, int size) {
		this.path = path;
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		load();
	}
	
	/**
	 * Populates pixels array from PNG image at path.
	 */
	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
