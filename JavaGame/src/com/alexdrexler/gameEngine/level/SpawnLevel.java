package com.alexdrexler.gameEngine.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.alexdrexler.gameEngine.entity.mob.TestMob;
import com.alexdrexler.gameEngine.graphics.SpriteSheet;
import com.alexdrexler.gameEngine.level.tile.Tile;

/**
 * Generates and renders tiles for spawn level
 * @author alexdrexler
 */
public class SpawnLevel extends Level {
	
	private SpriteSheet levelSheet = SpriteSheet.tiles;

	/**
	 * SpawnLevel constructor.
	 * @param path Path to PNG image of level in directory.
	 */
	public SpawnLevel(String path) {
		super(path);
	}
	
	/**
	 * Loads level mapping from PNG image.
	 * @param path	Path to PNG image of level in directory.
	 */
	protected void loadLevel(String path) {
		sheet = levelSheet;
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			tiles = new int[width * height];
			image.getRGB(0, 0, width, height, tiles, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception! Could not load level file.");
		}
		add(new TestMob(8,7));
	}
}
