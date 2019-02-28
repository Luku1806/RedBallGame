package de.lukas_reining.redball.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import de.lukas_reining.redball.utils.AssetManager;
import de.lukas_reining.redball.utils.Vec2D;

public abstract class Object {

	// Constants
	protected final static String ANIMATION_IDLE = "idle";
	protected final static String ANIMATION_WALKING_LEFT = "walking_left";
	protected final static String ANIMATION_WALKING_RIGHT = "walking_right";
	protected final static String ANIMATION_JUMPING_FALL = "jumping_fall";
	protected final static String ANIMATION_JUMPIG_UP = "jumping_up";
	protected final static String ANIMATION_HURT = "hurt";

	// Physics
	protected Vec2D position;
	protected int width, height;

	// View
	protected AssetManager assets;

	protected ArrayList<BufferedImage> sprites;
	protected HashMap<String, ArrayList<BufferedImage>> animations;
	protected ArrayList<BufferedImage> currentAnimationSprites;

	protected boolean isAnimated;
	private short frameCount;
	protected short framesPerSprite;
	protected String currentAnimationName;
	protected byte currentSpriteIndex;

	protected Object(double x, double y, int width, int height) {
		this.assets = AssetManager.getInstance();

		this.position = new Vec2D();
		this.position.setX(x);
		this.position.setY(y);
		this.width = width;
		this.height = height;

		this.sprites = new ArrayList<BufferedImage>();
		this.animations = new HashMap<String, ArrayList<BufferedImage>>();

		this.isAnimated = false;
		this.frameCount = 0;
		this.framesPerSprite = 60;
		this.currentAnimationName = "";
		this.currentSpriteIndex = 0;

		loadResources();
	}

	protected abstract void loadResources();

	public abstract void update(double elapsed);

	public abstract void render(Graphics g);

	protected void renderStatic(Graphics g) {
		if (sprites.isEmpty() || sprites.get(0) == null) {
			g.setColor(Color.RED);
			g.fillRect((int) getX(), (int) getY(), width, height);
		} else {
			g.drawImage(sprites.get(0), (int) getX(), (int) getY(), width, height, null);
		}
	}

	protected void renderAnimated(Graphics g) {
		frameCount++;
		if (frameCount > framesPerSprite) {
			frameCount = 0;
			// Loop through sprite indices
			currentSpriteIndex++;
			if (currentAnimationSprites == null || currentSpriteIndex >= currentAnimationSprites.size()) {
				currentSpriteIndex = 0;
			}
		}

		// Show right sprite
		if (currentAnimationSprites == null || currentAnimationSprites.isEmpty()
				|| currentAnimationSprites.get(currentSpriteIndex) == null) {
			g.setColor(Color.RED);
			g.fillRect((int) getX(), (int) getY(), width, height);
		} else {
			g.drawImage(currentAnimationSprites.get(currentSpriteIndex), (int) getX(), (int) getY(), width, height,
					null);
		}
	}

	protected void createAnimation(String animationName, int startIndex, int endIndex) {
		if (startIndex < endIndex && endIndex <= sprites.size()) {
			ArrayList<BufferedImage> animSprites = new ArrayList<BufferedImage>();
			animSprites.addAll(sprites.subList(startIndex, endIndex));
			animations.put(animationName, animSprites);
		} else {
			System.err.println("Animation \"" + animationName + "\" couldnt be created!\nIndices out of bounds\n");
		}
	}

	protected void setCurrentAnimation(String animationName) {
		if (currentAnimationName == animationName) {
			return; // return if current animation already is the right one
		}

		// If animation is not already set, set it
		ArrayList<BufferedImage> loaded = animations.get(animationName);
		if (loaded != null) {
			currentAnimationName = animationName;
			currentAnimationSprites = loaded;
		} else {
			System.err.println("Animation \"" + animationName + "\" doesn´t exist!!!\n");
		}
	}

	public double getX() {
		return position.getX();
	}

	public double getY() {
		return position.getY();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
