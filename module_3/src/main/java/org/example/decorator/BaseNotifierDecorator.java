package org.example.decorator;

public abstract class BaseNotifierDecorator implements Notifier {
    private final Notifier wrappedNotifier;

    public BaseNotifierDecorator(Notifier wrappedNotifier) {
        this.wrappedNotifier = wrappedNotifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}
