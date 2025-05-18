package org.algorithms.and.data.structures.concurrency;
// https://leetcode.com/problems/building-h2o/description/

import java.util.concurrent.Semaphore;

public class BuildingH2O {
    private final Semaphore hSemaphore = new Semaphore(2);
    private final Semaphore oSemaphore = new Semaphore(0);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        hSemaphore.acquire();
        releaseHydrogen.run();
        oSemaphore.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        oSemaphore.acquire(2);
        releaseOxygen.run();
        hSemaphore.release(2);
    }
}
