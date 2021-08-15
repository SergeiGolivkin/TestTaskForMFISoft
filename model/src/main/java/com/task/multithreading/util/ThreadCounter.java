package com.task.multithreading.util;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadCounter {

    private static volatile ThreadCounter instance;

    public static ThreadCounter getInstance(){
        if (instance == null){
            synchronized (ThreadCounter.class){
                if (instance == null)
                    instance = new ThreadCounter();
            }
        }
        return instance;
    }

    private final AtomicInteger actualCount = new AtomicInteger();

    private ThreadCounter(){
    }

    public AtomicInteger getActualCount() {
        return actualCount;
    }

    public void incrementActualCount(){
        actualCount.incrementAndGet();
    }
}
