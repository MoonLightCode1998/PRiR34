package zad5;

import Monte.Punkt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cwiartka extends Thread{
    int Xmin, xmax;
    int Ymin, ymax;
    List<Punkt> punkty = new ArrayList<>();
    Random rand = new Random();
    int nalezy=0;
    int nienalezy=0;

    public Cwiartka(int xmin, int xmax, int ymin, int ymax) {
        this.Xmin = xmin;
        this.xmax = xmax;
        this.Ymin = ymin;
        this.ymax = ymax;
    }
    @Override
    public void run() {
        for (int x = Xmin; x < xmax; x++) {
            for (int y = Ymin; y <ymax; y++) {
                Color c = new Color(Main.image.getRGB(x, y));
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();

                if (255 - red >= 0 && 255 - red <= 255) red = 255 - red;
                if (255 - green >= 0 && 255 - green <= 255) green = 255 - green;
                if (255 - blue >= 0 && 255 - blue <= 255) blue = 255 - blue;
                Color newColor = new Color(red, green, blue);
                Main.image.setRGB(x, y, newColor.getRGB());
            }
        }

    }
}
