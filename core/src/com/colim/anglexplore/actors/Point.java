/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

package com.colim.anglexplore.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.colim.anglexplore.utils.Constants;

/**
 * Created by hadri on 12/14/2015.
 */
public class Point extends Actor {

    private Vector2 position;
    private Color color;
    private ShapeRenderer shapeRenderer;

    public Point(Vector2 newPosition, Color newColor) {
        position = newPosition;
        color = newColor;
        shapeRenderer = new ShapeRenderer();
    }

    public Point() {
        position = new Vector2(Constants.WORLD_WIDTH/4, Constants.WORLD_HEIGHT/4);
        color = Color.BLACK;
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void draw(Batch batch, float alpha) {

        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color.r, color.g, color.b, color.a);
        shapeRenderer.circle(position.x, position.y, 10);
        shapeRenderer.end();
        batch.begin();
    }
}
