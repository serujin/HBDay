package com.seruji.hb.scenes;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.seruji.hb.main.HappyBirthdayMain;
import com.seruji.hb.model.Scene;
import com.seruji.hb.objects.university.Bus;
import com.seruji.hb.objects.university.BusStop;
import com.seruji.hb.objects.university.City;
import com.seruji.hb.objects.university.Person;
import com.seruji.hb.objects.university.Road;
import com.seruji.hb.objects.university.RoadMark;
import com.seruji.hb.objects.university.Stop;
import com.seruji.hb.utils.Assets;
import com.seruji.hb.utils.Utils;

public class University extends Scene {

	private Bus bus;
	private BusStop busStop;
	private Person lorena;
	private Person random1;
	private Person random2;
	private City city;
	private Road road;
	private RoadMark roadMark;
	private Stop stop;
	private int scene;
	private int[] stopPositions = {87, 420, 747};
	private Random random;
	private String pointsText;
	private int currentPoints;
	private int requiredPoints;
	private int stopSpeed;
	
	public University(HappyBirthdayMain game) {
		super(game, Assets.universityBg);
		random = new Random();
		scene = 0;
		bus = new Bus(1920, 530, 65, 30, batch);
		busStop = new BusStop(300, 585, 40, 18, batch);
		lorena = new Person(450, 660, 7, 14, batch, 0);
		random1 = new Person(1300, 650, 12, 24, batch, 1);
		random2 = new Person(1500, 660, 12, 24, batch, 2);
		city = new City(0, 0, 120, 60, batch);
		road = new Road(0, 870, 120, 20, batch);
		roadMark = new RoadMark(1620, 350, 10, 3, batch);
		currentPoints = 0;
		requiredPoints = 10;
		setPoints(currentPoints);
		stop = new Stop(0, stopPositions[1], 16, 16, batch);
		stopSpeed = 7;
		manageSpeed();
	}

	@Override
	protected void draw() {
		Utils.showText(batch, Assets.uniFont, Color.BLACK, "U.C.M. FACULTAD DE PSICOLOGIA\n    EDIFICIO JOSE LUIS PINILLOS", 650, 165);
		if(scene == 0) {
			city.draw();
		}
		if(scene < 2) {
			road.draw();
		}
		if(scene == 1) {
			roadMark.draw();
			stop.draw();
			Utils.showText(batch, Assets.uniFont, Color.WHITE, pointsText, 1810, 20);
		}
		if(scene == 0) {
			busStop.draw();
		}
		if(scene != 1) {
			lorena.draw();
		}
		if(scene < 2) {
			bus.draw();
		}
		if(scene > 1) {
			random1.draw();
			random2.draw();
		}
		if(scene == 1 && Gdx.input.isTouched()) {
			Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
			bus.setPosition(bus.getPosition()[0], (int) (touch.y - bus.getBounds().height/2));
		}
		if(scene == 3) {
			Utils.showText(batch, font, Color.WHITE, "¡Has conseguido llegar a la universidad!\n        (Toca para ir al menú)", 183, 403);
			Utils.showText(batch, font, Color.BLACK, "¡Has conseguido llegar a la universidad!\n        (Toca para ir al menú)", 180, 400);
		}
		if(scene == 3 && Gdx.input.justTouched()) {
			changeScene(1);
		}
	}
	
	private void manageSpeed() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				scene0();
				scene1();
				scene2();	
			}
		}).start();
	}
	
	private void scene0() {
		int position = bus.getPosition()[0];
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while(position > 280) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			bus.move(10, -1, 0);
			position = bus.getPosition()[0];
		}
		lorena.setPosition(-1000, 0);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while(position > -2800) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			bus.move(10, -1, 0);
			position = bus.getPosition()[0];
		}
		scene = 1;
	}
	
	private void scene1() {
		bus = new Bus(1500, 480, 25, 10, batch);
		road = new Road(0, -57, 120, 75, batch);
		while(scene == 1) {
			if(stop.getBounds().overlaps(bus.getBounds())) {
				currentPoints = 0;
				stopSpeed = 7;
				setPoints(currentPoints);
				initStop();
			}
			if(currentPoints == requiredPoints) {
				scene = 2;
			}
			if(roadMark.getPosition()[0] > 1920) {
				roadMark.setPosition(1620, roadMark.getPosition()[1]);
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(stop.getPosition()[0] > 1800) {
				currentPoints++;
				setPoints(currentPoints);
				initStop();
			}
			stop.move(stopSpeed, 1, 0);
			roadMark.move(9, 1, 0);
		}
		scene = 2;
	}
	
	private void scene2() {
		lorena = new Person(-200, 640, 12, 22, batch, 0);
		int positionL = lorena.getPosition()[0];
		while(positionL < 500) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lorena.move(3, 1, 0);
			positionL = lorena.getPosition()[0];
		}
		while(positionL < 800) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lorena.move(3, 1, 0);
			lorena.move(4, 0, -1);
			positionL = lorena.getPosition()[0];
		}
		scene = 3;
	}
	
	private void initStop() {
		int pos = stop.getPosition()[1];
		int positionY = random.nextInt(3);
		int finalY = stopPositions[positionY];
		while(pos == finalY) {
			positionY = random.nextInt(3);
			finalY = stopPositions[positionY];
		}
		stop = new Stop(0, finalY, 16, 16, batch);
		if(random.nextBoolean()) {
			stopSpeed += random.nextInt(3);
		}
	}
	
	private void setPoints(int points) {
		pointsText = points + "/" + requiredPoints;
	}

}
