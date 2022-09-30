package Test01;

public class XRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException ignore) {/*NOP*/;}
            System.out.println("run: "+i);
        }
    }
}
