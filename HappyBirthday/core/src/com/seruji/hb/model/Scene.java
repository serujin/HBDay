package com.seruji.hb.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.seruji.hb.main.HappyBirthdayMain;
import com.seruji.hb.objects.various.Back;
import com.seruji.hb.utils.Assets;

public abstract class Scene implements Screen {
	
	protected HappyBirthdayMain game;
	protected OrthographicCamera camera;
	protected SpriteBatch batch;
	protected Sprite background;
	protected BitmapFont font;
	protected Back back;
	
	public Scene(HappyBirthdayMain game, Sprite background) {
		this.game = game;
		this.background = background;
		font = Assets.font;
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1920, 1080);
		batch = new SpriteBatch();
		back = new Back(10, 10, 10, 10, batch);
	}
	
	protected abstract void draw();
	
	protected void changeScene(int scene) {
		game.changeScene(scene);
	}

	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
			batch.draw(background, 0, 0, 1920, 1080);
			draw();
			back.draw();
		batch.end();
		goToMenu();
	}
	
	private void goToMenu() {
		if(Gdx.input.justTouched()) {
			Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
			if(touch.x > back.bounds.x && touch.x < back.bounds.x + back.bounds.width
					&& touch.y > back.bounds.y && touch.y < back.bounds.y + back.bounds.height) {
				game.changeScene(1);
			}
		}
	}

	@Override
	public void resize(int width, int height) {
		

	}

	@Override
	public void pause() {
		

	}

	@Override
	public void resume() {
		

	}

	@Override
	public void hide() {
		

	}

	@Override
	public void dispose() {
		

	}
}
