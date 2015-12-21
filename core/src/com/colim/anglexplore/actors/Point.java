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
        dragListener.setTapSquareSize(2);
        this.addListener(dragListener);
    }


    @Override
    public void act(float delta) {
        super.act(delta);
    }

    DragListener dragListener = new DragListener() {
        private float startDragX, startDragY;

        @Override
        public void dragStart(InputEvent event, float x, float y, int pointer) {
            startDragX = x;
            startDragY = y;
        }

        public void drag(InputEvent event, float x, float y, int pointer) {
            moveBy(x - startDragX, y - startDragY);
            System.out.println(getX());
        }
    };
}
