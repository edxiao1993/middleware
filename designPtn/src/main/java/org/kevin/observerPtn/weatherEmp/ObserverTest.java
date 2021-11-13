package org.kevin.observerPtn.observerPtn.weatherEmp;

import org.kevin.observerPtn.observerPtn.weatherEmp.weather.ObjectObserver;
import org.kevin.observerPtn.observerPtn.weatherEmp.weather.RadioObserver;
import org.kevin.observerPtn.observerPtn.weatherEmp.weather.TVObserver;
import org.kevin.observerPtn.observerPtn.weatherEmp.weather.WeatherStation;

/**
 * @author Kevin.Z
 * @version 2021/11/3
 */
public class ObserverTest {

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        ObjectObserver radioObserver = new RadioObserver(weatherStation);

        ObjectObserver tvObserver = new TVObserver();
        weatherStation.registerObserver(tvObserver);

        weatherStation.setTemperature(22);

        weatherStation.removeObserver(radioObserver);
        weatherStation.setHumanity(90);
    }
}
