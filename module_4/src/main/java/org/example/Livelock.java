package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Livelock {
    private static final long HALF_A_SECOND_PAUSE_IN_MS = 500;

    public static void runExample () {
        final Lock fork = new ReentrantLock();
        final Lock knife = new ReentrantLock();

        Thread personA = new Thread(() -> {
            while (true) {
                try {
                    fork.lock();
                    System.out.println("Person A takes a Fork");
                    Thread.sleep(HALF_A_SECOND_PAUSE_IN_MS);

                    System.out.println("And now Person A trying to take a Knife");
                    if (knife.tryLock()) {
                        System.out.println("Person A now ready for LUNCH! CHEERS");
                        knife.unlock();
                    } else {
                        System.out.println("Person A failed to take a Knife. Giving up the Fork...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    fork.unlock();
                }
            }
        });

        Thread personB = new Thread(() -> {
            while (true) {
                try {
                    knife.lock();
                    System.out.println("Person B takes a Knife");
                    Thread.sleep(HALF_A_SECOND_PAUSE_IN_MS);

                    System.out.println("And now Person B trying to take a Fork");
                    if (fork.tryLock()) {
                        System.out.println("Person B now ready for LUNCH! CHEERS");
                        fork.unlock();
                    } else {
                        System.out.println("Person B failed to take a Fork. Giving up the Knife...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    knife.unlock();
                }
            }
        });

        personA.start();
        personB.start();
    }
}

