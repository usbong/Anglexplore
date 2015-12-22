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

    private float rotateAngle;
    private float startAngle;

    public Arm(Texture texture, float angle) {
        super(texture);
        setBounds(getX(), getY(), getWidth(), getHeight());

        startAngle = rotateAngle = angle;
        addListener(dragListener);
    }

    DragListener dragListener = new DragListener() {
        private float startDragX;

        @Override
        public void dragStart(InputEvent event, float x, float y, int pointer) {
            startDragX = x;
        }

        public void drag(InputEvent event, float x, float y, int pointer) {
            rotateAngle = startAngle + x - startDragX;
        }
    };

    @Override
    public void act(float delta) {
        setRotation(rotateAngle);
        super.act(delta);
    }
}
