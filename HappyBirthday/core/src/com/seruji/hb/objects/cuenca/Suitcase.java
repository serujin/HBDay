package com.seruji.hb.objects.cuenca;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class Suitcase extends GameObject {

	public Suitcase(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.cuencaSprites, 4);
	}

	@Override
	public void draw() {
		batch.draw(sprites[0], bounds.x - bounds.width/2, bounds.y, bounds.width, bounds.height);
	}
}
