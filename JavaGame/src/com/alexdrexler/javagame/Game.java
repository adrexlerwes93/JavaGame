package com.alexdrexler.javagame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.alexdrexler.javagame.entity.mob.Player;
import com.alexdrexler.javagame.graphics.Screen;
import com.alexdrexler.javagame.input.Keyboard;
import com.alexdrexler.javagame.level.Level;
import com.alexdrexler.javagame.level.RandomLevel;

/**
 * Main Game class.
 * Initializes all basic information for game and runs game loop.
 * @author alexdrexler
 */
public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public static int width = 300;
	public static int height = 300 / 16*9;
	public static int scale = 3;
	
	private Thread gameThread;
	private JFrame frame;
	private Keyboard key;
	private Level level;
	private Player player;
	private boolean running = false;
	private static String title = "Java Game";
	private Screen screen;
	private BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	//convert image into array of pixels.
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	/**
	 * Game constructor.
	 */
	public Game() {
		Dimension size = new Dimension(width*scale,height*scale);
		setPreferredSize(size);
		
		screen = new Screen(width,height);
		frame = new JFrame();
		key = new Keyboard();
		level = new RandomLevel(64,64);
		player = new Player(key);
		
		frame.addKeyListener(key);
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
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0; //60 ups
		double delta = 0;
		int frames = 0;
		int updates = 0;
		//game loop.
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer+=1000;
				frame.setTitle(title+" | "+updates +" ups, "+ frames +" fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
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
		//create/store buffers.
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		//render pixels from level and add them to current image.
		screen.clear();
		int xScroll = player.x - screen.width/2;
		int yScroll = player.y - screen.height/2 + 16;
		level.render(xScroll,yScroll,screen);
		player.render(screen);
		for(int i=0; i<pixels.length;i++) pixels[i] = screen.pixels[i];
		
		//populate/display buffer
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		//create game instance.
		Game game = new Game();
		//initialize game window.
		game.frame.setResizable(false);
		game.frame.setTitle(title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		//run game.
		game.start();
	}
}
