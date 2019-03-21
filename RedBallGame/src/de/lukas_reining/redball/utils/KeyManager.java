package de.lukas_reining.redball.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private static KeyManager instance;

	// Keys
	private boolean left, right, up, down;
	private boolean space;
	// End Keys

	private KeyManager() {
	}

	public static KeyManager getInstance() {
		if (KeyManager.instance == null) {
			KeyManager.instance = new KeyManager();
		}
		return KeyManager.instance;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		case KeyEvent.VK_SPACE:
			space = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		case KeyEvent.VK_SPACE:
			space = false;
			break;

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public boolean left_pressed() {
		return left;
	}

	public boolean right_pressed() {
		return right;
	}

	public boolean up_pressed() {
		return up;
	}

	public boolean down_pressed() {
		return down;
	}

	public boolean space_pressed() {
		return space;
	}
}
