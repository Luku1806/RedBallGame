package de.lukas_reining.redball.objects.dynamic.events;

import de.lukas_reining.redball.objects.dynamic.DynamicObject;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.player.Player;
import de.lukas_reining.redball.objects.events.Event;

public class ObjectAttackedEvent extends Event {

	private DynamicObject dynObject;
	
	public ObjectAttackedEvent(long duration, DynamicObject dynObject) {
		super(duration, dynObject);
		this.dynObject = dynObject;
	}

	@Override
	protected void onStart() {
		dynObject.hurt();
		dynObject.setIsHurt(true);
	}

	@Override
	protected void onUpdate() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onEnd() {
		// TODO Auto-generated method stub
		dynObject.setIsHurt(false);
	}

}
