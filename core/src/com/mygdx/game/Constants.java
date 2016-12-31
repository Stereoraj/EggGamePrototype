package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by stereoHeart on 30/12/2016.
 *
 * Constants class to store all the constant values stored throughout the game
 */
public class Constants {
    // dimension of the screen
    public static float WORLD_WIDTH = 350;
    public static float WORLD_HEIGHT = 600;

    // dimension of the basket carrying the egg
    public static float BASKET_WIDTH = 50.0f;
    public static float BASKET_HEIGHT = 20.0f;
    public static int  BASKET_DISTANCE = 100;

    // movement of eggs

    public static final float GRAVITY = -9.8f;

    public static final Vector2 MENU_CIRCLE_CENTER = new Vector2(WORLD_WIDTH/2,WORLD_HEIGHT/2);
    public static final float MENU_CIRCLE_RADIUS = 100;

}
