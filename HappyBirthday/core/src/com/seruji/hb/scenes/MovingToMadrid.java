package com.seruji.hb.scenes;

import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.seruji.hb.main.HappyBirthdayMain;
import com.seruji.hb.model.Scene;
import com.seruji.hb.objects.movingtomadrid.Suitcase;
import com.seruji.hb.objects.movingtomadrid.Wear;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class MovingToMadrid extends Scene {

	private Suitcase suitcase;
	private Wear[] clothes;
	private Random random;
	private int catchedItems;
	
	public MovingToMadrid(HappyBirthdayMain game) {
		super(game, Assets.movingToMadridBg);
		random = new Random();
		clothes = new Wear[16];
		suitcase = new Suitcase(920, 820, 20, 15, batch);
		catchedItems = 0;
		initClothes();
	}
	
	@Override
	protected void draw() {
		suitcase.draw();
		fall();
		if(catchedItems == clothes.length) {
			Utils.showText(batch, font, Color.WHITE, "Ya estamos listos para ir a Madrid\n      (Toca para ir al menú)", 248, 398);
			Utils.showText(batch, font, Color.BLACK, "Ya estamos listos para ir a Madrid\n      (Toca para ir al menú)", 250, 400);
		} else {
			Utils.showText(batch, Assets.uniFont, Color.BLACK, "¡Recoge la ropa para poder ir a Madrid!", 600, 30);
		}
		update();
	}
	
	private void update() {
		if(Gdx.input.isTouched()) {
			Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
			suitcase.setPosition((int) ((int) touch.x - suitcase.getBounds().width/2), suitcase.getPosition()[1]);
		}
		if(catchedItems == clothes.length && Gdx.input.justTouched()) {
			MainMenu.gamePassed(0);
			changeScene(1);
		}
	}
	
	private void fall() {
		for (int i = 0; i < clothes.length; i++) {
			if(clothes[i].getPosition()[1] > 1100) {
				clothes[i] = new Wear(random.nextInt(1690) + 60, 0, 5, 5, batch);
			}
			if(clothes[i].getBounds().overlaps(suitcase.getBounds())) {
				catchedItems ++;
				clothes[i].setPosition(-15000, -15000);
			}
			clothes[i].draw();
		}
	}
	
	private void initClothes() {
		for(int i = 0; i < clothes.length; i++) {
			clothes[i] = new Wear(random.nextInt(1690) + 60, 0, 5, 5, batch);
		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(catchedItems < clothes.length) {
					for (int i = 0; i < clothes.length; i++) {
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						clothes[i].move(random.nextInt(90), 0, 1);
					}
				}
			}
		}).start();
	}
}
