package org.kevin.commandPtn.commandEmp;

/**
 * @author Kevin.Z
 * @version 2021/11/29
 */
public class Stereo {
    private int status;
    private String cd;
    private int volume;

    // omit getter/setter

    public void on() {
        status = 1;
    }

    public void off() {
        status = 0;
    }

    public void setCD(String cd) {
        this.cd = cd;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
