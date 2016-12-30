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

    float velocity = 7.0f;

    //enums
    OnBasket onBasket;
    Movement movement;


    public Egg(BasketList basketList){
        position = new Vector2();
        this.basketList = basketList;

        basketNo = 0;

        this.position.x = (basketList.basketListArray.get(basketNo).getPosition()).x + 25;
        this.position.y = (basketList.basketListArray.get(basketNo).getPosition()).y + 30;

        onBasket = OnBasket.on;
        movement = Movement.stopping;

    }

    public void render(ShapeRenderer renderer){
        renderer.circle(position.x,position.y,10,100);

    }

    public void update(float delta){
        if(position.y>Constants.WORLD_HEIGHT){
            position.y = Constants.WORLD_HEIGHT;
        }
        /*if(position.y<0){
            position.y = 0;
        }*/

        /*if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){

            basketNo++;

            if(basketNo>4)
                basketNo=4;

            this.position.y = (basketList.basketListArray.get(basketNo).getPosition()).y + 28;

            if(this.position.x > basketList.basketListArray.get(basketNo).getPosition().x &&
                    this.position.x < basketList.basketListArray.get(basketNo).getPosition().x + Constants.BASKET_WIDTH) {
                onBasket = OnBasket.on;
            }else{
                onBasket = OnBasket.off;
            }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            //position.y-=100*delta;
            basketNo--;
            if(basketNo<0)
                basketNo=0;
            this.position.x = (basketList.basketListArray.get(basketNo).getPosition()).x + 25;
            this.position.y = (basketList.basketListArray.get(basketNo).getPosition()).y + 28;
        }

        if(onBasket == OnBasket.on) {
            this.position.x = (basketList.basketListArray.get(basketNo).getPosition()).x + 25;
        }
        */

        // bouncing the ball
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            movement = Movement.moving;
        }
        if(movement == Movement.moving) {
            jump();
            if(this.position.y>=basketList.basketListArray.get(basketNo+1).getPosition().y+Constants.BASKET_HEIGHT &&
                    this.position.y<=basketList.basketListArray.get(basketNo+1).getPosition().y+Constants.BASKET_HEIGHT+20) {
                checkCollision();
                //movement = Movement.stopping;
            }
        }
        else {

            this.position.x = (basketList.basketListArray.get(basketNo).getPosition()).x + 20;
            this.position.y = (basketList.basketListArray.get(basketNo).getPosition()).y + 28;
        }

    }

    void jump(){
        if(position.y >= Gdx.graphics.getHeight())
            velocity = -7;

        if(position.y < 0) {
            movement = movement.stopping;
            velocity = 7;
        }
        velocity += Constants.GRAVITY * Gdx.graphics.getDeltaTime();
        position.y +=velocity;
    }

    void checkCollision(){

        if(this.position.x > basketList.basketListArray.get(basketNo+1).getPosition().x &&
                this.position.x < basketList.basketListArray.get(basketNo+1).getPosition().x + Constants.BASKET_WIDTH){
            basketNo++;
            movement = Movement.stopping;

        }
    }

    // enumeration type to check whether the egg is on of off the basket

    enum OnBasket{
        on,
        off
    }

    enum Movement{
        moving,
        stopping
    }


}
