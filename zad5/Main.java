package zad5;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static BufferedImage image;
    public static void main(String[] args) {

         try {
             File input = new File("E:/Edukacja/spring/PRiR234/src/zad5/cos.png");
             image = ImageIO.read(input);
         }catch (Exception e){}

         Cwiartka ce = new Cwiartka(0, image.getWidth()/2,0,image.getHeight()/2);
        Cwiartka ce2 = new Cwiartka(image.getWidth()/2, image.getWidth(),image.getHeight()/2,image.getHeight());
        Cwiartka ce3= new Cwiartka(image.getWidth()/2, image.getWidth(),0,image.getHeight()/2);
        Cwiartka ce4 = new Cwiartka(0, image.getWidth()/2,image.getHeight()/2,image.getHeight());
         ce.start();
         ce2.start();
         ce3.start();
         ce4.start();
         try {
             ce.join();
             ce2.join();
             ce3.join();
             ce4.join();

         }catch (Exception e){}
        try {
            File ouptut = new File("grayscale.png");
            ImageIO.write(Main.image, "png", ouptut);
        } catch (Exception e) {

        }
    }
}
