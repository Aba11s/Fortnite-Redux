package com.gdx.core.object.entity;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gdx.core.data.Settings;
import com.gdx.core.object.GameObject;
import com.gdx.core.utility.TextureManager;

public abstract class Entity extends GameObject {

    protected Vector2 velocity;
    protected float rotation;
    protected float speed, acceleration;
    protected float maxSpeed;

    protected float health;
    protected float contactDamage;
    protected boolean isActive;

    protected TextureManager manager;

    public Entity(float x, float y, float width, float height, Vector2 initialDirection,
                  Camera camera, Settings sets, TextureManager manager) {

        super(x, y, width, height, initialDirection, camera, sets);
        this.manager = manager;
    }
    protected abstract void move(); // update position

    protected abstract void rotate(); // update rotation

    public Vector2 getCenter() {
        return center;
    }

    public Rectangle getRect() {
        return hBox;
    }


    @Override
    public void update(float delta) {
        rotate();
        move();
    }
}
