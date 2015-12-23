package com.colim.anglexplore.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

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
    private ClickListener clickArmListener;

    public GameAngle(TextureRegion pointTexture, TextureRegion armTexture, TextureRegion labelTexture, Vector2 position, float angle){
        point = new Point(pointTexture, position);
        arm = new Arm(armTexture, randomAngle);
        arm2 = new Arm(armTexture, randomAngle+angle);
        label = new Image(labelTexture);

        addActor(point);
        addActor(arm);
        addActor(arm2);
        this.position = position;

        setupArmListener();

    }

    public void resetPosition() {
        point.setPosition(position.x, position.y);
    }

    public void newRotation(float angle){
        float randomAngle =  ((float) Math.random() * 360f);
        arm.setRotation(randomAngle);
        arm2.setRotation(randomAngle + angle);
    }

    @Override
    public void act(float delta) {
        float armPosX = point.getX() + point.getWidth() / 2;
        float armPosY = point.getY() + point.getHeight() / 2;
        super.act(delta);
        arm.setPosition(armPosX, armPosY);
        arm2.setPosition(armPosX, armPosY);
        label.setPosition(point.getX() + 8 * point.getWidth()/4, point.getY() + 5 * point.getHeight() / 4 );
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        label.draw(batch, parentAlpha);
    }

    public void setupArmListener(){
        clickArmListener = new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                arm2.rotateBy(90);
                arm.rotateBy(90);
                return super.touchDown(event, x, y, pointer, button);
            }
        };

        arm.addListener(clickArmListener);
        arm2.addListener(clickArmListener);
    }
}
