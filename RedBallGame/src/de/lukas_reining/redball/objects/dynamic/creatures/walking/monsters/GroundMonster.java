package de.lukas_reining.redball.objects.dynamic.creatures.walking.monsters;

import java.util.ArrayList;

import de.lukas_reining.redball.objects.Object;
import de.lukas_reining.redball.objects.dynamic.creatures.Creature;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.WalkingCreature;
import de.lukas_reining.redball.objects.still.tiled.Water;

public abstract class GroundMonster extends WalkingCreature {

	public GroundMonster(double x, double y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void update(double elapsed) {
		super.update(elapsed);
		applyImpulse(moveForce);
	}

	@Override
	public void checkCollisions(ArrayList<Object> objects) {
		super.checkCollisions(objects);
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
