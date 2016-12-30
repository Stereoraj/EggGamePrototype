package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

/**
 * Created by stereoHeart on 29/12/2016.
 */
public class BasketList {
    Array<Basket> basketList;

    public BasketList(){
        //init();
        basketList = new Array<Basket>();
        init();
    }

    public void init(){

        for(int i=10;i<600;i+=100){
            basketList.add(new Basket(MathUtils.random(GameScreen.WORLD_WIDTH - 50),i));
        }

    }

    public void update(float delta){
        for(Basket basket: basketList){
            basket.update(delta);
        }


    }

    public void render(ShapeRenderer renderer){
        for(Basket basket: basketList){
            basket.render(renderer);
        }
    }
}
