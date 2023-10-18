package org.kevin.ALGORITHM.OD;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @author Kevin.Zng
 * @date 2022/3/23 23:18
 */
public class p86 {

    public static void main(String[] args) {
        int[] players = new int[]{3, 3, 7, 4, 4, 4, 4, 7, 7, 3, 5, 5, 5};
        int[] grades = new int[]{53, 80, 68, 76, 39, 24, 66, 16, 100, 55, 53, 80, 55};
//        List<Integer> list = Arrays.asList(53, 80, 68, 24, 39, 76, 66, 16, 100, 55, 53, 80, 55);
//        list.sort(Integer::compareTo);
//        System.out.println("list = " + list);
        solution(players, grades);
    }

    private static int[] solution(int[] players, int[] grades) {
        Map<Integer, LinkedList<Integer>> tempMap = new HashMap<Integer, LinkedList<Integer>>();
        for (int i = 0; i < players.length; i++) {
            LinkedList<Integer> tempList = tempMap.get(players[i]);
            if (Objects.isNull(tempList)) {
                tempList = new LinkedList<>();
                tempList.add(grades[i]);
                tempMap.put(players[i], tempList);
            } else {
                tempList.add(grades[i]);
            }
        }

        Map<Integer, Integer> playerGradesMap = new TreeMap<>();
        for (Map.Entry<Integer, LinkedList<Integer>> entry : tempMap.entrySet()) {
            LinkedList<Integer> t = entry.getValue();
            if (t.size() >= 3) {
                int score = getMax3(t);
                playerGradesMap.put(entry.getKey(), score);
            }
        }

//        int[] result = new int[playerGradesMap.size()];
//        for (Map.Entry<Integer, Integer> integerIntegerEntry : playerGradesMap.entrySet()) {
//
//        }
        System.out.println("playerGradesMap.size() = " + playerGradesMap.size());
        return null;
    }

    private static int getMax3(LinkedList<Integer> t) {
        int score = 0;

        if (t.size() == 3) {
            for (Integer i : t) {
                score += i;
            }
        } else if (t.size() > 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < t.size(); j++) {
                    if (t.get(i) < t.get(j)) {
                        int temp = t.get(i);
                        t.set(i, t.get(j));
                        t.set(j, temp);
                    }
                }
            }
            score += t.get(0) + t.get(1) + t.get(2);
        }

        return score;
    }
}
