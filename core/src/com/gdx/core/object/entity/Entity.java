package com.gdx.core.object.entity;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gdx.core.data.Settings;
import com.gdx.core.object.GameObject;

public abstract class Entity extends GameObject {

    protected float velX, velY;
    protected float rotation;
    protected float speed;

    protected float health;
    protected float contactDamage;
    protected boolean isActive;

    public Entity(float x, float y, float width, float height, Vector2 initialDirection,
                  Camera camera, Settings sets, Float delta) {

        super(x, y, width, height, initialDirection, camera, sets, delta);

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
    public void update() {
        rotate();
        move();
    }
}
