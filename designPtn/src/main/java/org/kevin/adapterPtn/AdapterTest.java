package org.kevin.adapterPtn;

import org.junit.Test;
import org.kevin.adapterPtn.adapterEmp.Turkey;
import org.kevin.adapterPtn.adapterEmp.TurkeyAdapter;
import org.kevin.adapterPtn.adapterEmp.WildTurkey;

/**
 * 这里使用了 适配器。
 * 将 turkey 赋值给 适配器TurkeyAdapter，从而使turkey可以直接调用属于 Duck 的方法。
 * 怪怪的……
 *
 * @author Kevin.Z
 * @version 2021/12/6
 */
public class AdapterTest {

    @Test
    public void testAdapter(){
        Turkey wildTurkey = new WildTurkey();
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(wildTurkey);

        turkeyAdapter.fly();
        turkeyAdapter.quack();
    }
}
