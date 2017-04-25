package com.FiveInRow.Actor;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.FiveInRow.MainGame;

/**
 * 演员组基类
 *
 */
public abstract class BaseGroup extends Group {

    private MainGame mainGame;

    public BaseGroup(MainGame mainGame) {
        this.mainGame = mainGame;
    }

    public MainGame getMainGame() {
        return mainGame;
    }

    public void setMainGame(MainGame mainGame) {
        this.mainGame = mainGame;
    }
}

