/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

package com.colim.anglexplore.actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by hadri on 12/16/2015.
 */
public class Arm extends Image {
    public Arm(TextureRegion texture, float angle) {
        super(texture);
        setBounds(getX(), getY(), getWidth(), getHeight());
        setRotation(angle);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

}
