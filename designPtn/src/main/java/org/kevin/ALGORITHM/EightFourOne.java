package org.kevin.ALGORITHM;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Kevin.Zng
 * @date 2022/5/26 00:51
 */
public class EightFourOne {

    public static void main(String[] args) {
        List<Integer> r0 = Lists.newArrayList(1);
        List<Integer> r1 = Lists.newArrayList(2);
        List<Integer> r2 = Lists.newArrayList(3);
        List<Integer> r3 = Lists.newArrayList();

        List<List<Integer>> rooms = Lists.newArrayList(r0, r1, r2, r3);

        System.out.println(violence(rooms));
    }

    private static boolean violence(List<List<Integer>> rooms) {
        Set<Integer> sets = new HashSet<>(rooms.get(0));
        sets.add(0);
        int lastSize = sets.size();

        while (!(lastSize == rooms.size())) {
            Set<Integer> tempSet = new HashSet<>();
            for (Integer i : sets) {
                tempSet.addAll(rooms.get(i));
            }

            sets.addAll(tempSet);
            if (lastSize == sets.size()) {
                break;
            }

            lastSize = sets.size();
        }

        return lastSize == rooms.size();
    }

}
