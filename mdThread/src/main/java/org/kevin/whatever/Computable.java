package org.kevin.whatever;

/**
 * @author Kevin.Z
 * @version 2021/7/24
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
