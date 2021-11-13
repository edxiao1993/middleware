package org.kevin;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin.Z
 * @version 2021/10/30
 */
public class Application {

    public static void main(String[] args) {
        System.out.println("hello world~");
    }

    @Test
    public void test1(){
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("123");
        list.add("!@#");

        boolean b = list.stream().anyMatch(o -> o.equals("123"));
        System.out.println("b = " + b);
    }
}
