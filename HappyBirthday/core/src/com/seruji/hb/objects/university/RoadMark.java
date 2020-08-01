package com.seruji.hb.objects.university;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class RoadMark extends GameObject {

	private int offset;
	
	public RoadMark(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.universitySprites, 6);
		offset = 300;
	}

	@Override
	public void draw() {
		batch.draw(sprites[0], bounds.x             , bounds.y    , bounds.width, bounds.height);
		batch.draw(sprites[0], bounds.x             , bounds.y * 2, bounds.width, bounds.height);
		batch.draw(sprites[0], bounds.x - offset    , bounds.y    , bounds.width, bounds.height);
		batch.draw(sprites[0], bounds.x - offset    , bounds.y * 2, bounds.width, bounds.height);
		batch.draw(sprites[0], bounds.x - offset * 2, bounds.y    , bounds.width, bounds.height);
		batch.draw(sprites[0], bounds.x - offset * 2, bounds.y * 2, bounds.width, bounds.height);
		batch.draw(sprites[0], bounds.x - offset * 3, bounds.y    , bounds.width, bounds.height);
		batch.draw(sprites[0], bounds.x - offset * 3, bounds.y * 2, bounds.width, bounds.height);
		batch.draw(sprites[0], bounds.x - offset * 4, bounds.y    , bounds.width, bounds.height);
		batch.draw(sprites[0], bounds.x - offset * 4, bounds.y * 2, bounds.width, bounds.height);
		batch.draw(sprites[0], bounds.x - offset * 5, bounds.y    , bounds.width, bounds.height);
		batch.draw(sprites[0], bounds.x - offset * 5, bounds.y * 2, bounds.width, bounds.height);
		batch.draw(sprites[0], bounds.x - offset * 6, bounds.y    , bounds.width, bounds.height);
		batch.draw(sprites[0], bounds.x - offset * 6, bounds.y * 2, bounds.width, bounds.height);
	}

}
