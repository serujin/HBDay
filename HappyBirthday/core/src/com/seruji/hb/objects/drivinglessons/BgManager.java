package com.seruji.hb.objects.drivinglessons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class BgManager extends GameObject {
	
	private int draw;

	public BgManager(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.drivingLessonsSprites, 0, 2);
		draw = 2;
	}

	@Override
	public void draw() {
		if(draw < 2) {
			batch.draw(sprites[draw], 0, 0, 1920, 1080);
		}
	}
	
	public void changeSprite() {
		if(draw == 2) {
			draw = 0;
		} else {
			draw++;
		}
	}

}
