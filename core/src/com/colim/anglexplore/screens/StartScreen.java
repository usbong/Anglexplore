package com.colim.anglexplore.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.colim.anglexplore.utils.AssetLoaderStart;
import com.colim.anglexplore.utils.Constants;

/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

public class StartScreen extends ScreenAdapter {

    private Stage stage;
    private TextureRegion startScreenTexture, tutorialTexture;


    private Game game;

    public StartScreen(Game game) {
        this.game = game;
    }

    public void show() {
        AssetLoaderStart.load();

        stage = new Stage(new StretchViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT));
        Gdx.input.setInputProcessor(stage);

        startScreenTexture = AssetLoaderStart.screen_start;

        Image startScreen = new Image(startScreenTexture);

        stage.addActor(startScreen);

        stage.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count,
                            int button) {
                super.tap(event, x, y, count, button);
                if (tutorialTexture == null) {
                    tutorialTexture = AssetLoaderStart.screen_instructions;

                    Image tutorial = new Image(tutorialTexture);
                    stage.addActor(tutorial);

                } else {
                    game.setScreen(new com.colim.anglexplore.screens.GameScreen());
                    dispose();
                }
            }
        });

    }

    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    public void render(float delta) {
        clearScreen();
        stage.act(delta);
        stage.draw();
    }

    public void dispose() {
        stage.dispose();
        AssetLoaderStart.dispose();
    }


    private void clearScreen() {
        Gdx.gl.glClearColor(255f, 255f,
                255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
