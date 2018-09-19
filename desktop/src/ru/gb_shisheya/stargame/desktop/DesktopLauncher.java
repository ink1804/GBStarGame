package ru.gb_shisheya.stargame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.gb_shisheya.stargame.App;
import ru.gb_shisheya.stargame.Star2DGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Star2DGame(), config);
		config.width = 512;
		config.height = 512;
	}
}
