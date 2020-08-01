package com.seruji.hb.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.seruji.hb.main.HappyBirthdayMain;
import com.seruji.hb.model.Scene;
import com.seruji.hb.objects.cuenca.BgManager;
import com.seruji.hb.objects.cuenca.LorenaAndSergio;
import com.seruji.hb.objects.cuenca.Suitcase;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class Cuenca extends Scene {

	private LorenaAndSergio we;
	private Suitcase suitcase;
	private BgManager bg;
	private int scene;
	
	public Cuenca(HappyBirthdayMain game) {
		super(game, Assets.cuencaBg);
		we = new LorenaAndSergio(1920, 400, 7, 14, batch);
		suitcase = new Suitcase(2100, 400, 14, 14, batch);
		bg = new BgManager(0, 0, 0, 0, batch);
		scene = 0;
		startInteractions();
	}

	@Override
	protected void draw() {
		if(scene != 0) {
			bg.draw();
		}
		if(scene == 0) {
			suitcase.draw();
			Utils.showText(batch, Assets.uniFont, Color.BLACK, "Al llegar del autobús hay que ir a casa a dejar la maleta", 500, 30);
		}
		if(scene == 1) {
			Utils.showText(batch, Assets.uniFont, Color.WHITE, "Visitan la famosa Torre de Mangana", 600, 30);
		}
		if(scene == 2) {
			Utils.showText(batch, Assets.uniFont, Color.WHITE, "La cena de aniversario en La Grotte", 1250, 30);
		}
		if(scene == 3) {
			Utils.showText(batch, font, Color.BLACK, " Ahora a descansar a casita\n después de la super cenita \n   (Toca para ir al menú)", 351, 351);
			Utils.showText(batch, font, Color.WHITE, " Ahora a descansar a casita\n después de la super cenita \n   (Toca para ir al menú)", 350, 350);
		}
		we.draw();
		update();
	} 
	
	private void update() {
		if(Gdx.input.justTouched()) {
			boolean end = scene == 3;
			if(end) {
				changeScene(1);
			}
		}
	}
	
	private void moveAll(int speed, int xAxis, int yAxis) {
		we.move(speed, xAxis, yAxis);
		suitcase.move(speed, xAxis, yAxis);
	}

	private void startInteractions() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				int x;
				while(scene == 0) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					moveAll(5, -1, 0);
					x = we.getPosition()[0];
					if(x < -340) {
						scene++;
					}
				}
				we = new LorenaAndSergio(1500, 1080, 7, 14, batch);
				we.changeScene();
				while(scene == 1) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					x = we.getPosition()[0];
					if(x > 990) {
						moveAll(5, -1, -1);
					}
					if(x < 991 && x > 800) {
						we.setPosition(-900, we.getPosition()[1]);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						we.setPosition(300, we.getPosition()[1]);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						scene++;
					}
				}
				we = new LorenaAndSergio(1920, 740, 10, 20, batch);
				we.changeScene();
				bg.changeScene();
				for(int i = 0; i < 330; i++) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					moveAll(5, -1, 0);
				}
				for(int i = 0; i < 70; i++) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					moveAll(2, 1, 0);
					moveAll(5, 0, -1);
				}
				we.setPosition(-10000, 20);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				scene++;
			}
		}).start();
	}
	
}
