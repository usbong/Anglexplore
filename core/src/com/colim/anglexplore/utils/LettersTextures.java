/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

package com.colim.anglexplore.utils;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

public class LettersTextures {
    private Map lettersMap = new HashMap();

    public LettersTextures(List<TextureRegion> lettersTextureRegion) {
        int i = 0;
        for (char n = 'A'; n <= 'F'; n++) {
            lettersMap.put(n, lettersTextureRegion.get(i));
            i++;
        }
    }

    public TextureRegion getLetter(char letter) {
        return ((TextureRegion) lettersMap.get(letter));
    }
}
