package com.gdx.core.actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class ObjectActor extends Actor {

    TextureRegion region;
    TextureRegion[][] regions;
    Sprite sprite;

    boolean isAnimated;
    int animationSpeed;
    int currentFrame = 0;
    float floatFrame = 0;

    // Single non-animated texture
    public ObjectActor(TextureRegion region, Vector2 center, float scale, float rotation) {
        isAnimated = false;

        this.region = new TextureRegion(region);
        this.sprite = new Sprite(this.region);
        this.sprite.setCenter(center.x, center.y);
        this.sprite.scale(scale);
        this.sprite.setRotation(rotation);
    }

    // Sprite sheet animated texture
    public ObjectActor(Texture texture, int col, int row, Vector2 center, float scale, float rotation, int animationSpeed) {
        isAnimated = true;

        this.region = new TextureRegion(texture);
        this.regions = this.region.split(col, row);
        this.sprite = new Sprite(regions[0][0]);
        this.sprite.setCenter(center.x, center.y);
        this.sprite.scale(scale);
        this.sprite.setRotation(rotation);

        this.animationSpeed = animationSpeed;
    }

    // FPS dependant
    private void animate() {
        floatFrame +=  animationSpeed / 60f;
        currentFrame = (int) floatFrame;
        this.sprite.setRegion(regions[0][currentFrame]);
    }

    // FPS independent
    private void animate(float delta) {
        floatFrame +=  (animationSpeed / 60f) / (1/60f) * delta;
        currentFrame = (int) floatFrame;
        this.sprite.setRegion(regions[0][currentFrame]);
    }

    public void setAlpha(float alpha) {
        this.sprite.setAlpha(alpha);
    }

    public void update(Vector2 center, float rotation) {
        this.sprite.setCenter(center.x, center.y);
        this.sprite.setRotation(rotation);

        if(isAnimated) {animate();}
    }

    public void update(Vector2 center, float rotation, float delta) {
        this.sprite.setCenter(center.x, center.y);
        this.sprite.setRotation(rotation);

        if(isAnimated) {animate(delta);}
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }
}
