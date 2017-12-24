package com.alexdrexler.gameEngine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Registers key presses to be handled in the game.
 * @author alexdrexler
 */
public class Keyboard implements KeyListener {
	
	private boolean[] keys = new boolean[65536];
	public boolean up, down, left, right;
	
	/**
	 * Updates boolean values based on key press, to create response from game.
	 */
	public void update() {
		// Removing support for WASD keys as it was causing a bug.
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
	}
	
	/**
	 * Registers down-pressed key.
	 */
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;	
	}
	
	/**
	 * Registers key release.
	 */
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	/**
	 * Handles key typed
	 */
	public void keyTyped(KeyEvent e) {
		
	}
}
