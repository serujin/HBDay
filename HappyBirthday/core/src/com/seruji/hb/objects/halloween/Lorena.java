package com.seruji.hb.objects.halloween;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class Lorena extends GameObject {

	private boolean head;
	private boolean body;
	private boolean acc;
	private boolean legs;
	private boolean shoes;
	
	public Lorena(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Utils.getSprites(Assets.halloweenSprites, 0, 6);
		head = false;
		body = false;
		acc = false;
		legs = false;
		shoes = false;
	}

	@Override
	public void draw() {
		batch.draw(sprites[0], bounds.x, bounds.y, bounds.width, bounds.height);
		if(head) {
			batch.draw(sprites[1], bounds.x, bounds.y, bounds.width, bounds.height);
		}
		if(body) {
			batch.draw(sprites[2], bounds.x, bounds.y, bounds.width, bounds.height);
		}
		if(acc) {
			batch.draw(sprites[3], bounds.x, bounds.y, bounds.width, bounds.height);
		}
		if(legs) {
			batch.draw(sprites[4], bounds.x, bounds.y, bounds.width, bounds.height);
		}
		if(shoes) {
			batch.draw(sprites[5], bounds.x, bounds.y, bounds.width, bounds.height);
		}
	}
	
	public void showHead() {
		head = true;
	}
	
	public void showBody() {
		body = true;
	}
	
	public void showAcc() {
		acc = true;
	}
	
	public void showLegs() {
		legs = true;
	}
	
	public void showShoes() {
		shoes = true;
	}
}
