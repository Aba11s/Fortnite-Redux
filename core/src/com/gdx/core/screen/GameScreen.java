package com.gdx.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gdx.core.Core;
import com.gdx.core.data.Settings;
import com.gdx.core.object.entity.Player;
import com.gdx.core.screen.stage.GameStage;
import com.gdx.core.screen.stage.MenuStage;
import com.gdx.core.utility.TextureManager;

import javax.sound.midi.SysexMessage;

public class GameScreen extends ScreenAdapter {

    boolean PAUSED = false;

    Float delta;
    Float delta2;
    Integer SCREENWIDTH, SCREENHEIGHT;
    Core core;
    Settings sets;

    TextureManager TEXTURES;

    OrthographicCamera camera;
    OrthographicCamera debugCamera;
    Viewport viewport;

    GameStage backStage;
    GameStage objStage;
    GameStage HUDStage;
    GameStage PauseStage;

    // Game Objects
    Player player;

    public GameScreen(Core core) {
        this.core = core;
        this.sets = core.sets;
        this.TEXTURES = core.TEXTURES;

        this.SCREENWIDTH = Gdx.graphics.getWidth();
        this.SCREENHEIGHT = Gdx.graphics.getHeight();

        this.camera = core.camera;
        this.debugCamera = core.debugCamera;

        this.viewport = core.viewport;

        this.backStage = new GameStage(viewport);
        this.objStage = new GameStage(viewport);
        this.HUDStage = new GameStage(viewport);
        Gdx.input.setInputProcessor(HUDStage);

        // Game objects


        // player

        player = new Player(SCREENWIDTH/2f, SCREENHEIGHT/2f, 20,20,
                new Vector2(0,1), camera, sets, TEXTURES);
        objStage.addActor(player.getActor());
    }

    // Logic updates
    public void update(float delta) {
        this.delta = delta; // if paused = delta time  = 0;

        player.update(delta);
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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
