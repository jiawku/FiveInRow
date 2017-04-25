package com.FiveInRow;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.FiveInRow.MainGame;

public class DesktopLauncher {
	
	public static void main (String[] arg) {
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
        final float pixWidth = 514;				// ���ڿ�Ȳο�ֵ
        final float ratio = 514F / 514F;	// ���ڿ�߱ȣ��ʵ����ڿ�߱ȿ��Բ鿴�ڲ�ͬ��Ļ�ϵ�Ч����
        final float scale = 1.0F;				// �ʵ��ı����ű�����Ӧ�Լ��ĵ�����Ļ
        
        config.width = (int) (pixWidth * scale);         	// ���ڿ��
        config.height = (int) ((pixWidth / ratio) * scale);	// ���ڸ߶�
        
        config.resizable = false;				// ��������Ϊ��С���ɸı�
        
        new LwjglApplication(new MainGame(), config);
	}

}