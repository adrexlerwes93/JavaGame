package com.alexdrexler.gameEngine.entity.mob;

import com.alexdrexler.gameEngine.graphics.Screen;
import com.alexdrexler.gameEngine.graphics.Sprite;

/**
 * Test mobile entity.
 * @author alexdrexler
 */
public class TestMob extends Mob {
	
	private Sprite down = Sprite.temp_mob;
	private Sprite up = Sprite.temp_mob;
	private Sprite left = Sprite.temp_mob;
	private Sprite right = Sprite.temp_mob;
	
	/**
	 * TestMob constructor
	 * @param x Starting X location.
	 * @param y Starting Y location.
	 */
	public TestMob(int x, int y) {
		this.x = x << 4;
		this.y = y << 4;
		sprite = down;
	}

	/**
	 * Update mob.
	 */
	public void update() {	
		int xa = 0; 
		int ya = 0;
		if (dir == Direction.UP) ya--;
		if (dir == Direction.DOWN) ya++;
		if (dir == Direction.LEFT) xa--;
		if (dir == Direction.RIGHT) xa++;
		
		if (xa != 0 || ya != 0) {
			move (xa,ya);
			moving = true;
		}
		else moving = false;
	}

	/**
	 * Render mob.
	 */
	public void render(Screen screen) {
		screen.renderMob(x, y, sprite, 0);
	}
}
