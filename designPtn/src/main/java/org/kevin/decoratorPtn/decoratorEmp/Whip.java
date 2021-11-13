package org.kevin.decoratorPtn.decoratorEmp;

/**
 * @author Kevin.Z
 * @version 2021/11/8
 */
public class Whip extends CondimentDecorator{

    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + .5;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
}
