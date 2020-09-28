package com.seruji.hb.objects.drivinglessons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class LorenaD extends GameObject{

	public LorenaD(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.drivingLessonsSprites, 8);
	}

	@Override
	public void draw() {
		batch.draw(sprites[0], bounds.x, bounds.y, bounds.width, bounds.height);
	}

}
