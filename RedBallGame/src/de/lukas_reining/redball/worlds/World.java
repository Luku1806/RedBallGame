package de.lukas_reining.redball.worlds;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import de.lukas_reining.redball.objects.Object;
import de.lukas_reining.redball.objects.dynamic.DynamicObject;
import de.lukas_reining.redball.objects.dynamic.creatures.Creature;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.player.Player;
import de.lukas_reining.redball.utils.Camera;

public abstract class World {

	// World Data
	protected int levelLenght;

	// Object stuff
	protected ArrayList<Object> objects;
	protected Player player;

	// Camera stuff
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
			if (obj instanceof Creature) {
				((Creature) obj).checkCollisions(objects);
			}
			// Check if object is alive
			if (obj instanceof DynamicObject) {
				if (!((DynamicObject) obj).isAlive() && !(obj instanceof Player)) {
					killGameObject(obj);
				}
			}
		}
	}

	public void render(Graphics g) {
		// Save old transformation
		Graphics2D g2d = ((Graphics2D) g);
		AffineTransform oldXForm = g2d.getTransform();

		camera.refresh(g2d);
		for (Object obj : objects) {
			obj.render(g2d);
		}

		// Reset transformation
		g2d.setTransform(oldXForm);
	}

	public void killGameObject(Object object) {
		objects.remove(object);
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
