package com.alexdrexler.javagame.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.alexdrexler.javagame.level.tile.Tile;

public class SpawnLevel extends Level {

	private int[] levelPixels;
	
	public SpawnLevel(String path) {
		super(path);
	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			image.getRGB(0, 0, width, height, levelPixels, 0, width);
			tiles = new Tile[width*height];
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void generateLevel() {
		
	}
}
