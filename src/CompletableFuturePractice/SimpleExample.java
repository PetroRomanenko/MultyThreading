package CompletableFuturePractice;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SimpleExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        String result  = completableFuture.get();
        //get() блокирует поток навсегда
        //для заверщения completableFuture использовать метод complete()
        completableFuture.complete("Результат Future");
    }
}
