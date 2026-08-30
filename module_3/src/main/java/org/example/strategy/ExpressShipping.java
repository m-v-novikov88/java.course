package org.example.strategy;

public class ExpressShipping implements ShippingStrategy {
    private static final double USD_COST_PER_KILO = 5.0;
    private static final double USD_COST_PER_KM = 0.5;
    private static final double USD_ADDITIONAL_FEE = 25.0;

    @Override
    public double calculateTheCost(double weight, double distance) {
        return (weight * USD_COST_PER_KILO) + (distance * USD_COST_PER_KM) + USD_ADDITIONAL_FEE;
    }
}
