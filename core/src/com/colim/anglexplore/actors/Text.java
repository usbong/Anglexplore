package com.colim.anglexplore.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.colim.anglexplore.utils.Constants;

/**
 * Created by jerelynco on 12/15/15.
 */
public class Text extends Actor {

    private Vector2 position;
    private Color color;
    private BitmapFont bitmapFont;
    private Label text;
    private Label.LabelStyle textStyle;

    public Text(Vector2 newPosition, Color newColor) {
        position = newPosition;
        color = newColor;

    }

    public Text() {
    }


}
