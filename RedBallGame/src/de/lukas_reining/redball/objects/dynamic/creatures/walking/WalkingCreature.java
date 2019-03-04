package de.lukas_reining.redball.objects.dynamic.creatures.walking;

import de.lukas_reining.redball.objects.dynamic.creatures.Creature;
import de.lukas_reining.redball.utils.Vec2D;

public abstract class WalkingCreature extends Creature {

	// Forces
	protected Vec2D jumpForce;

	// Physical Properties
	protected float frictionIndex;

	public WalkingCreature(double x, double y, int width, int height) {
		super(x, y, width, height);
		jumpForce = new Vec2D();
		frictionIndex = 1;
		gravity.setY(1000);
	}

	@Override
	public void update(double elapsed) {
		super.update(elapsed);
		applyGravity();
		applyFriction();
	}

	protected void applyFriction() {
		// TODO Friction not working AT ALL
		if (velocity.length() != 0) {
			Vec2D negVelocity = new Vec2D(-velocity.getX(), 0);
			Vec2D friction = negVelocity.mult(frictionIndex);
			addForce(friction);
		}
	}

	public void jump() {
		if (isOnGround) {
			applyImpulse(jumpForce);
			isOnGround = false;
		}
	}

	public Vec2D getJumpForce() {
		return jumpForce;
	}

	public void setJumpForce(Vec2D jumpForce) {
		this.jumpForce = jumpForce;
	}

}
