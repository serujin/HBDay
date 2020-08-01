package com.seruji.hb.objects.university;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class City extends GameObject {

	public City(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.universitySprites, 8, 10);
	}

	@Override
	public void draw() {
		batch.draw(sprites[1], bounds.x, bounds.y, bounds.width, bounds.height);
		for (int i = 0; i < 5; i++) {
			for(int j = 0; j < 11; j++) {
				batch.draw(sprites[0], bounds.x + j * bounds.width/10, bounds.y + 400 + i * bounds.height/10, bounds.width/10, bounds.height/10);
			}
		}
	}

}
