package org.example.strategy;

public class StandardShipping implements ShippingStrategy {
    private static final double USD_COST_PER_KILO = 3.0;
    private static final double USD_COST_PER_KM = 0.18;

    @Override
    public double calculateTheCost(double weight, double distance) {
        return (weight * USD_COST_PER_KILO) + (distance * USD_COST_PER_KM);
    }
}
