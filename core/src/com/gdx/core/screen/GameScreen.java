package com.gdx.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gdx.core.Core;
import com.gdx.core.screen.stage.GameStage;
import com.gdx.core.screen.stage.MenuStage;

public class GameScreen extends ScreenAdapter {

    Float delta;
    Integer SCREENWIDTH, SCREENHEIGHT;
    Core core;

    OrthographicCamera camera;
    OrthographicCamera debugCamera;

    Viewport viewport;
    GameStage stage;

    public GameScreen(Core core) {
        this.core = core;

        this.SCREENWIDTH = Gdx.graphics.getWidth();
        this.SCREENHEIGHT = Gdx.graphics.getHeight();

        this.camera = core.camera;
        this.debugCamera = core.debugCamera;

        this.viewport = core.viewport;
        this.stage = new GameStage(viewport);
        Gdx.input.setInputProcessor(stage);
    }

}
