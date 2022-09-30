package RentrantLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Foo {
   private Lock lock = new ReentrantLock();
    private int threadNumber;
    private Condition condition =lock.newCondition();
    public Foo() {
        this.threadNumber=1;

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            // printFirst.run() outputs "first". Do not change or remove this line.
            System.out.println("First");
            this.threadNumber++;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (this.threadNumber!=2){
                condition.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            System.out.println("Second");
            this.threadNumber++;
            condition.signalAll();
        }finally {
            lock.unlock();

        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (this.threadNumber!=3){
                condition.await();
            }
        // printThird.run() outputs "third". Do not change or remove this line.
        System.out.println("Third");
            condition.signalAll();
        }finally {
            lock.unlock();

        }
    }
}