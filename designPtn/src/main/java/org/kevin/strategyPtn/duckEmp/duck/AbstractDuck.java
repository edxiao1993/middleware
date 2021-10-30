package org.kevin.strategyPtn.duckEmp.duck;

import org.kevin.strategyPtn.duckEmp.duck.flyBehavior.FlyBehavior;
import org.kevin.strategyPtn.duckEmp.duck.quackBehavior.QuackBehavior;

/**
 * @author Kevin.Z
 * @version 2021/10/30
 */
public abstract class AbstractDuck {
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior){
        this.quackBehavior = quackBehavior;
    }

    public void swim() {
        System.out.println("swimming in the river.");
    }

    public abstract void play();

    public void fly() {
        flyBehavior.fly();
    }

    public void quack() {
        quackBehavior.quack();
    }
}
