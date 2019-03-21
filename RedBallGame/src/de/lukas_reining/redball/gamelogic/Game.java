package de.lukas_reining.redball.gamelogic;

import de.lukas_reining.redball.Window;
import de.lukas_reining.redball.gui.Gui;
import de.lukas_reining.redball.gui.elements.GameGui;
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
	
	//Gui stuff
	Gui currentGui;

	public Game() {
		currentWorld = new FirstWorld();
		currentGui = new GameGui();
		
		assets = AssetManager.getInstance();
		keys = KeyManager.getInstance();
		window = new Window(currentWorld, currentGui);
		
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
		if (keys.space_typed()) {
			currentWorld.getPlayer().jump();
			System.out.println("Juuump");
		}
	}

	@Override
	protected void update(double elapsed) {
		currentWorld.update(elapsed);
		currentGui.update(elapsed);
	}

	public World getCurrentWorld() {
		return currentWorld;
	}
}
