package com.colim.anglexplore.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.colim.anglexplore.actors.GameAngle;
import com.colim.anglexplore.actors.GameUI;
import com.colim.anglexplore.actors.Text;
import com.colim.anglexplore.utils.AssetLoaderGame;
import com.colim.anglexplore.utils.Constants;
import com.colim.anglexplore.utils.LettersTextures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

public class GameStage extends Stage {

    private GameUI gameUI;
    private TextureRegion pointTexture, armTexture, highlightArmTexture, arrowClockwiseTexture, arrowCounterclockwiseTexture;
    private List<GameAngle> angles;
    private LettersTextures lettersTextures;
    private Text text;
    private boolean rotated = false;

    public GameStage() {

        super(new StretchViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT,
                new OrthographicCamera(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT)));

        setupCamera();

        AssetLoaderGame.load();
        pointTexture = AssetLoaderGame.vertex;
        armTexture = AssetLoaderGame.arm;
        highlightArmTexture = AssetLoaderGame.highlightArm;
        arrowClockwiseTexture = AssetLoaderGame.arrowClockwise;
        arrowCounterclockwiseTexture = AssetLoaderGame.arrowCounterclockwise;
        lettersTextures = new LettersTextures(AssetLoaderGame.letters);

        gameUI = new GameUI();
        addActor(gameUI);

        setUpText();

        angles = new ArrayList<GameAngle>();
        generateGameAngles(angles);

