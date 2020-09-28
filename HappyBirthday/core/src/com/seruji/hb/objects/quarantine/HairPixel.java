package com.seruji.hb.objects.quarantine;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class HairPixel extends GameObject {
	
	private boolean touched;
	private boolean outOfScreen;

	public HairPixel(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.quarantineSprites, 8);
		touched = false;
		outOfScreen = false;
	}

	@Override
	public void draw() {
		if(touched) {
			bounds.y+=5;
		}
		if(bounds.y > 1200) {
			outOfScreen = true;
		}
		batch.draw(sprites[0], bounds.x, bounds.y, bounds.width, bounds.height);
	}
	
	public void touch() {
		touched = true;
	}
	
	public boolean shoulDelete() {
		return outOfScreen;
	}
}
