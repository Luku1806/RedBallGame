package de.lukas_reining.redball.gui;

import de.lukas_reining.redball.gamelogic.Game;
import de.lukas_reining.redball.gui.elements.PlayerHealthElement;

public class GameGui extends Gui {
	
	private Game game;
	
	public GameGui(Game game) {
		this.game = game;
		addInitialObjects();
	}

	@Override
	public void addInitialObjects() {
		PlayerHealthElement phe = new PlayerHealthElement(30, 30, 50, 50, game.getCurrentWorld().getPlayer());
		elements.add(phe);
	}
	
}
