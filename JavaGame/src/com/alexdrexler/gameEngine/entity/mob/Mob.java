package com.alexdrexler.gameEngine.entity.mob;

import com.alexdrexler.gameEngine.entity.Entity;
import com.alexdrexler.gameEngine.graphics.Screen;
import com.alexdrexler.gameEngine.graphics.Sprite;

/**
 * Render and update information regarding mobile entities.
 * @author alexdrexler
 *
 */
public abstract class Mob extends Entity{
	protected Sprite sprite;
	protected boolean moving = false;
	
	protected enum Direction { UP, DOWN, LEFT, RIGHT }
	protected Direction dir = Direction.DOWN;
	
	/**
	 * Changes x and y locations of the mob.
	 * @param xc	Direction of x movement. (-1,0,1)
	 * @param yc	Direction of y movement. (-1,0,1)
	 */
	public void move(int xa, int ya) {
		if (xa > 0) dir = Direction.RIGHT;
		if (xa < 0) dir = Direction.LEFT;
		if (ya > 0) dir = Direction.DOWN;
		if (ya < 0) dir = Direction.UP;
			
		if (!collision(xa,0)) x += xa;
		if (!collision(0,ya)) y += ya;
	}
	
	/**
	 * Return whether object is in contact with another solid object.
	 * @return collision.
	 */
	private boolean collision(int xa,int ya) {
		boolean collision = false;
		for (int c=0; c<4; c++) {
			int cornerX = ((x+xa)>>4)-(c%2);
			int cornerY = ((y+ya)>>4)-c/2;
			if (c == 0) {
				cornerX = ((x+xa-1)>>4)-(c%2);
				cornerY = ((y+ya-1)>>4)-c/2;
			}
			if (c == 1) {
				cornerX = ((x+xa+1)>>4)-(c%2);
				cornerY = ((y+ya-1)>>4)-c/2;
			}
			if (c == 2) {
				cornerX = ((x+xa-1)>>4)-(c%2);
				cornerY = ((y+ya+1)>>4)-c/2;
			}
			if (c == 3) {
				cornerX = ((x+xa+1)>>4)-(c%2);
				cornerY = ((y+ya+1)>>4)-c/2;
			}
			if (level.getTile(cornerX, cornerY).solid()){
				collision = true;
			}
		}
		return collision;
	}
	
	/**
	 * Update mob.
	 */
	public abstract void update();
	
	/**
	 * Render mob. 
	 */
	public abstract void render(Screen screen);
}
