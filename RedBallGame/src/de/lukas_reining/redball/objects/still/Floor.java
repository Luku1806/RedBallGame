package de.lukas_reining.redball.objects.still;

import java.awt.Color;
import java.awt.Graphics;

import de.lukas_reining.redball.objects.Object;

public class Floor extends Object {

	public Floor(double x, double y, int width, int height) {
		super(x, y, width, height);
	}
	
	@Override
	protected void loadResources() {

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect((int) getX(), (int) getY(), width, height);
	}

	@Override
	public void update(double elapsed) {
		// TODO Auto-generated method stub

	}

}
