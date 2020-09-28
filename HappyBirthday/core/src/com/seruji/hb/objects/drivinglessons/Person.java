package com.seruji.hb.objects.drivinglessons;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class Person extends GameObject {

	private Random r;
	private int sprite;
	
	public Person(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		r = new Random();
		sprite = r.nextInt(3) + 4;
		if(sprite > 4) {
			bounds.width = 48;
			bounds.height = 144;
		} else {
			bounds.width = 96;
			bounds.height = 192;
		}
		sprites = Utils.getSprites(Assets.drivingLessonsSprites, sprite);
	}

	@Override
	public void draw() {
		batch.draw(sprites[0], bounds.x, bounds.y, bounds.width, bounds.height);
	}

}
