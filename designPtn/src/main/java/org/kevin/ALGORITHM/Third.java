package org.kevin.ALGORITHM;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kevin.Zng
 * @date 2022/6/8 00:26
 */
public class Third {

    public static void main(String[] args) {
        String s = "aiouoiouiouiobiuouosiop";
        int flaw = 3;
        System.out.println(solution(s, flaw));
    }

    private static int solution(String s, int flaw) {
        Set<Character> yySets = new HashSet<>();
        yySets.add('a'); yySets.add('e'); yySets.add('i');
        yySets.add('o'); yySets.add('u');

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (yySets.contains(c)) {
                int left = i;
                int right = i + 1;
                int tempFlaw = flaw;
                while (tempFlaw > 0 && right < s.length()) {
                    char tempChar = s.charAt(right);
                    if (!yySets.contains(tempChar)) {
                        tempFlaw--;
                    }
                    right++;
                }

                int target = right;
                while (right < s.length()) {
                    char tempChar = s.charAt(target);
                    if (!yySets.contains(tempChar)) {
                        break;
                    }

                    target++;
                }

                if (flaw == 0) {
                    maxLength = Math.max(maxLength, right - left - 1);
                }

                if (tempFlaw <= 0) {
                    maxLength = Math.max(maxLength, right - left - 1);
                }

                if (right == s.length()) {
                    break;
                }
            }
        }

        return maxLength;
    }
}
