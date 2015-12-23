/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

package com.colim.anglexplore.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

/**
 * Created by hadri on 12/16/2015.
 */
public class Arm  extends Image {

    private float currentAngle;


    public Arm(Texture texture, float angle) {
        super(texture);
        setBounds(getX(), getY(), getWidth(), getHeight());

        currentAngle = angle;
        addListener(dragListener);
    }

    DragListener dragListener = new DragListener() {

        @Override
        public void dragStart(InputEvent event, float x, float y, int pointer) {

        }

        public void drag(InputEvent event, float x, float y, int pointer) {

        }
    };

    public void newRotation(float angle){
        currentAngle = angle;
    }

    @Override
    public void act(float delta) {
        setRotation(currentAngle);
        super.act(delta);
    }
}
