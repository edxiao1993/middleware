package org.kevin.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Kevin.Zng
 * @date 2022/6/14 00:14
 */
public class Basic {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Kevin");list.add("Zeng");list.add("Edward");list.add("Fang");
        System.out.println(list);

        List<String> nameWithUpperCase = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(nameWithUpperCase);
        String compared = nameWithUpperCase.stream().sorted(String::compareTo).collect(Collectors.joining(","));
        System.out.println(compared);

        Map<String, String> tempMap = nameWithUpperCase.stream().sorted(Comparator.reverseOrder())
                .collect(Collectors.toMap(s -> s, s -> String.valueOf(s.length())));
        Map<String, String> another = nameWithUpperCase.stream().collect(Collectors.toMap(Function.identity(), s -> String.valueOf(s.length())));
        System.out.println(tempMap);
        System.out.println(another);
    }
}
