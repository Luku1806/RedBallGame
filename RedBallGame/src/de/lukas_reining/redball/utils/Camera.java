package de.lukas_reining.redball.utils;

import java.awt.Graphics;

import de.lukas_reining.redball.gamelogic.Game;
import de.lukas_reining.redball.objects.Object;

public class Camera {

	private Object objToFollow;

	public Camera() {
		this(null);
	}

	public Camera(Object objToFollow) {
		this.objToFollow = objToFollow;
	}

	public void refresh(Graphics g) {
		if (objToFollow == null) {
			return;
		}

		g.translate((int) (-objToFollow.getX() + Game.WIDTH / 2), 0);
	}

	public Object getObjectToFollow() {
		return objToFollow;
	}

	public void setObjectToFollow(Object objToFollow) {
		this.objToFollow = objToFollow;
	}

}
