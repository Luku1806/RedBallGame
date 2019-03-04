package de.lukas_reining.redball.objects.dynamic.creatures;

import java.util.ArrayList;

import org.omg.CosNaming.IstringHelper;

import de.lukas_reining.redball.objects.Object;
import de.lukas_reining.redball.objects.dynamic.DynamicObject;

public abstract class Creature extends DynamicObject {

	public Creature(double x, double y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void update(double elapsed) {
		super.update(elapsed);
	}

	public void moveLeft() {
		applyImpulse(moveForce.mult(-1));
	}

	public void moveRight() {
		applyImpulse(moveForce);
	}

	@Override
	public void checkCollisions(ArrayList<Object> objects) {
		boolean tempOnGround = false;
		for (Object object : objects) {

			if (object == this || object == null) {
				continue;
			}

			double this_bottom = getY() + height;
			double obj_bottom = object.getY() + object.getHeight();
			double this_right = getX() + width;
			double obj_right = object.getX() + object.getWidth();

			double b_collision = obj_bottom - getY();
			double t_collision = this_bottom - object.getY();
			double l_collision = this_right - object.getX();
			double r_collision = obj_right - getX();

			if (this_right > object.getX() && getX() < obj_right && this_bottom > object.getY()
					&& this.getY() < obj_bottom) {

				if (t_collision < b_collision && t_collision < l_collision && t_collision < r_collision) {
					// bottom collision
					onCollisionBottom(object);
					tempOnGround = true;
				} else if (b_collision < t_collision && b_collision < l_collision && b_collision < r_collision) {
					// top collision
					onCollisionTop(object);
					//Test
				}

				if (l_collision < r_collision && l_collision < t_collision && l_collision < b_collision) {
					// right collision
					onCollisionRight(object);
				} else if (r_collision < l_collision && r_collision < t_collision && r_collision < b_collision) {
					// left collision
					onCollisionLeft(object);
				}
			}
			isOnGround = tempOnGround;
		}
	}

	public void onCollisionLeft(Object object) {
		position.setX(object.getX() + object.getWidth());
		velocity.setX(0);
	}

	public void onCollisionRight(Object object) {
		position.setX(object.getX() - width);
		velocity.setX(0);
	}

	public void onCollisionBottom(Object object) {
		position.setY(object.getY() - height);
		velocity.setY(0);
	}

	public void onCollisionTop(Object object) {
		position.setY(object.getY() + object.getHeight());
		velocity.setY(0);
	}

}
