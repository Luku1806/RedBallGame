package de.lukas_reining.redball.objects.still.tiled;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import de.lukas_reining.redball.objects.Object;;

public abstract class TiledObject extends Object {

	protected TiledObject(double x, double y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void render(Graphics g) {
		if (sprites.isEmpty() || sprites.get(0) == null) {
			g.setColor(Color.RED);
			g.fillRect((int) getX(), (int) getY(), width, height);
			return;
		}

		BufferedImage tileImg = sprites.get(0);
		int relativeRightX = (int) (getX() + width);
		for (int i = (int) getX(); i < relativeRightX; i += height) {
			int remainingWidth = relativeRightX - i;
			if (remainingWidth > height) {
				g.drawImage(tileImg, i, (int) getY(), height, height, null);
			} else {
				Image fittedImg = tileImg.getScaledInstance(height, height, Image.SCALE_DEFAULT);
				// scale down and convert
				BufferedImage scaled = new BufferedImage(fittedImg.getWidth(null), fittedImg.getHeight(null),
						BufferedImage.TYPE_INT_ARGB);
				// Draw the image on to the buffered image
				Graphics2D bGr = scaled.createGraphics();
				bGr.drawImage(fittedImg, 0, 0, null);
				bGr.dispose();
				// Get Subimage and draw
				scaled = scaled.getSubimage(0, 0, remainingWidth, fittedImg.getHeight(null));
				g.drawImage(scaled, i, (int) getY(), null);
			}
		}
	}

}
