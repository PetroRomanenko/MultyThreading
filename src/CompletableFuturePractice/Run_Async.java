package CompletableFuturePractice;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Run_Async {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable(){

            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("я буду работать в отдельном потоке, а не в главном");
            }
        });
        CompletableFuture<Void> futureLambda = CompletableFuture.runAsync(()->{


                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("я буду работать в отдельном потоке, а не в главном, с Ћ€мбда");

        });
        //блокировка и ожидание завершение Future
        future.get();
        futureLambda.get();

    }
}
