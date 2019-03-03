package de.lukas_reining.redball.objects.still;

import java.awt.Color;
import java.awt.Graphics;

import de.lukas_reining.redball.objects.Object;

public class Box extends Object {

	public Box(double x, double y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	protected void loadResources() {
		sprites.add(assets.getSprite("Texture_Bricks_0"));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawImage(sprites.get(0), (int) getX(), (int) getY(), width, height,null);
	}

	@Override
	public void update(double elapsed) {
		super.update(elapsed);
	}

}
