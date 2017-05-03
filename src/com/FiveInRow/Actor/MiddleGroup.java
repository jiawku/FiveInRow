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
import com.FiveInRow.Data.DataImp;
import com.FiveInRow.Data.DataInterface;
import com.FiveInRow.Data.Pattern;
import com.FiveInRow.Res.Res;

/**
 *
 */
public class MiddleGroup extends BaseGroup {
	

	private static final int ROW_SUM = 15;
	private static final int COL_SUM = 15;

    private Image bgImage;

    private DataImp DataModel;
    
    public MiddleGroup(MainGame mainGame) {
        super(mainGame);
        init();
    }
    
    private void init() {
        bgImage = new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.GAME_Broad));
        addActor(bgImage);
        DataModel=new DataImp(ROW_SUM,COL_SUM,new DataListenerImpl());
        setSize(bgImage.getWidth(), bgImage.getHeight());
        addListener(new InputListenerImpl());
        
    }
    

    private class InputListenerImpl extends InputListener {



        @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            int row,col;             
            row=Regularize(x)-1;
            col=Regularize(y)-1;
            
            if (DataModel.isBlank(row, col)){
            	AddPieceActor(row,col,DataModel.turn);
            	DataModel.AddPiece(row,col,DataModel.turn);   
            	DataModel.NextTurn();
            	DataModel.Computer_play();
            	/*Gdx.app.setLogLevel(Application.LOG_DEBUG);
            	Gdx.app.log("getEval:",Pattern.GetEval(DataModel.data,1)+"");*/

            		
            		/*Gdx.app.setLogLevel(Application.LOG_DEBUG);
            	    Gdx.app.log("RightSling",i+":"+Pattern.GetRightSling(DataModel.data,i,14-i)+""); */       			

               
            }
            return true;
        }
        
        public int Regularize(float x){
        	return (int) (Math.round((x)/34.5));
        }
       
    }
    
    private void AddPieceActor(int row,int col,boolean turn){
    	Image temp;
    	int RegX,RegY;
    	RegX=(int) ((row+1)*34.5-8);;
        RegY=(int) ((col+1)*34.5-8);;
        
    	 if (!turn) {
         	temp= new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.GAME_White));
     	} else{
         	temp= new Image(getMainGame().getAtlas().findRegion(Res.AtlasNames.GAME_Black));
         }
         
        temp.setPosition((RegX-temp.getWidth()/2), (RegY-temp.getHeight()/2));
     	addActor(temp);
     	
        
    }
    
    private class DataListenerImpl implements DataInterface.DataListener {

		@Override
		public void PlacePiece(int row, int col,int player) {
/*		 	Gdx.app.setLogLevel(Application.LOG_DEBUG);
	    	Gdx.app.log("model_play_actor","add row " + row + "add col" + col);*/
			AddPieceActor(row,col,DataModel.turn);
		}
		

      
    }
    
    public void restartGame() {
      init();
    }

}