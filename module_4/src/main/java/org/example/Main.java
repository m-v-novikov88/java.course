package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final String SCANNER_INTRO = """
            Choose between examples:
            1. Run Deadlock example.
            2. Run Livelock example.
            3. Run example about the series with queued 1s and 2s.
            """;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(SCANNER_INTRO);

            int choiceNum = scanner.nextInt();

            runChosenExample(choiceNum);
        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println("Try again with correct number.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runChosenExample(int num) throws IllegalArgumentException {
        if (num < 1 || num > 3) {
            throw new IllegalArgumentException();
        }

        switch (num) {
            case 1 -> Deadlock.runExample();
            case 2 -> Livelock.runExample();
            case 3 -> OnesAndTwosSemaphore.runExample();
        }
    }
}