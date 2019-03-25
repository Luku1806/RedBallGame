package de.lukas_reining.redball.objects.dynamic;

import java.util.ArrayList;

import de.lukas_reining.redball.objects.Object;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.player.events.PlayerHurtEvent;
import de.lukas_reining.redball.utils.Vec2D;

public abstract class DynamicObject extends Object {

	// General Properties

	// State variables
	protected boolean isOnGround;
	protected boolean isAlive;

	private int maxHealth = 5;
	private int health;

	// Forces
	protected Vec2D velocity;
	protected Vec2D acceleration;
	protected Vec2D impulses;
	protected Vec2D gravity;
	protected Vec2D moveForce;

	public DynamicObject(double x, double y, int width, int height) {
		super(x, y, width, height);

		isOnGround = false;
		isAlive = true;

		health = maxHealth;

		velocity = new Vec2D();
		acceleration = new Vec2D();
		impulses = new Vec2D();
		gravity = new Vec2D();
		moveForce = new Vec2D();
	}

	@Override
	public void update(double elapsed) {
		super.update(elapsed);
		applyForces(elapsed);
	}

	public void addForce(Vec2D force) {
		acceleration = acceleration.add(force);
	}

	protected void applyForces(double deltaTime) {
		velocity = velocity.add(acceleration.mult(deltaTime));
		position = position.add(velocity.mult(deltaTime));

		// Reset forces for next timestep
		acceleration = acceleration.mult(0);
	}

	public void applyImpulse(Vec2D impulse) {
		velocity = velocity.add(impulse);
	}

	protected void applyGravity() {
		addForce(gravity); // Gravity will always act on the body
	}

	public void checkCollisions(ArrayList<Object> objects) {
	}

	public void heal() {
		health++;
		if (health > 0) {
			health = maxHealth;
		}
	}

	public int getHealth() {
		return this.health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isHurt() {
		return this.isHurt;
	}

	public void setIsHurt(boolean hurt) {
		this.isHurt = hurt;
	}

	public boolean isAlive() {
		return this.isAlive;
	}

	public void setIsAlive(boolean alive) {
		this.isAlive = alive;
	}

	public Vec2D getVelocity() {
		return this.velocity;
	}

	public void setVelocity(Vec2D vel) {
		this.velocity = vel;
	}

	public Vec2D getMoveForce() {
		return this.moveForce;
	}

	public void setMoveForce(Vec2D mov) {
		this.moveForce = mov;
	}
}
