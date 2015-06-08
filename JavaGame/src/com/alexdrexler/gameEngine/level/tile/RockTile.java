package com.alexdrexler.gameEngine.level.tile;

import com.alexdrexler.gameEngine.graphics.Sprite;

/**
 * Tile for a rock object.
 * @author alexdrexler
 */
public class RockTile extends Tile {

	/**
	 * RockTile constructor.
	 * @param sprite	Sprite image for the tile.
	 */
	public RockTile(Sprite sprite) {
		super(sprite);
	}
	
	/**
	 * Rock tile can't be walked over.
	 */
	public boolean solid() {
		return true;
	}
	
}
