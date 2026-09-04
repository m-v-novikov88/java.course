package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {
    private static final long HALF_A_SECOND_IN_MS = 500;

    public static void runExample () {
        final Lock fork = new ReentrantLock();
        final Lock knife = new ReentrantLock();

        Thread personA = new Thread(() -> {
            try {
                fork.lock();
                System.out.println("Person A takes a Fork");
                Thread.sleep(HALF_A_SECOND_IN_MS);

                System.out.println("And now Person A trying to take a Knife");
                knife.lock();

                System.out.println("Person A now ready for LUNCH! CHEERS");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread personB = new Thread(() -> {
            try {
                knife.lock();
                System.out.println("Person B takes a Knife");
                Thread.sleep(HALF_A_SECOND_IN_MS);

                System.out.println("And now Person B trying to take a Fork");
                fork.lock();

                System.out.println("Person B now ready for LUNCH! CHEERS");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        personA.start();
        personB.start();
    }
}
