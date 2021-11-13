package org.kevin.decoratorPtn.decoratorEmp;

/**
 * @author Kevin.Z
 * @version 2021/11/8
 */
public abstract class Beverage {
    public enum Size {TALL, GRANDE, VENTI};

    Size size = Size.TALL;

    protected String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public abstract double cost();

}
