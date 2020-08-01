package com.seruji.hb.objects.halloween;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class Button extends GameObject {
	
	private boolean activated;

	public Button(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.halloweenSprites, 15);
	}

	@Override
	public void draw() {
		batch.draw(sprites[0], bounds.x, bounds.y, bounds.width, bounds.height);
	}
	
	public void activate() {
		activated = true;
	}
	
	public boolean isActivated() {
		return activated;
	}

}
