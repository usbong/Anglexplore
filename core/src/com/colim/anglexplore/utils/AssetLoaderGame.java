package com.colim.anglexplore.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

/**
 * Created by jerelynco on 12/21/15.
 */
public class AssetLoaderGame {
    public static Texture texturesGame;
    public static TextureRegion vertex, arm;
    public static ArrayList<TextureRegion> letters;

    public static void load() {
        texturesGame = new Texture(Gdx.files.internal("AssetsGame.png"));
        texturesGame.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        

    }

    public static void dispose(){

    }

}
