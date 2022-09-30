import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foo extends Thread {
    Semaphore semaphore1 = new Semaphore(1);
    Semaphore semaphore2 = new Semaphore(1);
    Lock lock= new ReentrantLock(true);
    CountDownLatch latchFirst = new CountDownLatch(1);
    CountDownLatch latchSecond = new CountDownLatch(1);


    public void   first(Thread thread) throws InterruptedException {

        latchFirst.countDown();
        System.out.println("First");

    }

    public void second(Thread thread) throws InterruptedException {
        latchFirst.await();
        System.out.println( "Second");
        latchSecond.countDown();
    }

    public void third(Thread thread) throws InterruptedException {
        latchSecond.await();
        System.out.println( "Third");

    }

//    public void first(Runnable r) { print("first"); }
//    public void second(Runnable r) { print("second"); }
//    public void third(Runnable r) { print("third"); }
}
