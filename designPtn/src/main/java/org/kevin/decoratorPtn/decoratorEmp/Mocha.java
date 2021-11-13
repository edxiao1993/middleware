package org.kevin.decoratorPtn.decoratorEmp;

/**
 * @author Kevin.Z
 * @version 2021/11/8
 */
public class Mocha extends CondimentDecorator{

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + .99;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}
