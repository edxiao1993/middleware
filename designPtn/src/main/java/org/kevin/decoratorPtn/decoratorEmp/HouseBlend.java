package org.kevin.decoratorPtn.decoratorEmp;

/**
 * @author Kevin.Z
 * @version 2021/11/8
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 1.49;
    }
}
