package org.kevin.factoryPtn.factoryEmp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin.Z
 * @version 2021/11/16
 */
public abstract class Pizza {
    protected String name;
    protected String dough;
    protected String sauce;
    protected List<String> toppings = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public void prepare(){

    }

    public void bake(){

    }

    public void cut(){

    }

    public void box(){

    }
}
