package com.seruji.hb.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.seruji.hb.main.HappyBirthdayMain;
import com.seruji.hb.model.Scene;
import com.seruji.hb.objects.summer.BgManager;
import com.seruji.hb.objects.summer.CarS;
import com.seruji.hb.objects.summer.LorenaS;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class Summer extends Scene {

	private CarS car;
	private LorenaS lorena;
	private BgManager bg;
	private int scene;
	
	public Summer(HappyBirthdayMain game) {
		super(game, Assets.summerBg);
		car = new CarS(-200, 830, 6, 6, batch);
		bg = new BgManager(0, 0, 0, 0, batch);
		lorena = new LorenaS(900, 1080, 3, 6, batch);
		scene = 0;
		initAnimations();
	}

	@Override
	protected void draw() {
		if(scene == 3 && Gdx.input.justTouched()) {
			MainMenu.gamePassed(6);
			changeScene(1);
		}
		if(scene != 0) {
			bg.draw();
		}
		if(scene == 1) {
			lorena.draw();
		}
		car.draw();
		if(scene == 0) {
			Utils.showText(batch, Assets.uniFont, Color.BLACK, "Pillaste un ferry para ir a Mallorca con tus amigos", 500, 10);
		}
		if(scene == 1) {
			Utils.showText(batch, Assets.uniFont, Color.BLACK, "Allí fuiste a playitas con ellos y tomabas el sol", 540, 10);
		}
		if(scene == 2) {
			Utils.showText(batch, Assets.uniFont, Color.BLACK, "Y visitaste pueblos muy bonitos como Valldemossa", 550, 10);
		}
		if(scene == 3) {
			Utils.showText(batch, font, Color.WHITE, "Después de pasarlo genial volviste\n    a casita con toda la familia\n      (Toca para ir al menú)", 259, 359);
			Utils.showText(batch, font, Color.BLACK, "Después de pasarlo genial volviste\n    a casita con toda la familia\n      (Toca para ir al menú)", 260, 360);
		}
	}
	
	private void initAnimations() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				int times = 0;
				while(scene == 0) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					car.move(2, 1, 0);
					if(car.getPosition()[0] > 380) {
						car.move(1, 0, -1);
					}
					if(car.getPosition()[0] > 500) {
						car = new CarS(-200, 830, 6, 6, batch); 
						times++;
					}
					if(times == 2) {
						scene++;
					}
				}
				boolean rotated = false;
				while(scene == 1) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(lorena.getPosition()[0] > 480) {
						lorena.move(2, -1, 0);
						lorena.move(1, 0, -1);
					}
					if(lorena.getPosition()[0] < 481 && lorena.getPosition()[0] > 240) {
						lorena.move(2, -1, 0);
					}
					if(lorena.getPosition()[0] < 241 && !rotated) {
						lorena.rotate();
						rotated = true;
						try {
							Thread.sleep(4000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						scene++;
						bg.changeSprite();
					}
				}
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				scene++;
			}
			
		}).start();
	}

}
