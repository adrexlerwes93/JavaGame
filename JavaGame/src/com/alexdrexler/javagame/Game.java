package com.alexdrexler.javagame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

/**
 * Main Game class.
 * Initializes all basic information for game and runs game loop.
 * 
 * @author alexdrexler
 */
public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public static int width = 300;
	public static int height = 300 / 16*9;
	public static int scale = 3;
	
	private Thread gameThread;
	private JFrame frame;
	private boolean running = false;
	
	/**
	 * Game constructor.
	 */
	public Game() {
		Dimension size = new Dimension(width*scale,height*scale);
		setPreferredSize(size);
		
		frame = new JFrame();
	}
	
	/**
	 * Start game thread.
	 */
	public synchronized void start() {
		running = true;
		gameThread = new Thread(this, "Display");
		gameThread.start();
	}
	
	/**
	 * End game thread.
	 */
	public synchronized void stop() {
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Run game loop.
	 */
	public void run() {
		//game loop.
		while (running) {
			update();
			render();
		}
	}
	
	/**
	 * Updates game.
	 * UPS =
	 */
	public void update() {
	}
	
	/**
	 * Renders game.
	 */
	public void render() {
		//create/store buffers.
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		//populate/display buffer
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		//create game instance.
		Game game = new Game();
		//initialize game window.
		game.frame.setResizable(false);
		game.frame.setTitle("JavaGame");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		//run game.
		game.start();
	}
}
