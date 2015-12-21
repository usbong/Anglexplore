/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

package com.colim.anglexplore.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by hadri on 12/16/2015.
 */
public class Arm  extends Image {

    private Vector2 position;
    private Point point;

    public Arm(Texture texture, float angle) {
        super(texture);
        setBounds(getX(), getY(), getWidth(), getHeight());
        setRotation(angle);
    }

    public void setPoint(Point point){
        this.point = point;
    }

    @Override
    public void act(float delta) {
        setPosition(point.getX() + point.getWidth()/2, point.getY() + point.getHeight()/2);
        super.act(delta);

    }


}
