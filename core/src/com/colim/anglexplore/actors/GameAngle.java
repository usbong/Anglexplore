package com.colim.anglexplore.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

public class GameAngle extends Group {

    private Point point;
    private Arm arm, arm2;
    private Image arrows;
    private float randomAngle =  ((float) Math.random() * 360f);
    private float angle, armRotation;
    private Vector2 labelPosition, pointPosition;
    private Label label;
    private DragListener dragArmListener;

    private Vector2 startPoint, draggingPoint;
    private float deltaAngle;

    public GameAngle(TextureRegion pointTexture, TextureRegion armTexture, TextureRegion arrowTexture, TextureRegion labelTexture, char labelName, Vector2 position, float angle){
        point = new Point(pointTexture, position);
        arm = new Arm(armTexture, randomAngle);
        arm2 = new Arm(armTexture, randomAngle+angle);
        label = new Label(labelTexture, labelName);
        arrows = new Image(arrowTexture);

        point.setZIndex(4);
        arrows.setZIndex(3);
        label.setZIndex(1);

        addActor(arm);
        addActor(arm2);
        addActor(point);

        this.angle = angle;
        this.deltaAngle = 0;

        labelPosition = new Vector2(point.getX() - 2 * point.getWidth(), point.getY());
        pointPosition = position;

        setupArmListener();

        armRotation = arm.getRotation();
        label.setOrigin(2.5f * point.getWidth(), 0);
        label.setRotation(arm.getRotation());
    }

    public void setArrows(boolean mode){
        if (mode == true){
            addActor(arrows);
            arrows.setZIndex(2);
        }
        else {
            arrows.remove();
        }
    }

    public Vector2 getPointPosition() {
        return point.getCurPos();
    }

    public float getInitialAngle() {
        if(arm.getRotation() % 360 < 0) {
            return 360 + arm.getRotation() % 360;
        }
        return arm.getRotation() % 360;
    }

    public float getTerminalAngle() {
        if(arm2.getRotation() % 360 < 0) {
            return 360 + arm2.getRotation() % 360;
        }
        return arm2.getRotation() % 360;
    }

    public float getAngle() {
        return angle;
    }

    public char getLabelName() {
        return label.getLabelName();
    }


    @Override
    public void act(float delta) {
        float armPosX = point.getX() + point.getWidth() / 2;
        float armPosY = point.getY() + point.getHeight() / 2;

        updateLabelPosition();

        arm.setPosition(armPosX, armPosY);
        arm2.setPosition(armPosX, armPosY);
        label.setPosition(labelPosition.x, labelPosition.y);
        arrows.setPosition(point.getX() - arrows.getWidth() / 3, point.getY() - arrows.getHeight() / 3);

        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        label.draw(batch, parentAlpha);
    }

    public void setupArmListener(){
        dragArmListener = new DragListener() {
            @Override
            public void dragStart(InputEvent event, float x, float y, int pointer) {
                startPoint = new Vector2(arm.getImageX(), arm.getImageY());
            }

            public void drag(InputEvent event, float x, float y, int pointer) {
                draggingPoint = new Vector2(x, y).sub(startPoint);
                deltaAngle = MathUtils.atan2(draggingPoint.y, draggingPoint.x) * MathUtils.radiansToDegrees;
                arm.rotateBy(deltaAngle);
                arm2.rotateBy(deltaAngle);
            }
        };

        arm.addListener(dragArmListener);
        arm2.addListener(dragArmListener);
    }
    private void updateLabelPosition() {
        if (pointPosition != new Vector2(point.getX(), point.getY())) {
            labelPosition = new Vector2(point.getX() - 2 * point.getWidth(), point.getY());
            pointPosition = new Vector2(point.getX(), point.getY());
        }
        if (armRotation != arm.getRotation()){
            label.setOrigin(2.5f * point.getWidth(), 0);
            label.rotateBy(- armRotation + arm.getRotation());
            if(label.getRotation() > 180){
                // Flip texture here
            }
            armRotation = arm.getRotation();
        }
    }
}
