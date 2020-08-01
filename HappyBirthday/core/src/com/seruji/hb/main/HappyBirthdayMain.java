package com.seruji.hb.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.seruji.hb.model.Scene;
import com.seruji.hb.scenes.Cuenca;
import com.seruji.hb.scenes.DrivingLessons;
import com.seruji.hb.scenes.Halloween;
import com.seruji.hb.scenes.Introduction;
import com.seruji.hb.scenes.MainMenu;
import com.seruji.hb.scenes.MovingToMadrid;
import com.seruji.hb.scenes.Quarantine;
import com.seruji.hb.scenes.Summer;
import com.seruji.hb.scenes.University;
import com.seruji.hb.utils.Assets;

public class HappyBirthdayMain extends Game {
	
	private Scene[] scenes;
	
	@Override
	public void create() {
		Assets.load();
		scenes = new Scene[9];
		loadScenes();
		changeScene(1);
	}	
	
	public void changeScene(int scene) {
		loadScene(scene);
		setScreen(scenes[scene]);
	}
	
	private void loadScenes() {
		scenes[0] = new Introduction(this);
		scenes[1] = new MainMenu(this);
		scenes[2] = new MovingToMadrid(this);
		scenes[3] = new University(this);
		scenes[4] = new Halloween(this);
		scenes[5] = new Cuenca(this);
		scenes[6] = new Quarantine(this);
		scenes[7] = new DrivingLessons(this);
		scenes[8] = new Summer(this);
	}
	
	private void loadScene(int scene) {
		Gdx.graphics.setContinuousRendering(scene != 1);
		if(scene == 0) {
			scenes[0] = new Introduction(this);
		}	
		if(scene == 2) {
			scenes[2] = new MovingToMadrid(this);
		}
		if(scene == 3) {
			scenes[3] = new University(this);
		}
		if(scene == 4) {
			scenes[4] = new Halloween(this);
		}
		if(scene == 5) {
			scenes[5] = new Cuenca(this);
		}
		if(scene == 6) {
			scenes[6] = new Quarantine(this);
		}
		if(scene == 7) {
			scenes[7] = new DrivingLessons(this);
		}
		if(scene == 8) {
			scenes[8] = new Summer(this);
		}
	}
}
