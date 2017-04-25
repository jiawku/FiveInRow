package com.FiveInRow.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.FiveInRow.MainGame;
import com.FiveInRow.Res.Res;
import com.FiveInRow.GameStage.GameStage;



public class GameScreen extends ScreenAdapter {

    private MainGame mainGame;

    private GameStage gameStage;


    public GameScreen(MainGame mainGame) {
        this.mainGame = mainGame;
        init();
    }

    private void init() {

        gameStage = new GameStage(
                mainGame,
                new StretchViewport(
                        mainGame.getWorldWidth(),
                        mainGame.getWorldHeight()
                )
        );

        

        Gdx.input.setInputProcessor(gameStage);
    }
    

    public void restartGame() {
        gameStage.restartGame();
    }
    
    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(Res.BG_RGBA.r, Res.BG_RGBA.g, Res.BG_RGBA.b, Res.BG_RGBA.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameStage.act();
        gameStage.draw();

    }

    @Override
    public void dispose() {

        if (gameStage != null) {
            gameStage.dispose();
        }
    }

    public GameStage getGameStage() {
        return gameStage;
    }

}


