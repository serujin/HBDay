package com.seruji.hb.objects.movingtomadrid;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class Wear extends GameObject {

	private Random random;
	private int sprite;
	private int dimension;
	
	public Wear(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize,batch);
		random = new Random();
		sprite = random.nextInt(5) + 10;
		if(!(sprite == 12 || sprite == 14)) {
			dimension = 2;
		} else {
			dimension = 1;
		}
		sprites = Utils.getSprites(Assets.movingToMadridSprites, sprite);
	}

	@Override
	public void draw() {
		batch.draw(sprites[0], bounds.x, bounds.y, bounds.width * dimension, bounds.height);
	}

}
