package com.colim.anglexplore.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

/**
 * Created by jerelynco on 12/25/15.
 */
public class Label extends Image {
    private char name;
    private TextureRegion texture;

    public Label(TextureRegion texture, char name) {
        super(texture);
        this.name = name;
        this.texture = texture;
    }

    public char getLabelName() {
        return name;
    }

    public void flip() {
        texture.flip(true, true);
        setDrawable(new SpriteDrawable(new Sprite(texture)));
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
