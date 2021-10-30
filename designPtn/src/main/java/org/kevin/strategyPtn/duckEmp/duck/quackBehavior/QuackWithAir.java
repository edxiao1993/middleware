package org.kevin.strategyPtn.duckEmp.duck.quackBehavior;

/**
 * @author Kevin.Z
 * @version 2021/10/30
 */
public class QuackWithAir implements QuackBehavior{
    public void quack() {
        System.out.println("quack with push");
    }
}
