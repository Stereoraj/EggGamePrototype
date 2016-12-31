package com.mygdx.game;

import com.badlogic.gdx.Game;

public class EggGame extends Game {

	@Override
	public void create(){
		showMenuScreen();
		//showGameScreen();
	}

	public void showMenuScreen(){
		setScreen(new MenuScreen(this));
	}

	public void showGameScreen(){
		setScreen(new GameScreen(this));
	}

}