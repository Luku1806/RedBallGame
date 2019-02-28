package de.lukas_reining.redball.worlds;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import de.lukas_reining.redball.gamelogic.Game;
import de.lukas_reining.redball.objects.Object;
import de.lukas_reining.redball.objects.dynamic.creatures.Creature;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.Player;
import de.lukas_reining.redball.utils.Camera;

public abstract class World {

	// World Data
	protected int levelLenght;

	// Object stuff
	protected ArrayList<Object> objects;
	protected Player player;
	private Color colorBackground = new Color(50, 219, 255);
	
	//Camera stuff
	protected Camera camera;

	public World(int levelLenght) {
		this.levelLenght = levelLenght;
		camera = new Camera();
		objects = new ArrayList<Object>();
		addInitialObjects();
	}

	protected abstract void addInitialObjects();

	public void update(double elapsed) {
		for (Object obj : objects) {
			obj.update(elapsed);
			// If creature check collisions
			if (obj instanceof Creature && obj != player) {
				((Creature) obj).checkCollisions(objects);
			}
		}
		//Check player collisions
		if (player != null) {
			player.checkCollisions(objects);
		}
	}
	
	
	public void render(Graphics g) {
		//TODO Dynamic/variable background
		g.setColor(colorBackground);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		
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
