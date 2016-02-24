package com.colim.anglexplore.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by jerelynco on 12/21/15.
 */
public class AssetLoaderUI {
    public static Texture texturesUI;
    public static TextureRegion bg, text_box, button_generate, button_quit;

    public static void load() {
        texturesUI = new Texture(Gdx.files.internal("AssetsUI.png"));
        texturesUI.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        bg = new TextureRegion(texturesUI, 0, 0, 1280, 720);
        text_box = new TextureRegion(texturesUI, 2, 725, 1040, 124);
        button_generate = new TextureRegion(texturesUI, 0, 853, 337, 56);
        button_quit = new TextureRegion(texturesUI, 340, 853, 100, 56);
    }

    public static void dispose() {
        texturesUI.dispose();
    }
}
