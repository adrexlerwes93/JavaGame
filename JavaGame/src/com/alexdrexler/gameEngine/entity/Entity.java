package com.alexdrexler.gameEngine.entity;

import java.util.Random;

import com.alexdrexler.gameEngine.graphics.Screen;
import com.alexdrexler.gameEngine.level.Level;

/**
 * General class for all "non-static" objects in the game.
 * @author alexdrexler
 */
public class Entity {
	
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	/**
	 * Update any changes to entity.
	 */
	public void update() {
	}
	
	/**
	 * Necessary information for rendering the entity.
	 * @param screen	Screen that will render the entity.
	 */
	public void render(Screen screen) {

	}
	
	/**
	 * Remove entity from a level
	 */
	public void remove() {
		removed = true;
	}
	
	/**
	 * Check if entity is removed or not
	 * @return	removed
	 */
	public boolean isRemoved() {
		return removed;
	}
	
	/**
	 * Specifies the level that the entity is a part of.
	 * @param level
	 */
	public void init(Level level) {
		this.level = level;
	}
}
