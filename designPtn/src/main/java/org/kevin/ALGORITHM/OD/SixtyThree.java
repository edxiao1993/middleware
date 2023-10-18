package org.kevin.ALGORITHM.OD;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin.Zng
 * @date 2022/5/4 13:33
 */
public class SixtyThree {

    public static void main(String[] args) {
        String s = "a:3,b:5,c:2@";
        System.out.println("solution(s) = " + solution(s));
    }

    private static String solution(String s) {
        String[] splits = s.split("@");
        if (splits.length == 1) {
            return splits[0];
        }
        String whole = s.split("@")[0];
        String exist = s.split("@")[1];

        if (exist.length() == 0) {
            return whole;
        }

        Map<String, Integer> result = new HashMap<>();
        String[] wholeParts = whole.split(",");
        for (String wholePart : wholeParts) {
            String[] tempStr = wholePart.split(":");
            result.put(tempStr[0], Integer.parseInt(tempStr[1]));
        }

        Map<String, Integer> tempResult = new HashMap<>();
        String[] existParts = exist.split(",");
        for (String existPart : existParts) {
            String[] tempStr = existPart.split(":");
            tempResult.put(tempStr[0], Integer.parseInt(tempStr[1]));
        }

        for (Map.Entry<String, Integer> entry : tempResult.entrySet()) {
            if (result.get(entry.getKey()) != null) {
                Integer value = entry.getValue();
                Integer realValue = result.get(entry.getKey()) - value;
                result.put(entry.getKey(), realValue);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            sb.append(entry.getKey()).append(":").append(entry.getValue()).append(",");
        }

        return sb.substring(0, sb.length() - 1);
    }
}
