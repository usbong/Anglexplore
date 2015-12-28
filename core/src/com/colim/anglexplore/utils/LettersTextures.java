/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */

package com.colim.anglexplore.utils;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.*;

/**
 * Created by hadri on 12/28/2015.
 */
public class LettersTextures {
    private Map lettersMap = new HashMap();
    private List<TextureRegion> lettersTextureRegion;
    private List keys;

    public LettersTextures(List<TextureRegion> lettersTextureRegion){
        int i = 0;
        this.lettersTextureRegion = lettersTextureRegion;
        for (char n = 'A'; n <= 'F'; n++) {
            lettersMap.put(n, lettersTextureRegion.get(i));
            i++;
        }
    }

    public TextureRegion getLetter(char letter){
        return ((TextureRegion) lettersMap.get(letter));
    }

}
