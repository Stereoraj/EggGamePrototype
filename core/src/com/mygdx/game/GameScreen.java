package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by stereoHeart on 27/12/2016.
 */
public class GameScreen extends ScreenAdapter{

    private ShapeRenderer shape;
    private Viewport viewport;

    private BasketList basketList;
    private Egg egg;

    public GameScreen(){
        shape = new ShapeRenderer();
        viewport = new ExtendViewport(Constants.WORLD_WIDTH,Constants.WORLD_HEIGHT);
        basketList = new BasketList();
        egg = new Egg(basketList);

        viewport.getCamera().translate(Constants.WORLD_WIDTH/2,Constants.WORLD_HEIGHT/2,0);
        viewport.getCamera().update();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        // updating the entities
        basketList.update(delta);
        egg.update(delta);

        viewport.apply();

        Gdx.gl.glClearColor(0.5f,0.2f,0.8f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shape.setProjectionMatrix(viewport.getCamera().combined);

        shape.begin(ShapeRenderer.ShapeType.Filled);
        basketList.render(shape);
        egg.render(shape);
        shape.end();

        if(egg.getBasketNo()==5){
            basketList.createNewList();
            egg.setBasketNo(0);
        }

        // rendering the rectangle for the game statistics
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.GREEN);
        shape.rect(0,Constants.WORLD_HEIGHT - 20,Constants.WORLD_WIDTH,20);
        shape.end();

        Gdx.app.log("GameScreen","Rendering");
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
        super.resize(width, height);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dispose() {
        super.dispose();
        shape.dispose();
    }
}
