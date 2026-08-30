package org.example.builder;

import java.util.List;

public class Pizza {
    private final Size size;
    private final Crust crust;
    private final List<Topping> toppings;
    private final boolean extraCheese;

    public Pizza(PizzaBuilder pizzaBuilder) {
        this.size = pizzaBuilder.getSize();
        this.crust = pizzaBuilder.getCrust();
        this.toppings = pizzaBuilder.getToppings();
        this.extraCheese = pizzaBuilder.isExtraCheese();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Your pizza consist of: size - ")
                .append(size)
                .append("; crust - ")
                .append(crust)
                .append("; toppings - ")
                .append(toppings)
                .append(extraCheese ? "; with extra chees": "")
                .toString();
    }
}
