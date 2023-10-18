package org.kevin.singletonPtn.singletonEmp;

/**
 * 默认选择第 1 种，
 * 2 和 2.1 看着办
 *
 * @author Kevin.Z
 * @version 2021/11/24
 */
public class ChocolateBoiler {
    // 1. 直接初始化
    private static ChocolateBoiler instance = new ChocolateBoiler();

    private static volatile ChocolateBoiler anotherInstance = null;

    private static class InnerClass {
        private static final ChocolateBoiler INSTANCE_INNER = new ChocolateBoiler();
    }

    // 3. 内部优化器
    public static ChocolateBoiler getInnerInstance() {
        return InnerClass.INSTANCE_INNER;
    }

    // 2. 使用时才初始化
    public static synchronized ChocolateBoiler getInstance() {
        if (anotherInstance == null) {
            anotherInstance = new ChocolateBoiler();
        }
        return anotherInstance;
    }

    // 2.1 优化同步器
    public static ChocolateBoiler getInstance2() {
        if (anotherInstance == null) {
            synchronized (ChocolateBoiler.class) {
                if (anotherInstance == null) {
                    anotherInstance = new ChocolateBoiler();
                }
            }
        }

        return anotherInstance;
    }

    private boolean empty;
    private boolean boiled;

    private ChocolateBoiler() {
    }

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
