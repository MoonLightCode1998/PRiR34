package Monte;

import java.util.ArrayList;
import java.util.List;

public class MonteCarlo {
    private double r;
    private List<Cwiartka> cw = new ArrayList<>();
    private int dobre=0;
    private int zle=0;

    public MonteCarlo(double r) {
        this.r = r;
        cw.add(new Cwiartka(-r,0,0,r));
        cw.add(new Cwiartka( -r,0,0,-r));
        cw.add(new Cwiartka(0,r,0,r));
        cw.add(new Cwiartka(0,r,0,-r));
    }


    public void exe() {
        for (Cwiartka cw : cw) {
            cw.start();
            try {
                cw.join();
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }

        }

        for(Cwiartka cw:cw){
            dobre+=cw.nalezy;
            zle+=cw.nienalezy;
        }
        System.out.println(2*r*2*r*((double)dobre/(double)(dobre+zle)));

    }
}
