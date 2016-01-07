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
    private Image arrowClockwise, arrowCounterclockwise;
    private float randomAngle =  ((float) Math.random() * 360f);
    private float angle, armRotation;
    private Vector2 labelPosition, pointPosition;
    private Label label;
    private DragListener dragArmListener;

    private Vector2 startPoint, draggingPoint;
    private float deltaAngle;

    private boolean labelFlipped = false;
    public GameAngle(TextureRegion pointTexture, TextureRegion armTexture, TextureRegion arrowClockwiseTexture, TextureRegion arrowCounterclockwiseTexture, TextureRegion labelTexture, char labelName, Vector2 position, float angle){

        point = new Point(pointTexture, position);
        arm = new Arm(armTexture, randomAngle);
        arm2 = new Arm(armTexture, randomAngle+angle);
        label = new Label(labelTexture, labelName);
        arrowClockwise = new Image(arrowClockwiseTexture);
        arrowCounterclockwise = new Image(arrowCounterclockwiseTexture);

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

        arm.setZIndex(0);
        arm2.setZIndex(1);
        point.setZIndex(2);
//        if (label.getRotation() % 360 > 90 && label.getRotation() % 360 < 270) {
//            label.flip();
//            labelFlipped = true;
//        }

    }

    public void setArrows(boolean mode){
        if (mode){
            addActor(arrowClockwise);
            addActor(arrowCounterclockwise);
            arrowClockwise.setZIndex(2);
            arrowCounterclockwise.setZIndex(2);
        }
        else {
            arrowClockwise.remove();
            arrowCounterclockwise.remove();
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

        arrowClockwise.setPosition(point.getX() + point.getWidth() / 2 - arrowClockwise.getWidth() / 2 - 2, point.getY() + point.getHeight() / 2 - arrowClockwise.getHeight() / 2);
        arrowCounterclockwise.setPosition(point.getX() + point.getWidth() / 2 - arrowCounterclockwise.getWidth() / 2 - 1, point.getY() + point.getHeight() / 2 - arrowClockwise.getHeight() / 2 - 6);

        arrowClockwise.setOrigin(arrowClockwise.getWidth()/2 , arrowClockwise.getHeight()/ 2);
        arrowClockwise.rotateBy(1);
        arrowCounterclockwise.setOrigin(arrowCounterclockwise.getWidth()/2, arrowCounterclockwise.getHeight()/2 - 2);
        arrowCounterclockwise.rotateBy(-1);
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
            label.setOrigin(2.6f * point.getWidth(), 5);
            label.rotateBy(- armRotation + arm.getRotation());
            if(label.getRotation() % 360 > 90 && label.getRotation() % 360 < 270  && !labelFlipped){
                label.flip();
                labelFlipped = true;
                System.out.println("Flip1");
            }
            // something wrong here idk yet
            else if (label.getRotation() % 360 > 270  && label.getRotation() % 360 < 90 && labelFlipped)
            {
                label.flip();
                labelFlipped = false;
                System.out.println("Flip2");
            }
            armRotation = arm.getRotation();
        }
    }
}
