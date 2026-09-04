package org.example;

import java.util.concurrent.Semaphore;

public class OnesAndTwosSemaphore {
    private static final long HALF_A_SECOND_PAUSE_IN_MS = 500;
    private static final String ONE_SIGN = "1";
    private static final String TWO_SIGN = "2";

    public static void runExample () {
        final Semaphore first = new Semaphore(1);
        final Semaphore second = new Semaphore(0);

        new Thread(() -> {
            try {
                while (true) {
                    first.acquire();
                    System.out.println(ONE_SIGN);
                    Thread.sleep(HALF_A_SECOND_PAUSE_IN_MS);
                    second.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    second.acquire();
                    System.out.println(TWO_SIGN);
                    Thread.sleep(HALF_A_SECOND_PAUSE_IN_MS);
                    first.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

