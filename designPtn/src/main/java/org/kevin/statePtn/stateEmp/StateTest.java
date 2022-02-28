package org.kevin.statePtn.stateEmp;

/**
 * @author Kevin.Zng
 * @date 2022/2/20 22:50
 */
public class StateTest {
    public static void main(String[] args) {
        OriginalGumballMachine gumballMachine = new OriginalGumballMachine(2);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        // any thing else...
    }
}
