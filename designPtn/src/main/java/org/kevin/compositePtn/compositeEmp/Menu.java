package org.kevin.compositePtn.compositeEmp;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Kevin.Zng
 * @date 2022/1/26 00:52
 */
public class Menu extends MenuComponent {
    private List<MenuComponent> menuComponents = new ArrayList<>();
    private String name;
    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void print() {
        System.out.print("\t" + getName());
        System.out.print(", " + getDescription());
        System.out.print("----------");

        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.print();
        }
    }
}
