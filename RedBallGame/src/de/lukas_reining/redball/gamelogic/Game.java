package de.lukas_reining.redball.gamelogic;

import de.lukas_reining.redball.Window;
import de.lukas_reining.redball.utils.AssetManager;
import de.lukas_reining.redball.utils.KeyManager;
import de.lukas_reining.redball.worlds.World;
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
	World currentWorld;

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

	public World getCurrentWorld() {
		return currentWorld;
	}
}
