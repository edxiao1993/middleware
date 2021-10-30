package org.kevin.ch3;

import org.kevin.whatever.Animal;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Kevin.Z
 * @version 2021/7/24
 */
public class StackSeal {


    public int loadTheArk(Collection<Animal> candidates){
        SortedSet<Animal> animals;
        int numParis = 0;
        Animal candidate = null;
        animals = new TreeSet<Animal>();

        // 只操作方法内的局部变量
        animals.addAll(candidates);
        // omit

        return numParis;
    }
}
