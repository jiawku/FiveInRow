package com.FiveInRow.GameStage;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.FiveInRow.MainGame;

/**
 * ��̨����
 *
 */
public abstract class BaseStage extends Stage {

    private MainGame mainGame;

    /** ��̨�Ƿ�ɼ����Ƿ���ºͻ��ƣ� */
    private boolean visible = true;

    public BaseStage(MainGame mainGame, Viewport viewport) {
        super(viewport);
        this.mainGame = mainGame;
    }

    public MainGame getMainGame() {
        return mainGame;
    }

    public void setMainGame(MainGame mainGame) {
        this.mainGame = mainGame;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}