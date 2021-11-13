package org.kevin.decoratorPtn.decoratorEmp;

/**
 * @author Kevin.Z
 * @version 2021/11/10
 */
public class SizeOfCoffee extends CondimentDecorator{

    public SizeOfCoffee(Beverage beverage){
        this.beverage = beverage;
        this.size = Size.TALL;
    }

    public SizeOfCoffee(Beverage beverage, Size size){
        this.beverage = beverage;
        super.size = size;
    }

    @Override
    public double cost() {
        return beverage.cost() + this.costOfSize();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", " + size.name();
    }

    private double costOfSize(){
        switch (size){
            case GRANDE:
                return .1;
            case VENTI:
                return .2;
            default:
                return 0;
        }
    }

    public void setSize(Size size){
        super.size = size;
    }

    public Size getSize(){
        return size;
    }
}
