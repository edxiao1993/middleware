package org.kevin.strategyPtn.duckEmp;

import org.kevin.strategyPtn.duckEmp.duck.AbstractDuck;
import org.kevin.strategyPtn.duckEmp.duck.duckObject.RealDuck;
import org.kevin.strategyPtn.duckEmp.duck.duckObject.ToyDuck;
import org.kevin.strategyPtn.duckEmp.duck.flyBehavior.FlyWithNothing;

/**
 * @author Kevin.Z
 * @version 2021/10/30
 */
public class StrategyTest {

    public static void main(String[] args) {
        readDuck();
        System.out.println("------------");
        toyDuck();
    }

    private static void readDuck(){
        AbstractDuck realDuck = new RealDuck();
        realDuck.play();
        realDuck.fly();
        realDuck.quack();
    }

    private static void toyDuck(){
        AbstractDuck toyDuck = new ToyDuck();
        toyDuck.play();
        toyDuck.fly();
        toyDuck.quack();

        toyDuck.setFlyBehavior(new FlyWithNothing());
        toyDuck.fly();
    }
}
