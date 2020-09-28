package com.seruji.hb.objects.summer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class BgManager extends GameObject {
	
	private int draw;

	public BgManager(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.summerSprites, 0, 2);
		draw = 0;
	}

	@Override
	public void draw() {
		batch.draw(sprites[draw], 0, 0, 1920, 1080);
	}
	
	public void changeSprite() {
		draw++;
	}

}
