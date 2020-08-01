package com.seruji.hb.objects.halloween;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class Cake extends GameObject {

	private int currentSprite = 0;
	
	public Cake(int xSize, int ySize, SpriteBatch batch) {
		super(0, 0, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.halloweenSprites, 12, 15);
		setPosition((int) (960 - bounds.width / 2), (int) (540 - bounds.height / 2)); 
	}

	@Override
	public void draw() {
		batch.draw(sprites[currentSprite], bounds.x, bounds.y, bounds.width, bounds.height);
	}
	
	public void changeState() {
		currentSprite++;
	}

	public boolean isEaten() {
		return currentSprite == 2;
	}
	
}
