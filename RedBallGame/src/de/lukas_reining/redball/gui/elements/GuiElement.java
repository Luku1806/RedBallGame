package de.lukas_reining.redball.gui.elements;

import java.awt.Graphics;

public abstract class GuiElement {

	protected int x, y;
	protected int width;
	protected int height;

	public GuiElement(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public abstract void update(double elapsed);

	public abstract void render(Graphics g);

}
