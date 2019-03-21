package de.lukas_reining.redball.gui;

import java.awt.Graphics;

public abstract class Gui {
	
	public Gui() {
		
	}

	public abstract void update(double elapsed);

	public abstract void render(Graphics g);


}
