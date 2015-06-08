package com.alexdrexler.gameEngine.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Registers mouse action to be handled in the game.
 * @author alexdrexler
 */
public class Mouse implements MouseListener, MouseMotionListener {
	
	private static int mouseX = -1;
	private static int mouseY = -1;
	private static int mouseB = -1;
	
	/**
	 * Returns x location of mouse on screen.
	 * @return X location of mouse on screen.
	 */
	public static int getX() {
		return mouseX;
	}
	
	/**
	 * Returns y location of mouse on screen.
	 * @return Y location of mouse on screen.
	 */
	public static int getY() {
		return mouseY;
	}
	
	/**
	 * Returns button pressed on mouse.
	 * @return Button pressed on mouse.
	 */
	public static int getButton() {
		return mouseB;
	}

	/**
	 * Fire when mouse dragged.
	 */
	public void mouseDragged(MouseEvent e) {	
	}

	/**
	 * Fire when mouse moved.
	 */
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX()-16;
		mouseY = e.getY()-16;
	}

	/**
	 * Fire when mouse clicked.
	 */
	public void mouseClicked(MouseEvent e) {
	}

	/**
	 * Fire when mouse pressed.
	 */
	public void mousePressed(MouseEvent e) {
		mouseB = e.getButton();
	}

	/**
	 * Fire when mouse released.
	 */
	public void mouseReleased(MouseEvent e) {
		mouseB = -1;
	}

	/**
	 * Fire when mouse entered screen.
	 */
	public void mouseEntered(MouseEvent e) {	
	}

	/**
	 * Fire when mouse exited screen.
	 */
	public void mouseExited(MouseEvent e) {
	}

}
