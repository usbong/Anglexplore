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
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

/**
 * Created by hadri on 12/14/2015.
 */
public class Point extends Actor {

    private Vector2 position;
    private float radius = 40f;
    private Color color;
    private ShapeRenderer shapeRenderer;

    public Point(Vector2 newPosition, Color newColor) {
        position = newPosition;
        color = newColor;
        shapeRenderer = new ShapeRenderer();
        setBounds(position.x - radius, position.y - radius, radius * 2, radius * 2);
        setTouchable(Touchable.enabled);
        addListener(new InputListener(){

        });
}

    public Point(Vector2 newPosition){
        this(newPosition, Color.BLACK);
    }

    @Override
    protected void positionChanged() {
        position.set(getX(), getY());
        super.positionChanged();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float alpha) {

        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color.r, color.g, color.b, color.a);
        shapeRenderer.circle(position.x, position.y, radius);
        shapeRenderer.end();
        batch.begin();
    }
}
