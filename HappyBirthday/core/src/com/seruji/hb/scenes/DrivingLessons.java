package com.seruji.hb.scenes;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.seruji.hb.main.HappyBirthdayMain;
import com.seruji.hb.model.Scene;
import com.seruji.hb.objects.drivinglessons.BgManager;
import com.seruji.hb.objects.drivinglessons.Car;
import com.seruji.hb.objects.drivinglessons.LorenaD;
import com.seruji.hb.objects.drivinglessons.Person;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class DrivingLessons extends Scene {

	private BgManager bg;
	private Person person;
	private Car car;
	private LorenaD lorena;
	private int scene;
	private int speed;
	private int pSpeed;
	private int score;
	
	public DrivingLessons(HappyBirthdayMain game) {
		super(game, Assets.drivingLessonsBg);
		bg = new BgManager(0, 0, 0, 0, batch);
		person = new Person(1000, 360, 2, 6, batch);
		car = new Car(375, 770, 30, 19, batch);
		lorena = new LorenaD(0, 300, 8, 16, batch);
		scene = 0;
		speed = 300;
		pSpeed = 1;
		score = 0;
		initAnimations();
	}

	@Override
	protected void draw() {
		bg.draw();	
		if(scene == 0) {
			lorena.draw();
		}
		if(scene == 1) {
			person.draw();
			Utils.showText(batch, Assets.uniFont, Color.BLACK, "SCORE: " + score, 870, 60);
		}
		if(scene < 2) {
			Utils.showText(batch, Assets.uniFont, Color.BLACK, "<- Pulsa a la izquierda o derecha para mover el coche ->", 480, 20);
			car.draw();
		}
		if(scene == 2) {
			Utils.showText(batch, font, Color.BLACK, "¡Bien jugado! Has conseguido:\n          " + score + " puntos\n   (Toca para ir al menú)", 358, 358);
			Utils.showText(batch, font, Color.WHITE, "¡Bien jugado! Has conseguido:\n          " + score + " puntos\n   (Toca para ir al menú)", 360, 360);
		}
		update();
	}
	
	private void update() {
		if(scene == 1) {
			if(speed > 100) {
				speed--;
			}
			person.move(pSpeed * 2, 0, 1);
			if(person.getPosition()[0] < 960) {
				person.move(pSpeed, -1, 0);
			} else {
				person.move(pSpeed, 1, 0);
			}
			person.addSize(1, 2);
		}
		if(Gdx.input.isTouched() && scene == 1) {
			Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
			if(touch.x < 960) {
				if(car.getPosition()[0] > 376) {
					car.move(8, -1, 0);
				}
			} else {
				if(car.getPosition()[0] < 1061) {
					car.move(8, 1, 0);
				}
			}
		}
		if(Gdx.input.justTouched() && scene == 2) {
			MainMenu.gamePassed(5);
			changeScene(1);
		}
	}
	
	private void initAnimations() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				Random r = new Random();
				int times = 0;
				while(scene == 0) {
					if(lorena.getBounds().overlaps(car.getBounds())) {
						scene++;
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(lorena.getPosition()[1] < car.getPosition()[1] - car.getBounds().height) {
						lorena.move(3, 0, 1);
					} else {
						lorena.move(2, 1, 0);
					}
				}
				while(scene == 1) {
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(car.getBounds().overlaps(person.getBounds())) {
						scene++;
					}
					if(times > 10 && pSpeed < 6) {
						times = 0;
						pSpeed++;
					}
					if(person.getPosition()[1] > 1180) {
						score++;
						if(r.nextBoolean()) {
							person = new Person(r.nextInt(60) + 850, 360, 2, 6, batch);
						} else {
							person = new Person(r.nextInt(60) + 1000, 360, 2, 6, batch);
						}
					}
					bg.changeSprite();
					times++;
				}
			}
		}).start();
	}
}
