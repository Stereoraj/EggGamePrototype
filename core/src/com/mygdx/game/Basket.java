package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by stereoHeart on 27/12/2016.
 */
public class Basket {

    Vector2 position;
    Direction direction;

    public  float MOVE_RATE = MathUtils.random(70,150);

    private float width = 50.0f;
    private float height = 20.0f;

    public Basket(float x,float y){
        position = new Vector2(x,y);
        direction = Direction.FORWARD;
    }

    public void update(float delta){

        if(position.x + width >= Constants.WORLD_WIDTH)    direction = Direction.BACKWARD;
        if(position.x <=0)                                  direction = Direction.FORWARD;

        if(direction == Direction.FORWARD)
            position.x += delta * MOVE_RATE;

        if(direction == Direction.BACKWARD)
            position.x -= delta * MOVE_RATE;

    }

    public void render(ShapeRenderer shape){
        shape.setColor(Color.BLACK);
        shape.rect(position.x,position.y,width,height);
    }

    public Vector2 getPosition(){
        return position;
    }

    public enum Direction{
        FORWARD,
        BACKWARD
    }
}
