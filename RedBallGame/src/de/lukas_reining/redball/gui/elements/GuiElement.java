package de.lukas_reining.redball.gui.elements;

import java.awt.Graphics;

import de.lukas_reining.redball.objects.Object;
import de.lukas_reining.redball.objects.dynamic.creatures.Creature;

public abstract class GuiElement {

	private int x, y;
	private int width, height;

	public GuiElement(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public abstract void update(double elapsed);

	public abstract void render(Graphics g);

}
