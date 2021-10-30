package org.kevin.basic;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Kevin.Z
 * @version 2021/7/27
 */
public class ListTester {
    public void lt(){
        ArrayList<String> array = new ArrayList<>();
        LinkedList<String> linked = new LinkedList<>();

        array.add("name");

        linked.add("name");
        linked.addFirst("second");
    }
}
