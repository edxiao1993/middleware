package org.kevin.factoryPtn.factoryEmp;

import org.junit.Test;

/**
 * @author Kevin.Z
 * @version 2021/11/16
 */
public class FactoryTest {

    @Test
    public void testFactory() {
        PizzaStore pizzaStore = new NYStylePizzaStore();
        Pizza pizza = pizzaStore.orderPizza("meat");
        System.out.println("Ethan ordered a " + pizza.getName());
    }
}
