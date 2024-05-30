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

        finishLoading();
    }

    private void loadBackGround() {

    }

    private void loadGameParticles() {

    }

    private void loadGameEntities() {
        // player
        super.load("textures/object/entity/player/player-ship-1.png", Texture.class);
        super.load("textures/object/entity/player/player-ship-2.png", Texture.class);
        super.load("textures/object/entity/player/player-ship-3.png", Texture.class);
        super.load("textures/object/entity/player/player-ship-4.png", Texture.class);

        // enemy
        super.load("textures/object/entity/enemy/enemy-scout.png", Texture.class);
        super.load("textures/object/entity/enemy/enemy-fighter.png", Texture.class);
        super.load("textures/object/entity/enemy/enemy-bomber.png", Texture.class);
        super.load("textures/object/entity/enemy/enemy-torpedo.png", Texture.class);
        super.load("textures/object/entity/enemy/enemy-frigate.png", Texture.class);
        super.load("textures/object/entity/enemy/enemy-battlecruiser.png", Texture.class);
    }

    private void loadGameProjectiles() {

    }

    private void loadUI() {

    }

}
