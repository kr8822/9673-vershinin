package ru.cft.focusstart;

import java.util.concurrent.atomic.AtomicInteger;

public class Resourse {
    private int id;
    private static int numberId = 0;

    Resourse() {
        this.id = numberId;
        this.incriseNumberId();

    }

    private synchronized void incriseNumberId() {
        numberId++;
    }

    public int getId() {
        return this.id;
    }
}
