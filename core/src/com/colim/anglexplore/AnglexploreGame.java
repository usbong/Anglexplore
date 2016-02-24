package com.colim.anglexplore;

/*
 * Created by Hadrian Paulo Lim on 2015.
 *
 * Copyright (c) Usbong Social Systems, Inc. All rights reserved.
 */


import com.badlogic.gdx.Game;
import com.colim.anglexplore.screens.StartScreen;

public class AnglexploreGame extends Game {
    @Override
    public void create() {
        setScreen(new StartScreen(this));
        //setScreen(new GameScreen());
    }

}
