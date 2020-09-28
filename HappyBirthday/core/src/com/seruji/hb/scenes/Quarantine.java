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
import com.seruji.hb.objects.quarantine.Rex;
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
	private Rex rex;
	private HairPixel[][] topHair;
	private HairPixel[][]sidesHair;
	private boolean up;
	private int scene;
	private int topColumns = 1050;
	private int sideColumns = 280;
	private int rows = 18;

	
	public Quarantine(HappyBirthdayMain game) {
		super(game, Assets.quarantineBg);
		lorena = new LorenaQ(230, 460, 18, 36, batch);
		sergio = new SergioQ(30, 440, 18, 36, batch);
		blanket = new Blanket(0, 480, 61, 40, batch);
		street = new Street(0, 0, 0, 0, batch);
		scene1Bg = new Home(1000, 300, batch);
		machine = new Machine(1750, 650, 5, 5, batch);
		face = new Face(0, 0, 60, 60, batch);
		rex = new Rex(490, 1275, 3, 3, batch);
		scene = 0;
		initHair();
		startAnimation();
	}

	@Override
	protected void draw() {
		if(Gdx.input.justTouched() && scene == 3) {
			MainMenu.gamePassed(4);
			changeScene(1);
		}
		if(Gdx.input.isTouched() && scene == 1) {
			machine.on();
			Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
			machine.setPosition((int) (touch.x - machine.getBounds().width/2), (int) (touch.y - machine.getBounds().height * 2/3));
		} else {
			machine.off();
			machine.setPosition(1750, 750);
		}
		if(scene > 1) {
			street.draw();
		}
		if(scene == 2) {
			rex.draw();
		}
		if(scene == 1) {
			scene1Bg.draw();
			face.draw();
			machine.draw();
			Utils.showText(batch, Assets.uniFont, Color.BLACK, "Coge la maquinilla y arrastra para cortar el pelo", 530, 10);
			for(int i = 0; i < rows; i++) {
				for (int j = 0; j < sideColumns; j++) {
					if(machine.getBounds().overlaps(sidesHair[i][j].getBounds())) {
						sidesHair[i][j].touch();
					}
					sidesHair[i][j].draw();
				}
			}
			for(int i = 0; i < rows; i++) {
				for (int j = 0; j < topColumns; j++) {
					if(machine.getBounds().overlaps(topHair[i][j].getBounds())) {
						topHair[i][j].touch();
					}
					topHair[i][j].draw();
				}
			}
				
		}
		lorena.draw();
		sergio.draw();
		if(scene == 0 && !up) {
			blanket.draw();
		}
		if(scene == 0 && up) {
			Utils.showText(batch, Assets.uniFont, Color.BLACK, "Buenos días parejita, antes de sacar a Rex Lorena tiene que rapar a Sergio", 300, 10);
		}
		if(scene == 3) {
			Utils.showText(batch, font, Color.BLACK, " Ahora a descansar a casita\n después de sacar a Rexito  \n   (Toca para ir al menú)", 352, 352);
			Utils.showText(batch, font, Color.WHITE, " Ahora a descansar a casita\n después de sacar a Rexito  \n   (Toca para ir al menú)", 350, 350);
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
				while(scene == 1) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(checkIfBold()) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						scene++;
						lorena = new LorenaQ(190, 1200, 4, 8, batch);
						sergio = new SergioQ(230, 1200, 4, 8, batch);
						lorena.changeSprite();
						sergio.changeSprite();
						lorena.changeRotation();
						sergio.changeRotation();
					}
				}
				boolean top = false;
				boolean left = false;
				while(scene == 2) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(lorena.getPosition()[1] < 50) {
						top = true;
						lorena.setPosition(1800, 250);
						sergio.setPosition(1840, 250);
						rex.setPosition(2100, 325);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if(top && lorena.getPosition()[0] < 200) {
						left = true;
					}
					if(left) {
						moveAllB(2, 0, 1);
					}
					if(top && !left) {	
						moveAllB(2, -1, 0);
					} else if(!left) {
						moveAllB(2, 0, -1);
					}
					if(lorena.getPosition()[1] > 1200) {
						scene++;
					}
				}
			}
		}).start();
	}
	
	private void initHair() {
		topHair = new HairPixel[rows][topColumns];
		sidesHair = new HairPixel[rows][sideColumns];
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < sideColumns/2; j++) {
				sidesHair[i][j] = new HairPixel(j + 430, i * 16 + (45 + rows * 16), 1, 1, batch);
			}
			for (int j = sideColumns/2; j < sideColumns; j++) {
				sidesHair[i][j] = new HairPixel(j + 1200, i * 16 + (45 + rows * 16), 1, 1, batch);
			}
		}
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < topColumns; j++) {
				topHair[i][j] = new HairPixel(j + 430, i * 16 + 45, 1, 1, batch);
			}
		}
	}
	
	private boolean checkIfBold() {
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < sideColumns; j++) {
				if(!sidesHair[i][j].shoulDelete()) {
					return false;
				}
			}
		}
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < topColumns; j++) {
				if(!topHair[i][j].shoulDelete()) {
					return false;
				}
			}
		}
		return true;
	}
	
	private void moveAll(int speed, int xAxis, int yAxis) {
		lorena.move(speed, xAxis, yAxis);
		sergio.move(speed, xAxis, yAxis);
	}
	
	private void moveAllB(int speed, int xAxis, int yAxis) {
		lorena.move(speed, xAxis, yAxis);
		sergio.move(speed, xAxis, yAxis);
		rex.move(speed, xAxis, yAxis);
	}

}
