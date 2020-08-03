package com.seruji.hb.objects.quarantine;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class LorenaQ extends GameObject {

	private int draw;
	private int rotation;
	
	public LorenaQ(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.quarantineSprites, 0, 2);
		draw = 0;
		rotation = 40;
	}

	@Override
	public void draw() {
		batch.draw(sprites[draw], bounds.x + 200, bounds.y, bounds.width / 2, bounds.height / 2, bounds.width, bounds.height, 1, 1, rotation);
	}
	
	public void changeSprite() {
		if(draw == 1) {
			draw--;
		} else {
			draw++;
		}
	}
	
	public void changeRotation() {
		if(rotation > 0) {
			rotation = 0;
		} else {
			rotation = 40;
		}
	}
}
