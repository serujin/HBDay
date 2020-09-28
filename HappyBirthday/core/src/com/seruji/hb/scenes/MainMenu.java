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
	private static boolean[] gamesPassed = new boolean[7];
	
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
		if(allGamesPassed()) {
			changeScene(9);
		}
		arrow.draw();
		Utils.showText(batch, font, Color.WHITE,     "Mudanza", x[0], 510);
		Utils.showText(batch, font, Color.WHITE, "Universidad", x[1], 510);
		Utils.showText(batch, font, Color.WHITE,   "Halloween", x[2], 510);
		Utils.showText(batch, font, Color.WHITE,      "Cuenca", x[3], 510);
		Utils.showText(batch, font, Color.WHITE,  "Cuarentena", x[4], 510);
		Utils.showText(batch, font, Color.WHITE,   "Prácticas", x[5], 510);
		Utils.showText(batch, font, Color.WHITE,      "Verano", x[6], 510);
		Utils.showText(batch, font, Color.WHITE,     "Mudanza", x[0] + 1, 511);
		Utils.showText(batch, font, Color.WHITE, "Universidad", x[1] + 1, 511);
		Utils.showText(batch, font, Color.WHITE,   "Halloween", x[2] + 1, 511);
		Utils.showText(batch, font, Color.WHITE,      "Cuenca", x[3] + 1, 511);
		Utils.showText(batch, font, Color.WHITE,  "Cuarentena", x[4] + 1, 511);
		Utils.showText(batch, font, Color.WHITE,   "Prácticas", x[5] + 1, 511);
		Utils.showText(batch, font, Color.WHITE,      "Verano", x[6] + 1, 511);
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
	
	private boolean allGamesPassed() {
		return gamesPassed[0] && gamesPassed[1] && gamesPassed[2] 
			   && gamesPassed[3] && gamesPassed[4] && gamesPassed[5] 
			   && gamesPassed[6];
	}
	
	public static void gamePassed(int number) {
		gamesPassed[number] = true;
	}
}
