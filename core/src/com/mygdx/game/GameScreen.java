package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
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


    }

    @Override
    public void render(float delta) {
        super.render(delta);

        viewport.apply();

        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        basketList.update(delta);
        egg.update(delta);
        //egg.update();
        shape.begin(ShapeRenderer.ShapeType.Filled);
        basketList.render(shape);
        //shape.circle(50,50,10,100);
        egg.render(shape);
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
