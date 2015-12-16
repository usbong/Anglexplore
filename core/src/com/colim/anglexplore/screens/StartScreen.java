package com.colim.anglexplore.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.colim.anglexplore.utils.Constants;

/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

public class StartScreen extends ScreenAdapter {

    private Stage stage;
    private Texture anglesTexture;
    private Texture titleTexture;
    private Texture playTexture;
    private Texture playPressTexture;


    private ImageButton play;
    private Game game;

    public StartScreen(Game game){
        this.game = game;
    }

    public void show(){
        stage = new Stage(new StretchViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT));
        Gdx.input.setInputProcessor(stage);

        titleTexture = new Texture(Gdx.files.internal("title.png"));
        Image title = new Image(titleTexture);
        title.setPosition(Constants.WORLD_WIDTH /2, 7 * Constants.WORLD_HEIGHT / 8,
                Align.center);
        stage.addActor(title);

        anglesTexture = new Texture(Gdx.files.internal("angles.png"));
        Image angles = new Image(anglesTexture);
        angles.setPosition(Constants.WORLD_WIDTH / 2, Constants.WORLD_HEIGHT / 3, Align.center);
        stage.addActor(angles);

        playTexture = new Texture(Gdx.files.internal("tap_unpressed.png"));

        playPressTexture = new
                Texture(Gdx.files.internal("tap_pressed.png"));

        play = new ImageButton(new TextureRegionDrawable(new
                TextureRegion(playTexture)), new TextureRegionDrawable(new
                TextureRegion(playPressTexture)));
        play.setPosition(Constants.WORLD_WIDTH / 2, Constants.WORLD_HEIGHT / 4, Align.center);

        stage.addActor(play);

        play.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count,
                            int button) {
                super.tap(event, x, y, count, button);
                game.setScreen(new com.colim.anglexplore.screens.GameScreen());
                dispose();
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

    public void dispose(){
        stage.dispose();
        playTexture.dispose();
        playPressTexture.dispose();
        titleTexture.dispose();
    }


    private void clearScreen(){
        Gdx.gl.glClearColor(70/255f, 157/255f,
                214/255f, 1); //Skyblue
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
