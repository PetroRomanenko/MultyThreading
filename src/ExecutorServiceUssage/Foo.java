package ExecutorServiceUssage;

import java.util.concurrent.Semaphore;

public class Foo  implements Runnable{
    Semaphore semaphore1 = new Semaphore(1);
    Semaphore semaphore2 = new Semaphore(1);
    public void first() {
        System.out.println("First");
    }

    public void second() {
        System.out.println("Second");
    }

    public void third() {
        System.out.println("Third");
    }

    @Override
    public void run() {
        first();
        second();
        third();

    }

//    public void first(Runnable r) { print("first"); }
//    public void second(Runnable r) { print("second"); }
//    public void third(Runnable r) { print("third"); }
}
