package com.gdx.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gdx.core.Core;
import com.gdx.core.screen.stage.MenuStage;

public class MenuScreen extends ScreenAdapter {

    Float delta;
    Integer SCREENWIDTH, SCREENHEIGHT;
    Core core;

    OrthographicCamera camera;
    OrthographicCamera debugCamera;

    Viewport viewport;
    MenuStage stage;

    public MenuScreen(Core core) {
        this.core = core;

        this.SCREENWIDTH = Gdx.graphics.getWidth();
        this.SCREENHEIGHT = Gdx.graphics.getHeight();

        this.camera = core.camera;
        this.debugCamera = core.debugCamera;

        this.viewport = core.viewport;
        this.stage = new MenuStage(viewport);
        Gdx.input.setInputProcessor(stage);
    }

    private void update() {
        this.SCREENWIDTH = Gdx.graphics.getWidth();
        this.SCREENHEIGHT = Gdx.graphics.getHeight();

        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            core.setScreen(new GameScreen(core));
        }
    }

    @Override
    public void render(float delta) {
        this.delta = delta;
        update();

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {

    }
}
