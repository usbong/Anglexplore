package com.colim.anglexplore.actors;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import static java.lang.Math.abs;

/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

public class GameAngle extends Group {

    public float otherAngleLabelPositionX;
    private Point point;
    private Arm arm, arm2, highlightArm, highlightArm2;
    private Image arrowClockwise, arrowCounterclockwise;
    private float randomAngle = ((float) Math.random() * 360f);
    private float angle;
    private Vector2 labelPosition, pointPosition;
    private Label label;
    private boolean locked = false;
    private GameAngle againstAngle;

    public GameAngle(TextureRegion pointTexture, TextureRegion armTexture, TextureRegion highlightArmTexture, TextureRegion arrowClockwiseTexture, TextureRegion arrowCounterclockwiseTexture, TextureRegion labelTexture, char labelName, Vector2 position, float angle) {

        point = new Point(pointTexture, position);
        arm = new Arm(armTexture, randomAngle);
        arm2 = new Arm(armTexture, randomAngle + angle);
        label = new Label(labelTexture, labelName);
        arrowClockwise = new Image(arrowClockwiseTexture);
        arrowCounterclockwise = new Image(arrowCounterclockwiseTexture);
        highlightArm = new Arm(highlightArmTexture, randomAngle);
        highlightArm2 = new Arm(highlightArmTexture, randomAngle + angle);


        addActor(arm);
        addActor(arm2);
        addActor(point);
        addActor(highlightArm);
        addActor(highlightArm2);
        highlightArm.setZIndex(2);
        highlightArm2.setZIndex(2);
        highlightArm.setVisible(false);
        highlightArm2.setVisible(false);

        this.angle = angle;
        pointPosition = position;
        otherAngleLabelPositionX = 0;

        arm.setZIndex(0);
        arm2.setZIndex(1);
        point.setZIndex(9);
    }

//    public void setArrows(boolean mode) {
//        if (mode) {
//            addActor(arrowClockwise);
//            addActor(arrowCounterclockwise);
//            arrowClockwise.setZIndex(2);
//            arrowCounterclockwise.setZIndex(2);
//        } else {
//            arrowClockwise.remove();
//            arrowCounterclockwise.remove();
//        }
//    }

    public void setHighlightInitial() {
        highlightArm.setVisible(true);
        arm2.setVisible(false);

    }

    public void setHighlightTerminal() {
        highlightArm2.setVisible(true);
        arm.setVisible(false);
    }

    public void clearHighlight() {
        highlightArm.setVisible(false);
        highlightArm2.setVisible(false);
        arm.setVisible(true);
        arm2.setVisible(true);
    }

    public Vector2 getPointPosition() {
        return point.getCurPos();
    }

    public float getInitialAngle() {
        if (arm.getRotation() % 360 < 0) {
            return 360 + arm.getRotation() % 360;
        }
        return arm.getRotation() % 360;
    }

    public float getTerminalAngle() {
        if (arm2.getRotation() % 360 < 0) {
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

        if(locked)
        {
            lock(againstAngle);
        }

        float armPosX = point.getX() + point.getWidth() / 2;
        float armPosY = point.getY() + point.getHeight() / 2;

        updateLabelPosition();

        if (checkOverlappingLabels(otherAngleLabelPositionX)) {
            labelPosition.x += 60;
        }
        arm.setOrigin(0, arm.getHeight()/2);
        arm2.setOrigin(0, arm2.getHeight()/2);

        highlightArm.setOrigin(0, highlightArm.getHeight()/2);
        highlightArm2.setOrigin(0, highlightArm2.getHeight()/2);

        arm.setPosition(armPosX, armPosY);
        arm2.setPosition(armPosX, armPosY);

        highlightArm.setPosition(armPosX, armPosY);
        highlightArm2.setPosition(armPosX, armPosY);

        label.setPosition(labelPosition.x, labelPosition.y);

        arrowClockwise.setPosition(point.getX() + point.getWidth() / 2 - arrowClockwise.getWidth() / 2 - 2, point.getY() + point.getHeight() / 2 - arrowClockwise.getHeight() / 2);
        arrowCounterclockwise.setPosition(point.getX() + point.getWidth() / 2 - arrowCounterclockwise.getWidth() / 2 - 1, point.getY() + point.getHeight() / 2 - arrowClockwise.getHeight() / 2 - 6);

        arrowClockwise.setOrigin(arrowClockwise.getWidth() / 2, arrowClockwise.getHeight() / 2);
        arrowClockwise.rotateBy(1);
        arrowCounterclockwise.setOrigin(arrowCounterclockwise.getWidth() / 2, arrowCounterclockwise.getHeight() / 2 - 2);
        arrowCounterclockwise.rotateBy(-1);
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        label.draw(batch, parentAlpha);
    }

    private void updateLabelPosition() {
        if (pointPosition != new Vector2(point.getX(), point.getY())) {
            pointPosition = new Vector2(point.getX(), point.getY());
            labelPosition = new Vector2(point.getX() - (1 / 2) * point.getWidth(), point.getY() - 10);
            // Should reset angle highlighting when angle is moved
            clearHighlight();
        }
    }

    public void changeArmAngle(float delta) {
        arm.setRotation(delta);
        arm2.setRotation(arm.getRotation() + angle);
        highlightArm.setRotation(delta);
        highlightArm2.setRotation(highlightArm.getRotation() + angle);
    }

    public float getArmAngle() {
        return arm2.getRotation();
    }

    public boolean checkOverlappingLabels(float x) {
        return abs(labelPosition.x - x) < 40;
    }

    public Vector2 getLabelPosition() {
        return labelPosition;
    }

    public void lock(GameAngle otherAngle) {
        if (!locked){
            againstAngle = otherAngle;
            locked = true;
        }
        point.setPosition(againstAngle.point.getX(), againstAngle.point.getY());
        againstAngle.point.setPosition(point.getX(), point.getY());
    }
}
