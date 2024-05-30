package com.gdx.core.object.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gdx.core.actor.ObjectActor;
import com.gdx.core.data.Settings;
import com.gdx.core.utility.TextureManager;

import java.util.Arrays;

public class Player extends Entity {

    // object states
    boolean isAlive = true;

    // Texture Regions
    TextureRegion[] regions;

    // Actor(s)
    ObjectActor baseActor;

    public Player(float x, float y, float width, float height,
                  Vector2 initialDirection, Camera camera, Settings sets, TextureManager manager) {

        super(x, y, width, height, initialDirection, camera, sets, manager);
        // import settings
        acceleration = 200f;
        maxSpeed = 200f;

        velocity = new Vector2(0,0);
        velocity.clamp(0, maxSpeed);

        // load textures as texture region
        regions = new TextureRegion[] {
                new TextureRegion(manager.get("textures/object/entity/player/player-ship-1.png", Texture.class)),
                new TextureRegion(manager.get("textures/object/entity/player/player-ship-2.png", Texture.class)),
                new TextureRegion(manager.get("textures/object/entity/player/player-ship-3.png", Texture.class)),
                new TextureRegion(manager.get("textures/object/entity/player/player-ship-4.png", Texture.class)),
        };

        setActor();
    }

    @Override
    public void setActor() {
        baseActor = new ObjectActor(regions[0], center, .25f, 0);
    }

    @Override
    public Actor getActor() {
        return baseActor;
    }

    private void setDirection() {
        float mX, mY;
        mX = Gdx.input.getX(); mY = sets.SCREENHEIGHT - Gdx.input.getY(); // input y starts from top
        target.set(mX - center.x, mY - center.y);
        target.nor();
    }

    @Override
    protected void move() {
        boolean forward = false;

        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            forward = true;
            System.out.println("W");
        }

        if(forward) {
            velocity.add(target.x * acceleration * delta, target.y * acceleration * delta);
            velocity.clamp(0, maxSpeed);
        } else {
            velocity.x *= 0.98f;
            velocity.y *= 0.98f;
        }

        center.add(velocity.x * delta, velocity.y * delta);

    }

    @Override
    protected void rotate() {
        rotation = target.angleDeg() - 90;
    }

    @Override
    public void update(float delta) {
        this.delta = delta;

        if(isAlive) {
            setDirection();
            rotate();
            move();

            baseActor.update(center, rotation);
        }
    }
}
