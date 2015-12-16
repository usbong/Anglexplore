package com.colim.anglexplore.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.colim.anglexplore.utils.Constants;

/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

public class GameAngle extends Actor {

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



        batch.begin();
    }
}
