package com.seruji.hb.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Utils {
	public static Sprite[] getSprites(Sprite[] raw, int start, int end) {
		int size = end - start;
		if(size < 1) {
			size = 1;
		}
		Sprite[] temp = new Sprite[size];
		for(int i = 0; i < temp.length; i++) {
			temp[i] = raw[start + i];
		}
		return temp;
	}
	
	public static Sprite[] getSprites(Sprite[] raw, int index) {
		return new Sprite[] {raw[index]};
	}
	
	public static void showText(SpriteBatch batch, BitmapFont font, Color color, String text, int x, int y) {
		font.setColor(color);
		font.draw(batch, text, x, y);
	}
}
