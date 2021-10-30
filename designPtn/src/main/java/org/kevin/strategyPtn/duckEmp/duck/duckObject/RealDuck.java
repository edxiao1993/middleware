package org.kevin.strategyPtn.duckEmp.duck.duckObject;

import org.kevin.strategyPtn.duckEmp.duck.AbstractDuck;
import org.kevin.strategyPtn.duckEmp.duck.flyBehavior.FlyWithWings;
import org.kevin.strategyPtn.duckEmp.duck.quackBehavior.QuackWithMouth;

/**
 * @author Kevin.Z
 * @version 2021/10/30
 */
public class RealDuck extends AbstractDuck {

    public RealDuck() {
        super.setFlyBehavior(new FlyWithWings());
        super.setQuackBehavior(new QuackWithMouth());
    }

    public void play() {
        System.out.println("I am a Real Duck, and I play in the playGround.");
    }
}
