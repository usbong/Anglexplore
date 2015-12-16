/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

package com.colim.anglexplore.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.colim.anglexplore.utils.Constants;

/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */


public class GameUI extends Group{

    private Texture generateTexture;
    private Texture quitTexture;
    private Texture answerTexture;
    private Image answer;
    private Image generate;
    private Image quit;

    public GameUI() {
        super();
        answerTexture = new Texture(Gdx.files.internal("answer.png"));
        generateTexture = new Texture(Gdx.files.internal("generate.png"));
        quitTexture = new Texture(Gdx.files.internal("quit.png"));

        answer = new Image(answerTexture);
        generate = new Image(generateTexture);
        quit = new Image(quitTexture);

        quit.setPosition(4*Constants.WORLD_WIDTH /5, Constants.WORLD_HEIGHT / 12, Align.center);
        generate.setPosition(Constants.WORLD_WIDTH /3, Constants.WORLD_HEIGHT / 12, Align.center);
        answer.setPosition(Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/4, Align.center);

        addActor(generate);
        addActor(answer);
        addActor(quit);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
