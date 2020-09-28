package com.seruji.hb.objects.quarantine;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class Machine extends GameObject {

	private boolean picked;
	private int draw;
	
	public Machine(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.quarantineSprites, 5, 7);
	}

	@Override
	public void draw() {
		draw = 0;
		if(picked) {
			draw = 1;
		}
		batch.draw(sprites[draw], bounds.x, bounds.y, bounds.width, bounds.height * 3);
	}
	
	public void on() {
		picked = true;
	}
	
	public void off() {
		picked = false;
	}
	
}
