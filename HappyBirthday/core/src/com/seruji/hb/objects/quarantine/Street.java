package com.seruji.hb.objects.quarantine;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class Street extends GameObject {

	public Street(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.quarantineSprites, 10);
	}

	@Override
	public void draw() {
		batch.draw(sprites[0], 0, 0, 1920, 1080);
	}
}
