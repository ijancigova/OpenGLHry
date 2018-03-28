package sk.uniza.fri.my.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import sk.uniza.fri.my.MyGdxGame;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Moja prva super hra";
        config.width = 800;
        config.height = 480;
        config.resizable = false;
        config.fullscreen = false;
        new LwjglApplication(new MyGdxGame(), config);
    }
}
