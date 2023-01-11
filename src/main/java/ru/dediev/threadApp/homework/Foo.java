package ru.dediev.threadApp.homework;

import java.util.concurrent.Semaphore;

public class Foo {

    private final Semaphore firstSemaphore = new Semaphore(0);
    private final Semaphore secondSemaphore = new Semaphore(0);

    public void first(Runnable r) {
        r.run();
        System.out.print("first");
        firstSemaphore.release();
    }

    public void second(Runnable r) {
        try {
            firstSemaphore.acquire();
            r.run();
            System.out.print("second");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            secondSemaphore.release();
        }
    }

    public void third(Runnable r) {
        try {
            secondSemaphore.acquire();
            r.run();
            System.out.print("third");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

