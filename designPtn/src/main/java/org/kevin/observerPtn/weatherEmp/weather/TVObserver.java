package org.kevin.observerPtn.weatherEmp.weather;

/**
 * @author Kevin.Z
 * @version 2021/11/3
 */
public class TVObserver implements ObjectObserver{
    private double temperature;

    @Override
    public void notifyUpdate(double temperature, int humanity, double pressure) {
        this.temperature = temperature;
        this.display();
    }

    public void display(){
        System.out.println("------ this is TV, and I just get interesting in temperature");
        System.out.println("temperature = " + temperature);
    }
}
