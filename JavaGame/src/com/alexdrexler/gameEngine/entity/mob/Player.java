package com.alexdrexler.gameEngine.entity.mob;

import com.alexdrexler.gameEngine.graphics.Screen;
import com.alexdrexler.gameEngine.graphics.Sprite;
import com.alexdrexler.gameEngine.graphics.SpriteSheet;
import com.alexdrexler.gameEngine.input.Keyboard;

/**
 * Handles rendering and updating of the player.
 * @author alexdrexler
 */
public class Player extends Mob {
	
	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	
	/**
	 * Standard Player constructor.
	 * @param input	Input handler to control player.
	 */
	public Player(Keyboard input) {	
		this.input = input;
		sprite = Sprite.player_up;
	}
	
	/**
	 * Location specific Player constructor.
	 * @param x	Starting x location of player.
	 * @param y Starting x location of player.
	 */
	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_down;
	}
	
	/**
	 * Update player.
	 */
	public void update() {
		int xa=0, ya=0;
		if (anim < 100) anim++;
		else anim = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		
		if (xa != 0 || ya != 0) {
			move (xa,ya);
			moving = true;
		}
		else moving = false;
	}
	
	/**
	 * Render player.
	 */
	public void render(Screen screen) {
		int flip = 0;
		if (dir == Direction.UP) {
			sprite = Sprite.player_up;
			if (moving) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_up_1;
				} else sprite = Sprite.player_up_2;
			}
		}
		if (dir == Direction.RIGHT) {
			sprite = Sprite.player_right;
			if (moving) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_right_1;
				} else sprite = Sprite.player_right_2;
			}
		}
		if (dir == Direction.DOWN) {
			sprite = Sprite.player_down;
			if (moving) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_down_1;
				} else sprite = Sprite.player_down_2;
			}
		}
		if (dir == Direction.LEFT) {
			sprite = Sprite.player_left;
			if (moving) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_left_1;
				} else sprite = Sprite.player_left_2;
			}
		}
		//for flipping
		//if (dir == 1 || dir == 3) sprite = Sprite.player_right;
		//if (dir == 3) flip = 1;
		screen.renderMob(x-16, y-16, sprite, flip);

	}
}
