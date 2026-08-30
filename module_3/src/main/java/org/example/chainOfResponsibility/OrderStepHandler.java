package org.example.chainOfResponsibility;

public abstract class OrderStepHandler {
    private OrderStepHandler nextStep;

    public void setOrderStepHandler(OrderStepHandler nextStep) {
        this.nextStep = nextStep;
    }

    public final void processTheOrder(ThingsItemOrder itemOrder) {
        itemOrder.logOrderHandler("[Enter step handler]: " + this.getClass().getSimpleName());

        boolean isSuccess = process(itemOrder);
        if(!isSuccess) {
            itemOrder.makeOrderFailed();
            itemOrder.logOrderHandler("[Order handler FAIL]: " + this.getClass().getSimpleName());
            rollback(itemOrder);
            return;
        }

        if (nextStep != null) {
            nextStep.processTheOrder(itemOrder);

            if (itemOrder.isOrderFailed()) {
                itemOrder.logOrderHandler("[Order subsequent handler FAIL]: " + this.getClass().getSimpleName());
                rollback(itemOrder);
            }
        }
    }

    protected abstract boolean process(ThingsItemOrder itemOrder);

    protected abstract void rollback(ThingsItemOrder itemOrder);
}
