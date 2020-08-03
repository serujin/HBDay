package com.seruji.hb.objects.quarantine;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class Face extends GameObject {

	public Face(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.quarantineSprites, 7);
	}

	@Override
	public void draw() {
		batch.draw(sprites[0], 960 - bounds.width/2, 540 - bounds.height/2, bounds.width, bounds.height);
	}
}
