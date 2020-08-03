package com.seruji.hb.objects.quarantine;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class HairManager {
	private static HairPixel[] hair;
	
	public static void initHair(int x, int y, int rows, int columns, int size, SpriteBatch batch) {
		hair = new HairPixel[rows * columns];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				hair[i] = new HairPixel(x * i, y * j, size, size, batch);
			}
		}
	}
	
	public static void checkCollisions(Rectangle machine) {
		
	}
}
