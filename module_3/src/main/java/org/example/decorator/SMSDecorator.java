package org.example.decorator;

public class SMSDecorator extends BaseNotifierDecorator{
    public SMSDecorator(Notifier wrappedNotifier) {
        super(wrappedNotifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendMessage(message);
    }

    private void sendMessage(String message) {
        System.out.println("[SMS]: " + message);
    }
}
