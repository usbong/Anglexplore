package com.colim.anglexplore.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ResolutionFileResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ResolutionFileResolver.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.colim.anglexplore.actors.GameAngle;
import com.colim.anglexplore.actors.Point;
import com.colim.anglexplore.utils.Constants;

import java.util.ArrayList;

/**
 * Created by hadri on 12/13/2015.
 */
public class GameStage extends Stage {

    private ResolutionFileResolver fileResolver;
    private OrthographicCamera camera;


    private Texture generateTexture;
    private Texture quitTexture;
    private Texture answerTexture;


    public GameStage(){
        fileResolver = new ResolutionFileResolver(new InternalFileHandleResolver(), new Resolution(800, 480, "480"),
                new Resolution(1280, 720, "720"), new Resolution(1920, 1080, "1080"));
        // use fileResolver for loading textures
        setupCamera();
        setViewport(new FitViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT));

        answerTexture = new Texture(Gdx.files.internal("answer.png"));
        Image answer = new Image(answerTexture);
        answer.setPosition(Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/3, Align.center);

        generateTexture = new Texture(Gdx.files.internal("generate.png"));
        Image generate = new Image(generateTexture);
        generate.setPosition(Constants.WORLD_WIDTH /3 + 20, Constants.WORLD_HEIGHT / 10,
                Align.center);

        quitTexture = new Texture(Gdx.files.internal("quit.png"));
        Image quit = new Image(quitTexture);
        quit.setPosition(5*Constants.WORLD_WIDTH /6 + 20, Constants.WORLD_HEIGHT / 10,
                Align.center);


        addActor(generate);
        addActor(answer);
        addActor(quit);
    }

    private void setupCamera() {
        camera = new OrthographicCamera(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }


    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        generateTexture.dispose();
        quitTexture.dispose();
        answerTexture.dispose();
    }


}
