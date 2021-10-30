package org.kevin.basic;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.WeakHashMap;

/**
 * @author Kevin.Z
 * @version 2021/7/27
 */
public class MapTester {
    public void mt(){
        HashMap<String, String> hashMap = new HashMap<>(20);
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
        TreeMap<String, String> treeMap = new TreeMap<>();

        hashMap.put("a", "b");

        linkedHashMap.put("a", "b");

        weakHashMap.put("a", "b");

        treeMap.put("a", "b");
    }
}
