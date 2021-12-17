package org.kevin.templatePtn.templateEmp;

/**
 * @author Kevin.Z
 * @version 2021/12/18
 */
public class Tea extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Steep the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding lemon");
    }
}
