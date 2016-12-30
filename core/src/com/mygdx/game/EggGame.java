package com.mygdx.game;

import com.badlogic.gdx.Game;

public class EggGame extends Game {
	public EggGame() {
		super();
	}

	@Override
	public void create(){
		this.setScreen(new GameScreen());
	}

}