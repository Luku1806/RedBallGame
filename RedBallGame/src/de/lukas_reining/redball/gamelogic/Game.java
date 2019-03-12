package de.lukas_reining.redball.gamelogic;

import de.lukas_reining.redball.Window;
import de.lukas_reining.redball.utils.AssetManager;
import de.lukas_reining.redball.utils.KeyManager;
import de.lukas_reining.redball.worlds.GameWorld;
import de.lukas_reining.redball.worlds.plain.FirstWorld;

public class Game extends GameLoop {

	// View stuff
	public static int WIDTH = 1280;
	public static int HEIGHT = 720;
	private Window window;

	// Utility's
	private AssetManager assets;
	private KeyManager keys;

	// World stuff
	GameWorld currentWorld;

	public Game() {
		currentWorld = new FirstWorld();
		
		assets = AssetManager.getInstance();
		keys = KeyManager.getInstance();
		window = new Window(currentWorld);
		
		startGameloop();
	}

	@Override
	protected void render() {
		window.repaint();
	}

	@Override
	protected void handleInput() {
		if (keys.left_pressed()) {
			currentWorld.getPlayer().moveLeft();
		}
		if (keys.right_pressed()) {
			currentWorld.getPlayer().moveRight();
		}
		if (keys.space_pressed()) {
			currentWorld.getPlayer().jump();
		}
	}

	@Override
	protected void update(double elapsed) {
		currentWorld.update(elapsed);
	}

	public GameWorld getCurrentGameWorld() {
		return currentWorld;
	}
}

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.dyn4j.dynamics.World;

/**
 * A very VERY simple framework for building samples.
 * @since 3.2.0
 * @version 3.2.0
 */
public abstract class Test extends JFrame {
	/** The serial version id */
	private static final long serialVersionUID = 7659608187025022915L;

	/** The conversion factor from nano to base */
	public static final double NANO_TO_BASE = 1.0e9;

	/** The canvas to draw to */
	protected final Canvas canvas;
	
	/** The dynamics engine */
	protected final World world;
	
	/** The pixels per meter scale factor */
	protected final double scale;
	
	/** True if the simulation is exited */
	private boolean stopped;
	
	/** True if the simulation is paused */
	private boolean paused;
	
	/** The time stamp for the last iteration */
	private long last;
	
	/**
	 * Constructor.
	 * <p>
	 * By default creates a 800x600 canvas.
	 * @param name the frame name
	 * @param scale the pixels per meter scale factor
	 */
	public Game(String title, double scale) {
		super(title);
		
		// set the scale
		this.scale = scale;
		
		// create the world
		this.world = new World();
		
		// setup the JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add a window listener
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// before we stop the JVM stop the simulation
				stop();
				super.windowClosing(e);
			}
		});
		
		// create the size of the window
		Dimension size = new Dimension(800, 600);
		
		// create a canvas to paint to 
		this.canvas = new Canvas();
		this.canvas.setPreferredSize(size);
		this.canvas.setMinimumSize(size);
		this.canvas.setMaximumSize(size);
		
		// add the canvas to the JFrame
		this.add(this.canvas);
		this.setResizable(false);
		this.pack();
	}
	
	/**
	 * Start active rendering the simulation.
	 * <p>
	 * This should be called after the JFrame has been shown.
	 */
	private void start() {
		canvas.setIgnoreRepaint(true);
		canvas.createBufferStrategy(2);
		
		Thread thread = new Thread() {
			public void run() {
				while (!isStopped()) {
					gameLoop();
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {}
				}
			}
		};
		
		// start the game loop
		thread.start();
	}
	
	/**
	 * The method calling the necessary methods to update
	 * the game, graphics, and poll for input.
	 */
	private void gameLoop() {
		// get the graphics object to render to
		Graphics2D g = (Graphics2D)this.canvas.getBufferStrategy().getDrawGraphics();
		
		// by default, set (0, 0) to be the center of the screen with the positive x axis
		// pointing right and the positive y axis pointing up
		transform(g);
		
		// reset the view
		clear(g);
		
		// get the current time
        long time = System.nanoTime();
        // get the elapsed time from the last iteration
        long diff = time - this.last;
        // set the last time
        last = time;
    	// convert from nanoseconds to seconds
    	double elapsedTime = (double)diff / NANO_TO_BASE;
		
		// render anything about the simulation (will render the World objects)
		this.render(g);
        
		if (!paused) {
	        // update the World
	        this.update(g, elapsedTime);
		}
		
		// dispose of the graphics object
		g.dispose();
		
		// blit/flip the buffer
		BufferStrategy strategy = this.canvas.getBufferStrategy();
		if (!strategy.contentsLost()) {
			strategy.show();
		}
		
		// Sync the display on some systems.
        // (on Linux, this fixes event queue problems)
        Toolkit.getDefaultToolkit().sync();
	}

	/**
	 * Performs any transformations to the graphics.
	 * <p>
	 * By default, this method puts the origin (0,0) in the center of the window
	 * and points the positive y-axis pointing up.
	 * @param g the graphics object to render to
	 */
	protected void transform(Graphics2D g) {
		final int w = this.canvas.getWidth();
		final int h = this.canvas.getHeight();
		
		// before we render everything im going to flip the y axis and move the
		// origin to the center (instead of it being in the top left corner)
		AffineTransform yFlip = AffineTransform.getScaleInstance(1, -1);
		AffineTransform move = AffineTransform.getTranslateInstance(w / 2, -h / 2);
		g.transform(yFlip);
		g.transform(move);
	}
	
	/**
	 * Clears the previous frame.
	 * @param g the graphics object to render to
	 */
	protected void clear(Graphics2D g) {
		final int w = this.canvas.getWidth();
		final int h = this.canvas.getHeight();
		
		// lets draw over everything with a white background
		g.setColor(Color.WHITE);
		g.fillRect(-w / 2, -h / 2, w, h);
	}
	
	/**
	 * Renders the example.
	 * @param g the graphics object to render to
	 */
	protected void render(Graphics2D g) {
		// draw all the objects in the world
		for (int i = 0; i < this.world.getBodyCount(); i++) {
			// get the object
			SimulationBody body = (SimulationBody) this.world.getBody(i);
			this.render(g, elapsedTime, body);
		}
	}
	
	/**
	 * Renders the body.
	 * @param g the graphics object to render to
	 * @param elapsedTime the elapsed time from the last update
	 * @param body the body to render
	 */
	protected void render(Graphics2D g, double elapsedTime, SimulationBody body) {
		// draw the object
		body.render(g, this.scale);
	}
	
	/**
	 * Updates the world.
	 * @param elapsedTime the elapsed time from the last update
	 */
	protected void update(double elapsedTime) {
        // update the world with the elapsed time
        world.update(elapsedTime);
	}
	
	/**
	 * Stops the simulation.
	 */
	public synchronized void stop() {
		this.stopped = true;
	}
	
	/**
	 * Returns true if the simulation is stopped.
	 * @return boolean true if stopped
	 */
	public boolean isStopped() {
		return this.stopped;
	}
	
	/**
	 * Pauses the simulation.
	 */
	public synchronized void pause() {
		this.paused = true;
	}
	
	/**
	 * Pauses the simulation.
	 */
	public synchronized void resume() {
		this.paused = false;
	}
	
	/**
	 * Returns true if the simulation is paused.
	 * @return boolean true if paused
	 */
	public boolean isPaused() {
		return this.paused;
	}
	
	/**
	 * Starts the simulation.
	 */
	public void run() {
		// set the look and feel to the system look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		// show it
		this.setVisible(true);
		
		// start it
		this.start();
	}
}
