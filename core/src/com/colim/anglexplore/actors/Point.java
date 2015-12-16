/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

package com.colim.anglexplore.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

public class Point extends Image {

    private Vector2 position;

    public Point(Texture texture, Vector2 position) {
        super(texture);
        setBounds(getX(), getY(), getWidth(), getHeight());
        setPosition(position.x, position.y);
    }


    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
