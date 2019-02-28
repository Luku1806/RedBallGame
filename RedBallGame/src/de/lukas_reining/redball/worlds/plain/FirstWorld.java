package de.lukas_reining.redball.worlds.plain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import de.lukas_reining.redball.gamelogic.Game;
import de.lukas_reining.redball.objects.dynamic.creatures.flying.BlueBird;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.Player;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.monsters.BlueMonster;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.monsters.LimboMonster;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.monsters.YellowMonster;
import de.lukas_reining.redball.objects.still.Boundary;
import de.lukas_reining.redball.objects.still.Box;
import de.lukas_reining.redball.objects.still.Floor;
import de.lukas_reining.redball.utils.AssetManager;
import de.lukas_reining.redball.worlds.World;

public class FirstWorld extends World {

	private Color colorBackground;
	private BufferedImage imageBackground;

	public FirstWorld() {
		super(2000);
		colorBackground = new Color(50, 219, 255);
		//imageBackground = AssetManager.getInstance().getSprite("Background_Clouds_0");
		imageBackground = AssetManager.getInstance().getSprite("Background_Grassy_Plains");
	}

	@Override
	public void addInitialObjects() {
		// Floor
		int floorHeight = 100;
		Floor floor = new Floor(0, Game.HEIGHT - floorHeight, levelLenght, floorHeight);
		objects.add(floor);

		// Boxes
		Box box1 = new Box(300, Game.HEIGHT - 150 - floorHeight, 200, 20);
		objects.add(box1);
		Box box2 = new Box(400, Game.HEIGHT - 400 - floorHeight, 200, 20);
		objects.add(box2);
		Box box3 = new Box(800, Game.HEIGHT - 400 - floorHeight, 200, 20);
		objects.add(box3);
		Box box4 = new Box(1500, Game.HEIGHT - 300 - floorHeight, 200, 100);
		objects.add(box4);

		// Bounds
		Boundary leftBound = new Boundary(0, 0, 1, Game.HEIGHT);
		objects.add(leftBound);
		Boundary rightBound = new Boundary(levelLenght, 0, 1, Game.HEIGHT);
		objects.add(rightBound);

		// Enemies
		BlueBird bBird1 = new BlueBird(400, Game.HEIGHT - 600);
		objects.add(bBird1);
		BlueMonster bMonster1 = new BlueMonster(50, Game.HEIGHT - floorHeight - 400);
		objects.add(bMonster1);
		YellowMonster yMonster1 = new YellowMonster(600, Game.HEIGHT - floorHeight - 400);
		objects.add(yMonster1);
		LimboMonster lMonster1 = new LimboMonster(800, Game.HEIGHT - floorHeight - 400);
		objects.add(lMonster1);

		// Finally the Player
		player = new Player(100, 100);
		objects.add(player);

		// Let camera follow player
		camera.setObjectToFollow(player);
	}

	@Override
	public void update(double elapsed) {
		super.update(elapsed);
	}

	@Override
	public void render(Graphics g) {
		// TODO Dynamic/variable background
//		g.setColor(colorBackground);
//		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(imageBackground,0,0,Game.WIDTH,Game.HEIGHT,null);

		// render all objects
		super.render(g);
	}

}
