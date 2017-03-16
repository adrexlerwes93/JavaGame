package com.alexdrexler.gameEngine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.alexdrexler.gameEngine.entity.mob.Player;
import com.alexdrexler.gameEngine.graphics.Screen;
import com.alexdrexler.gameEngine.input.Keyboard;
import com.alexdrexler.gameEngine.input.Mouse;
import com.alexdrexler.gameEngine.level.Level;
import com.alexdrexler.gameEngine.level.RandomLevel;
import com.alexdrexler.gameEngine.level.SpawnLevel;
import com.alexdrexler.gameEngine.level.TileCoordinate;

/**
 * Main Game class.
 * Initializes all basic information for game and runs game loop.
 * @author alexdrexler
 */
public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	public static String title = "Java Game";
	
	private Thread thread;
	private JFrame frame;
	private Keyboard key;
	private Level level;
	private Player player;
	private boolean running = false;
	
	private Screen screen;
	
	//array of pixels to be rendered to the screen.
	private BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	/**
	 * Game constructor.
	 */
	public Game() {
		Dimension size = new Dimension(width*scale, height*scale);
		setPreferredSize(size);
		
		screen = new Screen(width, height);
		frame = new JFrame();
		frame.setTitle(title);
		key = new Keyboard();
		level = new SpawnLevel("/gameEngine/levels/spawnlevel.png");
		TileCoordinate playerSpawn = new TileCoordinate(32,32);
		player = new Player(playerSpawn.getX(),playerSpawn.getY(),key);
		player.init(level);
		frame.addKeyListener(key);
		//CODE FOR MOUSE LISTENER
		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void changeLevel(Level newLevel) {
		level = newLevel;
	}
	
	/**
	 * Start game thread.
	 */
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	/**
	 * End game thread.
	 */
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Run game loop.
	 */
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		while (running) {
			frame.requestFocusInWindow();
			long now = System.nanoTime();
			delta += (now-lastTime)/ns;
			lastTime = now;
			while(delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(title + " || " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
	}
	
	/**
	 * Updates game.
	 */
	public void update() {
		key.update();
		player.update();
	}
	
	/**
	 * Renders game.
	 */
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		int xScroll = player.x - screen.width/2;
		int yScroll = player.y - screen.height/2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		//display all graphics here
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 50));
		//g.fillRect(Mouse.getX(), Mouse.getY(), 32, 32);
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
	
}
