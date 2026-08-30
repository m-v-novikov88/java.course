package org.example.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ShippingOrder {
    private final double weight;
    private final double distance;
    private ShippingStrategy shippingStrategy;
    private static final int TOTAL_COST_DECIMAL_SCALE = 2;

    public ShippingOrder(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public void setShippingStrategy(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public double calculateTotalShippingCost() {
        if (shippingStrategy == null) {
            throw new IllegalStateException("Choose shipping strategy");
        }

        double theShippingCost = shippingStrategy.calculateTheCost(weight, distance);
        return new BigDecimal(theShippingCost).setScale(TOTAL_COST_DECIMAL_SCALE, RoundingMode.CEILING).doubleValue();
    }
}
