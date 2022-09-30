package Syncron;/*Задание 1
        Дан класс:
public class Foo {
    public void first(Runnable r) { print("first"); }
    public void second(Runnable r) { print("second"); }
    public void third(Runnable r) { print("third"); }
}
    Один и тот же экземпляр данного класса будет вызван 3мя разными потоками.
     Поток А - будет вызывать метод first(). Поток B - second(). Поток С - third().
        Необходимо реализовать механизм и изменить программу таким образом,
        что методы класса Foo будут вызваны в правильном порядке.
        Пример:
        Вывод: "firstsecondthird"
        Мы не знаем, в каком порядке будут вызваны методы, но должны гарантировать порядок.

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
