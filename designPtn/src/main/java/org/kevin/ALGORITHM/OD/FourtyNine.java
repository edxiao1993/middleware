package org.kevin.ALGORITHM.OD;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kevin.Zng
 * @date 2022/5/22 23:30
 */
public class FourtyNine {

    public static void main(String[] args) {
        String s = "5,10,2,11,2,1,1,1";
        int k = 20;
        System.out.println(solution(s, k));
    }

    private static int solution(String s, int k) {
        String[] ss = s.split(",");
        List<Integer> list = Arrays.stream(ss).map(Integer::parseInt).sorted().collect(Collectors.toList());

        int sum = 0;
        int i;
        for (i = 0; i < list.size(); i++) {
            sum += list.get(i);
            if (sum > k) {
                break;
            }
        }

        return i;
    }
}
