package org.kevin.facadePtn.facedeEmp;

/**
 * @author Kevin.Z
 * @version 2021/12/13
 */
public class HomeTheaterTestDrive {

    public static void main(String[] args) {
        // instantiate components here;

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
                "amo", "tuner", "player", "projector", "lights", "screen", "popper"
        );
        homeTheater.watchMovie("The Grande Budapest");

        // just watch...

        homeTheater.endMovie();
    }
}
