package zad7;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Filozof extends Thread {


    static int MAX ;
    public static Semaphore[] widelec ;
    int mojNum;
    static int type=1;
    Random losuj = new Random();

    public Filozof(int nr) {
        mojNum = nr;
    }

    public void run() {
        if (type == 1) {
            while (true) {
// myslenie
                System.out.println("Mysle ¦ " + mojNum);
                try {
                    Thread.sleep((long) (5000 * Math.random()));
                } catch (InterruptedException e) {
                }
                if (mojNum == 0) {
                    widelec[(mojNum + 1) % MAX].acquireUninterruptibly();
                    widelec[mojNum].acquireUninterruptibly();
                } else {
                    widelec[mojNum].acquireUninterruptibly();
                    widelec[(mojNum + 1) % MAX].acquireUninterruptibly();
                }
// jedzenie
                System.out.println("Zaczyna jesc " + mojNum);
                try {
                    Thread.sleep((long) (3000 * Math.random()));
                } catch (InterruptedException e) {
                }
                System.out.println("Konczy jesc " + mojNum);
                widelec[mojNum].release();
                widelec[(mojNum + 1) % MAX].release();
            }
        }else if(type==2){
            while ( true ) {
// myslenie
                System.out.println ( "Mysle ¦ " + mojNum) ;
                try {
                    Thread.sleep ( ( long ) (5000 * Math.random( ) ) ) ;
                } catch ( InterruptedException e ) {
                }
                int strona = losuj.nextInt ( 2 ) ;
                boolean podnioslDwaWidelce = false ;
                do {
                    if ( strona == 0) {
                        widelec [mojNum].acquireUninterruptibly ( ) ;
                        if( ! ( widelec [ (mojNum+1)%MAX].tryAcquire ( ) ) ) {
                            widelec[mojNum].release ( ) ;
                        } else {
                            podnioslDwaWidelce = true ;
                        }
                    } else {
                        widelec[(mojNum+1)%MAX].acquireUninterruptibly ( ) ;
                        if ( ! (widelec[mojNum].tryAcquire ( ) ) ) {
                            widelec[(mojNum+1)%MAX].release ( ) ;
                        } else {
                            podnioslDwaWidelce = true ;
                        }
                    }
                } while ( podnioslDwaWidelce == false ) ;
                System.out.println ( "Zaczyna jesc "+mojNum) ;
                try {
                    Thread.sleep ( ( long ) (3000 * Math.random( ) ) ) ;
                } catch ( InterruptedException e ) {
                }
                System.out.println ( "Konczy jesc "+mojNum) ;
                widelec [mojNum].release ( ) ;
                widelec [ (mojNum+1)%MAX].release ( ) ;
            }
        }else{
            while ( true ) {
// myslenie
                System.out.println ( "Mysle ¦ " + mojNum) ;
                try {
                    Thread.sleep ( ( long ) (5000 * Math.random( ) ) ) ;
                } catch ( InterruptedException e ) {
                }
                if (mojNum == 0) {
                    widelec [ (mojNum+1)%MAX].acquireUninterruptibly ( ) ;
                    widelec [mojNum].acquireUninterruptibly ( ) ;
                } else {
                    widelec [mojNum].acquireUninterruptibly ( ) ;
                    widelec [ (mojNum+1)%MAX].acquireUninterruptibly ( ) ;
                }
// jedzenie
                System.out.println ( "Zaczyna jesc "+mojNum) ;
                try {
                    Thread.sleep ( ( long ) (3000 * Math.random( ) ) ) ;
                } catch ( InterruptedException e ) {
                }
                System.out.println ( "Konczy jesc "+mojNum) ;
                widelec [mojNum].release ( ) ;
                widelec [ (mojNum+1)%MAX].release ( ) ;
            }

        }

    }

    public static void setMAX(int MAX) {
        if(MAX>=2&&MAX<=100)
        Filozof.MAX = MAX;
        else System.out.println("NU zła liczba od 2 do 100 ma być ");
    }

    public static void setType(int type) {
        if(type>=1&&type<=3)
        Filozof.type = type;
        else System.out.println("NU zła liczba od 1 do 3 ma być ");
    }
}

