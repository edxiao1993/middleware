package org.kevin.compositePtn.compositeEmp;

/**
 * @author Kevin.Zng
 * @date 2022/1/26 00:58
 */
public class Waitress {
    private MenuComponent allMenu;

    public Waitress(MenuComponent allMenu) {
        this.allMenu = allMenu;
    }

    public void print() {
        allMenu.print();
    }
}
