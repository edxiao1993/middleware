package org.kevin.statePtn.stateEmp.gumbleMachine;

/**
 * @author Kevin.Zng
 * @date 2022/2/20 22:56
 */
public class HasQuarterState implements State {
    private GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("you can't insert another quarter");

    }

    @Override
    public void ejectQuarter() {
        System.out.println("quarter returned");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("you turned..");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("no gumball dispense");
    }
}
