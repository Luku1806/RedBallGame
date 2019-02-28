package de.lukas_reining.redball.utils;

import de.lukas_reining.redball.gamelogic.Game;
import de.lukas_reining.redball.objects.Object;
import java.awt.Graphics;

public class Camera {

	private Object objToFollow;

	public Camera() {
		this(null);
	}

	public Camera(Object objToFollow) {
		this.objToFollow = objToFollow;
	}

	public void refresh(Graphics g) {
		int newX = 0;
		int newY = 0;

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
