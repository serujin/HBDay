package com.seruji.hb.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject {

	protected Rectangle bounds;
	protected Sprite[] sprites;
	protected SpriteBatch batch;
	
	protected GameObject(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		bounds = new Rectangle(x, y, xSize * 16, ySize * 16);
		this.batch = batch;
	}
	
	public void move(int speed, int xAxis, int yAxis) {
		bounds.x += speed * xAxis;
		bounds.y += speed * yAxis;
	}
	
	public abstract void draw();
	
	public int[] getPosition() {
		return new int[] {(int) bounds.x, (int) bounds.y};
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public void setPosition(int x, int y) {
		bounds.x = x;
		bounds.y = y;
	}
}
