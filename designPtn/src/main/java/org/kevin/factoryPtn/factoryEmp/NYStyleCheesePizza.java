package org.kevin.factoryPtn.factoryEmp;

/**
 * @author Kevin.Z
 * @version 2021/11/16
 */
public class NYStyleCheesePizza extends Pizza{

    public NYStyleCheesePizza(){
        super.name = "NY Style Sauce and Cheese Pizza";
        super.dough = "Thin Crust Dough";
        super.sauce = "Maromara Sauce";

        super.toppings.add("Grated Reggiano Cheese");
    }
}
