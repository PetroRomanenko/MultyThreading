package practice.Ships01.tasks;

import practice.Ships01.Tunnel;
import practice.Ships01.ships.Ship;
import practice.Ships01.ships.types.Size;
import practice.Ships01.ships.types.Type;

import java.util.Random;

public class ShipGenerator implements Runnable{
    private Tunnel tunnel;
    private int shipCount;

    public ShipGenerator(Tunnel tunnel,int shipCount){
        this.tunnel=tunnel;
        this.shipCount=shipCount;
    }

    @Override
    public void run() {
        int count =0;
        while (count<shipCount){
            Thread.currentThread().setName(" Generator ship");
            count++;
            tunnel.add(new Ship(getRandomSize(), getRandomType()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Size getRandomSize() {
        Random random = new Random();
        return Size.values()[random.nextInt(Size.values().length)];

    }

    private Type getRandomType() {
        Random random = new Random();
        return Type.values()[random.nextInt(Type.values().length)];

    }
}