        gameUI.generate.addListener(new ClickListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                updateGameAngles(angles);
                return true;
            }
        });

        gameUI.quit.addListener(new ClickListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                return true;
            }
        });
    }

    private void setupCamera() {
        OrthographicCamera camera;
        camera = new OrthographicCamera(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }

    private void setUpText() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("arial.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 30;
        BitmapFont font = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose();
        text = new Text("", new Label.LabelStyle(font, Color.WHITE));
        text.setWrap(true);
        text.setWidth(3 * Constants.WORLD_WIDTH / 4);
        addActor(text);
    }

    public void generateGameAngles(List<GameAngle> angles) {
        float angle_x = ((float) Math.random()) * 90f;
        float angle_y = ((float) Math.random()) * 180f;

        List<Character> letters = new LinkedList<Character>();
        for (char n = 'A'; n <= 'F'; n++)
            letters.add(n);
        Collections.shuffle(letters);

        List<Vector2> initialPositions = new LinkedList<Vector2>();
        initialPositions.add(new Vector2(Constants.WORLD_WIDTH / 5, 3 * Constants.WORLD_HEIGHT / 4 - 70));
        initialPositions.add(new Vector2(Constants.WORLD_WIDTH / 2, 3 * Constants.WORLD_HEIGHT / 4 - 70));
        initialPositions.add(new Vector2(4 * Constants.WORLD_WIDTH / 5, 3 * Constants.WORLD_HEIGHT / 4 - 70));
        initialPositions.add(new Vector2(Constants.WORLD_WIDTH / 5, 2 * Constants.WORLD_HEIGHT / 4 - 80));
        initialPositions.add(new Vector2(Constants.WORLD_WIDTH / 2, 2 * Constants.WORLD_HEIGHT / 4 - 80));
        initialPositions.add(new Vector2(4 * Constants.WORLD_WIDTH / 5, 2 * Constants.WORLD_HEIGHT / 4 - 80));
        Collections.shuffle(initialPositions);

        angles.add(new GameAngle(pointTexture, armTexture, highlightArmTexture, arrowClockwiseTexture, arrowCounterclockwiseTexture, lettersTextures.getLetter(letters.get(0)), letters.get(0), initialPositions.get(0), angle_x));
        angles.add(new GameAngle(pointTexture, armTexture, highlightArmTexture, arrowClockwiseTexture, arrowCounterclockwiseTexture, lettersTextures.getLetter(letters.get(1)), letters.get(1), initialPositions.get(1), 90 - angle_x));
        angles.add(new GameAngle(pointTexture, armTexture, highlightArmTexture, arrowClockwiseTexture, arrowCounterclockwiseTexture, lettersTextures.getLetter(letters.get(2)), letters.get(2), initialPositions.get(2), angle_y));
        angles.add(new GameAngle(pointTexture, armTexture, highlightArmTexture, arrowClockwiseTexture, arrowCounterclockwiseTexture, lettersTextures.getLetter(letters.get(3)), letters.get(3), initialPositions.get(3), 180 - angle_y));
        angles.add(new GameAngle(pointTexture, armTexture, highlightArmTexture, arrowClockwiseTexture, arrowCounterclockwiseTexture, lettersTextures.getLetter(letters.get(4)), letters.get(4), initialPositions.get(4), ((float) Math.random()) * 180f));
        angles.add(new GameAngle(pointTexture, armTexture, highlightArmTexture, arrowClockwiseTexture, arrowCounterclockwiseTexture, lettersTextures.getLetter(letters.get(5)), letters.get(5), initialPositions.get(5), ((float) Math.random()) * 180f));

        for (final GameAngle angle : angles) {
            addActor(angle);
/*            angle.addListener(clickListener = new ClickListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                    toggleArrowsVisibility(angle);
                    return true;
                }
            });*/
        }
    }
/*
    public void toggleArrowsVisibility(GameAngle activeAngle) {
        for (GameAngle angle : angles) {
            angle.setArrows(false);
        }
        activeAngle.setArrows(true);
        activeAngle.removeListener(clickListener);
    }*/

    public void updateGameAngles(List<GameAngle> angles) {
        for (GameAngle angle : angles) {
            angle.remove();
        }
        angles.clear();
        generateGameAngles(angles);
    }

    // Checks if two angles have a considerable angle difference to be considered collision
    public boolean validAngleDiff(float val1, float val2) {
        return Math.abs(val2 - val1) < 5;
    }

    // Checks if two points/vertices have considerable distance to be considered collision
    public boolean validPointDistance(Vector2 pos1, Vector2 pos2) {
        return pos1.dst(pos2) < 10;
    }

    public void checkCollision(List<GameAngle> angles) {
        float angleSum;
        String result;

        for (int angleCurrentIndex = 0; angleCurrentIndex < angles.size(); angleCurrentIndex++) {
            for (int angleAgainstIndex = angleCurrentIndex + 1; angleAgainstIndex < angles.size(); angleAgainstIndex++) {

                GameAngle currentAngle = angles.get(angleCurrentIndex);
                GameAngle againstAngle = angles.get(angleAgainstIndex);

                angleSum = currentAngle.getAngle() + againstAngle.getAngle();

                boolean currInitAgainstTermCollide = validAngleDiff(currentAngle.getInitialAngle(), againstAngle.getTerminalAngle());
                boolean currTermAgainstInitCollide = validAngleDiff(currentAngle.getTerminalAngle(), againstAngle.getInitialAngle());


                if (validPointDistance(currentAngle.getPointPosition(), againstAngle.getPointPosition())) {
                    if (!rotated) {
                        currentAngle.changeArmAngle(againstAngle.getArmAngle());
                        rotated = true;
                    }

                    currentAngle.otherAngleLabelPositionX = againstAngle.getLabelPosition().x;

                    if ((angleSum == 90.0 || angleSum == 180.0)) {
                        if (currInitAgainstTermCollide) {
                            currentAngle.setHighlightTerminal();
                            againstAngle.setHighlightInitial();
                        } else if (currTermAgainstInitCollide) {
                            currentAngle.setHighlightInitial();
                            againstAngle.setHighlightTerminal();
                        }
                    }

                    if (angleSum == 90.0) {
                        result = "Complementary";
                        currentAngle.lock(againstAngle);
                        againstAngle.lock(currentAngle);
                    } else if (angleSum == 180.0) {
                        result = "Supplementary";
                        currentAngle.lock(againstAngle);
                        againstAngle.lock(currentAngle);
                    } else {
                        result = "neither Complementary nor Supplementary";
                    }

                    text.setText("Angle " + String.valueOf(currentAngle.getLabelName() + " and Angle "
                            + String.valueOf(againstAngle.getLabelName() + " are " + result
                            + " angles. The sum of their angle measure is " + String.format("%.2f", angleSum) + " degrees.")));
                }
            }
            rotated = false;
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        this.checkCollision(angles);
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoaderGame.dispose();
    }
}
