package com.seruji.hb.objects.movingtomadrid;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class Suitcase extends GameObject {
	
	public Suitcase(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.movingToMadridSprites, 0, 10);
	}

	@Override
	public void draw() {
		batch.draw(sprites[0], bounds.x                     , bounds.y                        , bounds.width/4, bounds.height/3);
		batch.draw(sprites[1], bounds.x + bounds.width/4    , bounds.y                        , bounds.width/4, bounds.height/3);
		batch.draw(sprites[1], bounds.x + bounds.width/4 * 2, bounds.y                        , bounds.width/4, bounds.height/3);
		batch.draw(sprites[2], bounds.x + bounds.width/4 * 3, bounds.y                        , bounds.width/4, bounds.height/3);
		batch.draw(sprites[3], bounds.x                     , bounds.y + bounds.height/3      , bounds.width/4, bounds.height/3);
		batch.draw(sprites[4], bounds.x + bounds.width/4    , bounds.y + bounds.height/3      , bounds.width/4, bounds.height/3);
		batch.draw(sprites[4], bounds.x + bounds.width/4 * 2, bounds.y + bounds.height/3      , bounds.width/4, bounds.height/3);
		batch.draw(sprites[9], bounds.x + bounds.width/4 * 4, bounds.y + bounds.height/3 * 7/6, bounds.width/4, bounds.height/3);
		batch.draw(sprites[5], bounds.x + bounds.width/4 * 3, bounds.y + bounds.height/3      , bounds.width/4, bounds.height/3);
		batch.draw(sprites[6], bounds.x                     , bounds.y + bounds.height/3 * 2  , bounds.width/4, bounds.height/3);
		batch.draw(sprites[7], bounds.x + bounds.width/4    , bounds.y + bounds.height/3 * 2  , bounds.width/4, bounds.height/3);
		batch.draw(sprites[7], bounds.x + bounds.width/4 * 2, bounds.y + bounds.height/3 * 2  , bounds.width/4, bounds.height/3);
		batch.draw(sprites[8], bounds.x + bounds.width/4 * 3, bounds.y + bounds.height/3 * 2  , bounds.width/4, bounds.height/3);
	}
}
