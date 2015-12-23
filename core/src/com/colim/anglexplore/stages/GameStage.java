package com.colim.anglexplore.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.resolvers.ResolutionFileResolver;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.colim.anglexplore.actors.GameAngle;
import com.colim.anglexplore.actors.GameUI;
import com.colim.anglexplore.utils.Constants;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.List;


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
    private Texture armTexture;
    private List<GameAngle> angles;

    public GameStage(){

        super(new StretchViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT,
                new OrthographicCamera(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT)));

        setupCamera();

        pointTexture = new Texture(Gdx.files.internal("vertex.png"));
        armTexture = new Texture(Gdx.files.internal("arm.png"));

        gameUI = new GameUI();
        addActor(gameUI);

        angles = new ArrayList<GameAngle>();

        generateGameAngles(angles);

        gameUI.generate.addListener(new ClickListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                updateGameAngles(angles);
                return true;
            }
        });

        gameUI.quit.addListener(new ClickListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                Gdx.app.exit();
                return true;
            }
        });

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
        armTexture.dispose();
    }

    public void generateGameAngles(List<GameAngle> angles){

        float angle_x = ((float) Math.random()) * 90f;
        float angle_y = ((float) Math.random()) * 180f;

        angles.add(new GameAngle(pointTexture, armTexture, new Vector2(Constants.WORLD_WIDTH /4 , 3* Constants.WORLD_HEIGHT /4 ), angle_x));
        angles.add(new GameAngle(pointTexture, armTexture, new Vector2(2 * Constants.WORLD_WIDTH /4 , 3* Constants.WORLD_HEIGHT /4 ), 90 - angle_x));
        angles.add(new GameAngle(pointTexture, armTexture, new Vector2(3 * Constants.WORLD_WIDTH /4 , 3* Constants.WORLD_HEIGHT /4 ), angle_y));
        angles.add(new GameAngle(pointTexture, armTexture, new Vector2(Constants.WORLD_WIDTH /4 , 2* Constants.WORLD_HEIGHT /4 ), 180-angle_y));
        angles.add(new GameAngle(pointTexture, armTexture, new Vector2(2 * Constants.WORLD_WIDTH /4 , 2* Constants.WORLD_HEIGHT /4 ),((float) Math.random()) * 180f));
        angles.add(new GameAngle(pointTexture, armTexture, new Vector2(3 * Constants.WORLD_WIDTH /4 , 2* Constants.WORLD_HEIGHT /4 ), ((float) Math.random()) * 180f));


        for (GameAngle angle : angles) {
            addActor(angle);
        }
    }

    // Really dirty hack.
    public void updateGameAngles(List<GameAngle> angles){
        float angle_x = ((float) Math.random()) * 90f;
        float angle_y = ((float) Math.random()) * 180f;

        for (GameAngle angle : angles){
            angle.resetPosition();
        }
        angles.get(0).newRotation(angle_x);
        angles.get(1).newRotation(90 - angle_x);
        angles.get(2).newRotation(angle_y);
        angles.get(3).newRotation(180 - angle_y);
        angles.get(4).newRotation(((float) Math.random()) * 180f);
        angles.get(5).newRotation(((float) Math.random()) * 180f);

    }



}
