package com.colim.anglexplore.actors;

import com.colim.anglexplore.utils.Constants;

/**
 * Created by jerelynco on 12/26/15.
 */
public class Text extends com.badlogic.gdx.scenes.scene2d.ui.Label {
    private String text;

    public Text(final CharSequence text, final LabelStyle style) {
        super(text, style);
        this.text = text.toString();
    }

    @Override
    public void act(final float delta) {
        this.setText(text);
        this.setPosition(Constants.WORLD_WIDTH / 8, Constants.WORLD_HEIGHT / 4);
        super.act(delta);
    }
}
