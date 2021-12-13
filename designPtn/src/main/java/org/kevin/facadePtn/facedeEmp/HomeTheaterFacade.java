package org.kevin.facadePtn.facedeEmp;

/**
 * @author Kevin.Z
 * @version 2021/12/13
 */
public class HomeTheaterFacade {
    // Let's pretend the following String is the device
    private String amp;
    private String tuner;
    private String player;
    private String projector;
    private String lights;
    private String screen;
    private String popper;

    public HomeTheaterFacade(String amp, String tuner, String player,
                             String projector, String lights, String screen,
                             String popper){
        this.amp = amp;
        this.tuner = tuner;
        this.player = player;
        this.projector = projector;
        this.lights = lights;
        this.screen = screen;
        this.popper = popper;
    }

    public void watchMovie(String movie){
        // tune on all the devices.
        System.out.println("start to watch the movies");
    }

    public void endMovie(){
        // turn off all the devices.
        System.out.println("shutting movie theater down...");
    }
}
