package com.colim.anglexplore.stages;

import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ResolutionFileResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ResolutionFileResolver.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colim.anglexplore.actors.GameAngle;
import com.colim.anglexplore.utils.Constants;

/**
 * Created by hadri on 12/13/2015.
 */
public class GameStage extends Stage {

    private ResolutionFileResolver fileResolver;
    private OrthographicCamera camera;
    private GameAngle gameAngle;

    public GameStage(){
        fileResolver = new ResolutionFileResolver(new InternalFileHandleResolver(), new Resolution(800, 480, "480"),
                new Resolution(1280, 720, "720"), new Resolution(1920, 1080, "1080"));
        // use fileResolver for loading textures
        setupCamera();
        gameAngle = new GameAngle();
        addActor(gameAngle);
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
