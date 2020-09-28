package com.seruji.hb.objects.drivinglessons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class Car extends GameObject {
	
	public Car(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.drivingLessonsSprites, 2);
		bounds.height = bounds.height/2;
		bounds.width = (float) (bounds.width / 1.5);
		bounds.x+= bounds.width/4;
		bounds.y+= bounds.height;
	}

	@Override
	public void draw() {
		batch.draw(sprites[0], bounds.x - bounds.width/4, bounds.y - bounds.height, (float) (bounds.width * 1.5), bounds.height * 2);
	}
}
