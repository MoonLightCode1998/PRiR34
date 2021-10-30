package zad6;

import Monte.Punkt;
import org.w3c.dom.css.RGBColor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Julia extends  Thread{
   int Xmin, xmax;
    int Ymin, ymax;
    Zespolona c = new Zespolona(-0.123,0.745);


    public Julia(int xmin, int xmax, int ymin, int ymax) {
        this.Xmin = xmin;
        this.xmax = xmax;
        this.Ymin = ymin;
        this.ymax = ymax;
    }


    public  void jula(double X0, double Y0, double X1, double Y1, int ITER, int width, int height, Zespolona z) {
        double dy = (Y1 - Y0) / height;
        double dx = (X1 - X0) / width;
        int red=0;
        int green=0;
        int blue=0;
        Zespolona p = new Zespolona();
        for (int x = Xmin; x < xmax; x++) {

            for (int y = Ymin; y < ymax; y++) {
                int k = 0;
                p.re = x * dx + X0;
                p.im = y * dy + Y0;

                while (k < ITER && (Math.pow(p.re, 2) + Math.pow(p.im, 2)) < 4) {

                    p.kwadrat();
                    p.suma(z);
                    k++;

                }



                if(k<50){
                    red = 255;
                    green = 255;
                    blue = 0;
                }
                if(k>50&&k<100){
                    red = 60;
                    green = 60;
                    blue = 60;
                }
                else
                if(k>100){
                    red = 0;
                    green = 0;
                    blue = 0;
                }


                Color color = new Color(red,green,blue);
                Main.image.setRGB(x,y,color.getRGB());

            }
        }
    }

    @Override
    public void run() {
        jula(-1.5,-1.25,1.5,1.25,256,3000,3000,c);
    }
}
