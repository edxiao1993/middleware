package org.kevin.singletonPtn.singletonEmp;

/**
 * @author Kevin.Z
 * @version 2021/11/24
 */
public enum ChocolateEnum {
    UNIQUE_INSTANCE;

    private ChocolateEnum() {
    }

    private boolean empty;
    private boolean boiled;

    public void fill() {
        if (this.isEmpty()) {
            empty = false;
            boiled = false;

            // fill the boiler with any thing you like
        }
    }

    public void drain() {
        if (!this.isEmpty() && isBoiled()) {
            // drain the boiled milk and chocolate
            empty = true;
        }
    }

    public void boil() {
        if (!this.isEmpty() && !isBoiled()) {
            // bring the contents to a boil
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
