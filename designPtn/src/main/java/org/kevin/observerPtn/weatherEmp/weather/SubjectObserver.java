package org.kevin.observerPtn.weatherEmp.weather;

/**
 * @author Kevin.Z
 * @version 2021/11/3
 */
public interface SubjectObserver {
    void registerObserver(ObjectObserver oo);

    void removeObserver(ObjectObserver oo);

    void notifyObserver();
}
