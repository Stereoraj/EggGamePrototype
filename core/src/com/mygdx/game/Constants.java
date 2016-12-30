package com.mygdx.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by stereoHeart on 30/12/2016.
 *
 * Constants class to store all the constant values stored throughout the game
 */
public class Constants {
    // dimension of the screen
    public static float WORLD_WIDTH = Gdx.graphics.getWidth();
    public static float WORLD_HEIGHT = Gdx.graphics.getHeight();

    // dimension of the basket carrying the egg
    public static float BASKET_WIDTH = 50.0f;
    public static float BASKET_HEIGHT = 20.0f;
    public static int  BASKET_DISTANCE = 100;

    // movement of eggs

    public static final float GRAVITY = -9.8f;

}
