package de.lukas_reining.redball.objects.still.tiled;

import java.awt.Graphics;

public class Floor extends TiledObject {

	public Floor(double x, double y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	protected void loadResources() {
		sprites.add(assets.getSprite("Texture_Grass_0"));
	}

	@Override
	public void render(Graphics g) {
		super.render(g);
		
//		for (int i = (int) getX(); i < getX() + width; i += height) {
//			g.drawImage(sprites.get(0), i, (int) getY(), height, height, null);
//		}

	}

	@Override
	public void update(double elapsed) {
		super.update(elapsed);
	}

}
