package org.kevin.commandPtn.commandEmp;

/**
 * @author Kevin.Z
 * @version 2021/11/29
 */
public class LightCommand implements Command {
    private Light light;

    public LightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
