package de.lukas_reining.redball.gui.elements;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import de.lukas_reining.redball.objects.dynamic.creatures.walking.player.Player;
import de.lukas_reining.redball.utils.AssetManager;

public class PlayerHealthElement extends GuiElement{
	
	private final AssetManager assets;
	private final BufferedImage heartImage;
	
	private Player player;

	public PlayerHealthElement(int x, int y, int width, int height, Player player) {
		super(x, y, width, height);
		assets = AssetManager.getInstance();
		heartImage = assets.getSprite("Asset_Heart_0");
		this.player = player;
	}

	@Override
	public void update(double elapsed) {
	}

	@Override
	public void render(Graphics g) {
		for(int i = 0; i < player.getHealth(); i++) {
			g.drawImage(heartImage, x + ((height + 5) * i), y, height, height, null);
		}
	}

}
