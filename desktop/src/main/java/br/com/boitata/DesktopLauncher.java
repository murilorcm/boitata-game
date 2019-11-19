package br.com.boitata;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();

//		cfg.addIcon("snake.png", Files.FileType.Internal);

		System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
		cfg.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
		cfg.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;

		new LwjglApplication(new BoitataGame() , cfg);
	}
}
