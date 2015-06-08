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
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
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
