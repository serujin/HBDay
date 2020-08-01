package com.seruji.hb.objects.halloween;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class Home extends GameObject {

	public Home(int xSize, int ySize, SpriteBatch batch) {
		super(0, 0, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.halloweenSprites, 16);
	}

	@Override
	public void draw() {
		batch.draw(sprites[0], bounds.x, bounds.y, bounds.width, bounds.height);

	}

}
