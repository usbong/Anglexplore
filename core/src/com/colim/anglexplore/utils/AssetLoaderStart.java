package com.colim.anglexplore.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by jerelynco on 12/21/15.
 */
public class AssetLoaderStart {
    public static Texture texturesStart;
    public static TextureRegion screen_start, screen_instructions;


    public static void load() {
        texturesStart = new Texture(Gdx.files.internal("AssetsStart.png"));
        texturesStart.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        screen_start = new TextureRegion(texturesStart, 0, 0, 1280, 720);
        screen_instructions = new TextureRegion(texturesStart, 0, 720, 1280, 720);
    }

    public static void dispose() {
        texturesStart.dispose();
    }
}
