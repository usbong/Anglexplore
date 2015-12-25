package com.colim.anglexplore.actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by jerelynco on 12/25/15.
 */
public class Label extends Image {
    private char name;
    public Label(TextureRegion texture, char name) {
        super(texture);
        this.name = name;
    }

    public char getLabelName() {
        return name;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

}
