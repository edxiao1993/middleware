package org.kevin.compositePtn;

import org.kevin.compositePtn.compositeEmp.Menu;
import org.kevin.compositePtn.compositeEmp.MenuComponent;
import org.kevin.compositePtn.compositeEmp.MenuItem;
import org.kevin.compositePtn.compositeEmp.Waitress;

/**
 * @author Kevin.Zng
 * @date 2022/1/26 00:36
 */
public class CompositeTest {

    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
        MenuComponent cafeMenu = new Menu("CAKE MENU", "Low tea");
        MenuComponent dessert = new Menu("DESSERT MENU", "Dessert of course");

        MenuComponent allMenu = new Menu("ALL MENU", " All menu combined ");
        allMenu.add(pancakeHouseMenu);
        allMenu.add(dinerMenu);
        allMenu.add(cafeMenu);

        dinerMenu.add(new MenuItem("Pasta", "Spaghetti", true, 3.89));
        dinerMenu.add(dessert);
        dinerMenu.add(new MenuItem("Apple pie", "Applie pie with ...", false, 1.59));

        Waitress waitress = new Waitress(allMenu);

        waitress.print();
    }
}
