package org.kevin.commandPtn.commandEmp;

/**
 * @author Kevin.Z
 * @version 2021/11/29
 */
public class Light {
    private int status;

    public void on() {
        status = 1;
    }

    public void off() {
        status = 0;
    }
}
