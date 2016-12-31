package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by stereoHeart on 31/12/2016.
 */
public class MenuScreen  extends InputAdapter implements Screen {

    Viewport viewport;
    ShapeRenderer renderer;
    EggGame eggGame;


    public MenuScreen(EggGame eggGame){
        this.eggGame = eggGame;
        viewport = new StretchViewport(Constants.WORLD_WIDTH,Constants.WORLD_HEIGHT);
        renderer = new ShapeRenderer();

        Gdx.input.setInputProcessor(this);

        viewport.getCamera().translate(Constants.WORLD_WIDTH/2,Constants.WORLD_HEIGHT/2,0);
        viewport.getCamera().update();
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        viewport.apply();

        Gdx.gl.glClearColor(0.2f,0.1f,0.5f,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(viewport.getCamera().combined);

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.WHITE);
        renderer.circle(Constants.WORLD_WIDTH/2,Constants.WORLD_HEIGHT/2,Constants.MENU_CIRCLE_RADIUS);
        renderer.setColor(Color.BLACK);
        renderer.triangle(130,220,130,380,250,300);
        renderer.end();

        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.WHITE);
        renderer.line(130,220,130,380);
        renderer.line(130,220,250,300);
        renderer.line(250,300,130,380);
        renderer.end();


    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        renderer.dispose();
    }

    @Override
    public void dispose() {

    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button){

        Vector2 worldTouch = viewport.unproject(new Vector2(screenX, screenY));
        System.out.println(" "+worldTouch.x+" "+worldTouch.y);

        if (worldTouch.dst(Constants.MENU_CIRCLE_CENTER) < Constants.MENU_CIRCLE_RADIUS) {
            eggGame.showGameScreen();
        }

        return true;
    }
}
