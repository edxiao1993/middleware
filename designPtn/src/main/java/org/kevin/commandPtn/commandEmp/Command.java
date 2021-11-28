package org.kevin.commandPtn.commandEmp;

/**
 * @author Kevin.Z
 * @version 2021/11/29
 */
public interface Command {
    void execute();

    void undo();
}
