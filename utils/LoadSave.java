package utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import MainGame.Game;

public class LoadSave {

    public static final String PLAYER_ATLAS = "C:\\Users\\pablo\\OneDrive\\Escritorio\\Portfolio\\PlatformerTutorial\\resource\\player_sprites.png";
    public static final String LEVEL_ATLAS = "C:\\Users\\pablo\\OneDrive\\Escritorio\\Portfolio\\PlatformerTutorial\\resource\\outside_sprites.png";
    public static final String LEVEL_ONE_DATA = "C:\\Users\\pablo\\OneDrive\\Escritorio\\Portfolio\\PlatformerTutorial\\resource\\level_one_data.png";
    public static final String MENU_BUTTONS = "C:\\Users\\pablo\\OneDrive\\Escritorio\\Portfolio\\PlatformerTutorial\\resource\\button_atlas.png";
    public static final String MENU_BACKGROUND = "C:\\Users\\pablo\\OneDrive\\Escritorio\\Portfolio\\PlatformerTutorial\\resource\\menu_background.png";
    public static final String PAUSE_BACKGROUND = "C:\\Users\\pablo\\OneDrive\\Escritorio\\Portfolio\\PlatformerTutorial\\resource\\pause_menu.png";
    public static final String SOUND_BUTTONS = "C:\\Users\\pablo\\OneDrive\\Escritorio\\Portfolio\\PlatformerTutorial\\resource\\sound_button.png";
    public static final String URM_BUTTONS = "C:\\Users\\pablo\\OneDrive\\Escritorio\\Portfolio\\PlatformerTutorial\\resource\\urm_buttons.png";
    public static final String VOLUME_BUTTONS = "C:\\Users\\pablo\\OneDrive\\Escritorio\\Portfolio\\PlatformerTutorial\\resource\\volume_buttons.png";
        public static final String MENU_BACKGROUND_IMG = "C:\\Users\\pablo\\OneDrive\\Escritorio\\Portfolio\\PlatformerTutorial\\resource\\background_menu.png";


    public static BufferedImage GetSpriteAtlas(String fileName) {
        BufferedImage img = null;
        File imageFile = new File("/" + fileName);

        try {
            img = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return img;
    }

    public static int[][] GetLevelData() {
        int[][] lvlData = new int[Game.TILES_IN_HEIGHT][Game.TILES_IN_WIDTH];
        BufferedImage img = GetSpriteAtlas(LEVEL_ONE_DATA);

        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getRed();
                if (value >= 48)
                    value = 0;
                lvlData[j][i] = value;
            }
        return lvlData;
    }
}
