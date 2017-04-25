package com.FiveInRow.Res;

import com.badlogic.gdx.graphics.Color;

/**
 * ��Դ����
 *
 */
public interface Res {

    /** �̶�������Ϊ 480, �߶ȸ���ʵ����Ļ�������� */
    public static final float FIX_WORLD_WIDTH = 514;

    /** ����ͼ�� �ļ�·�� */
    public static final String ATLAS_PATH = "assets/GameAtlas.pack";


    /** ������ɫ */
    public static final Color BG_RGBA = new Color(0xEEE7D4FF);

    /**
     * ����ͼ����Сͼ���Ƴ���
     */
    public static interface AtlasNames {
        public static final String GAME_Broad = "Broad";
        public static final String GAME_White = "white";
        public static final String GAME_Black = "black";
    }
    
    /**
     * ��Ƶ��Դ
     */
/*    public static interface Audios {
    	public static final String MOVE = "audio/move.mp3";
    	public static final String MERGE = "audio/merge.mp3";
    }
*/

}

