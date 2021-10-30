package org.kevin.ch5;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * 构造一个有界集合
 *
 * @author Kevin.Z
 * @version 2021/7/24
 */
public class SemaphoreTester<T> {
    private final Set<T> set;
    private final Semaphore sem;

    public SemaphoreTester(int bound){
        this.set = Collections.synchronizedSet(new HashSet<T>());
        sem = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException{
        sem.acquire();
        boolean wasAdded = false;
        try{
            wasAdded = set.add(o);
            return wasAdded;
        } finally {
            if(!wasAdded){
                sem.release();
            }
        }
    }

    public boolean remove(T o){
        boolean wasRemoved = set.remove(o);
        if(wasRemoved){
            sem.release();
        }
        return wasRemoved;
    }
}
