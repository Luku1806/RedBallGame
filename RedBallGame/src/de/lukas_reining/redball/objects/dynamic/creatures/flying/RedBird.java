package de.lukas_reining.redball.objects.dynamic.creatures.flying;

import java.awt.Graphics;

import de.lukas_reining.redball.objects.Object;

public class RedBird extends FlyingCreature {

	public RedBird(double x, double y) {
		this(x, y, 100, 100);
	}

	public RedBird(double x, double y, int width, int height) {
		super(x, y, width, height);
		moveForce.setX(4);
		framesPerSprite = 1;
		loadResources();
	}

	@Override
	protected void loadResources() {
		// Loaaaaaaaaad
		sprites.add(assets.getSprite("RedBird_0"));
		sprites.add(assets.getSprite("RedBird_1"));
		sprites.add(assets.getSprite("RedBird_2"));
		sprites.add(assets.getSprite("RedBird_3"));
		// Reversed
		sprites.add(assets.getSprite("RedBird_0_rev"));
		sprites.add(assets.getSprite("RedBird_1_rev"));
		sprites.add(assets.getSprite("RedBird_2_rev"));
		sprites.add(assets.getSprite("RedBird_3_rev"));

		// Create animations
		createAnimation(Object.ANIMATION_WALKING_RIGHT, 0, 4);
		createAnimation(Object.ANIMATION_WALKING_LEFT, 4, 8 );

		setCurrentAnimation(Object.ANIMATION_WALKING_LEFT);
	}

	@Override
	public void render(Graphics g) {
		if (velocity.getX() < 0) {
			setCurrentAnimation(Object.ANIMATION_WALKING_LEFT);
		} else {
			setCurrentAnimation(Object.ANIMATION_WALKING_RIGHT);
		}
		renderAnimated(g);
	}

	@Override
	public void update(double elapsed) {
		super.update(elapsed);
		applyImpulse(moveForce);
	}

}