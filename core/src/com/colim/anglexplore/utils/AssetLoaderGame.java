package com.colim.anglexplore.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerelynco on 12/21/15.
 */
public class AssetLoaderGame {
    public static Texture texturesGame;
    public static TextureRegion vertex, arm;
    public static List<TextureRegion> letters = new ArrayList<TextureRegion>();

    public static void load() {
        texturesGame = new Texture(Gdx.files.internal("AssetsGame.png"));
        texturesGame.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        vertex = new TextureRegion(texturesGame, 0, 82, 28, 28);
        arm = new TextureRegion(texturesGame, 66, 104, 127, 5);
        for(int i=0; i<6; i++){
            letters.add(new TextureRegion(texturesGame, i * 25, 0, 25, 25));
        }
        System.out.println(letters.size());
    }

    public static void dispose(){

    }

}
