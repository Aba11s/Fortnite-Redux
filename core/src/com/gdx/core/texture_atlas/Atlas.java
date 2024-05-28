package com.gdx.core.texture_atlas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Atlas extends TextureAtlas {

    // --
    AtlasRegion badlogic;

    public Atlas(String path) {
        super(Gdx.files.internal(path));

        badlogic = findRegion("badlogic");
    }
}
