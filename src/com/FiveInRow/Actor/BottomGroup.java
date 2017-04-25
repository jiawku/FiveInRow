package com.FiveInRow.Actor;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import com.FiveInRow.MainGame;
import com.FiveInRow.Actor.BaseGroup;
import com.FiveInRow.Res.Res;

/**
 * 底部演员组, 包括 游戏帮助 和 退出游戏 按钮
 *
 */
public class BottomGroup extends BaseGroup {

    /** 退出按钮 */
    private Button exitButton;

	public BottomGroup(MainGame mainGame) {
		super(mainGame);
		init();
	}


	private void init() {
		/*
		 * 退出按钮
		 */
		Button.ButtonStyle exitStyle = new Button.ButtonStyle();
		exitStyle.up = new TextureRegionDrawable(
				getMainGame().getAtlas().findRegion(Res.AtlasNames.GAME_BTN_EXIT, 1)
		);
		exitStyle.down = new TextureRegionDrawable(
				getMainGame().getAtlas().findRegion(Res.AtlasNames.GAME_BTN_EXIT, 2)
		);
		exitButton = new Button(exitStyle);
		exitButton.setX(240);
		// 设置按钮点击监听
		exitButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				getMainGame().getGameScreen().setShowExitConfirmStage(true);
			}
		});
		addActor(exitButton);
	}
    
}
