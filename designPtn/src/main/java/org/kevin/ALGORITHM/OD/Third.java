package org.kevin.ALGORITHM.OD;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin.Zng
 * @date 2022/5/19 00:03
 */
public class Third {

    public static void main(String[] args) {
        int[] n = new int[]{1, 1, 2, 3, 4, 1, 2, 3};
        int[] t = new int[]{0, 1, 2, 3, 4, 5, 6, 7};

        n = new int[] {1,2,3,4,1,2,3,1};

        n = new int[] {1,2,3,4,5,6,7,8,9,10};
        n = new int[] {10,9,8,7,6,5,4,3,2,1};
        System.out.println(solution(n));
    }

    private static String solution(int[] nums) {
        List<TempStructure> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            TempStructure ts = new TempStructure();
            ts.num = nums[i];
            ts.position = i;
            list.add(ts);
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (list.size() > 0) {
            int j;
            for (j = 1; j < list.size(); j++) {
                if (list.get(0).num < list.get(j).num) {
                    put2Last(list);
                    break;
                }
            }
            count++;

            if (j == list.size()) {
                TempStructure ts = list.remove(0);
                sb.append(ts.position).append(",");
            }

//            int removeIndex = -1;
//            TempStructure ts = list.get(0);
//            for (int i = 1; i < list.size(); i++) {
//                if (ts.num < list.get(i).num) {
//                    removeIndex = i;
//                    ts = list.get(i);
//                }
//            }
//
//            if (removeIndex > -1) {
//                list.remove(removeIndex);
//            }
        }

        System.out.println(count);
        return sb.substring(0, sb.length() - 1);
    }

    private static List<TempStructure> put2Last(List<TempStructure> list) {
        TempStructure ts = list.remove(0);
        list.add(ts);

        return list;
    }

    private static List<TempStructure> removeTargetObject(List<TempStructure> list, int removeIndex) {
        list.remove(removeIndex);
        return list;
    }

    private static class TempStructure {
        int num;
        int position;
    }
}
