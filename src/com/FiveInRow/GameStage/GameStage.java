package com.FiveInRow.GameStage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.FiveInRow.MainGame;

import com.FiveInRow.Actor.MiddleGroup;
import com.FiveInRow.Actor.BottomGroup;

import com.FiveInRow.Res.Res;
import com.FiveInRow.GameStage.BaseStage;


public class GameStage extends BaseStage {



    private MiddleGroup middleGroup;


    private BottomGroup bottomGroup;

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
         * �ײ���Ա��
         */
/*        bottomGroup = new BottomGroup(getMainGame());
        bottomGroup.setX(getWidth() / 2 - bottomGroup.getWidth() / 2);				// ˮƽ����
        bottomGroup.setY(middleGroup.getY() / 2 - bottomGroup.getHeight() / 2);		// �ײ���ֱ����
        addActor(bottomGroup);
*/

        /*
         * �����̨������
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
        	
        	 * ���� PC ƽ̨, ��ͬʱͨ������������Ϸ,
        	 * ����������İ���, ���ݷ�����ƶ���Ƭ
        	 
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
                // ������Ϸ��̨���水�·��ؼ��������, ��ʾ�Ƿ��˳���Ϸ����ʾ�˳�ȷ����̨��
                getMainGame().getGameScreen().setShowExitConfirmStage(true);
                return true;
            }
            return super.keyUp(event, keycode);
        }
    */}

}
