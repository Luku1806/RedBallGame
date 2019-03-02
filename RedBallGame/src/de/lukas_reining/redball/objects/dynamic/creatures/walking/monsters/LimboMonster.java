package de.lukas_reining.redball.objects.dynamic.creatures.walking.monsters;

import java.awt.Graphics;

import de.lukas_reining.redball.objects.Object;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.WalkingCreature;

public class LimboMonster extends GroundMonster {

	public LimboMonster(double x, double y) {
		this(x, y, 125, 125);
	}

	public LimboMonster(double x, double y, int width, int height) {
		super(x, y, width, height);
		framesPerSprite = 15;
		moveForce.setX(5);
	}

	@Override
	protected void loadResources() {
		sprites.add(assets.getSprite("LimboMonster_Idle_0"));
		sprites.add(assets.getSprite("LimboMonster_Idle_1"));
		sprites.add(assets.getSprite("LimboMonster_Hit_0"));
		sprites.add(assets.getSprite("LimboMonster_Jump_Fall"));
		sprites.add(assets.getSprite("LimboMonster_Jump_Up"));

		createAnimation(Object.ANIMATION_IDLE, 0, 2);
		createAnimation(Object.ANIMATION_HURT, 2, 3);
		createAnimation(Object.ANIMATION_JUMPING_FALL, 3, 4);
		createAnimation(Object.ANIMATION_JUMPIG_UP, 4, 5);

		setCurrentAnimation(Object.ANIMATION_IDLE);
	}

	@Override
	public void render(Graphics g) {
		renderAnimated(g);
	}

	@Override
	public void update(double elapsed) {
		super.update(elapsed);
	}

	@Override
	public void onCollisionLeft(Object object) {
		super.onCollisionLeft(object);
	}

	@Override
	public void onCollisionRight(Object object) {
		super.onCollisionRight(object);
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
