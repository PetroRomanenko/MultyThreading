package Test01;

import javax.swing.plaf.TableHeaderUI;

public class MainTest {
    public static void main(String[] args) throws InterruptedException {
//        new  Thread(new XRunnable()).start();
//         Thread ref = new Thread();
//        System.out.println(Thread.activeCount());

        for (int i = 0; i < 1000; i++) {
            Thread.sleep(250);
            System.out.println("main: "+i);
        }

//        Thread.sleep(1000);
//        tr.interrupt();
    }
}
