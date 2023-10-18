package org.kevin.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Second {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String height = in.nextLine();
        String weight = in.nextLine();

        solution(height, weight);
    }

    private static void solution(String height, String weight) {
        String[] hs = height.split(" ");
        String[] ws = weight.split(" ");

        List<Student> studentList = new ArrayList<>(hs.length);
        for (int i = 0; i < hs.length; i++) {
            Student stu = new Student();
            stu.num = i + 1;
            stu.height = Integer.parseInt(hs[i]);
            stu.weight = Integer.parseInt(ws[i]);

            studentList.add(stu);
        }

        List<Student> sorted = studentList.stream().sorted(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (!o1.height.equals(o2.height)) {
                    return o1.height.compareTo(o2.height);
                }

                return o1.weight.compareTo(o2.weight);
            }
        }).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (Student student : sorted) {
            sb.append(student.num).append(" ");
        }

        System.out.println(sb.substring(0, sb.length() - 1));
    }

    static class Student {
        int num;
        Integer height;
        Integer weight;
    }
}
