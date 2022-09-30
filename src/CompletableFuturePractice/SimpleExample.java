package CompletableFuturePractice;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SimpleExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        String result  = completableFuture.get();
        //get() ��������� ����� ��������
        //��� ���������� completableFuture ������������ ����� complete()
        completableFuture.complete("��������� Future");
    }
}
