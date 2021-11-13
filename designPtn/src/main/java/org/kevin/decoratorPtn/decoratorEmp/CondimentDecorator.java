package org.kevin.decoratorPtn.decoratorEmp;

/**
 * @author Kevin.Z
 * @version 2021/11/8
 */
public abstract class CondimentDecorator extends Beverage{
    protected Beverage beverage;

    public abstract String getDescription();
}
