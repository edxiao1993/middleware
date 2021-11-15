package org.kevin.factoryPtn.factoryEmp;

/**
 * @author Kevin.Z
 * @version 2021/11/16
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = this.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    public abstract Pizza createPizza(String type);
}
