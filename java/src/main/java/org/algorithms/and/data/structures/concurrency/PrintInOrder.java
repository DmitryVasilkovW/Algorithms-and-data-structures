package org.algorithms.and.data.structures.concurrency;
// https://leetcode.com/problems/print-in-order/description/

public class PrintInOrder {
    private volatile boolean firstDone = false;
    private volatile boolean secondDone = false;

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstDone = true;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        while (!firstDone) {

        }

        printSecond.run();
        secondDone = true;
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        while (!firstDone || !secondDone) {

        }

        printThird.run();
    }
}
