package org.example.decorator;

public class TelegramDecorator extends BaseNotifierDecorator {
    public TelegramDecorator(Notifier wrappedNotifier) {
        super(wrappedNotifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendMessage(message);
    }

    private void sendMessage(String message) {
        System.out.println("[TELEGRAM]: " + message);
    }
}
