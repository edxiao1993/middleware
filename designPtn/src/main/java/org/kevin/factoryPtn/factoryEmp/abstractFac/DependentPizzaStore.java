package org.kevin.factoryPtn.factoryEmp.abstractFac;

import org.kevin.factoryPtn.factoryEmp.NYStyleCheesePizza;
import org.kevin.factoryPtn.factoryEmp.NYStyleMeatPizza;
import org.kevin.factoryPtn.factoryEmp.Pizza;

/**
 * @author Kevin.Z
 * @version 2021/11/23
 */
public class DependentPizzaStore {

    /**
     * decide the pizza store by the style,
     *  and using the type to return the actual pizza.
     *
     * @param style
     * @param type
     * @return
     */
    public Pizza createPizza(String style, String type) {
        Pizza pizza = null;
        if (style.equals("NY")) {
            if (type.equals("meat")) {
                pizza = new NYStyleMeatPizza();
            } else if (type.equals("cheese")) {
                pizza = new NYStyleCheesePizza();
            }
            // continue ......
        } else if (style.equals("Chicago")) {
            // continue ...
        } else {
            // default pizza;
        }

        pizza.prepare();
        pizza.bake();
        // ...

        return pizza;
    }
}
