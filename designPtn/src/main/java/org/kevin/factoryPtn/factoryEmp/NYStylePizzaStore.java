package org.kevin.factoryPtn.factoryEmp;

/**
 * @author Kevin.Z
 * @version 2021/11/16
 */
public class NYStylePizzaStore extends PizzaStore{

    @Override
    public Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new NYStyleCheesePizza();
        } else if(type.equals("meat")){
            return new NYStyleMeatPizza();
        }
        return null;
    }
}
