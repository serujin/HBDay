package com.seruji.hb.objects.cuenca;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class BgManager extends GameObject {

	private int draw;
	
	public BgManager(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.cuencaSprites, 5, 7);
		draw = 1;
	}

	@Override
	public void draw() {
		batch.draw(sprites[draw], bounds.x, bounds.y, 1920, 1080);
	}

	public void changeScene() {
		draw--;
	}

}
