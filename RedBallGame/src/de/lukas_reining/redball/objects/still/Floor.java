package de.lukas_reining.redball.objects.still;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import de.lukas_reining.redball.objects.Object;

public class Floor extends Object {

	public Floor(double x, double y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	protected void loadResources() {
		sprites.add(assets.getSprite("Texture_Grass_1"));
	}

	@Override
	public void render(Graphics g) {
		for (int i = (int) getX(); i < getX() + width; i += height) {
			g.drawImage(sprites.get(0), i, (int) getY(), height, height, null);
		}
	}

	@Override
	public void update(double elapsed) {
		// TODO Auto-generated method stub

	}

}
