package ru.cft.focusstart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;

public class MultiThreadFabric {
    public final static int S = 5;
    public final static int N = 5;
    public final static int TN = 1000;
    public final static int M = 3;
    public final static int TM = 800;

    public static ArrayBlockingQueue<Resourse> storage = new ArrayBlockingQueue<Resourse>(S);

    private static final Logger log = LoggerFactory.getLogger(MultiThreadFabric.class);

    public static void main(String[] args) {
        Runnable taskFabric = () -> {
            try {
                while (true) {
                    Thread.sleep(TN);
                    Resourse res;
                    synchronized (MultiThreadFabric.class) {
                        res = new Resourse();
                    }
                    log.info("Resource №{} was create", res.getId());
                    storage.put(res);
                    log.info("Resource №{} push to storage", res.getId());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable taskConsumers = () -> {
            try {
                while (true) {
                    Resourse res = storage.take();
                    log.info("Resource №{} take from storage", res.getId());
                    Thread.sleep(TM);
                    log.info("Resource №{} was consumed", res.getId());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread[] fabrics = new Thread[N];
        for (int i = 0; i < N; i++) {
            fabrics[i] = new Thread(taskFabric, "Fabric №" + (i + 1));
            fabrics[i].start();
        }
        Thread[] consumers = new Thread[M];
        for (int i = 0; i < M; i++) {
            consumers[i] = new Thread(taskConsumers, "Consumer №" + (i + 1));
            consumers[i].start();
        }
    }
}
