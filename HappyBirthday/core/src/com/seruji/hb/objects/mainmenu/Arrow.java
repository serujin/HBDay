package com.seruji.hb.objects.mainmenu;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class Arrow extends GameObject {

	public Arrow(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.mainMenuSprites, 5, 7);
		bounds.y = 540 - bounds.height/2;
		bounds.x = 120;
	}

	@Override
	public void draw() {
		batch.draw(sprites[0], bounds.x                   , bounds.y, bounds.width, bounds.height);
		batch.draw(sprites[1], bounds.x + bounds.width * 6, bounds.y, bounds.width, bounds.height);

	}

}
