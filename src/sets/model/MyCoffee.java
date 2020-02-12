package sets.model;

import java.util.Objects;

/**
 * Class Coffee
 * Which has two fields
 * 1)Coffee type coffee
 * 2)Integer type price
 * functions equals hashCode and compareTo were overriden
 */
public class MyCoffee implements Comparable<MyCoffee>{
    private CoffeeType coffee;
    private Integer price;

    public MyCoffee(CoffeeType coffee, Integer price) {
        this.coffee = coffee;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyCoffee myCoffee = (MyCoffee) o;
        return price == myCoffee.price &&
                coffee == myCoffee.coffee;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffee, price);
    }

    @Override
    public int compareTo(MyCoffee myCoffee) {
        int comparablePrice=myCoffee.price;
        CoffeeType comparableCoffee= myCoffee.coffee;
        return this.price.compareTo(comparablePrice)==0
                ? this.coffee.name().compareTo(comparableCoffee.name())
                :this.price.compareTo(comparablePrice);
    }

    @Override
    public String toString() {
        return  coffee.name() + ": "+ price;
    }
}
