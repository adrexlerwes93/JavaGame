package com.alexdrexler.javagame.entity.mob;

import com.alexdrexler.javagame.entity.Entity;
import com.alexdrexler.javagame.graphics.Sprite;

public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
	/**
	 * Changes x and y locations of the mob.
	 * @param xc	Direction of x movement. (-1,0,1)
	 * @param yc	Direction of y movement. (-1,0,1)
	 */
	public void move(int xc, int yc) {
		if (xc > 0) dir = 1;
		if (xc < 0) dir = 3;
		if (yc > 0) dir = 2;
		if (yc < 0) dir = 0;
		
		if (!collision()) {
			x += xc;
			y += yc;
		}
	}
	
	/**
	 * Update mob.
	 */
	public void update() {
	}
	
	/**
	 * Render mob. 
	 */
	public void render() {
	}
	
	/**
	 * Return whether object is in contact with another solid object.
	 * @return collision.
	 */
	private boolean collision() {
		return false;
	}
}
