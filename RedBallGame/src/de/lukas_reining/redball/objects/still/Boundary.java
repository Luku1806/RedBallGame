package de.lukas_reining.redball.objects.still;

import java.awt.Color;
import java.awt.Graphics;

import de.lukas_reining.redball.objects.Object;

public class Boundary extends Object {

	public Boundary(double x, double y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	protected void loadResources() {

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) getX(), (int) getY(), width, height);
	}

	@Override
	public void update(double elapsed) {
		super.update(elapsed);
	}

}
