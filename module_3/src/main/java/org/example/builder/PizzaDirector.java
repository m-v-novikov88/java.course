package org.example.builder;

public class PizzaDirector {
    public Pizza makeLargePizzaWithHamAndExtraChees() {
        return new PizzaBuilder(Size.LARGE, Crust.TRADITIONAL)
                .addTopping(Topping.HAM)
                .addExtraChees()
                .build();
    }

    public Pizza makeThinPepperoni() {
        return new PizzaBuilder(Size.MEDIUM, Crust.THIN)
                .addTopping(Topping.PEPPERONI)
                .build();
    }

    public Pizza makeStuffedVegetarianPizza() {
        return new PizzaBuilder(Size.MEDIUM, Crust.STUFFED)
                .addTopping(Topping.MUSHROOMS)
                .addTopping(Topping.PEPPERS)
                .addTopping(Topping.ONIONS)
                .build();
    }
}
