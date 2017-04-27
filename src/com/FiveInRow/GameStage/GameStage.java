package com.FiveInRow.GameStage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.FiveInRow.MainGame;

import com.FiveInRow.Actor.MiddleGroup;
//import com.FiveInRow.Actor.BottomGroup;

import com.FiveInRow.Res.Res;
import com.FiveInRow.GameStage.BaseStage;


public class GameStage extends BaseStage {



    private MiddleGroup middleGroup;


 //   private BottomGroup bottomGroup;

    public GameStage(MainGame mainGame, Viewport viewport) {
        super(mainGame, viewport);
        init();
    }

    private void init() {

        middleGroup = new MiddleGroup(getMainGame());
        
        middleGroup.setPosition(
                getWidth() / 2 - middleGroup.getWidth() / 2,
                getHeight() / 2 - middleGroup.getHeight() / 2
        );
        addActor(middleGroup);
        

        /*
         * 锟阶诧拷锟斤拷员锟斤拷
         */
/*        bottomGroup = new BottomGroup(getMainGame());
        bottomGroup.setX(getWidth() / 2 - bottomGroup.getWidth() / 2);				// 水平锟斤拷锟斤拷
        bottomGroup.setY(middleGroup.getY() / 2 - bottomGroup.getHeight() / 2);		// 锟阶诧拷锟斤拷直锟斤拷锟斤拷
        addActor(bottomGroup);
*/

        /*
         * 锟斤拷锟斤拷锟教拷锟斤拷锟斤拷锟�
         */
        addListener(new InputListenerImpl());
    }


    public void restartGame() {
        middleGroup.restartGame();

    }


    private class InputListenerImpl extends InputListener {
    	/*
    	@Override
        public boolean keyDown(InputEvent event, int keycode) {
        	
        	 * 锟斤拷锟斤拷 PC 平台, 锟斤拷同时通锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷戏,
        	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷陌锟斤拷锟�, 锟斤拷锟捷凤拷锟斤拷锟斤拷贫锟斤拷锟狡�
        	 
        	switch (keycode) {
				case Input.Keys.UP: {
					middleGroup.toTop();
					return true;
				}
				case Input.Keys.DOWN: {
					middleGroup.toBottom();
					return true;
				}
				case Input.Keys.LEFT: {
					middleGroup.toLeft();
					return true;
				}
				case Input.Keys.RIGHT: {
					middleGroup.toRight();
					return true;
				}
			}
        	
        	return super.keyDown(event, keycode);
        }
    	
        @Override
        public boolean keyUp(InputEvent event, int keycode) {
            if (keycode == Input.Keys.BACK) {
                // 锟斤拷锟斤拷锟斤拷戏锟斤拷台锟斤拷锟芥按锟铰凤拷锟截硷拷锟斤拷锟斤拷锟斤拷锟�, 锟斤拷示锟角凤拷锟剿筹拷锟斤拷戏锟斤拷锟斤拷示锟剿筹拷确锟斤拷锟斤拷台锟斤拷
                getMainGame().getGameScreen().setShowExitConfirmStage(true);
                return true;
            }
            return super.keyUp(event, keycode);
        }
    */}

}
