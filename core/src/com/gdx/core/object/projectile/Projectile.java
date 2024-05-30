package com.gdx.core.object.projectile;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gdx.core.data.Settings;
import com.gdx.core.object.GameObject;

public abstract class Projectile extends GameObject {
    public Projectile(float x, float y, float width, float height,
                      Vector2 initialDirection, Camera camera, Settings sets) {

        super(x, y, width, height, initialDirection, camera, sets);
    }
}
