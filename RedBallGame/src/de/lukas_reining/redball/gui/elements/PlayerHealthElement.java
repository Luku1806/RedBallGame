package de.lukas_reining.redball.gui.elements;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import de.lukas_reining.redball.utils.AssetManager;

public class PlayerHealthElement extends GuiElement{
	
	private final AssetManager assets;
	private final BufferedImage heartImage;
	
	private int hearts = 5;

	public PlayerHealthElement(int x, int y, int width, int height) {
		super(x, y, width, height);
		assets = AssetManager.getInstance();
		heartImage = assets.getSprite("Asset_Heart_0");
	}

	@Override
	public void update(double elapsed) {
	}

	@Override
	public void render(Graphics g) {
		for(int i = 0; i < hearts; i++) {
			g.drawImage(heartImage, x + (height * i), y, height, height, null);
		}
	}

}
