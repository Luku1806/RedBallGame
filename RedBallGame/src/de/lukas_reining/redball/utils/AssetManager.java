package de.lukas_reining.redball.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class AssetManager {

	private static AssetManager instance;
	private HashMap<String, BufferedImage> sprites;

	private AssetManager() {
		sprites = new HashMap<String, BufferedImage>();
		loadSprites();
	}

	public static AssetManager getInstance() {
		if (AssetManager.instance == null) {
			AssetManager.instance = new AssetManager();
		}
		return AssetManager.instance;
	}

	private void loadSprites() {
		// Load RedBall Image
		loadSprite("Player", "res/redball.png");
		// Load BlueBird
		loadSprite("BlueBird_0", "res/BlueBird/frames/frame-1.png");
		loadSprite("BlueBird_1", "res/BlueBird/frames/frame-2.png");
		loadSprite("BlueBird_2", "res/BlueBird/frames/frame-3.png");
		loadSprite("BlueBird_3", "res/BlueBird/frames/frame-4.png");
		loadSprite("BlueBird_4", "res/BlueBird/frames/frame-5.png");
		loadSprite("BlueBird_5", "res/BlueBird/frames/frame-6.png");
		// Load BlueBird(Reversed)
		loadSprite("BlueBird_0_rev", "res/BlueBird/frames/frame-1-rev.png");
		loadSprite("BlueBird_1_rev", "res/BlueBird/frames/frame-2-rev.png");
		loadSprite("BlueBird_2_rev", "res/BlueBird/frames/frame-3-rev.png");
		loadSprite("BlueBird_3_rev", "res/BlueBird/frames/frame-4-rev.png");
		loadSprite("BlueBird_4_rev", "res/BlueBird/frames/frame-5-rev.png");
		loadSprite("BlueBird_5_rev", "res/BlueBird/frames/frame-6-rev.png");
		// Load RedBird
		loadSprite("RedBird_0", "res/Birds/frames/Bird_Red/frame-1.png");
		loadSprite("RedBird_1", "res/Birds/frames/Bird_Red/frame-2.png");
		loadSprite("RedBird_2", "res/Birds/frames/Bird_Red/frame-3.png");
		loadSprite("RedBird_3", "res/Birds/frames/Bird_Red/frame-4.png");
		// Load RedBird(Reversed)
		loadSprite("RedBird_0_rev", "res/Birds/frames/Bird_Red/frame-1-rev.png");
		loadSprite("RedBird_1_rev", "res/Birds/frames/Bird_Red/frame-2-rev.png");
		loadSprite("RedBird_2_rev", "res/Birds/frames/Bird_Red/frame-3-rev.png");
		loadSprite("RedBird_3_rev", "res/Birds/frames/Bird_Red/frame-4-rev.png");
		// Load BlueMonster
		loadSprite("BlueMonster_Idle_0", "res/LandMonsterBlue/frames/idle/frame-1.png");
		loadSprite("BlueMonster_Idle_1", "res/LandMonsterBlue/frames/idle/frame-2.png");
		loadSprite("BlueMonster_Hit_0", "res/LandMonsterBlue/frames/got_hit/frame.png");
		// Load YellowMonster
		loadSprite("YellowMonster_Idle_0", "res/LandMonsterYellow/frames/idle/frame-1.png");
		loadSprite("YellowMonster_Idle_1", "res/LandMonsterYellow/frames/idle/frame-2.png");
		loadSprite("YellowMonster_Hit_0", "res/LandMonsterYellow/frames/got_hit/frame.png");
		// Load YellowBubbleMonster
		loadSprite("YellowBubbleMonster_Idle_0", "res/BubbleMonsterYellow/frames/idle/frame-1.png");
		loadSprite("YellowBubbleMonster_Idle_1", "res/BubbleMonsterYellow/frames/idle/frame-2.png");
		loadSprite("YellowBubbleMonster_Idle_2", "res/BubbleMonsterYellow/frames/idle/frame-3.png");
		loadSprite("YellowBubbleMonster_Idle_3", "res/BubbleMonsterYellow/frames/idle/frame-4.png");
		loadSprite("YellowBubbleMonster_Idle_4", "res/BubbleMonsterYellow/frames/idle/frame-5.png");
		loadSprite("YellowBubbleMonster_Idle_5", "res/BubbleMonsterYellow/frames/idle/frame-6.png");
		loadSprite("YellowBubbleMonster_Idle_6", "res/BubbleMonsterYellow/frames/idle/frame-7.png");
		loadSprite("YellowBubbleMonster_Idle_7", "res/BubbleMonsterYellow/frames/idle/frame-8.png");
		loadSprite("YellowBubbleMonster_Hit_0", "res/BubbleMonsterYellow/frames/got_hit/frame-1.png");
		loadSprite("YellowBubbleMonster_Hit_1", "res/BubbleMonsterYellow/frames/got_hit/frame-2.png");
		// Load LimboMonster
		loadSprite("LimboMonster_Idle_0", "res/LimboMonster/frames/idle/frame-1.png");
		loadSprite("LimboMonster_Idle_1", "res/LimboMonster/frames/idle/frame-2.png");
		loadSprite("LimboMonster_Hit_0", "res/LimboMonster/frames/got_hit/frame.png");
		loadSprite("LimboMonster_Jump_Fall", "res/LimboMonster/frames/jump/jump_fall.png");
		loadSprite("LimboMonster_Jump_Up", "res/LimboMonster/frames/jump/jump_up.png");

		// Load Backgrounds
		loadSprite("Background_Clouds_0", "res/Backgrounds/clouds_1.png");
		loadSprite("Background_Grassy_Plains", "res/Backgrounds/grassy_plains.jpg");

		// Load Textures
		loadSprite("Texture_Grass_0", "res/textures/grass_0.png");
		loadSprite("Texture_Grass_1", "res/textures/grass_1.png");
		loadSprite("Texture_Water_0", "res/textures/water_0.png");
		loadSprite("Texture_Bricks_0", "res/textures/bricks_0.png");
		
		//Load other assets
		loadSprite("Asset_Heart_0", "res/assets/heart_0.png");
	}

	private void loadSprite(String name, String path) {
		BufferedImage tempImg = loadImage(path);
		if (tempImg != null) {
			sprites.put(name, tempImg);
		} else {
			System.err.println("Ressource \"" + name + "\" couldn´t be loaded from \"" + path + "\"\n");
		}
	}

	private BufferedImage loadImage(String path) {
		InputStream stream = getClass().getClassLoader().getResourceAsStream(path);
		if (stream == null) {
			System.err.println("Ressource-Path \"" + path + "\" doesn´t exist\n");
			return null;
		}
		try {
			return ImageIO.read(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public BufferedImage getSprite(String name) {
		BufferedImage sprite = sprites.get(name);
		if(sprite == null) {
			System.err.println("Sprite \"" + name + "\" doesn´t exist\n");
		}
		return sprite;
	}

}
