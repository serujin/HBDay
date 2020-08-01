package com.seruji.hb.desktop;

import java.awt.Toolkit;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.seruji.hb.main.HappyBirthdayMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Happy Birthday Lorena!!!";
		config.width = 1280;
		config.height = 720;
		config.x = Toolkit.getDefaultToolkit().getScreenSize().width/2 - (1280/2);
		config.y = Toolkit.getDefaultToolkit().getScreenSize().height/2 - (720/2);
		new LwjglApplication(new HappyBirthdayMain(), config);
	}
}
