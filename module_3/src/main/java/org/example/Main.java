package org.example;

import org.example.adapter.LegacyLogger;
import org.example.adapter.LegacyLoggerAdapter;
import org.example.adapter.Logger;
import org.example.builder.Pizza;
import org.example.builder.PizzaDirector;
import org.example.chainOfResponsibility.*;
import org.example.decorator.EmailNotifier;
import org.example.decorator.Notifier;
import org.example.decorator.SMSDecorator;
import org.example.decorator.TelegramDecorator;
import org.example.proxy.ProxyVideo;
import org.example.proxy.Video;
import org.example.strategy.ExpressShipping;
import org.example.strategy.ShippingOrder;
import org.example.strategy.StandardShipping;

public class Main {
    public static void main(String[] args) {
        builderDemo();

        proxyDemo();

        decoratorDemo();

        adapterDemo();

        strategyDemo();

        chainOfResponsibilityDemo();
    }

    public static void builderDemo() {
        System.out.println();
        System.out.println("--- Pizza builder ---");
        PizzaDirector pizzaDirector = new PizzaDirector();

        Pizza largePizzaWithHamAndExtraChees = pizzaDirector.makeLargePizzaWithHamAndExtraChees();
        System.out.println(largePizzaWithHamAndExtraChees);

        Pizza stuffedVegetarianPizza = pizzaDirector.makeStuffedVegetarianPizza();
        System.out.println(stuffedVegetarianPizza);
    }

    public static void proxyDemo() {
        System.out.println();
        System.out.println("--- Video proxy ---");
        Video video = new ProxyVideo("java-course_lesson.mp4");
        video.run(); // here we should load the real video before the run
        video.pause(); // just pause as we loaded it earlier
        video.stop(); // same here
    }

    public static void decoratorDemo() {
        System.out.println();
        System.out.println("--- Notifier decorator ---");
        Notifier regularNotifier = new EmailNotifier();
        Notifier telegramDecorator = new TelegramDecorator(regularNotifier);
        Notifier smsDecorator = new SMSDecorator(telegramDecorator);
        smsDecorator.send("Your password was changed successfully!"); // [EMAIL] + [TELEGRAM] + [SMS]
    }

    public static void adapterDemo() {
        System.out.println();
        System.out.println("--- Logger adapter ---");
        LegacyLogger legacyLogger = new LegacyLogger(); // has no logMessage method
        Logger logger = new LegacyLoggerAdapter(legacyLogger);
        logger.logMessage("Database connection established.");
    }

    public static void strategyDemo() {
        System.out.println();
        System.out.println("--- Shipping strategy ---");
        double shippingItemWeight = 100.0;
        double shippingDistance = 388.0;
        ShippingOrder order = new ShippingOrder(shippingItemWeight, shippingDistance);
        order.setShippingStrategy(new StandardShipping());
        System.out.println("The full cost of shipping: " + order.calculateTotalShippingCost());
        order.setShippingStrategy(new ExpressShipping());
        System.out.println("The full cost of shipping: " + order.calculateTotalShippingCost());
    }

    public static void chainOfResponsibilityDemo() {
        System.out.println();
        System.out.println("--- Orders chain of responsibility ---");
        OrderStepHandler inventoryHandler = new InventoryHandler();
        OrderStepHandler additionalFeeHandler = new AdditionalFeeHandler();
        OrderStepHandler successPaymentHandler = new PaymentHandler(true);
        OrderStepHandler failPaymentHandler = new PaymentHandler(false);
        inventoryHandler.setOrderStepHandler(additionalFeeHandler);

        additionalFeeHandler.setOrderStepHandler(successPaymentHandler);
        String grayShirtId = "grayShirtUniqueId";
        double grayShirtBasePrice = 8.99;
        ThingsItemOrder successOrder = new ThingsItemOrder(grayShirtId, grayShirtBasePrice);
        inventoryHandler.processTheOrder(successOrder);
        System.out.println("---> Full logs - " + successOrder + ":");
        successOrder.getOrderLogs().forEach(System.out::println);

        System.out.println(" ------------ ");

        additionalFeeHandler.setOrderStepHandler(failPaymentHandler);
        String blueShirtId = "blueShirtUniqueId";
        double blueShirtBasePrice = 99.99;
        ThingsItemOrder failedOrder = new ThingsItemOrder(blueShirtId, blueShirtBasePrice);
        inventoryHandler.processTheOrder(failedOrder);
        System.out.println("---> Full logs - " + failedOrder + ":");
        failedOrder.getOrderLogs().forEach(System.out::println);
    }
}