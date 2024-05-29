package com.gdx.core.utility;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureManager extends AssetManager {

    public TextureManager() {

        super.load("badlogic.jpg", Texture.class);

        loadBackGround();
        loadGameParticles();
        loadGameEntities();
        loadGameProjectiles();
        loadUI();
    }

    private void loadBackGround() {

    }

    private void loadGameParticles() {

    }

    private void loadGameEntities() {
        // Player ship
        super.load("", Texture.class);
        super.load("", Texture.class);
    }

    private void loadGameProjectiles() {

    }

    private void loadUI() {

    }

}
