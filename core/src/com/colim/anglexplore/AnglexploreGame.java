package com.colim.anglexplore;

import com.badlogic.gdx.Game;
import com.colim.anglexplore.screens.GameScreen;

public class AnglexploreGame extends Game {
	@Override
	public void create () {
		setScreen(new GameScreen());
	}

}
