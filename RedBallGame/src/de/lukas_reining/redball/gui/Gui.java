package de.lukas_reining.redball.gui;

import java.awt.Graphics;
import java.util.ArrayList;

import de.lukas_reining.redball.gui.elements.GuiElement;

public abstract class Gui {

	protected ArrayList<GuiElement> elements;

	public Gui() {
		elements = new ArrayList<GuiElement>();
		addInitialObjects();
	}

	public abstract void addInitialObjects();
	
	public void update(double elapsed) {
		for (GuiElement element : elements) {
			element.update(elapsed);
		}
	}

	public void render(Graphics g) {
		for (GuiElement element : elements) {
			element.render(g);
		}
	}

}
