package org.kevin.commandPtn;

import org.junit.Test;
import org.kevin.commandPtn.commandEmp.*;

/**
 * @author Kevin.Z
 * @version 2021/11/29
 */
public class CommandTest {

    @Test
    public void testCommand(){
        Light roomLight = new Light();
        Command c = new LightCommand(roomLight);
        c.execute();

        Stereo stereo = new Stereo();
        Command stereoCmd = new StereoCommand(stereo);
        stereoCmd.execute();
        // then ......
        stereoCmd.undo();
    }
}
