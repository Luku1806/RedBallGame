package de.lukas_reining.redball.objects.dynamic.creatures.walking;

import java.awt.Graphics;
import java.util.ArrayList;

import de.lukas_reining.redball.objects.Object;

public class Player extends WalkingCreature {

	public Player(double x, double y) {
		this(x, y, 150, 150);
	}

	public Player(double x, double y, int width, int height) {
		super(x, y, width, height);

		frictionIndex = 3;

		gravity.setY(1000);
		moveForce.setX(30);
		jumpForce.setY(-800);
	}
	
	@Override
	protected void loadResources() {
		sprites.add(assets.getSprite("Player"));
	}

	@Override
	public void render(Graphics g) {
		renderStatic(g);			
	}

	@Override
	public void update(double elapsed) {
		super.update(elapsed);
	}


	@Override
	public void checkCollisions(ArrayList<Object> objects) {
		super.checkCollisions(objects);
	}

}
