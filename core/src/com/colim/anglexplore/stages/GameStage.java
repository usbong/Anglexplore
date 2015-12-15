package com.colim.anglexplore.stages;

import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ResolutionFileResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ResolutionFileResolver.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
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
    private GameAngle gameAngle;
    private Point point;
    private Point point2;


    public GameStage(){
        fileResolver = new ResolutionFileResolver(new InternalFileHandleResolver(), new Resolution(800, 480, "480"),
                new Resolution(1280, 720, "720"), new Resolution(1920, 1080, "1080"));
        // use fileResolver for loading textures
        setupCamera();
        gameAngle = new GameAngle();
        point = new Point();
        point2 = new Point(new Vector2(0, 0), Color.RED);


        addActor(gameAngle);
        addActor(point);
        addActor(point2);
    }

    private void setupCamera() {
        camera = new OrthographicCamera(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }

    @Override
    public void draw(){
        super.draw();
    }
}
