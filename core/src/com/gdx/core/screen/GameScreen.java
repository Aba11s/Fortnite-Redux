package com.gdx.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gdx.core.Core;
import com.gdx.core.screen.stage.GameStage;
import com.gdx.core.screen.stage.MenuStage;

import javax.sound.midi.SysexMessage;

public class GameScreen extends ScreenAdapter {

    boolean PAUSED = false;

    Float delta;
    Float delta2;
    Integer SCREENWIDTH, SCREENHEIGHT;
    Core core;

    OrthographicCamera camera;
    OrthographicCamera debugCamera;

    Viewport viewport;
    GameStage backStage;
    GameStage objStage;
    GameStage HUDStage;
    GameStage PauseStage;

    public GameScreen(Core core) {
        this.core = core;

        this.SCREENWIDTH = Gdx.graphics.getWidth();
        this.SCREENHEIGHT = Gdx.graphics.getHeight();

        this.camera = core.camera;
        this.debugCamera = core.debugCamera;

        this.viewport = core.viewport;

        this.backStage = new GameStage(viewport);
        this.objStage = new GameStage(viewport);
        this.HUDStage = new GameStage(viewport);
        Gdx.input.setInputProcessor(HUDStage);
    }

    // Logic updates
    public void update(float delta) {
        this.delta = (!PAUSED) ? delta : 0; // if paused = delta time  = 0;
    }

    @Override
    public void render(float delta) {
        update(delta);

        backStage.draw();
        objStage.draw();
        HUDStage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {
        backStage.dispose();
        objStage.dispose();
        HUDStage.dispose();
    }


}
