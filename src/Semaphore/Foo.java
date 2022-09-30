package Semaphore;

import java.util.concurrent.Semaphore;

public class Foo extends Thread {
    private Semaphore semaphoreOne = new Semaphore(0);
    private Semaphore semaphoreTwo = new Semaphore(0);


    Foo (){

    }


     public void   first(Thread thread) throws InterruptedException {


        System.out.println("First");
        semaphoreOne.release();


    }

     public void second(Thread thread) throws InterruptedException {
        semaphoreOne.acquire();
        System.out.println( "Second");
        semaphoreTwo.release();


    }

     public void third(Thread thread) throws InterruptedException {
        semaphoreTwo.acquire();
        System.out.println( "Third");
            }

//    public void first(Runnable r) { print("first"); }
//    public void second(Runnable r) { print("second"); }
//    public void third(Runnable r) { print("third"); }
}
