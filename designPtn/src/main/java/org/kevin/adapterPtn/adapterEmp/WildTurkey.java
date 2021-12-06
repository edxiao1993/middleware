package org.kevin.adapterPtn.adapterEmp;

/**
 * @author Kevin.Z
 * @version 2021/12/6
 */
public class WildTurkey implements Turkey{
    @Override
    public void gobble() {
        System.out.println("Gobble, gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
