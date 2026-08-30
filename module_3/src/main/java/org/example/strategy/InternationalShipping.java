package org.example.strategy;

public class InternationalShipping implements ShippingStrategy {
    private static final double USD_COST_PER_KILO = 10.0;
    private static final double USD_COST_PER_KM = 1.8;
    private static final double USD_ADDITIONAL_FEE = 110.0;

    @Override
    public double calculateTheCost(double weight, double distance) {
        return (weight * USD_COST_PER_KILO) + (distance * USD_COST_PER_KM) + USD_ADDITIONAL_FEE;
    }
}
