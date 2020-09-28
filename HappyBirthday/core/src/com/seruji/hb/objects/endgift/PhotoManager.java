package com.seruji.hb.objects.endgift;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seruji.hb.model.GameObject;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class PhotoManager extends GameObject {

	private int xGap;
	private int yGap;
	
	public PhotoManager(int x, int y, int xSize, int ySize, SpriteBatch batch) {
		super(x, y, xSize, ySize, batch);
		sprites = Assets.photos;
		xGap = 1920;
		yGap = 1080;
	}

	@Override
	public void draw() {
		//BLOQUE 1
		batch.draw( sprites[0], bounds.x + 100, bounds.y + 50, 188, 252, 378, 504, 1, 1, -15); //AGOSTO
		batch.draw( sprites[1], bounds.x + 400, bounds.y + 50, 191, 256, 383, 512, 1, 1, 6); //AGOSTO
		Utils.showText(batch, Assets.uniFont, Color.WHITE, "AGOSTO", (int) bounds.x + 350, (int) bounds.y + 580);
		batch.draw( sprites[2], bounds.x + 1000, bounds.y + 400, 191, 256, 383, 512, 1, 1, -10); //SEPTIEMBRE
		batch.draw( sprites[4], bounds.x + 1250, bounds.y + 135, 256, 191, 512, 383, 1, 1, 2); //SEPTIEMBRE
		batch.draw( sprites[3], bounds.x + 1350, bounds.y + 500, 256, 191, 512, 383, 1, 1, 6); //SEPTIEMBRE
		Utils.showText(batch, Assets.uniFont, Color.WHITE, "SEPTIEMBRE", (int) bounds.x + 1360, (int) bounds.y + 920);
		//BLOQUE 2
		batch.draw( sprites[5], bounds.x + 50, bounds.y + 400 - yGap, 191, 256, 383, 512, 1, 1, -6); //OCTUBRE
		batch.draw( sprites[6], bounds.x + 420, bounds.y + 400 - yGap, 191, 256, 383, 512, 1, 1, 5); //OCTUBRE
		Utils.showText(batch, Assets.uniFont, Color.WHITE, "OCTUBRE", (int) bounds.x + 320, (int) bounds.y + 930 - yGap);
		batch.draw( sprites[7], bounds.x + 1350, bounds.y + 200 - yGap, 256, 191, 512, 383, 1, 1, 6); //NOVIEMBRE
		batch.draw( sprites[8], bounds.x + 1000, bounds.y + 80 - yGap, 191, 256, 383, 512, 1, 1, -5); //NOVIEMBRE
		Utils.showText(batch, Assets.uniFont, Color.WHITE, "NOVIEMBRE", (int) bounds.x + 1390, (int) bounds.y + 120 - yGap);
		//BLOQUE 3
		batch.draw( sprites[9], bounds.x + 100 - xGap, bounds.y + 50 - yGap, 256, 191, 512, 383, 1, 1, -10); //DICIEMBRE
		batch.draw(sprites[10], bounds.x + 600 - xGap, bounds.y + 50 - yGap, 256, 191, 512, 383, 1, 1, 2); //DICIEMBRE
		Utils.showText(batch, Assets.uniFont, Color.WHITE, "DICIEMBRE", (int) bounds.x + 490 - xGap, (int) bounds.y + 460 - yGap);
		batch.draw(sprites[11], bounds.x + 1320 - xGap, bounds.y + 50 - yGap, 121, 162, 243, 324, 1, 1, -10); //ENERO
		batch.draw(sprites[12], bounds.x + 1550 - xGap, bounds.y + 50 - yGap, 162, 121, 324, 243, 1, 1, 3); //ENERO
		Utils.showText(batch, Assets.uniFont, Color.WHITE, "ENERO", (int) bounds.x + 1600 - xGap, (int) bounds.y + 310 - yGap);
		batch.draw(sprites[14], bounds.x + 1400 - xGap, bounds.y + 500 - yGap, 191, 256, 383, 512, 1, 1, 7); //FEBRERO
		batch.draw(sprites[13], bounds.x + 1040 - xGap, bounds.y + 500 - yGap, 191, 256, 383, 512, 1, 1, -5); //FEBRERO
		Utils.showText(batch, Assets.uniFont, Color.WHITE, "FEBRERO", (int) bounds.x + 1400 - xGap, (int) bounds.y + 1020 - yGap);
		batch.draw(sprites[15], bounds.x + 100 - xGap, bounds.y + 600 - yGap, 256, 191, 512, 383, 1, 1, -5); //MARZO
		batch.draw(sprites[16], bounds.x + 500 - xGap, bounds.y + 540 - yGap, 191, 256, 383, 512, 1, 1, 5); //MARZO
		Utils.showText(batch, Assets.uniFont, Color.WHITE, "MARZO", (int) bounds.x + 300 - xGap, (int) bounds.y + 1020 - yGap);
		//BLOQUE 4
		batch.draw(sprites[18], bounds.x + 100 - xGap, bounds.y + 600, 256, 191, 512, 383, 1, 1, -5); //ABRIL
		batch.draw(sprites[17], bounds.x + 500 - xGap, bounds.y + 540, 144, 256, 288, 512, 1, 1, 5); //ABRIL
		Utils.showText(batch, Assets.uniFont, Color.WHITE, "ABRIL", (int) bounds.x + 300 - xGap, (int) bounds.y + 1020);
		batch.draw(sprites[19], bounds.x + 1350 - xGap, bounds.y + 600, 256, 191, 512, 383, 1, 1, 6); //MAYO
		batch.draw(sprites[20], bounds.x + 1000 - xGap, bounds.y + 500, 191, 256, 383, 512, 1, 1, -10); //MAYO
		Utils.showText(batch, Assets.uniFont, Color.WHITE, "MAYO", (int) bounds.x + 1400 - xGap, (int) bounds.y + 1000);
		//BLOQUE 5
		batch.draw(sprites[21], bounds.x + 450 - xGap, bounds.y + 200 + yGap, 255, 341, 510, 682, 1, 1, -4); //JUNIO
		batch.draw(sprites[22], bounds.x + 950 - xGap, bounds.y + 200 + yGap, 255, 341, 510, 682, 1, 1, 2); //JUNIO
		Utils.showText(batch, Assets.uniFont, Color.WHITE, "JUNIO", (int) bounds.x + 900 - xGap, (int) bounds.y + 900 + yGap);
		//BLOQUE 6
		batch.draw(sprites[27], bounds.x + 650 - xGap - xGap, bounds.y + 500 + yGap, 150, 200, 300, 400, 1, 1, -5);
		batch.draw(sprites[23], bounds.x + 700 - xGap - xGap, bounds.y + 150 + yGap, 256, 191, 542, 413, 1, 1, 6);
		batch.draw(sprites[24], bounds.x + 950 - xGap - xGap, bounds.y + 500 + yGap, 150, 200, 300, 400, 1, 1, 5);
		batch.draw(sprites[25], bounds.x + 1250 - xGap - xGap, bounds.y + 200 + yGap, 255, 341, 510, 682, 1, 1, -4);
		batch.draw(sprites[26], bounds.x + 150 - xGap - xGap, bounds.y + 200 + yGap, 255, 341, 510, 682, 1, 1, 4);
		Utils.showText(batch, Assets.uniFont, Color.WHITE, "Me encanta tu sonrisaaaa", (int) bounds.x + 200 - xGap - xGap, (int) bounds.y + 130 + yGap);
		Utils.showText(batch, Assets.uniFont, Color.WHITE, "Ojalá estar en muchos cumpleaños más, y poder pasar muchos mas años contigo, te amo cariño \n                     "
				+ "                                             ¡FELIZ CUMPLEAÑOS!", (int) bounds.x + 100 - xGap - xGap, (int) bounds.y + 930 + yGap);
	}

}
