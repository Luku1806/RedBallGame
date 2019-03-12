package de.lukas_reining.redball;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.lukas_reining.redball.gamelogic.Game;
import de.lukas_reining.redball.utils.KeyManager;
import de.lukas_reining.redball.worlds.GameWorld;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;

	// Window data
	private final static String title = "RedBall Game";

	// Other stuff
	private Canvas canvas;
	private BufferStrategy bufferStrategy;
	
	//GameStuff
	private GameWorld gameWorld;

	public Window(GameWorld gameWorld) {
		this(Game.WIDTH, Game.HEIGHT, gameWorld);
	}

	public Window(int width, int height, GameWorld gameWorld) {
		super(title);
		this.gameWorld = gameWorld;
		show(width, height);
	}

	public void show(int width, int height) {
		Dimension size = new Dimension(800, 600);

		canvas = new Canvas();
		canvas.setPreferredSize(size);
		canvas.setMinimumSize(size);
		canvas.setMaximumSize(size);

		bufferStrategy = canvas.getBufferStrategy();

		add(canvas);
		setResizable(false);
		pack();
		addKeyListener(KeyManager.getInstance());
		setVisible(true);
	}

	public void render() {
		// get the graphics object to render to
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();

		g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		transform(g);
		clear(g);
		gameWorld.render(g);
		g.dispose();

		// blit/flip the buffer
		BufferStrategy strategy = canvas.getBufferStrategy();
		if (!strategy.contentsLost()) {
			strategy.show();
		}

		// Sync the display on some systems.
		Toolkit.getDefaultToolkit().sync();
	}

	/**
	 * Performs any transformations to the graphics.
	 * <p>
	 * By default, this method puts the origin (0,0) in the center of the window and
	 * points the positive y-axis pointing up.
	 * 
	 * @param g the graphics object to render to
	 */
	protected void transform(Graphics2D g) {
		final int w = this.canvas.getWidth();
		final int h = this.canvas.getHeight();

		// flip the y axis and move the origin to the center (instead of it being in the
		// top left corner)
		AffineTransform yFlip = AffineTransform.getScaleInstance(1, -1);
		AffineTransform move = AffineTransform.getTranslateInstance(w / 2, -h / 2);
		g.transform(yFlip);
		g.transform(move);
	}

	/**
	 * Clears the previous frame.
	 * 
	 * @param g the graphics object to render to
	 */
	protected void clear(Graphics2D g) {
		final int w = this.canvas.getWidth();
		final int h = this.canvas.getHeight();

		g.setColor(Color.WHITE);
		g.fillRect(-w / 2, -h / 2, w, h);
	}

	class ResizeListener extends ComponentAdapter {
		@Override
		public void componentResized(ComponentEvent e) {
			// Game.WIDTH = e.getComponent().getWidth();
			// Game.HEIGHT = e.getComponent().getHeight();
		}
	}
}
