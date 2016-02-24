package com.colim.anglexplore.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.colim.anglexplore.stages.GameStage;
import com.colim.anglexplore.utils.AssetLoaderGame;
import com.colim.anglexplore.utils.AssetLoaderUI;

/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

public class GameScreen extends ScreenAdapter {

    private GameStage stage;

    public GameScreen() {
        stage = new GameStage();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        clearScreen();
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
        AssetLoaderGame.dispose();
        AssetLoaderUI.dispose();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(255f, 255f,
                255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
