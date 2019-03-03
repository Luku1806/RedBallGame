package de.lukas_reining.redball.objects.still.tiled;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import de.lukas_reining.redball.objects.Object;

public class Water extends TiledObject {

	public Water(double x, double y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	protected void loadResources() {
		sprites.add(assets.getSprite("Texture_Water_0"));
	}

	@Override
	public void render(Graphics g) {
	super.render(g);
	}

	@Override
	public void update(double elapsed) {
		super.update(elapsed);
	}

}
