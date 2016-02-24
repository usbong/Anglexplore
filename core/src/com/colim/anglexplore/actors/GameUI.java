/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

package com.colim.anglexplore.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.colim.anglexplore.utils.AssetLoaderUI;
import com.colim.anglexplore.utils.Constants;

/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */


public class GameUI extends Group {

    public Image bg, textBox, generate, quit;
    private TextureRegion bgTexture, generateTexture, quitTexture, textBoxTexture;

    public GameUI() {
        super();

        AssetLoaderUI.load();
        bgTexture = AssetLoaderUI.bg;
        textBoxTexture = AssetLoaderUI.text_box;
        generateTexture = AssetLoaderUI.button_generate;
        quitTexture = AssetLoaderUI.button_quit;

        bg = new Image(bgTexture);
        textBox = new Image(textBoxTexture);
        generate = new Image(generateTexture);
        quit = new Image(quitTexture);

        generate.setPosition(Constants.WORLD_WIDTH / 4, Constants.WORLD_HEIGHT / 10, Align.center);
        quit.setPosition(5 * Constants.WORLD_WIDTH / 6, Constants.WORLD_HEIGHT / 10, Align.center);
        textBox.setPosition(Constants.WORLD_WIDTH / 2, 1 * Constants.WORLD_HEIGHT / 4, Align.center);

        addActor(bg);
        addActor(generate);
        addActor(textBox);
        addActor(quit);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
