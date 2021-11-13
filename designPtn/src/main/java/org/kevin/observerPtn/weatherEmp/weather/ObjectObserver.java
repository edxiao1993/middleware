package org.kevin.observerPtn.observerPtn.weatherEmp.weather;

/**
 * @author Kevin.Z
 * @version 2021/11/3
 */
public interface ObjectObserver {
    void notifyUpdate(double temperature, int humanity, double pressure);
}
