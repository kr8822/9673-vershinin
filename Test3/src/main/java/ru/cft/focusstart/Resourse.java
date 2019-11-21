package ru.cft.focusstart;


public class Resourse {
    private int id;
    private static int numberId = 0;

    Resourse() {
        this.id = generateId();
    }

    private synchronized int generateId() {
        return numberId++;
    }

    public int getId() {
        return this.id;
    }
}
