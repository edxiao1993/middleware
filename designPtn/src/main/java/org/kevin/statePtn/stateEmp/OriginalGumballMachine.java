package org.kevin.statePtn.stateEmp;

/**
 * @author Kevin.Zng
 * @date 2022/2/20 22:43
 */
public class OriginalGumballMachine {
    private final int SOLD_OUT = 0;
    private final int NO_QUARTER = 0;
    private final int HAS_QUARTER = 0;
    private final int SOLD = 0;

    private int state;
    private int count;

    public OriginalGumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    /**
     * in different state, act differently.
     * if needed, change the state
     */
    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("you can't insert another quarter");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("you insert a quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("you can't insert a quarter, the machine is sold out");
        } else if (state == SOLD) {
            System.out.println("please wait. we're already giving you a gumball");
        }
    }

    public void ejectQuarter(){
        // TODO: same as the insertQuarter()
    }

    public void turnCrank() {
        // TODO: same as the insertQuarter
    }

    public void dispense() {
        // TODO: most likely the insertQuarter
    }
}
