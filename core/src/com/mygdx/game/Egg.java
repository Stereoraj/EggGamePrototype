package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by stereoHeart on 29/12/2016.
 */
public class Egg{
    Vector2 position;
    BasketList basketList;
    int basketNo,scoreCounter,eggsLeft;


    float velocity = 7.0f;

    //enumerations
    Movement movement;


    public Egg(BasketList basketList){
        position = new Vector2();
        this.basketList = basketList;

        basketNo = 0;
        scoreCounter = 0;
        eggsLeft = 6;

        this.position.x = (basketList.basketListArray.get(basketNo).getPosition()).x + 25;
        this.position.y = (basketList.basketListArray.get(basketNo).getPosition()).y + 30;

        movement = Movement.stopping;

    }

    public void render(ShapeRenderer renderer){
        renderer.setColor(Color.YELLOW);
        renderer.circle(position.x,position.y,10,100);

    }

    public void update(float delta){
        if(position.y>Constants.WORLD_HEIGHT){
            position.y = Constants.WORLD_HEIGHT;
        }

        // bouncing the ball
        if(movement != Movement.moving){
            if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.isTouched()) {

                // initialising the initial velocity of the ball
                velocity = 7.0f;

                movement = Movement.moving;
            }
        }
        if(movement == Movement.moving) {
            ballJump();

            // check only if the egg/ball is in the falling direction
            if(velocity<0) {
                if (this.position.y >= basketList.basketListArray.get(basketNo + 1).getPosition().y + Constants.BASKET_HEIGHT &&
                        this.position.y <= basketList.basketListArray.get(basketNo + 1).getPosition().y + Constants.BASKET_HEIGHT + 20) {
                    checkCollision();

                }

            }
            if(eggsLeft==0){
                //Gdx.app.exit();
            }
        }
        else {

            this.position.x = (basketList.basketListArray.get(basketNo).getPosition()).x + 25;
            this.position.y = (basketList.basketListArray.get(basketNo).getPosition()).y + 28;
        }

    }

    void ballJump(){
        if(position.y >= Gdx.graphics.getHeight())
            velocity = -7;

        if(position.y < 0) {
            movement = Movement.stopping;
            eggsLeft--;
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
            scoreCounter++;

        }
    }

    public int getBasketNo(){
        return basketNo;
    }

    public void setBasketNo(int basketNo){
        this.basketNo = basketNo;
    }

    public int getScore(){
        return scoreCounter;
    }

    public int getEggsLeft(){
        return eggsLeft;
    }



    enum Movement{
        moving,
        stopping
    }


}
