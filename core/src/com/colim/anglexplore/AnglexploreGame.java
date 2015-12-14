package com.colim.anglexplore;

import com.badlogic.gdx.Game;
import com.colim.anglexplore.screens.GameScreen;
import com.colim.anglexplore.screens.StartScreen;

public class AnglexploreGame extends Game {
	@Override
	public void create () {
		setScreen(new StartScreen(this));
		//setScreen(new GameScreen());
	}

}
