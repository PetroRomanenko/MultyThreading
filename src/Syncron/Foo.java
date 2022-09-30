package Syncron;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foo extends Thread {
    public int threadNumber;

    Foo (){
        this.threadNumber=1;
    }


    synchronized public void   first(Thread thread) throws InterruptedException {

        while (threadNumber!=1){
            wait();
        }
        System.out.println("First");
        threadNumber++;
        notifyAll();

    }

    synchronized public void second(Thread thread) throws InterruptedException {
        while (threadNumber!=2){
            wait();
        }
        System.out.println( "Second");
        threadNumber++;
        notifyAll();

    }

    synchronized public void third(Thread thread) throws InterruptedException {
        while (threadNumber!=3){
            wait();
        }
        System.out.println( "Third");
        threadNumber++;
        notifyAll();



    }

//    public void first(Runnable r) { print("first"); }
//    public void second(Runnable r) { print("second"); }
//    public void third(Runnable r) { print("third"); }
}
