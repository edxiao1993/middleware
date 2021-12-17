package org.kevin.templatePtn;

import org.kevin.templatePtn.templateEmp.CaffeineBeverage;
import org.kevin.templatePtn.templateEmp.Coffee;
import org.kevin.templatePtn.templateEmp.Tea;

/**
 * @author Kevin.Z
 * @version 2021/12/18
 */
public class TemplateTest {
    public static void main(String[] args) {
        CaffeineBeverage coffee = new Coffee();
        coffee.prepareRecipe();

        CaffeineBeverage tea = new Tea();
        tea.prepareRecipe();
    }
}
