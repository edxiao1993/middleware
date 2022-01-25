package org.kevin.observerPtn.weatherEmp.weather;

/**
 * @author Kevin.Z
 * @version 2021/11/3
 */
public class RadioObserver implements ObjectObserver{
    private double temperature;
    private int humanity;
    private double pressure;

    public RadioObserver(){}

    public RadioObserver(SubjectObserver subjectObserver){
        subjectObserver.registerObserver(this);
    }

    @Override
    public void notifyUpdate(double temperature, int humanity, double pressure) {
        this.temperature = temperature;
        this.humanity = humanity;
        this.pressure = pressure;

        this.display();
    }

    public void display(){
        System.out.println("====== this is radio, and I am going to speak the data from weather station");
        System.out.println("humanity = " + humanity);
    }
}
