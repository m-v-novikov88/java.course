package org.example.decorator;

public class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("[EMAIL]: " + message);
    }
}
