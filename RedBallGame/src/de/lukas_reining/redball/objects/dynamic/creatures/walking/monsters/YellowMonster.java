
package de.lukas_reining.redball.objects.dynamic.creatures.walking.monsters;

import java.awt.Graphics;

import de.lukas_reining.redball.objects.Object;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.WalkingCreature;

public class YellowMonster extends WalkingCreature {

	public YellowMonster(double x, double y) {
		this(x, y, 125, 125);
	}

	public YellowMonster(double x, double y, int width, int height) {
		super(x, y, width, height);
		framesPerSprite = 5;
		moveForce.setX(8);
	}

	@Override
	protected void loadResources() {
		sprites.add(assets.getSprite("YellowMonster_Idle_0"));
		sprites.add(assets.getSprite("YellowMonster_Idle_1"));
		sprites.add(assets.getSprite("YellowMonster_Hit_0"));

		createAnimation(Object.ANIMATION_IDLE, 0, 2);
		createAnimation(Object.ANIMATION_HURT, 2, 3);

		setCurrentAnimation(Object.ANIMATION_IDLE);
	}

	@Override
	public void render(Graphics g) {
		renderAnimated(g);
	}

	@Override
	public void update(double elapsed) {
		super.update(elapsed);
		applyImpulse(moveForce);
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
