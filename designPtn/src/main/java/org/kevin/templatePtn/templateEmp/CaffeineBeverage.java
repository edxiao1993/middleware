package org.kevin.templatePtn.templateEmp;

/**
 * @author Kevin.Z
 * @version 2021/12/18
 */
public abstract class CaffeineBeverage {
    public final void prepareRecipe() {
        this.boilWater();
        this.brew();
        this.addCondiments();
        this.pourInCup();
    }

    abstract void brew();

    abstract void addCondiments();

    private void boilWater(){
        // TODO: boil water
    }

    private void pourInCup(){
        // TODO: pour into cup
    }
}
