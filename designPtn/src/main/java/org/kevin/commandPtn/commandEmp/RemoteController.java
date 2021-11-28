package org.kevin.commandPtn.commandEmp;

/**
 * @author Kevin.Z
 * @version 2021/11/29
 */
public class RemoteController {
    private Command[] onCommands;
    private Command[] offCommands;
    private Command lastCommand;

    private static final int DEFAULT_COMMAND_NUMBER = 7;

    public RemoteController(int size){
        onCommands = new Command[DEFAULT_COMMAND_NUMBER];
        offCommands = new Command[DEFAULT_COMMAND_NUMBER];

        Command noCommand = new NoCommand();
        for (int i = 0; i < DEFAULT_COMMAND_NUMBER; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        lastCommand = noCommand;
    }

    public RemoteController(){
        this(7);
    }

    public void setCommand(int slot, Command command, Command offCommand){
        onCommands[slot] = command;
        offCommands[slot] = offCommand;
    }

    /**
     * 按下按钮之后的操作应该都是调用 execute 的方法。
     * @param slot
     */
    public void onButtonWasPushed(int slot){
        onCommands[slot].execute();
        lastCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot){
        offCommands[slot].execute();
        lastCommand = offCommands[slot];
    }

    public void undo(){
        lastCommand.undo();
    }
}
