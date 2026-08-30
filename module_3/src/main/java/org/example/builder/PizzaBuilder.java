package org.example.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PizzaBuilder {
    private final Size size;
    private final Crust crust;
    private final List<Topping> toppings = new ArrayList<>();
    private boolean extraCheese = false;

    public PizzaBuilder(Size size, Crust crust) {
        this.size = size;
        this.crust = crust;
    }

    public PizzaBuilder addTopping(Topping topping) {
        toppings.add(topping);
        return this;
    }

    public PizzaBuilder addExtraChees() {
        extraCheese = true;
        return this;
    };

    public List<Topping> getToppings() {
        return Collections.unmodifiableList(toppings);
    }

    public Size getSize() {
        return size;
    }

    public Crust getCrust() {
        return crust;
    }

    public boolean isExtraCheese() {
        return  extraCheese;
    }

    public Pizza build() {
        return new Pizza(this);
    }
}
