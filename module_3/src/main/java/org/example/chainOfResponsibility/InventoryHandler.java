package org.example.chainOfResponsibility;

public class InventoryHandler extends OrderStepHandler {
    @Override
    protected boolean process(ThingsItemOrder itemOrder) {
        return true;
    }

    @Override
    protected void rollback(ThingsItemOrder itemOrder) {
        // Nothing for current simulation;
    }
}
