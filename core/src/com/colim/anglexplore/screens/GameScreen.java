package com.colim.anglexplore.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.colim.anglexplore.stages.GameStage;
import com.colim.anglexplore.utils.Constants;

/**
 * Created by hadri on 12/13/2015.
 */
public class GameScreen extends ScreenAdapter {

    private GameStage stage;

    public GameScreen(){
        stage = new GameStage();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {


    }

    @Override
    public void render(float delta) {
        clearScreen();
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
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
        stage.dispose();
    }

    private void clearScreen(){
        Gdx.gl.glClearColor(70/255f, 157/255f,
                214/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
