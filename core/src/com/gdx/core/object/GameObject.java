package com.gdx.core.object;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gdx.core.actor.ObjectActor;
import com.gdx.core.data.Settings;

public abstract class GameObject{

    protected Camera camera;
    protected Settings sets;
    protected Float delta;

    protected Vector2 direction, target;
    protected Vector2 center;

    protected TextureRegion region;
    protected Rectangle rect, hBox;

    protected boolean toRemove;

    public GameObject(float x, float y, float width, float height, Vector2 initialDirection,
                      Camera camera, Settings sets) {
        // yeah
        this.camera = camera;
        this.sets = sets;

        // init vectors
        this.center = new Vector2(x,y);
        this.direction = new Vector2(initialDirection);
        this.target = new Vector2();

        // init hitBox rectangle
        this.hBox = new Rectangle();
        this.hBox.setCenter(center);
        this.hBox.setSize(width, height);
    }

    public abstract void setActor();

    public abstract Actor getActor();

    public abstract void update(float delta); // logic updates
}
