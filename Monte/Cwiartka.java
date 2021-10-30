package Monte;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cwiartka extends Thread {
    double Xmin, xmax;
    double Ymin, ymax;
    List<Punkt> punkty = new ArrayList<>();
    Random rand = new Random();
    int nalezy=0;
    int nienalezy=0;

    public Cwiartka(double xmin, double xmax, double ymin, double ymax) {
        this.Xmin = xmin;
        this.xmax = xmax;
        this.Ymin = ymin;
        this.ymax = ymax;
    }


    @Override
    public void run() {
        for(int x= 0;x<10000000;x++){
        punkty.add(new Punkt(rand.nextDouble()*((xmax-Xmin)+Xmin),rand.nextDouble()*((ymax-Ymin)+Ymin)));
        }
        for(Punkt punkt : punkty){
            if(Math.sqrt(Math.pow(punkt.x,2)+Math.pow(punkt.y,2))<=xmax-Xmin){
                nalezy++;
            }
            else {
                nienalezy++;
            }
        }




    }
}
