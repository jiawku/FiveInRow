package com.FiveInRow.Actor;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;

import com.FiveInRow.MainGame;
import com.FiveInRow.Actor.BaseGroup;
//import com.FiveInRow.Data.IDataModel;
import com.FiveInRow.Res.Res;

/**
 *
 */
public class MiddleGroup extends BaseGroup {
	
	// ��Ƭ��������
	private static final int CARD_ROW_SUM = 15;
	private static final int CARD_COL_SUM = 15;

    private Image bgImage,white,black;
    
    private Boolean turn;
    

/*  
    private Sound moveSound;
    

    private Sound mergeSound;
    */


   // private IDataModel dataModel;
    
    public MiddleGroup(MainGame mainGame) {
        super(mainGame);
        init();
    }

    private Boolean NextTurn() {
    	turn= !turn;
    	return turn;
    }
    
    private void init() {
    	turn=true;
        bgImage = new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.GAME_Broad));
        addActor(bgImage);
        
        setSize(bgImage.getWidth(), bgImage.getHeight());
        addListener(new InputListenerImpl());
        
    }
    
    /**
     * 输入监听器的实现
     */
    private class InputListenerImpl extends InputListener {



        @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            Image temp;
            

            if (turn) {
            	temp= new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.GAME_White));
            	temp.setPosition((RegularizePosition(x)-temp.getWidth()/2), (RegularizePosition(y)-temp.getHeight()/2));
            	addActor(temp);
            } else{
            	temp= new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.GAME_Black));
            	temp.setPosition((RegularizePosition(x)-temp.getWidth()/2), (RegularizePosition(y)-temp.getHeight()/2));
            	addActor(temp);
            }
            
            NextTurn();
            return true;
        }
        
        public int Regularize(float x){
        	Gdx.app.setLogLevel(Application.LOG_DEBUG);
        	Gdx.app.log("five","Regularize " + Math.round((x)/34.5));
        	return (int) (Math.round((x)/34.5));
        }

        public int RegularizePosition(float x){
        	return (int) (Regularize(x)*34.5-8);
        }
       
    }
    
    public void restartGame() {
      
    }

}