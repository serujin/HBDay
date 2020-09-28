package com.seruji.hb.objects.summer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class LorenaS extends GameObject {

	private int rotation;
	
	public LorenaS(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.summerSprites, 8);
		rotation = 0;
	}

	@Override
	public void draw() {
		batch.draw(sprites[0], bounds.x, bounds.y, bounds.width/2, bounds.height/2, bounds.width, bounds.height, 1, 1, rotation);
	}
	
	public void rotate() {
		rotation = -90;
	}

}
