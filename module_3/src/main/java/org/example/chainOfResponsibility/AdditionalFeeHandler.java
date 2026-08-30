package org.example.chainOfResponsibility;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AdditionalFeeHandler extends OrderStepHandler {
    private static final int PRICE_MAX_SCALE = 2;
    private static final double FEE_SIZE = 1.20;
    @Override
    protected boolean process(ThingsItemOrder itemOrder) {
        double priceAfterFee = new BigDecimal(itemOrder.getBasePrice() * FEE_SIZE).setScale(PRICE_MAX_SCALE, RoundingMode.CEILING).doubleValue();
        itemOrder.setFinalPrice(priceAfterFee);
        return true;
    }

    @Override
    protected void rollback(ThingsItemOrder itemOrder) {
        itemOrder.setFinalPrice(itemOrder.getBasePrice());
    }
}
