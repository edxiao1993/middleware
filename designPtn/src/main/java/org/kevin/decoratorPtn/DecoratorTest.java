package org.kevin.decoratorPtn;

import org.kevin.decoratorPtn.decoratorEmp.*;

/**
 * @author Kevin.Z
 * @version 2021/11/8
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Beverage mocha = new HouseBlend();
        mocha = new Whip(mocha);
        mocha = new Mocha(mocha);

        System.out.println("mocha.getDescription() = " + mocha.getDescription());
        System.out.println("mocha.cost() = " + mocha.cost());

        Beverage whip = new Espresso();
        whip = new Whip(whip);
        System.out.println("whip.getDescription() = " + whip.getDescription());
        System.out.println("whip.cost() = " + whip.cost());

        Beverage ventiEspresso = new Espresso();
        ventiEspresso = new Mocha(ventiEspresso);
        ventiEspresso = new Whip(ventiEspresso);
        ventiEspresso = new SizeOfCoffee(ventiEspresso);
        ventiEspresso.setSize(Beverage.Size.VENTI);
        System.out.println("----------------");
        System.out.println("ventiEspresso.getDescription() = " + ventiEspresso.getDescription());
        System.out.println("ventiEspresso.cost() = " + ventiEspresso.cost());
    }
}
