package com.colim.anglexplore.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

public class GameAngle extends Group {

    private Point point;
    private Arm arm, arm2;
    private float randomAngle =  ((float) Math.random() * 360f);
    private Vector2 position;
    private Image label;

    public GameAngle(TextureRegion pointTexture, TextureRegion armTexture, TextureRegion labelTexture, Vector2 position, float angle){ //Vector2 vertex, float angle
        // create angle here
        point = new Point(pointTexture, position);
        arm = new Arm(armTexture, randomAngle);
        arm2 = new Arm(armTexture, randomAngle+angle);
        label = new Image(labelTexture);

        addActor(point);
        addActor(arm);
        addActor(arm2);
        this.position = position;
    }

    public void resetPosition() {
        point.setPosition(position.x, position.y);
    }

    public void newRotation(float angle){
        float randomAngle =  ((float) Math.random() * 360f);
        arm.newRotation(randomAngle);
        arm2.newRotation(randomAngle + angle);
    }

    @Override
    public void act(float delta) {
        float armPosX = point.getX() + point.getWidth() / 2;
        float armPosY = point.getY() + point.getHeight() / 2;
        super.act(delta);
        arm.setPosition(armPosX, armPosY);
        arm2.setPosition(armPosX, armPosY);
        label.setPosition(point.getX() + 8 * point.getWidth()/7, point.getY() + 8 * point.getHeight() / 7 );
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        label.draw(batch, parentAlpha);
    }
}
