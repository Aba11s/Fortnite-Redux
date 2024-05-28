package com.gdx.core.object;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gdx.core.data.Settings;
import com.gdx.core.object.GameObject;

public abstract class GameEntity extends Actor implements GameObject {

    protected Camera camera;
    protected Settings sets;
    protected Float delta;

    protected float velX, velY;
    protected Vector2 direction, target;
    protected Vector2 position, center;
    protected float angle;
    protected float speed;

    protected Texture texture;
    protected TextureRegion region;
    protected Rectangle rect, hBox;

    public GameEntity(float x, float y, float width, float height, Vector2 initialDirection,
                      Camera camera, Settings sets, Float delta) throws Exception {

        // yeah
        this.camera = camera;
        this.sets = sets;
        this.delta = delta;

        // init vectors
        this.position = new Vector2();
        this.center = new Vector2(x,y);
        this.direction = new Vector2(initialDirection);

        // init hitBox rectangle
        this.hBox = new Rectangle();
        this.hBox.setCenter(center);
        this.hBox.setSize(width, height);
    }

    protected abstract void loadSetting(); // loads variables from setting

    protected abstract void loadTexture(); // loads textures

    protected abstract void loadSFX(); // loads sfx

    protected abstract void move(); // update position

    protected abstract void rotate(); // update rotation

    @Override
    public void update() {
        rotate();
        move();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

    }
}
