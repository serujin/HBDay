package com.seruji.hb.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.seruji.hb.main.HappyBirthdayMain;
import com.seruji.hb.model.Scene;
import com.seruji.hb.objects.endgift.PhotoManager;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class EndGift extends Scene {

	private PhotoManager photo;
	private boolean scene;
	private boolean end;
	private boolean orNot;
	
	public EndGift(HappyBirthdayMain game) {
		super(game, Assets.endGiftBg);
		back.setPosition(-9000, 0);
		photo = new PhotoManager(0, 0, 0, 0, batch);
		scene = false;
		end = false;
		orNot = false;
		initAnimations();
	}

	@Override
	protected void draw() {
		if(Gdx.input.justTouched() && !scene) {
			scene = true;
		}
		if(!scene) {
			Utils.showText(batch, font, Color.BLACK, " Felicidades, has superado \n    todos los minijuegos\n(Toca para recibir el regalo)", 386, 431);
			Utils.showText(batch, font, Color.WHITE, " Felicidades, has superado \n    todos los minijuegos\n(Toca para recibir el regalo)", 385, 430);
		}
		if(scene) {
			photo.draw();
		}
		if(end) {
			Utils.showText(batch, font, Color.BLACK, "The End", 781, 461);
			Utils.showText(batch, font, Color.WHITE, "The End", 780, 460);
		}
		if(orNot) {
			Utils.showText(batch, font, Color.BLACK, "of the game ;)", 677, 541);
			Utils.showText(batch, font, Color.WHITE, "of the game ;)", 678, 540);
		}
	}
	
	public void initAnimations() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(!scene) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				carousel();
			}
			
		}).start();
	}

	private void carousel() {
		photo = new PhotoManager(0, 0, 0, 0, batch);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		for(int i = 0; i < 540; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			photo.move(2, 0, 1);
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		for(int i = 0; i < 960; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			photo.move(2, 1, 0);
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		for(int i = 0; i < 540; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			photo.move(2, 0, -1);
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		for(int i = 0; i < 540; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			photo.move(2, 0, -1);
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		for(int i = 0; i < 960; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			photo.move(2, 1, 0);
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		end = true;
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		orNot = true;
	}

}
