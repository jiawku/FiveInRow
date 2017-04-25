package com.FiveInRow;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import com.FiveInRow.Res.Res;
import com.FiveInRow.Screen.GameScreen;


public class MainGame extends Game {

    public static final String TAG = "FiveInRow";


    private float worldWidth;

    private float worldHeight;

    private AssetManager assetManager;


    private TextureAtlas atlas;

    private GameScreen gameScreen;

    @Override
    public void create() {

        Gdx.app.setLogLevel(Application.LOG_DEBUG);

  
        worldWidth = Res.FIX_WORLD_WIDTH;
        worldHeight = Gdx.graphics.getHeight() * worldWidth / Gdx.graphics.getWidth();
        
      /*  worldWidth = 514;
        worldHeight = 700;
*/
        Gdx.app.log(TAG, "World Size: " + worldWidth + " * " + worldHeight);


        assetManager = new AssetManager();


        assetManager.load(Res.ATLAS_PATH, TextureAtlas.class);

/*        assetManager.load(Res.Audios.MOVE, Sound.class);
        assetManager.load(Res.Audios.MERGE, Sound.class);*/


        assetManager.finishLoading();

        atlas = assetManager.get(Res.ATLAS_PATH, TextureAtlas.class);
        

        gameScreen = new GameScreen(this);


        setScreen(gameScreen);


        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void dispose() {
        super.dispose();

        if (gameScreen != null) {
            gameScreen.dispose();
        }
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    public AssetManager getAssetManager() {
		return assetManager;
	}

	public TextureAtlas getAtlas() {
        return atlas;
	}
    
    public float getWorldWidth() {
        return worldWidth;
    }

    public float getWorldHeight() {
        return worldHeight;
    }
    
}
