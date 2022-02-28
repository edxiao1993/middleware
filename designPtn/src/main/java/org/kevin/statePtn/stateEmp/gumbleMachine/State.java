package org.kevin.statePtn.stateEmp.gumbleMachine;

/**
 * @author Kevin.Zng
 * @date 2022/2/20 22:54
 */
public interface State {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}
