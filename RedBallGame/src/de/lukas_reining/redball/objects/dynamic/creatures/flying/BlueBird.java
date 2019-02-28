package de.lukas_reining.redball.objects.dynamic.creatures.flying;

import java.awt.Graphics;
import de.lukas_reining.redball.objects.Object;

public class BlueBird extends FlyingCreature {

	public BlueBird(double x, double y) {
		this(x, y, 100, 100);
	}

	public BlueBird(double x, double y, int width, int height) {
		super(x, y, width, height);
		moveForce.setX(4);
		framesPerSprite = 5;
		loadResources();
	}

	@Override
	protected void loadResources() {
		// Loaaaaaaaaad
		sprites.add(assets.getSprite("BlueBird_0"));
		sprites.add(assets.getSprite("BlueBird_1"));
		sprites.add(assets.getSprite("BlueBird_2"));
		sprites.add(assets.getSprite("BlueBird_3"));
		sprites.add(assets.getSprite("BlueBird_4"));
		sprites.add(assets.getSprite("BlueBird_5"));
		// Reversed
		sprites.add(assets.getSprite("BlueBird_0_rev"));
		sprites.add(assets.getSprite("BlueBird_1_rev"));
		sprites.add(assets.getSprite("BlueBird_2_rev"));
		sprites.add(assets.getSprite("BlueBird_3_rev"));
		sprites.add(assets.getSprite("BlueBird_4_rev"));
		sprites.add(assets.getSprite("BlueBird_5_rev"));

		// Create animations
		createAnimation(Object.ANIMATION_WALKING_RIGHT, 0, 6);
		createAnimation(Object.ANIMATION_WALKING_LEFT, 6, 12);

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
