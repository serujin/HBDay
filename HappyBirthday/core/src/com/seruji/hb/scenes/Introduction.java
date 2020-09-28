package com.seruji.hb.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.seruji.hb.main.HappyBirthdayMain;
import com.seruji.hb.model.Scene;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class Introduction extends Scene {

	private int textX;
	private boolean canGo;
	
	public Introduction(HappyBirthdayMain game) {
		super(game, Assets.introductionBg);
		back.setPosition(-9000, 0);
		textX = -2000;
		canGo = false;
		initAnimations();
	}

	@Override
	protected void draw() {
		if(Gdx.input.justTouched() && canGo) {
			changeScene(1);
		}
		if(canGo) {
			Utils.showText(batch, Assets.uniFont, Color.BLACK, "(Pulsa para ir al menú principal)", 662, 1002);
			Utils.showText(batch, Assets.uniFont, Color.WHITE, "(Pulsa para ir al menú principal)", 660, 1000);
		}
		Utils.showText(batch, font, Color.BLACK, "Tendrás que jugar y superar todos\n    los minijuegos para descubrir \n   la sorpresa final, buena suerte", textX + 2, 342);
		Utils.showText(batch, font, Color.WHITE, "Tendrás que jugar y superar todos\n    los minijuegos para descubrir \n   la sorpresa final, buena suerte", textX, 340);
	}
	
	private void initAnimations() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				while(!canGo) {
					try {
						Thread.sleep(8);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(textX < 221) {
						textX+=12;
					} else {
						canGo = true;
					}
				}
			}
			
		}).start();
	}

}
