package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by stereoHeart on 27/12/2016.
 */
public class GameScreen extends ScreenAdapter{

    private ShapeRenderer shape;
    private Viewport viewport,hudViewport;
    private SpriteBatch batch;
    private BitmapFont font;

    private BasketList basketList;
    private Egg egg;

    public GameScreen(){
        shape = new ShapeRenderer();
        batch = new SpriteBatch();
        viewport = new StretchViewport(Constants.WORLD_WIDTH,Constants.WORLD_HEIGHT);
        hudViewport = new ScreenViewport();

        basketList = new BasketList();
        egg = new Egg(basketList);

        font = new BitmapFont();
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);

        viewport.getCamera().translate(Constants.WORLD_WIDTH/2,Constants.WORLD_HEIGHT/2,0);
        viewport.getCamera().update();

        hudViewport.getCamera().translate(Constants.WORLD_WIDTH/2,Constants.WORLD_HEIGHT/2,0);
        hudViewport.getCamera().update();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        // updating the entities
        basketList.update(delta);
        egg.update(delta);

        viewport.apply();

        Gdx.gl.glClearColor(0.0f,0.5f,0.4f,1);
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

        hudViewport.apply();
        batch.setProjectionMatrix(hudViewport.getCamera().combined);

        batch.begin();
        final String msg= "Score: " + egg.getScore();
        //batch.setColor(Color.BLACK);
        //font.setColor(Color.BLACK);
        font.draw(batch,msg,5,Constants.WORLD_HEIGHT - 5);
        batch.end();

        Gdx.app.log("GameScreen","Rendering");
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
        hudViewport.update(width,height);
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
