package ru.dediev.threadApp.homework;

import java.util.concurrent.CompletableFuture;

public class ThreadExample {
    public static void main(String [] args) {
        Foo foo = new Foo();

        CompletableFuture.runAsync(() -> {
                foo.first(new Thread());
        });

        CompletableFuture.runAsync(() -> {
                foo.second(new Thread());
        });

        CompletableFuture.runAsync(() -> {
                foo.third(new Thread());
        });
    }
}
