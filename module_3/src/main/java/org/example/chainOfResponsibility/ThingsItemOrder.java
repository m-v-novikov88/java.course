package org.example.chainOfResponsibility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThingsItemOrder {
    private final String orderId;
    private final double basePrice;
    private final List<String> orderLogs = new ArrayList<>();
    private double finalPrice;
    private boolean isOrderFailed = false;

    public ThingsItemOrder(String orderId, double basePrice) {
        this.orderId = orderId;
        this.basePrice = basePrice;
        this.finalPrice = basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public List<String> getOrderLogs() {
        return Collections.unmodifiableList(orderLogs);
    }

    public void logOrderHandler(String message) {
        orderLogs.add(message);
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public boolean isOrderFailed() {
        return isOrderFailed;
    }

    public void makeOrderFailed() {
        isOrderFailed = true;
    }

    @Override
    public String toString() {
        return "id: \"" + orderId + "\", basePrice: " + basePrice + ", finalPrice: " + finalPrice + ", isCompleted: " + !isOrderFailed;
    }
}
