public class Samochod extends Thread{
    private String nrRej;
    private int pojZbiornika;
    public int paliwo;
    public Samochod (String nr, int _pojZbiornika){
        this.nrRej=nr;
        this.pojZbiornika=_pojZbiornika;
        paliwo=_pojZbiornika;
    }
    public void tankowanie (int _paliwo){
        paliwo+=_paliwo;
    }


    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(1000);
            }catch (Exception e){e.printStackTrace();}
            this.paliwo-=1;

            System.out.println(this.toString());
        }
    }

    @Override
    public String toString() {
        return this.nrRej + "--->"+this.paliwo;
    }
}
