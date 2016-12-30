package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

/**
 * Created by stereoHeart on 29/12/2016.
 */
public class BasketList {
    Array<Basket> basketListArray;

    public BasketList(){
        basketListArray = new Array<Basket>();
        init();
    }

    public void init(){

        for(int i=10;i<600;i+=Constants.BASKET_DISTANCE){
            basketListArray.add(new Basket(MathUtils.random(Constants.WORLD_WIDTH - 50),i));
        }

    }

    public void update(float delta){
        for(Basket basket: basketListArray){
            basket.update(delta);
        }


    }

    public void render(ShapeRenderer renderer){
        for(Basket basket: basketListArray){
            basket.render(renderer);
        }
    }
}
