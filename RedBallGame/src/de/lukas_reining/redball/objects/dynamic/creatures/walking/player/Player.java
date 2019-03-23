package de.lukas_reining.redball.objects.dynamic.creatures.walking.player;

import java.awt.Graphics;
import java.util.ArrayList;

import de.lukas_reining.redball.objects.Object;
import de.lukas_reining.redball.objects.dynamic.creatures.flying.FlyingCreature;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.WalkingCreature;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.monsters.GroundMonster;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.monsters.events.MonsterAttackedEvent;

public class Player extends WalkingCreature {

	private final int maxHealth = 5;
	private int health = maxHealth;
	
	public Player(double x, double y) {
		this(x, y, 150, 150);
	}

	public Player(double x, double y, int width, int height) {
		super(x, y, width, height);

		frictionIndex = 3;

		gravity.setY(1000);
		moveForce.setX(30);
		jumpForce.setY(-800);
	}
	
	@Override
	protected void loadResources() {
		sprites.add(assets.getSprite("Player"));
	}

	@Override
	public void render(Graphics g) {
		renderStatic(g);			
	}

	@Override
	public void update(double elapsed) {
		super.update(elapsed);
	}


	@Override
	public void checkCollisions(ArrayList<Object> objects) {
		super.checkCollisions(objects);
	}
	
	@Override
	public void onCollisionLeft(Object object) {
		super.onCollisionLeft(object);
		if (object instanceof GroundMonster || object instanceof FlyingCreature) {
			hurt(); // Player is hurt
		}
	}

	@Override
	public void onCollisionRight(Object object) {
		super.onCollisionRight(object);
		if (object instanceof GroundMonster || object instanceof FlyingCreature) {
			hurt(); // Player is hurt
		}
	}

	@Override
	public void onCollisionBottom(Object object) {
		super.onCollisionBottom(object);
		if (object instanceof GroundMonster || object instanceof FlyingCreature) {
			heal(); // Player heals
		}
	}

	@Override
	public void onCollisionTop(Object object) {
		super.onCollisionTop(object);
	}

	public void hurt() {
		health--;
		if(health < 0) {
			health = 0;
		}
	}
	
	public void heal() {
		health++;
		if(health > 0) {
			health = maxHealth;
		}
	}
	
	public int getHealth() {
		return this.health;
	}

}
