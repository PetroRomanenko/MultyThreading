package Syncron;/*������� 1
        ��� �����:
public class Foo {
    public void first(Runnable r) { print("first"); }
    public void second(Runnable r) { print("second"); }
    public void third(Runnable r) { print("third"); }
}
    ���� � ��� �� ��������� ������� ������ ����� ������ 3�� ������� ��������.
     ����� � - ����� �������� ����� first(). ����� B - second(). ����� � - third().
        ���������� ����������� �������� � �������� ��������� ����� �������,
        ��� ������ ������ Foo ����� ������� � ���������� �������.
        ������:
        �����: "firstsecondthird"
        �� �� �����, � ����� ������� ����� ������� ������, �� ������ ������������� �������.

 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.util.concurrent.CompletableFuture.runAsync;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Foo foo = new Foo();

       CompletableFuture completableFuture2= runAsync(()->{
           try {
                foo.second(new Thread());
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       });
        CompletableFuture completableFuture1= runAsync(()->{
            try {
                 foo.first(new Thread());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture completableFuture3= runAsync(()->{
            try {
                foo.third(new Thread());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


    }

}
