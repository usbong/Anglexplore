package com.colim.anglexplore.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.colim.anglexplore.actors.GameAngle;
import com.colim.anglexplore.actors.GameUI;
import com.colim.anglexplore.utils.AssetLoaderGame;
import com.colim.anglexplore.utils.Constants;

import java.util.ArrayList;
import java.util.List;


/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

public class GameStage extends Stage {

    private OrthographicCamera camera;
    private GameUI gameUI;
    private TextureRegion pointTexture;
    private TextureRegion armTexture;
    private List<TextureRegion> lettersTexture;
    private List<GameAngle> angles;

    public GameStage(){

        super(new StretchViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT,
                new OrthographicCamera(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT)));

        setupCamera();

        AssetLoaderGame.load();
        pointTexture = AssetLoaderGame.vertex;
        armTexture = AssetLoaderGame.arm;
        lettersTexture = AssetLoaderGame.letters;

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

    public void generateGameAngles(List<GameAngle> angles){
        float angle_x = ((float) Math.random()) * 90f;
        float angle_y = ((float) Math.random()) * 180f;

        angles.add(new GameAngle(pointTexture, armTexture, lettersTexture.get(0), new Vector2(Constants.WORLD_WIDTH /4 , 3* Constants.WORLD_HEIGHT /4 ), angle_x));
        angles.add(new GameAngle(pointTexture, armTexture, lettersTexture.get(1), new Vector2(2 * Constants.WORLD_WIDTH /4 , 3* Constants.WORLD_HEIGHT /4 ), 90 - angle_x));
        angles.add(new GameAngle(pointTexture, armTexture, lettersTexture.get(2), new Vector2(3 * Constants.WORLD_WIDTH /4 , 3* Constants.WORLD_HEIGHT /4 ), angle_y));
        angles.add(new GameAngle(pointTexture, armTexture, lettersTexture.get(3), new Vector2(Constants.WORLD_WIDTH /4 , 2* Constants.WORLD_HEIGHT /4 ), 180-angle_y));
        angles.add(new GameAngle(pointTexture, armTexture, lettersTexture.get(4), new Vector2(2 * Constants.WORLD_WIDTH /4 , 2* Constants.WORLD_HEIGHT /4 ),((float) Math.random()) * 180f));
        angles.add(new GameAngle(pointTexture, armTexture, lettersTexture.get(5), new Vector2(3 * Constants.WORLD_WIDTH /4 , 2* Constants.WORLD_HEIGHT /4 ), ((float) Math.random()) * 180f));

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

    // Checks if two angles have a considerable angle difference to be considered collision
    public boolean validAngleDiff(float val1, float val2) {
        if( Math.abs(val2 - val1) < 5 ) {
            return true;
        }
        return false;
    }

    // Checks if two points/vertices have considerable distance to be considered collision
    public boolean validPointDistance(Vector2 pos1, Vector2 pos2) {
        if(pos1.dst(pos2) < 5) {
            return true;
        }
        return false;
    }

    public void checkCollision(List <GameAngle> angles){
        for(int angleCurrentIndex = 0; angleCurrentIndex < angles.size(); angleCurrentIndex++) {
            for(int angleAgainstIndex = angleCurrentIndex+1; angleAgainstIndex < angles.size(); angleAgainstIndex++) {

                GameAngle currentAngle = angles.get(angleCurrentIndex);
                GameAngle againstAngle = angles.get(angleAgainstIndex);

                if( validPointDistance(currentAngle.getPointPosition(), againstAngle.getPointPosition()) &&
                        (validAngleDiff(currentAngle.getInitialAngle(), againstAngle.getTerminalAngle()) ||
                                validAngleDiff(currentAngle.getTerminalAngle(), againstAngle.getInitialAngle()))) {
                    Gdx.app.log("Collision", "POINT AND ANGLE COLLISION!");
                }
            }
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        this.checkCollision(angles);
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoaderGame.dispose();
    }
}
