package com.seruji.hb.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.seruji.hb.main.HappyBirthdayMain;
import com.seruji.hb.model.Scene;
import com.seruji.hb.objects.mainmenu.Arrow;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class MainMenu extends Scene {

	private Arrow arrow;
	private int currentMiniGame;
	private int[] x;
	
	public MainMenu(HappyBirthdayMain game) {
		super(game, Assets.mainMenuBg);
		currentMiniGame = 2;
		arrow = new Arrow(0, 0, 15, 15, batch);
		Gdx.graphics.setContinuousRendering(false);
		back.setPosition(15000, 0);
		initPositions();
	}

	@Override
	protected void draw() {
		arrow.draw();
		Utils.showText(batch, font, Color.BLACK,     "Mudanza", x[0], 510);
		Utils.showText(batch, font, Color.BLACK, "Universidad", x[1], 510);
		Utils.showText(batch, font, Color.BLACK,   "Halloween", x[2], 510);
		Utils.showText(batch, font, Color.BLACK,      "Cuenca", x[3], 510);
		Utils.showText(batch, font, Color.BLACK,  "Cuarentena", x[4], 510);
		Utils.showText(batch, font, Color.BLACK,   "Prácticas", x[5], 510);
		Utils.showText(batch, font, Color.BLACK,      "Verano", x[6], 510);
		update();
	}
	
	private void update() {
		if(Gdx.input.justTouched()) {
			Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
			if(touch.x > 1440) {
				moveRight();
			}
			if(touch.x < 475) {
				moveLeft();
			}
			if(475 < touch.x && touch.x < 1440 && touch.y > 235 && touch.y < 845) {
				changeScene(currentMiniGame);
			}
		}
	}
	
	private void moveLeft() {
		if(x[0] > 2000 || x[0] < 0) {
			currentMiniGame--;
			for(int i = 0; i < x.length; i++) {
				x[i] += 2000;
			}
		}
	}

	private void moveRight() {
		if(x[6] > 2000) {
			currentMiniGame++;
			for(int i = 0; i < x.length; i++) {
				x[i] -= 2000;
			}
		}
	}

	private void initPositions() {
		x = new int[] {
			  785,
			 2730,
			 4775,
			 6810,
			 8725,
			10770,
			12825
		};
	}
}
