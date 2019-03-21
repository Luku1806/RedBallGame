package de.lukas_reining.redball.objects.still.tiled;

import java.awt.Graphics;

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
