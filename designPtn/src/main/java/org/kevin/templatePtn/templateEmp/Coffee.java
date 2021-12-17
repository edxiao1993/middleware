package org.kevin.templatePtn.templateEmp;

/**
 * @author Kevin.Z
 * @version 2021/12/18
 */
public class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("I am Coffee. Let's dripping coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("just black coffee");
    }
}
