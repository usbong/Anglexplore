package com.colim.anglexplore.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.colim.anglexplore.utils.Constants;

/**
 * Created by hadri on 12/13/2015.
 */
public class GameAngle extends Actor {

    private Vector2 vertex, pointA, pointB;
    private ShapeRenderer shapeRenderer;
    static private boolean projectionMatrixSet;

    public GameAngle(){ //Vector2 vertex, float angle
        // create angle here
        shapeRenderer = new ShapeRenderer();
        projectionMatrixSet = false;
    }

    @Override
    public void draw(Batch batch, float alpha){
        // draw here

        batch.end();
        if(!projectionMatrixSet){
            shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        }
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/2, 20, 20);
        shapeRenderer.end();
        batch.begin();

    }
}
