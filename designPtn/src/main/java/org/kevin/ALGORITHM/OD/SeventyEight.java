package org.kevin.ALGORITHM.OD;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Kevin.Zng
 * @date 2022/5/11 00:21
 */
public class SeventyEight {
    public static void main(String[] args) {
        String[] ss = new String[]{
                "01:41:8.9",
                "1:1:09.211",
                "08:01:22.0",
        };

//        ss = new String[]{
//                "22:41:08.023",
//                "22:41:08.23"
//        };
//
//        ss = new String[] {
//                "1:1:1.1",
//                "01:01:01.1",
//                "1:01:1.100"
//        };

        System.out.println(solution(ss));
    }

    private static int toMilli(String s) {
        if (s.length() == 2) {
            s = s + "0";
        }
        if (s.length() == 1) {
            s = s + "00";
        }

        if (s.startsWith("0")) {
            return Integer.parseInt(s);
        } else {
            int i = Integer.parseInt(s);
            if (i < 10) {
                return i * 100;
            } else if (i < 100) {
                return i * 10;
            } else {
                return i;
            }
        }
    }

    private static List<String> solution(String[] ss) {
        List<TimesClz> tempResult = new ArrayList<>(ss.length);

        for (String s : ss) {
            String[] timeStrs = s.split(":");
            long hour = Long.parseLong(timeStrs[0]) * 60 * 60 * 1000L;
            long minute = Long.parseLong(timeStrs[1]) * 60 * 1000L;
            String[] secondStrs = timeStrs[2].split("\\.");
            long second = Long.parseLong(secondStrs[0]) * 1000L;
            long milliSeconds = hour + minute + second + toMilli(secondStrs[1]);

            TimesClz obj = new TimesClz();
            obj.milliSecond = milliSeconds;
            obj.originalStr = s;
            tempResult.add(obj);
        }

        List<String> result = tempResult.stream().sorted(new Comparator<TimesClz>() {
            @Override
            public int compare(TimesClz o1, TimesClz o2) {
                return o1.milliSecond.compareTo(o2.milliSecond);
            }
        }).map(o -> o.originalStr).collect(Collectors.toList());
        return result;
    }

    private static class TimesClz{
        Long milliSecond;
        String originalStr;
    }
}
