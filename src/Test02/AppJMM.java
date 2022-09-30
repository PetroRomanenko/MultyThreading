package Test02;

public class AppJMM {
    static volatile boolean ready = false;
    static int data = 0;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                sleep(1000L);
                data=1;
                ready= true;
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!ready);
                System.out.println(data);
            }
        }).start();
    }
    private static void sleep(Long time){
        try{
            Thread.sleep(time);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }
}
