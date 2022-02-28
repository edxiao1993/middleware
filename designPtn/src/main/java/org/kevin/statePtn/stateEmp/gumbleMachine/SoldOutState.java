package org.kevin.statePtn.stateEmp.gumbleMachine;

/**
 * @author Kevin.Zng
 * @date 2022/2/20 22:55
 */
public class SoldOutState implements State{
    private GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {

    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {

    }
}
