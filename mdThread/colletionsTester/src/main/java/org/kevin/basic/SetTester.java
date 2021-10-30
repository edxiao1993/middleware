package org.kevin.basic;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * @author Kevin.Z
 * @version 2021/7/27
 */
public class SetTester {
    public void st(){
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();

        hashSet.add("name");

        linkedHashSet.add("first");

        treeSet.add("Kevin");
    }
}
