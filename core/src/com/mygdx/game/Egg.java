package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by stereoHeart on 29/12/2016.
 */
public class Egg{
    Vector2 position;
    BasketList basketList;
    int basketNo;


    public Egg(BasketList basketList){
        position = new Vector2();
        this.basketList = basketList;

        basketNo = 0;

        this.position.x = (basketList.basketList.get(0).getPosition()).x + 25;
        this.position.y = (basketList.basketList.get(0).getPosition()).y + 30;

    }

    public void render(ShapeRenderer renderer){
        renderer.circle(position.x,position.y,10,100);

    }

    public void update(float delta){
        if(position.y>Constants.WORLD_HEIGHT){
            position.y = Constants.WORLD_HEIGHT;
        }
        if(position.y<0){
            position.y = 0;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            //for(Basket basket: basketList.basketList){
                //if(basket.getPosition().x < this.position.x && basket.getPosition().x+50 > this.position.x){
                    basketNo++;
                    if(basketNo>4)
                        basketNo=4;
                    this.position.x = (basketList.basketList.get(basketNo).getPosition()).x + 25;
                    this.position.y = (basketList.basketList.get(basketNo).getPosition()).y + 28;
                //}
            //}
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            //position.y-=100*delta;
            basketNo--;
            if(basketNo<0)
                basketNo=0;
            this.position.x = (basketList.basketList.get(basketNo).getPosition()).x + 25;
            this.position.y = (basketList.basketList.get(basketNo).getPosition()).y + 28;
        }

        this.position.x = (basketList.basketList.get(basketNo).getPosition()).x + 25;
        this.position.y = (basketList.basketList.get(basketNo).getPosition()).y + 28;


    }

    public Vector2 getPosition(){
        return position;
    }
}
