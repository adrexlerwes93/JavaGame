package com.alexdrexler.javagame.level.tile;

import com.alexdrexler.javagame.graphics.Sprite;

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
	
	public boolean solid() {
		return true;
	}
}
