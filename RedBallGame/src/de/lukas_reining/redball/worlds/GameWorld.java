package de.lukas_reining.redball.worlds;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import de.lukas_reining.redball.gamelogic.Game;
import de.lukas_reining.redball.objects.Object;
import de.lukas_reining.redball.objects.dynamic.creatures.Creature;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.Player;
import de.lukas_reining.redball.utils.Camera;

public abstract class GameWorld {

	// World Data
	protected int levelLenght;

	// Object stuff

	// Camera stuff
	protected Camera camera;

	public GameWorld(int levelLenght) {
		this.levelLenght = levelLenght;
		camera = new Camera();
		addInitialObjects();
	}

	public void initialise() {
		init();
		addInitialObjects();
	}

	protected abstract void init();

	protected abstract void addInitialObjects();

	public void update(double elapsed) {
		for (Object obj : objects) {
			obj.update(elapsed);
			// If creature check collisions
			if (obj instanceof Creature) {
				((Creature) obj).checkCollisions(objects);
			}
		}
	}

	public void render(Graphics g) {
		camera.refresh(g);
		for (Object obj : objects) {
			obj.render(g);
		}
	}

	public int getLenght() {
		return levelLenght;
	}

	public ArrayList<Object> getObjects() {
		return objects;
	}

	public Player getPlayer() {
		return player;
	}

	public Camera getCamera() {
		return camera;
	}

}
