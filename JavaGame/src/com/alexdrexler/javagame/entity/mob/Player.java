package com.alexdrexler.javagame.entity.mob;

import com.alexdrexler.javagame.graphics.Screen;
import com.alexdrexler.javagame.graphics.Sprite;
import com.alexdrexler.javagame.input.Keyboard;

public class Player extends Mob {
	
	private Keyboard input;
	private int anim = 0;
	private boolean moving;

	/**
	 * Standard Player constructor.
	 * @param input	Input handler to control player.
	 */
	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.playerDown;
	}
	
	/**
	 * Location specific Player constructor.
	 * @param x	Starting x location of player.
	 * @param y Starting x location of player.
	 */
	public Player(int x, int y, Keyboard input) {
		this.input = input;
		this.x = x;
		this.y = y;
		sprite = Sprite.playerDown;
	}
	
	/**
	 * Update player.
	 */
	public void update() {
		int xa = 0; int ya = 0;
		if (anim < 1000) anim++;
		else anim = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		if (xa!=0 || ya!=0) {
			move(xa,ya);
			moving = true;
		}
		else moving = false;
	}
	
	/**
	 * Render player.
	 */
	public void render(Screen screen) {
		if (dir == 2) {
			sprite = Sprite.playerDown;
			if (moving) {
				if (anim % 30 > 15) {
					sprite = Sprite.playerDownM1;
				}
				else sprite = Sprite.playerDownM2;
			}
		}
		if (dir == 0) {
			sprite = Sprite.playerUp;
			if (moving) {
				if (anim % 30 > 15) {
					sprite = Sprite.playerUpM1;
				}
				else sprite = Sprite.playerUpM2;
			}
		}
		if (dir == 1) {
			sprite = Sprite.playerRight;
			if (moving) {
				if (anim % 30 > 15) {
					sprite = Sprite.playerRightM1;
				}
				else sprite = Sprite.playerRightM2;
			}
		}
		if (dir ==3) {
			sprite = Sprite.playerLeft;
			if (moving) {
				if (anim % 30 > 15) {
					sprite = Sprite.playerLeftM1;
				}
				else sprite = Sprite.playerLeftM2;
			}
		}
		screen.renderPlayer(x-8, y+8, sprite);
	}
}
