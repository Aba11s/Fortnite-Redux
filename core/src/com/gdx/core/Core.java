package com.gdx.core;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gdx.core.screen.MenuScreen;

public class Core extends Game {

	float SCREENWIDTH, SCREENHEIGHT;
	float delta;

	public Viewport viewport;
	public OrthographicCamera camera;
	public OrthographicCamera debugCamera;

	Screen MenuScreen, GameScreen, EndScreen;

	public Core() {

	}

	@Override
	public void create() {
		SCREENWIDTH = Gdx.graphics.getWidth();
		SCREENHEIGHT = Gdx.graphics.getHeight();

		viewport = new FitViewport(SCREENWIDTH, SCREENHEIGHT);

		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCREENWIDTH/2, SCREENHEIGHT/2);

		debugCamera = new OrthographicCamera();
		debugCamera.setToOrtho(false, SCREENWIDTH/2, SCREENHEIGHT/2);

		setScreen(new MenuScreen(this) );
	}

	@Override
	public void render() {
		super.render();
		delta = Gdx.graphics.getDeltaTime();

		SCREENWIDTH = Gdx.graphics.getWidth();
		SCREENHEIGHT = Gdx.graphics.getHeight();
	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
