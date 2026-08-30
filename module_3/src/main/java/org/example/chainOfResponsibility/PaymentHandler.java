package org.example.chainOfResponsibility;

public class PaymentHandler extends OrderStepHandler {
    private final boolean willPaymentComplete;
    private static final String SUCCESS_STATUS = "Success";
    private static final String FAIL_STATUS = "Fail";

    public PaymentHandler(boolean willPaymentComplete) {
        this.willPaymentComplete = willPaymentComplete;
    }

    @Override
    protected boolean process(ThingsItemOrder itemOrder) {
        System.out.println("[PAYMENT_INFO]: $" + itemOrder.getFinalPrice());
        System.out.println("[PAYMENT_STATUS]: " + (willPaymentComplete ? SUCCESS_STATUS : FAIL_STATUS));
        return willPaymentComplete;
    }

    @Override
    protected void rollback(ThingsItemOrder itemOrder) {
        // Nothing for current simulation
    }
}
