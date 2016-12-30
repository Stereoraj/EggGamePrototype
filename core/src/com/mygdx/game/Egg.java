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

    //enumerations
    Movement movement;


    public Egg(BasketList basketList){
        position = new Vector2();
        this.basketList = basketList;

        basketNo = 0;

        this.position.x = (basketList.basketListArray.get(basketNo).getPosition()).x + 25;
        this.position.y = (basketList.basketListArray.get(basketNo).getPosition()).y + 30;

        movement = Movement.stopping;

    }

    public void render(ShapeRenderer renderer){
        renderer.circle(position.x,position.y,10,100);

    }

    public void update(float delta){
        if(position.y>Constants.WORLD_HEIGHT){
            position.y = Constants.WORLD_HEIGHT;
        }

        // bouncing the ball
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {

            // initialising the initial velocity of the ball
            velocity = 7.0f;

            movement = Movement.moving;
        }
        if(movement == Movement.moving) {
            ballJump();


            if(this.position.y>=basketList.basketListArray.get(basketNo+1).getPosition().y+Constants.BASKET_HEIGHT &&
                    this.position.y<=basketList.basketListArray.get(basketNo+1).getPosition().y+Constants.BASKET_HEIGHT+20) {
                checkCollision();

            }
        }
        else {

            this.position.x = (basketList.basketListArray.get(basketNo).getPosition()).x + 20;
            this.position.y = (basketList.basketListArray.get(basketNo).getPosition()).y + 28;
        }

    }

    void ballJump(){
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



    enum Movement{
        moving,
        stopping
    }


}
