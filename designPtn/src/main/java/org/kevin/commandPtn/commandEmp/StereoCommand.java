package org.kevin.commandPtn.commandEmp;

/**
 * @author Kevin.Z
 * @version 2021/11/29
 */
public class StereoCommand implements Command{
    private Stereo stereo;

    public StereoCommand(Stereo stereo){
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD("default");
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
