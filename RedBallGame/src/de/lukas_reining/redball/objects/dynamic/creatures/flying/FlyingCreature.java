package de.lukas_reining.redball.objects.dynamic.creatures.flying;

import de.lukas_reining.redball.objects.Object;
import de.lukas_reining.redball.objects.dynamic.creatures.Creature;

public abstract class FlyingCreature extends Creature {

	public FlyingCreature(double x, double y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void update(double elapsed) {
		super.update(elapsed);
	}

	@Override
	public void onCollisionLeft(Object object) {
		super.onCollisionLeft(object);
		moveForce.setX(moveForce.getX() * -1);
	}

	@Override
	public void onCollisionRight(Object object) {
		super.onCollisionRight(object);
		moveForce.setX(moveForce.getX() * -1);
	}

	@Override
	public void onCollisionBottom(Object object) {
		super.onCollisionBottom(object);
	}

	@Override
	public void onCollisionTop(Object object) {
		super.onCollisionTop(object);
	}

}
