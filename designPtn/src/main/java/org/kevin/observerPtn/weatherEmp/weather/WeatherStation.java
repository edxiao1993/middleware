package org.kevin.observerPtn.weatherEmp.weather;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin.Z
 * @version 2021/11/3
 */
public class WeatherStation implements SubjectObserver {
    private List<ObjectObserver> objectObservers = new ArrayList<>();

    private double temperature = 18.5;

    private int humanity = 75;

    private double pressure = 1.0;

    // omit getter

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        this.notifyObserver();
    }

    public void setHumanity(int humanity) {
        this.humanity = humanity;
        this.notifyObserver();
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
        this.notifyObserver();
    }

    @Override
    public void registerObserver(ObjectObserver oo) {
        objectObservers.add(oo);
    }

    @Override
    public void removeObserver(ObjectObserver oo) {
        objectObservers.remove(oo);
    }

    @Override
    public void notifyObserver() {
        for (ObjectObserver objectObserver : objectObservers) {
            objectObserver.notifyUpdate(this.temperature, this.humanity, this.pressure);
        }
    }
}
