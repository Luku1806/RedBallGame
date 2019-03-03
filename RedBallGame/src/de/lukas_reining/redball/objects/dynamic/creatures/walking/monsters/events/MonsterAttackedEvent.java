package de.lukas_reining.redball.objects.dynamic.creatures.walking.monsters.events;

import de.lukas_reining.redball.objects.Object;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.monsters.GroundMonster;
import de.lukas_reining.redball.objects.events.Event;
import de.lukas_reining.redball.utils.Vec2D;

public class MonsterAttackedEvent extends Event {

	private GroundMonster monster;
	private Vec2D prevVelocity;

	public MonsterAttackedEvent(GroundMonster monster) {
		this(1000, monster);
	}

	public MonsterAttackedEvent(long duration, GroundMonster monster) {
		super(duration, monster);
		this.monster = monster;
	}

	@Override
	protected void onStart() {
		System.out.println("Event triggered");
		monster.setCurrentAnimation(Object.ANIMATION_HURT);
		prevVelocity = monster.getVelocity();
		monster.setVelocity(new Vec2D(0, prevVelocity.getY()));
	}

	@Override
	protected void onUpdate() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void onEnd() {
		System.out.println("Event ended");
		monster.setCurrentAnimation(Object.ANIMATION_IDLE);
		monster.setVelocity(prevVelocity);
	}

}
