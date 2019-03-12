package de.lukas_reining.redball.worlds.plain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import de.lukas_reining.redball.gamelogic.Game;
import de.lukas_reining.redball.objects.dynamic.creatures.flying.BlueBird;
import de.lukas_reining.redball.objects.dynamic.creatures.flying.RedBird;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.Player;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.monsters.BlueMonster;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.monsters.LimboMonster;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.monsters.YellowBubbleMonster;
import de.lukas_reining.redball.objects.dynamic.creatures.walking.monsters.YellowMonster;
import de.lukas_reining.redball.objects.still.Boundary;
import de.lukas_reining.redball.objects.still.Box;
import de.lukas_reining.redball.objects.still.tiled.Floor;
import de.lukas_reining.redball.objects.still.tiled.Water;
import de.lukas_reining.redball.utils.AssetManager;
import de.lukas_reining.redball.worlds.GameWorld;

public class FirstWorld extends GameWorld {

	private BufferedImage imageBackground;

	public FirstWorld() {
		super(2000);
		imageBackground = AssetManager.getInstance().getSprite("Background_Grassy_Plains");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addInitialObjects() {
		// Floor
		int floorHeight = 100;
		Floor floor1 = new Floor(0, Game.HEIGHT - floorHeight, 400, floorHeight);
		objects.add(floor1);
		Water water1 = new Water(400, Game.HEIGHT - floorHeight, 300, floorHeight);
		objects.add(water1);
		Floor floor2 = new Floor(700, Game.HEIGHT - floorHeight, levelLenght - 700, floorHeight);
		objects.add(floor2);

		// Boxes
		Box box1 = new Box(300, Game.HEIGHT - 200 - floorHeight, 150, 75);
		objects.add(box1);
		Box box2 = new Box(700, Game.HEIGHT - 400 - floorHeight, 150, 75);
		objects.add(box2);
		Box box3 = new Box(1100, Game.HEIGHT - 400 - floorHeight, 150, 75);
		objects.add(box3);
		Box box4 = new Box(1700, Game.HEIGHT - 300 - floorHeight, 200, 100);
		objects.add(box4);

		// Bounds
		Boundary leftBound = new Boundary(0, 0, 1, Game.HEIGHT * 2);
		objects.add(leftBound);
		Boundary rightBound = new Boundary(levelLenght, 0, 1, Game.HEIGHT * 2);
		objects.add(rightBound);

		// Enemies
		BlueBird bBird1 = new BlueBird(400, Game.HEIGHT - 600);
		objects.add(bBird1);
		RedBird rBird1 = new RedBird(100, Game.HEIGHT - 700);
		objects.add(rBird1);
		BlueMonster bMonster1 = new BlueMonster(50, Game.HEIGHT - floorHeight - 400);
		objects.add(bMonster1);
		YellowMonster yMonster1 = new YellowMonster(600, Game.HEIGHT - floorHeight - 400);
		objects.add(yMonster1);
		YellowBubbleMonster yBubbleMonster1 = new YellowBubbleMonster(500, Game.HEIGHT - floorHeight - 400);
		objects.add(yBubbleMonster1);
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
		g.drawImage(imageBackground, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		// render all objects
		super.render(g);
	}

}
