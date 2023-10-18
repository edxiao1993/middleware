package org.kevin.ALGORITHM.OD;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kevin.Zng
 * @date 2022/5/9 23:48
 */
public class SeventyNine {

    public static void main(String[] args) {
        int[] height = new int[]{100, 100, 120, 130};
        int[] weight = new int[]{40, 30, 60, 50};

        height = new int[]{100, 100, 100, 100};
        weight = new int[]{40, 39, 41, 40};
        System.out.println(solution(height, weight));
    }

    private static List<Integer> solution(int[] heights, int[] weights) {
        List<Stu> stuList = new ArrayList<>(heights.length);
        for (int i = 0; i < heights.length; i++) {
            Stu s = new Stu();
            s.id = i + 1;
            s.height = heights[i];
            s.weight = weights[i];

            stuList.add(s);
        }

        List<Integer> result = stuList.stream().sorted(new Comparator<Stu>() {
            @Override
            public int compare(Stu o1, Stu o2) {
                if (o1.height != o2.height) {
                    return o1.height - o2.height;
                } else if (o1.weight != o2.weight) {
                    return o1.weight - o2.weight;
                } else {
                    return 0;
                }
            }
        }).map(stu -> stu.id).collect(Collectors.toList());

        return result;
    }

    private static class Stu {
        int id;
        int height;
        int weight;
    }
}
