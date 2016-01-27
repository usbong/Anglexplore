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
    public static Texture texturesGame, texturesGameSelected, texturesHighlightArm, textureClockwise, textureCounterclockwise;
    public static TextureRegion vertex, arm, highlightArm, arrowClockwise, arrowCounterclockwise;
    public static List<TextureRegion> letters = new ArrayList<TextureRegion>();

    public static void load() {
        texturesGame = new Texture(Gdx.files.internal("AssetsGame.png"));
        texturesGameSelected = new Texture(Gdx.files.internal("AssetsArrows.png"));
        texturesHighlightArm = new Texture(Gdx.files.internal("AssetsUI.png"));

        texturesGame.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        vertex = new TextureRegion(texturesGame, 0, 82, 28, 28);
        //arm = new TextureRegion(texturesGame, 66, 104, 127, 5);
        // 2x higher
        arm = new TextureRegion(texturesGame, 66, 99, 150, 10);

        arrowClockwise = new TextureRegion(texturesGameSelected, 6, 11, 63, 63);
        arrowCounterclockwise = new TextureRegion(texturesGameSelected, 74, 0, 74, 81);

        for(int i=0; i<6; i++){
            letters.add(new TextureRegion(texturesGame, i * 25, 0, 25, 25));
        }

        System.out.println(letters.size());
    }

    public static void dispose(){
        texturesGame.dispose();
        texturesGameSelected.dispose();
        textureClockwise.dispose();
        textureCounterclockwise.dispose();
    }

}
