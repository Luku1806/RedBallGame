package de.lukas_reining.redball.objects.dynamic.creatures.walking.player.events;

import de.lukas_reining.redball.objects.Object;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.player.Player;
import de.lukas_reining.redball.objects.events.Event;

public class PlayerHurtEvent extends Event {

	private Player player;
	private final static int DURATION = 1500;

	public PlayerHurtEvent(Player player) {
		super(DURATION, player);
		this.player = player;
		this.isExclusive = true; // !! Important
	}

	@Override
	protected void onStart() {
		player.setHealth(player.getHealth() - 1);

		if (player.getHealth() < 0) {
			player.setHealth(0);
		}
	}

	@Override
	protected void onUpdate() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onEnd() {
		// TODO Auto-generated method stub

	}

}
