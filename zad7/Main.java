package zad7;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

import static zad7.Filozof.MAX;
import static zad7.Filozof.widelec;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Podaj ilość filozofów 2-100 ");
        Filozof.setMAX(scan.nextInt());
        widelec = new Semaphore[MAX];
        System.out.println("Podaj typ programu 1-3");
        Filozof.setType(scan.nextInt());


        for ( int i =0; i<MAX; i++) {
            widelec [ i ]=new Semaphore( 1 ) ;
        }
        for ( int i =0; i<MAX; i++) {
            new Filozof(i).start();
        }
    }

}

