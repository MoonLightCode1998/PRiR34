package zad6;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static BufferedImage image;
    static int width;
    static  int height;


    public static void setImage(String path) {
        try {
            File input = new File(path);
            Main.image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        setImage("C:/Users/jbond/Desktop/Dopa.png");
        Julia ce = new Julia(0, image.getWidth()/2,0,image.getHeight()/2);
        Julia ce2 = new Julia(image.getWidth()/2, image.getWidth(),image.getHeight()/2,image.getHeight());
       Julia ce3= new Julia(image.getWidth()/2, image.getWidth(),0,image.getHeight()/2);
        Julia ce4 = new Julia(0, image.getWidth()/2,image.getHeight()/2,image.getHeight());
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
            File ouptut = new File("grayscale2.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {

        }
    }
}
