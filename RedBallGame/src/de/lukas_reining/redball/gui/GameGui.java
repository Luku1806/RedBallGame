package de.lukas_reining.redball.gui;

import java.awt.Graphics;

import de.lukas_reining.redball.gui.elements.PlayerHealthElement;

public class GameGui extends Gui {
	
	
	public GameGui() {
		super();
	}

	@Override
	public void addInitialObjects() {
		PlayerHealthElement phe = new PlayerHealthElement(30, 30, 50, 50);
		elements.add(phe);
	}
	
}
