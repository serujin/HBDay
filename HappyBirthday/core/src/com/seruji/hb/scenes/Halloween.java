package com.seruji.hb.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.seruji.hb.main.HappyBirthdayMain;
import com.seruji.hb.model.Scene;
import com.seruji.hb.objects.halloween.Button;
import com.seruji.hb.objects.halloween.Cake;
import com.seruji.hb.objects.halloween.Home;
import com.seruji.hb.objects.halloween.Lorena;
import com.seruji.hb.objects.halloween.Sergio;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class Halloween extends Scene {

	private Lorena lorena;
	private Sergio sergio;
	private Button head;
	private Button body;
	private Button acc;
	private Button legs;
	private Button shoes;
	private Home home;
	private Cake cake;
	private int distanceBetween = 385;
	private int xOff = 40;
	private int yOff = 65;
	private int[] buttonX = new int[]{
		  32 + distanceBetween * 0,
		  32 + distanceBetween * 1,
		  32 + distanceBetween * 2,
		  32 + distanceBetween * 3,
		  32 + distanceBetween * 4
	};
	private int scene;
	
	public Halloween(HappyBirthdayMain game) {
		super(game, Assets.halloweenBg);
		back.setPosition(1748, 10);
		lorena = new Lorena(800, 220, 20, 40, batch);
		sergio = new Sergio(1100, 220, 20, 40, batch);
		head =  new Button(buttonX[0], 910, 20, 10, batch);
		body =  new Button(buttonX[1], 910, 20, 10, batch);
		acc =   new Button(buttonX[2], 910, 20, 10, batch);
		legs =  new Button(buttonX[3], 910, 20, 10, batch);
		shoes = new Button(buttonX[4], 910, 20, 10, batch);
		home = new Home(1000, 300, batch);
		cake = new Cake(45, 45, batch);
		scene = 0;
		startEvents();
	}

	@Override
	protected void draw() {
		if(scene < 2) {
			home.draw();
		}
		if(scene == 0) {
			Utils.showText(batch, Assets.uniFont, Color.BLACK, "Antes de la fiesta hay que coger fuerzas con tartita y prepararse\n"
					+ "                                      (Toca para comer tarta)", 370, 60);
			cake.draw();
		}
		if(scene > 0) {
			lorena.draw();
			sergio.draw();
		}
		if(scene == 1) {
			Utils.showText(batch, Assets.uniFont, Color.BLACK, "Ahora hay que vestirse para la fiesta", 1000, 20);
			head.draw();
			Utils.showText(batch, Assets.uniFont, Color.BLACK, "MAQUILLAJE",  head.getPosition()[0] + xOff,  head.getPosition()[1] + yOff);
			body.draw();
			Utils.showText(batch, Assets.uniFont, Color.BLACK,   "CAMISETA",    body.getPosition()[0] + 61,  body.getPosition()[1] + yOff);
			acc.draw();
			Utils.showText(batch, Assets.uniFont, Color.BLACK, "ACCESORIOS",   acc.getPosition()[0] + xOff,   acc.getPosition()[1] + yOff);
			legs.draw();
			Utils.showText(batch, Assets.uniFont, Color.BLACK, "PANTALONES",    legs.getPosition()[0] + 35,  legs.getPosition()[1] + yOff);
			shoes.draw();
			Utils.showText(batch, Assets.uniFont, Color.BLACK, "ZAPATILLAS", shoes.getPosition()[0] + xOff, shoes.getPosition()[1] + yOff);
		}
		if(scene == 3) {
			Utils.showText(batch, font, Color.BLACK, " Ahora a descansar a casita\ndespués de la noche de baile\n   (Toca para ir al menú)", 351, 351);
			Utils.showText(batch, font, Color.WHITE, " Ahora a descansar a casita\ndespués de la noche de baile\n   (Toca para ir al menú)", 350, 350);
		}
		update();
	}
	
	private void update() {
		if(Gdx.input.justTouched()) {
			boolean end = scene == 3;
			if(end) {
				changeScene(1);
			}
			Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
			if(scene == 0) {
				cake.changeState();
			}
			if(isTouched(head, touch)) {
				lorena.showHead();
				sergio.showHead();
				head.activate();
			}
			if(isTouched(body, touch)) {
				lorena.showBody();
				sergio.showBody();
				body.activate();
			}
			if(isTouched(acc, touch)) {
				lorena.showAcc();
				sergio.showAcc();
				acc.activate();
			}
			if(isTouched(legs, touch)) {
				lorena.showLegs();
				sergio.showLegs();
				legs.activate();
			}
			if(isTouched(shoes, touch)) {
				lorena.showShoes();
				sergio.showShoes();
				shoes.activate();
			}
		}
	}
	
	private boolean isTouched(Button button, Vector3 touch) {
		return touch.x > button.getBounds().x && touch.x < button.getBounds().x + button.getBounds().width
				&& touch.y > button.getBounds().y && touch.y < button.getBounds().y + button.getBounds().height;
	}
	
	private void startEvents() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(scene == 0) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(cake.isEaten()) {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						scene = 1;
						home = new Home(120, 68, batch);
					}
				}
				while(scene == 1) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(head.isActivated() && body.isActivated() && acc.isActivated()
							&& legs.isActivated() && shoes.isActivated()) {
						scene = 2;
					}
				}
				lorena.setPosition(lorena.getPosition()[0] - 200, 400);
				sergio.setPosition(sergio.getPosition()[0] - 200, 430);
				int times = 2;
				while(times > 0) {
					for (int i = 0; i < 10; i++) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						lorena.move(10, 1, 0);
						sergio.move(10, -1, 0);
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						lorena.move(10, -1, 0);
						sergio.move(10, 1, 0);
					}
					times--;
				}
				scene = 3;
			}
		}).start();
	}

}
