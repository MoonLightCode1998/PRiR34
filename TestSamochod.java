import java.util.ArrayList;
import java.util.List;

public class TestSamochod {
    public static void main(String[] args) {
        List<Samochod> aaa = new ArrayList<>();
        aaa.add(new Samochod("Bi665", 1000));
        aaa.add(new Samochod("WZK665", 1000));
        aaa.add(new Samochod("AMD165", 1000));


        for (Samochod auto : aaa){
            auto.start();
        }
        while (true){
            for (Samochod auto : aaa){
                if(auto.paliwo<990){
                    auto.interrupt();
                    auto.tankowanie(500);
                    auto.start();
                }
            }
        }



    }
}
