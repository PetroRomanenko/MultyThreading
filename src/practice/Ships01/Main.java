package practice.Ships01;

import practice.Ships01.ships.types.Type;
import practice.Ships01.tasks.PierLoader;
import practice.Ships01.tasks.ShipGenerator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Available number of cores: "+Runtime.getRuntime().availableProcessors());

        Tunnel tunnel=new Tunnel();
        ShipGenerator shipGenerator = new ShipGenerator(tunnel,10);


        PierLoader pierLoader1 = new PierLoader(tunnel, Type.DRESS);
        PierLoader pierLoader2 = new PierLoader(tunnel, Type.BANANA);
        PierLoader pierLoader3 = new PierLoader(tunnel, Type.MEAL);

        ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        es.execute(shipGenerator);
        es.execute(pierLoader1);
        es.execute(pierLoader2);
        es.execute(pierLoader3);

        es.shutdown();

    }
}
