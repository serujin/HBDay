package com.seruji.hb.objects.various;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class Back extends GameObject {

	public Back(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.variousSprites, 0);
	}

	@Override
	public void draw() {
		batch.draw(sprites[0], bounds.x, bounds.y, bounds.width, bounds.height);
	}
}
