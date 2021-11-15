package org.kevin.factoryPtn.factoryEmp;

/**
 * @author Kevin.Z
 * @version 2021/11/16
 */
public class NYStyleMeatPizza extends Pizza{

    public NYStyleMeatPizza(){
        super.name = "NY Style Meat and Cheese Pizza";
        super.dough = "Thick Crust Dough";
        super.sauce = "Meat Meat Meat";

        super.toppings.add("Grated Reggiano Cheese");
    }

    public String getName(){
        return super.name;
    }
}
