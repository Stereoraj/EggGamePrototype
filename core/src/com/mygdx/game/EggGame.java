package com.mygdx.game;

import com.badlogic.gdx.Game;

public class EggGame extends Game {

	@Override
	public void create(){
		this.setScreen(new GameScreen());
	}

}