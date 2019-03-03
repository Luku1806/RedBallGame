package de.lukas_reining.redball.objects.dynamic.creatures.walking.monsters;

import java.awt.Graphics;

import de.lukas_reining.redball.objects.Object;

public class YellowBubbleMonster extends GroundMonster {

	public YellowBubbleMonster(double x, double y) {
		this(x, y, 125, 125);
	}

	public YellowBubbleMonster(double x, double y, int width, int height) {
		super(x, y, width, height);
		framesPerSprite = 5;
		moveForce.setX(8);
		jumpForce.setY(-400);
	}

	@Override
	protected void loadResources() {
		sprites.add(assets.getSprite("YellowBubbleMonster_Idle_0"));
		sprites.add(assets.getSprite("YellowBubbleMonster_Idle_1"));
		sprites.add(assets.getSprite("YellowBubbleMonster_Idle_2"));
		sprites.add(assets.getSprite("YellowBubbleMonster_Idle_3"));
		sprites.add(assets.getSprite("YellowBubbleMonster_Idle_4"));
		sprites.add(assets.getSprite("YellowBubbleMonster_Idle_5"));
		sprites.add(assets.getSprite("YellowBubbleMonster_Idle_6"));
		sprites.add(assets.getSprite("YellowBubbleMonster_Idle_7"));
		sprites.add(assets.getSprite("YellowBubbleMonster_Hit_0"));
		sprites.add(assets.getSprite("YellowBubbleMonster_Hit_1"));

		createAnimation(Object.ANIMATION_IDLE, 0, 8);
		createAnimation(Object.ANIMATION_HURT, 8, 10);

		setCurrentAnimation(Object.ANIMATION_HURT);
	}

	@Override
	public void render(Graphics g) {
		renderAnimated(g);
	}

	@Override
	public void update(double elapsed) {
		jump();
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
