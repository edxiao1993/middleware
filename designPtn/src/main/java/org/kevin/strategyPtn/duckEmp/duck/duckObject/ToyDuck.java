package org.kevin.strategyPtn.duckEmp.duck.duckObject;

import org.kevin.strategyPtn.duckEmp.duck.AbstractDuck;
import org.kevin.strategyPtn.duckEmp.duck.flyBehavior.FlyWithRocket;
import org.kevin.strategyPtn.duckEmp.duck.quackBehavior.QuackWithAir;

/**
 * @author Kevin.Z
 * @version 2021/10/30
 */
public class ToyDuck extends AbstractDuck {

    public ToyDuck(){
        super.setFlyBehavior(new FlyWithRocket());
        super.setQuackBehavior(new QuackWithAir());
    }

    public void play() {
        System.out.println("I am a ToyDuck, and I play in the hands of children");
    }
}
