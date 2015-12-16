package com.colim.anglexplore.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.resolvers.ResolutionFileResolver;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.colim.anglexplore.actors.GameUI;
import com.colim.anglexplore.actors.Point;
import com.colim.anglexplore.utils.Constants;


/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

public class GameStage extends Stage {

    private ResolutionFileResolver fileResolver;
    private OrthographicCamera camera;
    private GameUI gameUI;
    private Texture pointTexture;
    private Point point;

    public GameStage(){

        super(new StretchViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT,
                new OrthographicCamera(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT)));

        setupCamera();


        pointTexture = new Texture(Gdx.files.internal("vertex.png"));
        point = new Point(pointTexture, new Vector2(500,500));
        gameUI = new GameUI();
        addActor(gameUI);
        addActor(point);


    }

    private void setupCamera() {
        camera = new OrthographicCamera(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }


    @Override
    public void dispose() {
        super.dispose();
        pointTexture.dispose();
    }
}
