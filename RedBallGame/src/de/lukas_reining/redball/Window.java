package de.lukas_reining.redball;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.lukas_reining.redball.gamelogic.Game;
import de.lukas_reining.redball.objects.Object;
import de.lukas_reining.redball.utils.KeyManager;
import de.lukas_reining.redball.worlds.World;

public class Window extends JPanel {

	// Window data
	private final String title = "RedBall Game";
	private int renderWidth;
	private int renderHeight;
	private float height_width_ratio;

	// Drawing stuff
	private BufferedImage buffer;
	private Graphics2D bufferGraphics;

	// Other stuff
	private JFrame frame;
	private World world;

	public Window(World world) {
		this(Game.WIDTH, Game.HEIGHT, world);
	}

	public Window(int width, int height, World world) {
		this.renderWidth = width;
		this.renderHeight = height;
		this.height_width_ratio = height / width;
		this.world = world;
		this.frame = new JFrame();

		this.buffer = new BufferedImage(renderWidth, renderHeight, BufferedImage.TYPE_INT_RGB);
		this.bufferGraphics = buffer.createGraphics();

		show(width, height);
	}

	public void show(int width, int height) {
		this.setPreferredSize(new Dimension(width, height));
		this.addComponentListener(new ResizeListener());
		setBackground(Color.BLACK);
		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.addKeyListener(KeyManager.getInstance());
		frame.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // paint parent's background

		//Render to buffer
		Graphics2D buffGraphics = buffer.createGraphics();
		render(buffGraphics);
		buffGraphics.dispose();

		// Scale
		float scale = Math.min((float) getWidth() / Game.WIDTH, (float) getHeight() / Game.HEIGHT);
		int displayWidth = (int) (Game.WIDTH * scale);
		int displayHeight = (int) (Game.HEIGHT * scale);

		//Render scaled image to screen
		g.drawImage(buffer, getWidth() / 2 - displayWidth / 2, getHeight() / 2 - displayHeight / 2, displayWidth,
				displayHeight, null);
	}

	public void render(Graphics g) {
		world.render(g);
	}

	class ResizeListener extends ComponentAdapter {
		public void componentResized(ComponentEvent e) {
			// Game.WIDTH = e.getComponent().getWidth();
			// Game.HEIGHT = e.getComponent().getHeight();
		}
	}
}
