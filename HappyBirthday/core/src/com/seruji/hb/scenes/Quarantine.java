package com.seruji.hb.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.seruji.hb.main.HappyBirthdayMain;
import com.seruji.hb.model.Scene;
import com.seruji.hb.objects.halloween.Home;
import com.seruji.hb.objects.quarantine.Blanket;
import com.seruji.hb.objects.quarantine.Face;
import com.seruji.hb.objects.quarantine.HairPixel;
import com.seruji.hb.objects.quarantine.LorenaQ;
import com.seruji.hb.objects.quarantine.Machine;
import com.seruji.hb.objects.quarantine.SergioQ;
import com.seruji.hb.objects.quarantine.Street;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class Quarantine extends Scene {

	private LorenaQ lorena;
	private SergioQ sergio;
	private Blanket blanket;
	private Street street;
	private Home scene1Bg;
	private Machine machine;
	private Face face;
	private HairPixel[] hair;
	private boolean up;
	private int scene;
	
	public Quarantine(HappyBirthdayMain game) {
		super(game, Assets.quarantineBg);
		lorena = new LorenaQ(230, 460, 18, 36, batch);
		sergio = new SergioQ(30, 440, 18, 36, batch);
		blanket = new Blanket(0, 480, 61, 40, batch);
		street = new Street(0, 0, 0, 0, batch);
		scene1Bg = new Home(1000, 300, batch);
		machine = new Machine(1750, 650, 5, 15, batch);
		face = new Face(0, 0, 60, 60, batch);
		scene = 1;
		startAnimation();
	}

	@Override
	protected void draw() {
		if(Gdx.input.justTouched()) {
			Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
			System.out.println(touch.x + " " + touch.y);
		}
//		if(Gdx.input.isTouched() && scene == 1) {
//			machine.on();
//			Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
//			camera.unproject(touch);
//			machine.setPosition((int) (touch.x - machine.getBounds().width/2), (int) (touch.y - machine.getBounds().height * 2/3));
//		} else {
//			machine.off();
//			machine.setPosition(1750, 750);
//		}
		if(scene == 2) {
			street.draw();
		}
		if(scene == 1) {
			scene1Bg.draw();
			face.draw();
			machine.draw();
//			for(HairPixel h : hair) {
//				if(machine.getBounds().overlaps(h.getBounds())) {
//					h.touch();
//				}
//			}
		}
//		lorena.draw();
//		sergio.draw();
		if(scene == 0 && !up) {
			blanket.draw();
		}
		if(scene == 0 && up) {
			Utils.showText(batch, Assets.uniFont, Color.BLACK, "Buenos días parejita, antes de sacar a Rex Lorena tiene que rapar a Sergio", 300, 10);
		}
	}
	
	private void startAnimation() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
				up = true;
				lorena.changeRotation();
				lorena.setPosition(lorena.getPosition()[0] + 350, lorena.getPosition()[1]);

				sergio.changeRotation();
				sergio.setPosition(sergio.getPosition()[0] + 350, lorena.getPosition()[1]);
				while(scene == 0) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					moveAll(2, 0, 1);
					moveAll(1, 1, 0);
					if(lorena.getPosition()[1] > 1100) {
						scene++;
					}
				}
			}
		}).start();
	}
	
	private void initHair() {
		int minX = 480;
		int maxX = 1440;
		int minY = 65;
		int eyeHeight = 320;
		int maxY = 540;
		//660 pixels between max and min x
		//475 pixels between max and min y
		//MCD of 660 and 480 is 5
		hair = new HairPixel[] {
			
		};
	}
	
	private void moveAll(int speed, int xAxis, int yAxis) {
		lorena.move(speed, xAxis, yAxis);
		sergio.move(speed, xAxis, yAxis);
	}

}
