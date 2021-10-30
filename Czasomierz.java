public class Czasomierz extends Thread{

    int sekunda=0;
    int minuta=59;
    int godzina=0;

    @Override
    public void run() {
        while (true) {
            if (sekunda < 60) {

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e.getStackTrace());
                }
                sekunda++;

            }
            if (minuta < 60&&sekunda==60) {
                sekunda = 0;
                minuta++;
            }
            if (godzina < 60&&minuta==60) {
                minuta = 0;
                godzina++;
            }
            if(godzina==24){
                minuta = 0;
                godzina = 0;
            }
            System.out.println(this.toString());
        }
    }

    @Override
    public String toString() {
        return godzina+":"+minuta+":"+sekunda;
    }
}
