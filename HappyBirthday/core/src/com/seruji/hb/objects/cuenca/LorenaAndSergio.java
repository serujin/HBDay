package com.seruji.hb.objects.cuenca;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class LorenaAndSergio extends GameObject {

	private int draw;
	
	public LorenaAndSergio(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.cuencaSprites, 0, 4);
		draw = 0;
	}

	@Override
	public void draw() {
		batch.draw(  sprites[draw],                      bounds.x, bounds.y, bounds.width, bounds.height);
		batch.draw(sprites[draw+1], bounds.x + bounds.width * 2/3, bounds.y, bounds.width, bounds.height);
	}
	
	public void changeScene() {
		draw+=2;
	}

}
