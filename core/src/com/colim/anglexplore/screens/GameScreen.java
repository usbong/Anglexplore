package com.colim.anglexplore.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.colim.anglexplore.stages.GameStage;
import com.colim.anglexplore.utils.Constants;

/**
 * Created by hadri on 12/13/2015.
 */
public class GameScreen extends ScreenAdapter {

    private Stage stage;
    private Viewport viewport;
    private Camera camera;
    private SpriteBatch batch;

    private Texture generateTexture;
    private Texture quitTexture;
    private Texture answerTexture;

    public GameScreen(){
        stage = new GameStage();
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.position.set(Constants.WORLD_WIDTH / 2, Constants.WORLD_HEIGHT / 2, 0);
        camera.update();
        viewport = new FitViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, camera);
        batch = new SpriteBatch();

        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        answerTexture = new Texture("answer.png");
        Image answer = new Image(answerTexture);
        answer.setPosition(Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/3, Align.center);
        stage.addActor(answer);

        generateTexture = new Texture("generate.png");
        Image generate = new Image(generateTexture);
        generate.setPosition(Constants.WORLD_WIDTH /3 + 20, Constants.WORLD_HEIGHT / 10,
                Align.center);
        stage.addActor(generate);

        quitTexture = new Texture("quit.png");
        Image quit = new Image(quitTexture);
        quit.setPosition(5*Constants.WORLD_WIDTH /6 + 20, Constants.WORLD_HEIGHT / 10,
                Align.center);
        stage.addActor(quit);
    }

    @Override
    public void render(float delta) {
        clearScreen();
        batch.setProjectionMatrix(camera.projection);
        batch.setTransformMatrix(camera.view);
        batch.begin();
        batch.end();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
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
        generateTexture.dispose();
        quitTexture.dispose();
        stage.dispose();
        batch.dispose();
    }

    private void clearScreen(){
        Gdx.gl.glClearColor(70/255f, 157/255f,
                214/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
